package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request;


import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;

public class NWDRequestPlayerToken {
    private short AccountRange;
    private long ProjectId;
    private long PlayerReference;
    private String Token;
    private String OldToken;
    private NWDEnvironmentKind EnvironmentKind;
    private NWDExchangeOrigin ExchangeOrigin;

//    private NWDSyncInformation PlayerSyncInformation = new NWDSyncInformation();
//    private NWDSyncInformation StudioSyncInformation = new NWDSyncInformation();



    public NWDRequestPlayerToken(INWDProjectInformation sProjectInformation)
    {
        AccountRange = 0;
        PlayerReference = 0;
        ProjectId = sProjectInformation.GetProjectId();
        Token = "";
        OldToken = "";
        EnvironmentKind = sProjectInformation.GetProjectEnvironment();
        ExchangeOrigin = NWDExchangeOrigin.Unknown;
    }

    public NWDRequestPlayerToken(long sProjectId, NWDEnvironmentKind sEnvironmentKind)
    {
        AccountRange = 0;
        PlayerReference = 0;
        ProjectId = sProjectId;
        Token = "";
        OldToken = "";
        EnvironmentKind = sEnvironmentKind;
        ExchangeOrigin = NWDExchangeOrigin.Unknown;
    }

    public NWDRequestPlayerToken(NWDRequestPlayerToken sToCopy)
    {
        if (sToCopy != null)
        {
            AccountRange = sToCopy.AccountRange;
            PlayerReference = sToCopy.PlayerReference;
            ProjectId = sToCopy.ProjectId;
            Token = sToCopy.Token;
            OldToken = sToCopy.OldToken;
            /*PlayerSyncInformation = new NWDSyncInformation(sToCopy.PlayerSyncInformation);
            StudioSyncInformation = new NWDSyncInformation(sToCopy.StudioSyncInformation);*/
            EnvironmentKind = sToCopy.EnvironmentKind;
            ExchangeOrigin = sToCopy.ExchangeOrigin;
        }
    }


    public short getAccountRange() {
        return AccountRange;
    }

    public void setAccountRange(short accountRange) {
        AccountRange = accountRange;
    }

    public long getProjectId() {
        return ProjectId;
    }

    public void setProjectId(long projectId) {
        ProjectId = projectId;
    }

    public long getPlayerReference() {
        return PlayerReference;
    }

    public void setPlayerReference(long playerReference) {
        PlayerReference = playerReference;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getOldToken() {
        return OldToken;
    }

    public void setOldToken(String oldToken) {
        OldToken = oldToken;
    }

    public NWDEnvironmentKind getEnvironmentKind() {
        return EnvironmentKind;
    }

    public void setEnvironmentKind(NWDEnvironmentKind environmentKind) {
        EnvironmentKind = environmentKind;
    }

    public NWDExchangeOrigin getExchangeOrigin() {
        return ExchangeOrigin;
    }

    public void setExchangeOrigin(NWDExchangeOrigin exchangeOrigin) {
        ExchangeOrigin = exchangeOrigin;
    }
}
