package fr.nwwdjavaspringboot.model.NWD;

import com.google.gson.annotations.SerializedName;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDDownPayload;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDStudioDataStorage;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
public class NWDDownPayloadDataSyncByIncrement extends NWDDownPayload implements Serializable {

    @SerializedName("PlayerLastSync")
    public BigInteger playerLastSync;
    @SerializedName("PlayerDataList")
    public List<NWDPlayerDataStorage> playerDataList;
    @SerializedName("StudioLastSync")
    public BigInteger studioLastSync;
    @SerializedName("StudioDataList")
    public List<NWDStudioDataStorage> studioDatalist;


}
