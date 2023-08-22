package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account.NWDAccountSign;

import java.io.Serializable;

public class NWDUpPayloadAccountSignUp extends NWDUpPayload implements Serializable {

    public NWDAccountSign AccountSign;

    public NWDUpPayloadAccountSignUp(NWDAccountSign sAccountSign) {
        super();
        AccountSign = sAccountSign;
    }
}
