package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import com.google.gson.annotations.SerializedName;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataStorageBuilder;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDAccountDependence;

import java.math.BigInteger;

public class NWDPlayerDataStorage extends NWDDataBasicStorageModel implements INWDAccountDependence {

    @SerializedName("Account")
    public BigInteger account;
    @SerializedName("Range")
    public int range;
    @SerializedName("Process")
    public NWDPlayerDataProcessKind process = NWDPlayerDataProcessKind.None;

    public NWDPlayerDataStorage() {
    }

    public NWDPlayerDataStorage(NWDPlayerDataStorageBuilder b) {
        account = b.account;
        range = b.range;
        dataTrack = b.dataTrack;
        availableForWeb = b.availableForWeb;
        availableForGame = b.availableForGame;
        availableForApp = b.availableForApp;
        syncDatetime = b.syncDatetime;
        commit = b.commit;
        className = b.className;
        json = b.json;
        indexOne = b.indexOne;
        indexTwo = b.indexTwo;
        indexThree = b.indexThree;
        indexFour = b.indexFour;
        projectId = b.projectId;
        creation = b.creation;
        modification = b.modification;
        active = b.active;
        trashed = b.trashed;
        reference = b.reference;

    }

}
