package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDAccountDependence;

public class NWDPlayerDataStorage extends NWDDataBasicStorageModel implements INWDAccountDependence {

    public long account;
    public int range;
    public NWDPlayerDataProcessKind process = NWDPlayerDataProcessKind.None;
    public NWDPlayerDataStorage()
    {
    }
}
