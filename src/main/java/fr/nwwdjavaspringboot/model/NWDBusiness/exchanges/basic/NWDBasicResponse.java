package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.basic;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestStatus;

public abstract class NWDBasicResponse extends NWDBasicExchange {
    public NWDRequestStatus Status = NWDRequestStatus.None;
    public String ServerIdentity;
    public String Debug;
}

