package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.basic;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeDevice;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;

public class NWDBasicRequest extends NWDBasicExchange {

    public NWDExchangeOrigin Origin = NWDExchangeOrigin.Unknown;
    public NWDExchangeDevice Device  = NWDExchangeDevice.Unknown;

}
