package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDPlayerDataStorageBuilder;
import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDAccountDependence;

import java.math.BigInteger;

public class NWDPlayerDataStorage extends NWDDataBasicStorageModel implements INWDAccountDependence {

    public BigInteger account;
    public int range;
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
