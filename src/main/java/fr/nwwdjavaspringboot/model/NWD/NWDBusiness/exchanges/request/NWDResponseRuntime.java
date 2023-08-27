package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request;

import com.google.gson.Gson;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDProjectKey;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDDownPayload;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.basic.NWDBasicResponse;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDExchangeRuntimeKind;
import fr.nwwdjavaspringboot.model.NWD.util.NWDRandom;
import fr.nwwdjavaspringboot.model.NWD.util.NWDSecurityTools;
import fr.nwwdjavaspringboot.model.NWD.util.NWDTimestamp;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigInteger;

public class NWDResponseRuntime extends NWDBasicResponse implements Serializable {
    public transient String debug;
    public NWDExchangeRuntimeKind runtimeKind;
    public NWDRequestPlayerToken playerToken;
    public int duration;

    public NWDResponseRuntime() {
        timestamp = NWDTimestamp.getTimestampUnix();
    }

    public NWDResponseRuntime(NWDRequestStatus sStatus) {
        timestamp = NWDTimestamp.getTimestampUnix();
        status = sStatus;
    }

    public NWDResponseRuntime(INWDProjectKey sProjectKeyManager, NWDRequestPlayerToken sPlayerToken, NWDExchangeRuntimeKind sRuntimeKind, NWDDownPayload sPayload, NWDRequestStatus sStatus, String sDebug) {
        timestamp = NWDTimestamp.getTimestampUnix();
        duration = 0;
        projectId = sPlayerToken.getProjectId();
        environment = sPlayerToken.getEnvironmentKind();
        playerToken = sPlayerToken;
        runtimeKind = sRuntimeKind;
        if (sPayload != null) {
            setPayload(sPayload);
        }
        if (payload.isEmpty()) {
            payload = "";
        }
        status = sStatus;
        if (!projectId.equals(BigInteger.ZERO)) {
            secure(sProjectKeyManager, NWDRandom.RandomStringCypher(32));
        }
    }

    protected void setPayload(NWDDownPayload sPayload) {
        payload = new Gson().toJson(sPayload);
    }

    public <T extends NWDDownPayload> T getPayload(INWDProjectKey sProjectKeyManager, Type payloadType) {
        T rReturn = null;
        if (isValid(sProjectKeyManager)) {
            rReturn = new Gson().fromJson(payload, payloadType);
        } else {
            //NWDLogger.Warning("["+IdName+ "] " +nameof (NWDResponseRuntime) +" "+nameof(GetPay}
        }
        return rReturn;
    }

    private String generateHash(INWDProjectKey sProjectKeyManager) {
        String rReturn;
        String tPayLoadPrint;
        if (playerToken == null) {
            playerToken = new NWDRequestPlayerToken(projectId, environment);
        }
        if (payload == null) {
            payload = "";
        }
        String tSaltKey = sProjectKeyManager.getProjectKey(projectId, environment);
        if (tSaltKey != null && !tSaltKey.isEmpty()) {
            tPayLoadPrint = NWDSecurityTools.GenerateSha(payload);
            rReturn = NWDSecurityTools.GenerateSha(
                    tPayLoadPrint
                            + stamp
                            + tSaltKey
                            + status.toString()
                            + runtimeKind.toString()
                            + playerToken.getToken()
                            + playerToken.getAccountRange()
                            + playerToken.getEnvironmentKind().toString()
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
        stamp = sStamp;
        hash = generateHash(sProjectKeyManager);
    }

    public boolean isValid(INWDProjectKey sProjectKeyManager) {
        boolean rReturn = false;
        String tHashActual = generateHash(sProjectKeyManager);
        if (hash != null && !hash.isEmpty()) {
            if (tHashActual.equals(hash)) {
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

    public <T extends NWDDownPayload> T GetPayload(INWDProjectKey sProjectKeyManager, Class<T> type)
    {
        T rReturn = null;
        if (isValid( sProjectKeyManager))
        {
            Gson gson = new Gson();
            rReturn = gson.fromJson(payload, type);
            /*rReturn = JsonConvert.DeserializeObject<T>(Payload);*/
        }
        else
        {
            //NWDLogger.Warning("["+IdName+ "] " +nameof (NWDResponseRuntime) +" "+nameof(GetPayload)+" NOT POSSIBLE TO GET OBJECT! for "+ProjectId+" "+Environment.ToString()+" (player token "+ProjectId+" "+Environment.ToString()+") with salt result  '" +sProjectKeyManager.GetProjectKey(PlayerToken.ProjectId, PlayerToken.EnvironmentKind)+"' " + Payload);
        }
        return rReturn;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public NWDExchangeRuntimeKind getRuntimeKind() {
        return runtimeKind;
    }

    public void setRuntimeKind(NWDExchangeRuntimeKind runtimeKind) {
        this.runtimeKind = runtimeKind;
    }

    public NWDRequestPlayerToken getPlayerToken() {
        return playerToken;
    }

    public void setPlayerToken(NWDRequestPlayerToken playerToken) {
        this.playerToken = playerToken;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}