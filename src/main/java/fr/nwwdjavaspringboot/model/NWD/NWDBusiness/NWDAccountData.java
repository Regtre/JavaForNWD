package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDAccountDependence;
import lombok.Getter;

@Getter
public class NWDAccountData extends NWDBasicModel implements INWDAccountDependence {

    public long account;
    public short range;

    public void setAccount(long account) {
        this.account = account;
    }

    public void setRange(short range) {
        this.range = range;
    }
}
