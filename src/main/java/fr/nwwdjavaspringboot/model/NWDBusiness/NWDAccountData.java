package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDAccountDependence;

public class NWDAccountData extends NWDBasicModel implements INWDAccountDependence {

    public long Account;
    public short Range;

    public long getAccount() {
        return Account;
    }

    public void setAccount(long account) {
        Account = account;
    }

    public short getRange() {
        return Range;
    }

    public void setRange(short range) {
        Range = range;
    }
}
