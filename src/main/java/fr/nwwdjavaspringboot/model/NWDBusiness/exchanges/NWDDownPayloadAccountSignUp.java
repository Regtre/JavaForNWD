package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account.NWDAccountSign;

import java.util.ArrayList;
import java.util.List;

public class NWDDownPayloadAccountSignUp extends NWDDownPayload {
    public List<NWDAccountSign> AccountSignList = new ArrayList<NWDAccountSign>();
}
