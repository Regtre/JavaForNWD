package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

public abstract class NWDBasicResponse extends NWDBasicExchange {
    public NWDRequestStatus Status = NWDRequestStatus.None;
    public String ServerIdentity;
    public String Debug;
}

