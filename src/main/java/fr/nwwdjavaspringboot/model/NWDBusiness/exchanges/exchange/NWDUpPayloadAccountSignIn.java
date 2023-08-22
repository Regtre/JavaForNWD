package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDUpPayload;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account.NWDAccountSign;

public class NWDUpPayloadAccountSignIn extends NWDUpPayload {

    public NWDAccountSign AccountSign;

    public NWDUpPayloadAccountSignIn(NWDAccountSign sAccountSign) {
        super();
        AccountSign = sAccountSign;
    }
}
