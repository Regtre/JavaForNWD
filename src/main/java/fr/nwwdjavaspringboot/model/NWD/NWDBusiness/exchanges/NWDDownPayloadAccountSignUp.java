package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.account.NWDAccountSign;

import java.util.ArrayList;
import java.util.List;

public class NWDDownPayloadAccountSignUp extends NWDDownPayload {
    public List<NWDAccountSign> AccountSignList = new ArrayList<NWDAccountSign>();
}
