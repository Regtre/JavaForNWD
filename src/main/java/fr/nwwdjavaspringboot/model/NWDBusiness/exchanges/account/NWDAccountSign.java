package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDAccountData;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import fr.nwwdjavaspringboot.util.NWDSecurityTools;

import java.io.UnsupportedEncodingException;

public class NWDAccountSign extends NWDAccountData {


    /// <summary>
    /// Name of sign (to show in list)
    /// </summary>
    public String Name = "";

    /// <summary>
    /// Sign Kind
    /// </summary>
    public NWDAccountSignType SignType = NWDAccountSignType.None;

    /// <summary>
    /// hash for the real sign
    /// </summary>
    public String SignHash = "";

    /// <summary>
    /// hash for the email if email is use (to check duplicate)
    /// </summary>
    public String RescueHash = "";

    /// <summary>
    /// hash for the login if login is use (to check duplicate)
    /// </summary>
    public String LoginHash = "";

    /// <summary>
    /// if ok => Associated
    /// </summary>
    public NWDAccountSignAction SignStatus = NWDAccountSignAction.None;

    public String TokenRescue = "";

    /// <summary>
    /// the dateTimeLimit to used the TokenRescue token (24h?)
    /// </summary>
    public int TokenRescueLimit;

    public String TokenVerif = "";

    public int TokenVerifLimit;

    public String SignVerifHash = "";

    public String RescueVerifHash = "";

    public String LoginVerifHash = "";


    public static String EmailToPartialString(String sOriginalEmail) {
        StringBuilder rReturn = new StringBuilder();

        if (sOriginalEmail.length() > 6) {
            rReturn.append(sOriginalEmail.charAt(0));
            rReturn.append(sOriginalEmail.charAt(1));
            for (int t = 2; t < sOriginalEmail.length() - 2; t++) {
                if (sOriginalEmail.charAt(t) == '@') {
                    rReturn.append("@");
                } else if (sOriginalEmail.charAt(t) == ' ') {
                    // It's a login email password case ...
                    rReturn.append(" / ");
                    if (sOriginalEmail.length() >= t + 4) {
                        t++;
                        rReturn.append(sOriginalEmail.charAt(t));
                        t++;
                        rReturn.append(sOriginalEmail.charAt(t));
                    }
                } else if (sOriginalEmail.charAt(t) == '.') {
                    rReturn.append(".");
                } else {
                    rReturn.append("•");
                }
            }

            rReturn.append(sOriginalEmail.lastIndexOf(2));
            rReturn.append(sOriginalEmail.lastIndexOf(1));
        } else {
            rReturn.append(sOriginalEmail);
        }

        return rReturn.toString();
    }

    /// <summary>
    /// Create a sign for device by device unique identifier (UDID) and associate device's name
    /// </summary>
    /// <param name="sDeviceId"></param>
    /// <param name="sProject"></param>
    /// <param name="sDeviceName"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateDeviceId(String sDeviceId, long sProject, String sDeviceName) throws ArgumentNullException, UnsupportedEncodingException {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.DeviceId);
        rReturn.projectId = sProject;
        if (sDeviceName.isEmpty() || sDeviceName == "") {
            sDeviceName = NWDAccountSignType.DeviceId.toString();
        }
        rReturn.Name = NWDSecurityTools.CryptAes(sDeviceName, Long.toString(sProject), Long.toString(sProject));
        rReturn.SignType = NWDAccountSignType.DeviceId;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sDeviceId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sDeviceId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sDeviceId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sDeviceId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sDeviceId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sDeviceId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with email and password
    /// </summary>
    /// <param name="sEmail"></param>
    /// <param name="sPassword"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateEmailPassword(String sEmail, String sPassword, long sProject) throws ArgumentNullException, UnsupportedEncodingException {
        NWDAccountSign rReturn = new NWDAccountSign();
        rReturn.projectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(EmailToPartialString(sEmail), Long.toString(sProject), Long.toString(sProject));
        rReturn.SignType = NWDAccountSignType.EmailPassword;
        rReturn.LoginHash = NWDSecurityTools.GenerateSha(sEmail + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sEmail);
        rReturn.RescueHash = NWDSecurityTools.GenerateSha(sEmail + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sEmail);
        rReturn.SignHash = NWDSecurityTools.GenerateSha(sEmail + sPassword + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sPassword + sEmail);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with login, email and password
    /// </summary>
    /// <param name="sLogin"></param>
    /// <param name="sEmail"></param>
    /// <param name="sPassword"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateLoginEmailPassword(String sLogin, String sEmail, String sPassword, long sProject) throws ArgumentNullException, UnsupportedEncodingException {
        NWDAccountSign rReturn = new NWDAccountSign();
        rReturn.projectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(sLogin + " " + EmailToPartialString(sEmail),  Long.toString(sProject),  Long.toString(sProject));
        rReturn.SignType = NWDAccountSignType.LoginEmailPassword;
        rReturn.LoginHash = NWDSecurityTools.GenerateSha(sLogin + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sLogin);
        rReturn.RescueHash = NWDSecurityTools.GenerateSha(sEmail + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sEmail);
        rReturn.SignHash = NWDSecurityTools.GenerateSha(sPassword + sEmail + sLogin + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sPassword + sLogin);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with with login and password
    /// </summary>
    /// <param name="sLogin"></param>
    /// <param name="sPassword"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateLoginPassword(String sLogin, String sPassword, long sProject) throws ArgumentNullException, UnsupportedEncodingException {
        NWDAccountSign rReturn = new NWDAccountSign();
        rReturn.projectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(sLogin,  Long.toString(sProject),  Long.toString(sProject));
        rReturn.SignType = NWDAccountSignType.LoginPassword;
        rReturn.LoginHash = NWDSecurityTools.GenerateSha(sLogin + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sLogin);
        rReturn.RescueHash = NWDSecurityTools.GenerateSha(sLogin + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sLogin);
        rReturn.SignHash = NWDSecurityTools.GenerateSha(sPassword + sLogin + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sPassword + sLogin);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /*

    /// <summary>
    /// Create a sign with social id (facebook)
    /// </summary>
    /// <param name="sFacebookId"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateFacebook(String sFacebookId, ulong sProject) {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.Facebook);
        rReturn.ProjectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(NWDAccountSignType.Facebook.toString(), sProject.toString(), sProject.toString());
        rReturn.SignType = NWDAccountSignType.Facebook;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sFacebookId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sFacebookId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sFacebookId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sFacebookId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sFacebookId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sFacebookId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with social id (facebook)
    /// </summary>
    /// <param name="sFacebookId"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateDiscord(String sFacebookId, ulong sProject) {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.Discord);
        rReturn.ProjectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(NWDAccountSignType.Discord.toString(), sProject.toString(), sProject.toString());
        rReturn.SignType = NWDAccountSignType.Discord;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sFacebookId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sFacebookId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sFacebookId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sFacebookId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sFacebookId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sFacebookId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with social id (Google)
    /// </summary>
    /// <param name="sGoogleId"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateGoogle(String sGoogleId, ulong sProject) {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.Google);
        rReturn.ProjectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(NWDAccountSignType.Google.toString(), sProject.toString(), sProject.toString());
        rReturn.SignType = NWDAccountSignType.Google;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sGoogleId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sGoogleId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sGoogleId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sGoogleId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sGoogleId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sGoogleId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with social id (AppleID)
    /// </summary>
    /// <param name="sAppleId"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateApple(String sAppleId, ulong sProject) {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.Apple);
        rReturn.ProjectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(NWDAccountSignType.Apple.toString(), sProject.toString(), sProject.toString());
        rReturn.SignType = NWDAccountSignType.Apple;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sAppleId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sAppleId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sAppleId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sAppleId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sAppleId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sAppleId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with social id (Microsoft)
    /// </summary>
    /// <param name="sMicrosoftId"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateMicrosoft(String sMicrosoftId, ulong sProject) {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.Microsoft);
        rReturn.ProjectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(NWDAccountSignType.Microsoft.toString(), sProject.toString(), sProject.toString());
        rReturn.SignType = NWDAccountSignType.Microsoft;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sMicrosoftId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sMicrosoftId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sMicrosoftId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sMicrosoftId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sMicrosoftId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sMicrosoftId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with social id (Twitter)
    /// </summary>
    /// <param name="sTwitterId"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateTwitter(String sTwitterId, ulong sProject) {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.Twitter);
        rReturn.ProjectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(NWDAccountSignType.Twitter.toString(), sProject.toString(), sProject.toString());
        rReturn.SignType = NWDAccountSignType.Twitter;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sTwitterId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sTwitterId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sTwitterId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sTwitterId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sTwitterId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sTwitterId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }

    /// <summary>
    /// Create a sign with social id (LinkedIn)
    /// </summary>
    /// <param name="sLinkedInId"></param>
    /// <param name="sProject"></param>
    /// <returns></returns>
    public static NWDAccountSign CreateLinkedIn(String sLinkedInId, ulong sProject) {
        NWDAccountSign rReturn = new NWDAccountSign();
        String tType = DeviceTypeObfuscation(NWDAccountSignType.LinkedIn);
        rReturn.ProjectId = sProject;
        rReturn.Name = NWDSecurityTools.CryptAes(NWDAccountSignType.LinkedIn.toString(), sProject.toString(), sProject.toString());
        rReturn.SignType = NWDAccountSignType.LinkedIn;
        rReturn.LoginHash = tType + "-" + NWDSecurityTools.GenerateSha(sLinkedInId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sLinkedInId);
        rReturn.RescueHash = tType + "-" + NWDSecurityTools.GenerateSha(sLinkedInId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sLinkedInId);
        rReturn.SignHash = tType + "-" + NWDSecurityTools.GenerateSha(sLinkedInId + sProject) + "-" +
                NWDSecurityTools.GenerateSha(sLinkedInId);
        rReturn.SignStatus = NWDAccountSignAction.None;
        return rReturn;
    }


     */

    private static String DeviceTypeObfuscation(NWDAccountSignType sType) {
        String rResult = "";

        switch (sType) {
            case DeviceId -> rResult = "M";
            case Facebook -> rResult = "E";
            case Google -> rResult = "R";
            case Apple -> rResult = "D";
            case Microsoft -> rResult = "I";
            case Twitter -> rResult = "Q";
            case LinkedIn -> rResult = "U";
            case Discord -> rResult = "A";
            default -> {
            }
        }

        return rResult;
    }

}
