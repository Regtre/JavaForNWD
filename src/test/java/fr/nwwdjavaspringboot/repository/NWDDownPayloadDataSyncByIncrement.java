package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDDownPayload;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDStudioDataStorage;

import java.math.BigInteger;
import java.util.List;

public class NWDDownPayloadDataSyncByIncrement extends NWDDownPayload {

    public BigInteger PlayerLastSync ;
    public List<NWDPlayerDataStorage> PlayerDataList ;
    public BigInteger StudioLastSync ;
    public List<NWDStudioDataStorage> StudioDataList ;

}
