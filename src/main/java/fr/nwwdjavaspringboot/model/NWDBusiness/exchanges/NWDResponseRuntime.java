package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;
import com.google.gson.Gson;
import fr.nwwdjavaspringboot.model.NWDBusiness.INWDProjectKey;
import fr.nwwdjavaspringboot.util.NWDRandom;
import fr.nwwdjavaspringboot.util.NWDSecurityTools;
import fr.nwwdjavaspringboot.util.NWDTimestamp;

import java.lang.reflect.Type;

public class NWDResponseRuntime extends NWDBasicResponse {
    private String Debug;
    private NWDExchangeRuntimeKind RuntimeKind;
    private NWDRequestPlayerToken PlayerToken;
    private int Duration;

    public NWDResponseRuntime() {
        Timestamp = NWDTimestamp.getTimestampUnix();
    }

    public NWDResponseRuntime(NWDRequestStatus sStatus) {
        Timestamp = NWDTimestamp.getTimestampUnix();
        Status = sStatus;
    }
    public NWDResponseRuntime(INWDProjectKey sProjectKeyManager, NWDRequestPlayerToken sPlayerToken, NWDExchangeRuntimeKind sRuntimeKind, NWDDownPayload sPayload, NWDRequestStatus sStatus, String sDebug) {
        Timestamp = NWDTimestamp.getTimestampUnix();
        Duration = 0;
        ProjectId = sPlayerToken.getProjectId();
        Environment = sPlayerToken.getEnvironmentKind();
        PlayerToken = sPlayerToken;
        RuntimeKind = sRuntimeKind;
        if (sPayload != null) {
            setPayload(sPayload);
        }
        if (Payload.isEmpty()) {
            Payload = "";
        }
        Status = sStatus;
        if (ProjectId != 0) {
            secure(sProjectKeyManager, NWDRandom.RandomStringCypher(32));
        }
    }

    protected void setPayload(NWDDownPayload sPayload) {
        Payload = new Gson().toJson(sPayload);
    }

    public <T extends NWDDownPayload> T getPayload(INWDProjectKey sProjectKeyManager, Type payloadType) {
        T rReturn = null;
        if (isValid(sProjectKeyManager)) {
            rReturn = new Gson().fromJson(Payload, payloadType);
        } else {
            //NWDLogger.Warning("["+IdName+ "] " +nameof (NWDResponseRuntime) +" "+nameof(GetPay}
        }
        return rReturn;
    }

    private String generateHash(INWDProjectKey sProjectKeyManager) {
        String rReturn;
        String tPayLoadPrint;
        if (PlayerToken == null) {
            PlayerToken = new NWDRequestPlayerToken(ProjectId, Environment);
        }
        if (Payload == null) {
            Payload = "";
        }
        String tSaltKey = sProjectKeyManager.getProjectKey(ProjectId, Environment);
        if (tSaltKey != null && !tSaltKey.isEmpty()) {
            tPayLoadPrint = NWDSecurityTools.GenerateSha(Payload);
            rReturn = NWDSecurityTools.GenerateSha(
                    tPayLoadPrint
                            + Stamp
                            + tSaltKey
                            + Status.toString()
                            + RuntimeKind.toString()
                            + PlayerToken.getToken()
                            + PlayerToken.getAccountRange()
                            + PlayerToken.getEnvironmentKind().toString()
                    // + PlayerToken.DataTrack
            );
        } else {
            rReturn = "";
            //throw new Exception(sProjectKeyManager.GetProjectKeyInstanceName()+" : "+ nameof(INWDProjectKey) + "." + nameof(INWDProjectKey.GetProjectKey) + " return string empty or null!");
        }
        //NWDLogger.Information("["+IdName+ "] " +nameof (NWDResponseRuntime) +"
        return rReturn;
    }
    protected void secure(INWDProjectKey sProjectKeyManager, String sStamp) {
        Stamp = sStamp;
        Hash = generateHash(sProjectKeyManager);
    }

    public boolean isValid(INWDProjectKey sProjectKeyManager) {
        boolean rReturn = false;
        String tHashActual = generateHash(sProjectKeyManager);
        if (Hash != null && !Hash.isEmpty()) {
            if (tHashActual.equals(Hash)) {
                rReturn = true;
            }
        }
        if (!rReturn) {
            //NWDLogger.Warning("["+IdName+ "] " +nameof (NWDResponseRuntime) +"." +nameof (IsValid) +" Error  : hash is not valid for "+ProjectId+" "+Environment.toString()+" (player token "+ProjectId+" "+Environment.toString()+") with salt result  '" +sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind)+"' Hash is '"+Hash+"' and actual generate return '"+tHashActual+"'");
        } else {
            //NWDLogger.TraceSuccess("["+IdName+ "] " +nameof (NWDResponseRuntime) +"." +nameof (IsValid) +" hash is valid for "+ProjectId+" "+Environment.toString()+" (player token "+ProjectId+" "+Environment.toString()+") with salt result  '" +sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind)+"' Hash is '"+Hash+"' and actual generate return '"+tHashActual+"'");
        }
        return rReturn;
    }


}