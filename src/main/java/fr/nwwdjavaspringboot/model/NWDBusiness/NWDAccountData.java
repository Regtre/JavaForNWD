package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDAccountDependence;
import lombok.Getter;

@Getter
public class NWDAccountData extends NWDBasicModel implements INWDAccountDependence {

    public long Account;
    public short Range;

    public void setAccount(long account) {
        Account = account;
    }

    public void setRange(short range) {
        Range = range;
    }
}
