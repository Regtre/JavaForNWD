package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDAccountDependence;

public class NWDPlayerDataStorage extends NWDDataBasicStorageModel implements INWDAccountDependence {

    public long Account;
    public int Range;
    public NWDPlayerDataProcessKind Process = NWDPlayerDataProcessKind.None;
    public NWDPlayerDataStorage()
    {
    }
}
