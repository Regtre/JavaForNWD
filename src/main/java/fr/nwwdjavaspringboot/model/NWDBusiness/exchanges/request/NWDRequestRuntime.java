package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request;

import com.google.gson.Gson;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDUpPayloadAccountSignUp;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account.NWDAccountSign;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDUpPayloadAccountSignIn;
import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDProjectKey;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDUpPayload;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.basic.NWDBasicRequest;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeDevice;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeRuntimeKind;
import fr.nwwdjavaspringboot.util.NWDRandom;
import fr.nwwdjavaspringboot.util.NWDSecurityTools;
import fr.nwwdjavaspringboot.util.NWDTimestamp;

import java.lang.reflect.Type;

public class NWDRequestRuntime extends NWDBasicRequest {


    public NWDExchangeRuntimeKind Kind;

    public NWDRequestPlayerToken PlayerToken;

    public NWDRequestRuntime() {
        Timestamp = NWDTimestamp.getTimestampUnix();
    }


    public NWDRequestRuntime(INWDProjectKey sProjectKeyManager, NWDRequestPlayerToken sPlayerToken, NWDExchangeRuntimeKind sKind,
                             NWDUpPayload sUpPayload, NWDExchangeOrigin sOrigin, NWDExchangeDevice sDevice) {
        Timestamp = NWDTimestamp.getTimestampUnix();
        ProjectId = sPlayerToken.getProjectId();
        Environment = sPlayerToken.getEnvironmentKind();
        PlayerToken = sPlayerToken;
        Kind = sKind;
        Origin = sOrigin;
        Device = sDevice;
        if (sUpPayload != null) {
            setPayload(sUpPayload);
        }

        if (Payload == null || Payload.isEmpty()) {
            Payload = "";
        }
        if (ProjectId != 0) {
            Secure(sProjectKeyManager, NWDRandom.RandomStringCypher(32));
        }
    }

    public void setPayload(NWDUpPayload sUpPayload) {
        Gson gson = new Gson();
        Payload = gson.toJson(sUpPayload);
    }

    public <T extends NWDUpPayload> T GetPayload(INWDProjectKey sProjectKeyManager, Type payloadType) {
        T rReturn = null;
        if (IsValid(sProjectKeyManager)) {
            rReturn = new Gson().fromJson(Payload, payloadType);
        } else {
            //NWDLogger.Warning("["+IdName+ "] " +nameof (NWDRequestRuntime) +" "+nameof(GetPayload)+" NOT POSSIBLE TO GET OBJECT! for "+ProjectId+" "+Environment.ToString()+" (player token "+ProjectId+" "+Environment.ToString()+") with salt result  '" +sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind)+"' " + Payload);
        }
        return rReturn;
    }

    protected String GenerateHash(INWDProjectKey sProjectKeyManager) {
        String rReturn;
        String tPayLoadPrint;
        if (PlayerToken == null) {
            PlayerToken = new NWDRequestPlayerToken(ProjectId, Environment);
        }

        if (Payload == null) {
            Payload = "";
        }

        // string tSaltKey = sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind);
        String tSaltKey = sProjectKeyManager.getProjectKey(ProjectId, Environment);
        if (tSaltKey != null && !tSaltKey.isEmpty()) {
            tPayLoadPrint = NWDSecurityTools.GenerateSha(Payload);
            rReturn = NWDSecurityTools.GenerateSha(
                    tPayLoadPrint
                            + Stamp
                            + tSaltKey
                            + Kind.toString()
                            + PlayerToken.getToken()
                            + PlayerToken.getAccountRange()
                            + PlayerToken.getEnvironmentKind()
                            + Origin
                    // + PlayerToken.DataTrack.ToString())
            );
        } else {
            return "";
            //throw new Exception(sProjectKeyManager.GetProjectKeyInstanceName()+" : "+ nameof(INWDProjectKey) + "." + nameof(INWDProjectKey.GetProjectKey) + " return string empty or null!");
        }

        //NWDLogger.Information("["+IdName+ "] " +nameof (NWDRequestRuntime) +"  hash "+ProjectId+" "+Environment.ToString()+" (player token "+ProjectId+" "+Environment.ToString()+") with salt result  '" +sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind)+"', rReturn = '"+rReturn+"' for message '" + Payload);
        return rReturn;
    }

    public void Secure(INWDProjectKey sProjectKeyManager, String sStamp) {
        Stamp = sStamp;
        Hash = GenerateHash(sProjectKeyManager);
    }

    public boolean IsValid(INWDProjectKey sProjectKeyManager) {
        boolean rReturn = false;
        String tHashActual = GenerateHash(sProjectKeyManager);
        if (Hash != null && !Hash.isEmpty()) {
            if (tHashActual == Hash) {
                if (PlayerToken.getProjectId() == ProjectId) {
                    rReturn = true;
                }
            }
        }
        if (rReturn == false) {
            //NWDLogger.Warning("["+IdName+ "] " +nameof (NWDRequestRuntime) +"." +nameof (IsValid) +" Error  : hash is not valid for "+ProjectId+" "+Environment.ToString()+" (player token "+ProjectId+" "+Environment.ToString()+") with salt result  '" +sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind)+"' Hash is '"+Hash+"' and actual generate return '"+tHashActual+"'");
        } else {
            //NWDLogger.TraceSuccess("["+IdName+ "] " +nameof (NWDRequestRuntime) +"." +nameof (IsValid) +" hash is valid for "+ProjectId+" "+Environment.ToString()+" (player token "+ProjectId+" "+Environment.ToString()+") with salt result  '" +sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind)+"' Hash is '"+Hash+"' and actual generate return '"+tHashActual+"'");
        }
        return rReturn;
    }

    public static NWDRequestRuntime CreateRequestTest(INWDProjectKey sProjectKeyManager, NWDRequestPlayerToken sPlayerToken,
                                                      NWDExchangeOrigin sOrigin,
                                                      NWDExchangeDevice sDevice) {
        return new NWDRequestRuntime(sProjectKeyManager, sPlayerToken, NWDExchangeRuntimeKind.Test,
                new NWDUpPayload(), sOrigin, sDevice);
    }

    public static NWDRequestRuntime CreateRequestSignIn(INWDProjectKey sProjectKeyManager, NWDRequestPlayerToken sPlayerToken,
                                                        NWDAccountSign sAccountSign, NWDExchangeOrigin sOrigin,
                                                        NWDExchangeDevice sDevice) {
        return new NWDRequestRuntime(sProjectKeyManager, sPlayerToken, NWDExchangeRuntimeKind.SignIn,
                new NWDUpPayloadAccountSignIn(sAccountSign), sOrigin, sDevice);
    }

    public static NWDRequestRuntime CreateRequestSignUp(INWDProjectKey sProjectKeyManager, NWDRequestPlayerToken sPlayerToken,
                                                        NWDAccountSign sAccountSign, NWDExchangeOrigin sOrigin,
                                                        NWDExchangeDevice sDevice) {
        return new NWDRequestRuntime(sProjectKeyManager, sPlayerToken, NWDExchangeRuntimeKind.SignUp,
                new NWDUpPayloadAccountSignUp(sAccountSign), sOrigin, sDevice);
    }


}
