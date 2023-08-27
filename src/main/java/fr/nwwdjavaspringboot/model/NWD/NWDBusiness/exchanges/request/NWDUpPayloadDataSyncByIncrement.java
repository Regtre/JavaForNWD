package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDStudioDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDUpPayload;

import java.util.List;

public class NWDUpPayloadDataSyncByIncrement extends NWDUpPayload {

    public NWDSyncInformation PlayerDataSyncInformation ;
    public List<NWDPlayerDataStorage> PlayerDataList ;
    public NWDSyncInformation StudioDataSyncInformation ;
    public List<NWDStudioDataStorage> StudioDataList ;

    public List<NWDVolatileData> VolatileDataList ;
}
