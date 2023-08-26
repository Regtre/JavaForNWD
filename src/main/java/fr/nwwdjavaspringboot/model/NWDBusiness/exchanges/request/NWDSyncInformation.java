package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request;

import java.io.Serializable;
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
    public int oldSyncCommitId;

    /// <summary>
    /// Sync DateTime
    /// </summary>
    public Date syncDateTime;

    /// <summary>
    /// Sync Commit Id of request/Transaction
    /// </summary>
    public int syncCommitId;

    public NWDSyncInformation()
    {
        syncDateTime = new Date(0);
        syncCommitId = 0;
        oldSyncDateTime = new Date(0);
        oldSyncCommitId = 0;
    }


}
