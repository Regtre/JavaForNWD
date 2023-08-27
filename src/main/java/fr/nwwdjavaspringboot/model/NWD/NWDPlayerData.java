package fr.nwwdjavaspringboot.model.NWD;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDBasicModel;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataProcessKind;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDAccountDependence;

import java.math.BigInteger;

public abstract class NWDPlayerData extends NWDBasicModel implements INWDAccountDependence, INWDAvailableForTarget, INWDDataTrack, INWDSyncCommitByTimestamp {

    public BigInteger account;
    public int range;
    public int dataTrack;
    public boolean availableForWeb = false;
    public boolean availableForGame = false;
    public boolean availableForApp = false;
    public int syncDatetime;
    public int commit;
    public NWDPlayerDataProcessKind process = NWDPlayerDataProcessKind.None;
}
