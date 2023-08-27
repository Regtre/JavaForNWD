package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.account.NWDAccountSign;

import java.io.Serializable;

public class NWDUpPayloadAccountSignUp extends NWDUpPayload implements Serializable {

    public NWDAccountSign AccountSign;

    public NWDUpPayloadAccountSignUp(NWDAccountSign sAccountSign) {
        super();
        AccountSign = sAccountSign;
    }
}
