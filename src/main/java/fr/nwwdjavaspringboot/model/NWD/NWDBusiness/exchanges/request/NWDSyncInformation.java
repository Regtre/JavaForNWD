package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class NWDSyncInformation implements INWDSerializable, Serializable {

    public Boolean useMe = true;

    /// <summary>
    /// Sync DateTime Last time
    /// </summary>
    public Date oldSyncDateTime;

    /// <summary>
    /// Sync Commit Id of request/Transaction Last time
    /// </summary>
    public BigInteger oldSyncCommitId;

    /// <summary>
    /// Sync DateTime
    /// </summary>
    public Date syncDateTime;

    /// <summary>
    /// Sync Commit Id of request/Transaction
    /// </summary>
    public BigInteger syncCommitId;

    public NWDSyncInformation()
    {
        syncDateTime = new Date();
        syncCommitId = BigInteger.ONE;
        oldSyncDateTime = new Date(0);
        oldSyncCommitId = BigInteger.ZERO;
    }


}
