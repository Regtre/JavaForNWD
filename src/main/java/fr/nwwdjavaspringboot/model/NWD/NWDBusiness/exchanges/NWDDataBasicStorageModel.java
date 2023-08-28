package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import com.google.gson.annotations.SerializedName;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDBasicModel;

import java.math.BigInteger;

public class NWDDataBasicStorageModel extends NWDBasicModel {

    @SerializedName("DataTrack")
    public int dataTrack;
    @SerializedName("AvailableForWeb")
    public boolean availableForWeb = false;
    @SerializedName("AvailableForGame")
    public boolean availableForGame = false;
    @SerializedName("AvailableForApp")
    public boolean availableForApp = false;
    @SerializedName("SyncDatetime")
    public int syncDatetime;
    @SerializedName("Commit")
    public BigInteger commit;
    @SerializedName("ClassName")
    public String className;
    @SerializedName("Json")
    public String json;
    @SerializedName("IndexOne")
    public String indexOne;
    @SerializedName("IndexTwo")
    public String indexTwo;
    @SerializedName("IndexThree")
    public String indexThree;
    @SerializedName("IndexFour")
    public String indexFour;

    public NWDDataBasicStorageModel() {
    }

}
