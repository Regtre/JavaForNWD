package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request;

import java.util.Date;

public class NWDSyncInformation implements INWDSerializable {

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


}
