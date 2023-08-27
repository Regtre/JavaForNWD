package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request;


import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDEnvironmentKind;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public class NWDRequestPlayerToken {
    private short accountRange;
    private BigInteger projectId;
    private BigInteger playerReference;
    private String token;
    private String oldToken;
    private NWDEnvironmentKind environmentKind;
    private NWDExchangeOrigin exchangeOrigin;

//    private NWDSyncInformation PlayerSyncInformation = new NWDSyncInformation();
//    private NWDSyncInformation StudioSyncInformation = new NWDSyncInformation();



    public NWDRequestPlayerToken(INWDProjectInformation sProjectInformation)
    {
        accountRange = 0;
        playerReference = BigInteger.ZERO;
        projectId = sProjectInformation.GetProjectId();
        token = "";
        oldToken = "";
        environmentKind = sProjectInformation.GetProjectEnvironment();
        exchangeOrigin = NWDExchangeOrigin.Unknown;
    }

    public NWDRequestPlayerToken(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind)
    {
        accountRange = 0;
        playerReference = BigInteger.ZERO;
        projectId = sProjectId;
        token = "";
        oldToken = "";
        environmentKind = sEnvironmentKind;
        exchangeOrigin = NWDExchangeOrigin.Unknown;
    }

    public NWDRequestPlayerToken(NWDRequestPlayerToken sToCopy)
    {
        if (sToCopy != null)
        {
            accountRange = sToCopy.accountRange;
            playerReference = sToCopy.playerReference;
            projectId = sToCopy.projectId;
            token = sToCopy.token;
            oldToken = sToCopy.oldToken;
            /*PlayerSyncInformation = new NWDSyncInformation(sToCopy.PlayerSyncInformation);
            StudioSyncInformation = new NWDSyncInformation(sToCopy.StudioSyncInformation);*/
            environmentKind = sToCopy.environmentKind;
            exchangeOrigin = sToCopy.exchangeOrigin;
        }
    }


    public void setAccountRange(short accountRange) {
        this.accountRange = accountRange;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public void setPlayerReference(BigInteger playerReference) {
        this.playerReference = playerReference;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setOldToken(String oldToken) {
        this.oldToken = oldToken;
    }

    public void setEnvironmentKind(NWDEnvironmentKind environmentKind) {
        this.environmentKind = environmentKind;
    }

    public void setExchangeOrigin(NWDExchangeOrigin exchangeOrigin) {
        this.exchangeOrigin = exchangeOrigin;
    }
}
