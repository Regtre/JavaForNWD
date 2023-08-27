package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataProcessKind;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;

import java.math.BigInteger;

public class NWDPlayerDataStorageBuilder {

    public BigInteger account;
    public int range;
    public BigInteger creation;
    public BigInteger modification;
    public boolean active;
    public boolean trashed;
    public BigInteger reference;

    @JsonIgnore
    public BigInteger rowId;

    public BigInteger projectId;

    public int dataTrack;
    public boolean availableForWeb = false;
    public boolean availableForGame = false;
    public boolean availableForApp = false;
    public int syncDatetime;

    public int commit;
    public String className;
    public String json;
    public String indexOne;
    public String indexTwo;
    public String indexThree;
    public String indexFour;

    public NWDPlayerDataStorageBuilder setProjectId(BigInteger projectId) {
        this.projectId = projectId;
        return this;
    }

    public NWDPlayerDataStorageBuilder setDataTrack(int dataTrack) {
        this.dataTrack = dataTrack;
        return this;
    }

    public NWDPlayerDataStorageBuilder setAvailableForWeb(boolean availableForWeb) {
        this.availableForWeb = availableForWeb;
        return this;

    }

    public NWDPlayerDataStorageBuilder setAvailableForGame(boolean availableForGame) {
        this.availableForGame = availableForGame;
        return this;

    }

    public NWDPlayerDataStorageBuilder setAvailableForApp(boolean availableForApp) {
        this.availableForApp = availableForApp;
        return this;

    }

    public NWDPlayerDataStorageBuilder setSyncDatetime(int syncDatetime) {
        this.syncDatetime = syncDatetime;
        return this;

    }

    public NWDPlayerDataStorageBuilder setCommit(int commit) {
        this.commit = commit;
        return this;

    }

    public NWDPlayerDataStorageBuilder setClassName(String className) {
        this.className = className;
        return this;

    }

    public NWDPlayerDataStorageBuilder setJson(String json) {
        this.json = json;
        return this;

    }

    public NWDPlayerDataStorageBuilder setIndexOne(String indexOne) {
        this.indexOne = indexOne;
        return this;

    }

    public NWDPlayerDataStorageBuilder setIndexTwo(String indexTwo) {
        this.indexTwo = indexTwo;
        return this;

    }

    public NWDPlayerDataStorageBuilder setIndexThree(String indexThree) {
        this.indexThree = indexThree;
        return this;

    }

    public NWDPlayerDataStorageBuilder setIndexFour(String indexFour) {
        this.indexFour = indexFour;
        return this;

    }

    public NWDPlayerDataStorageBuilder setCreation(BigInteger creation) {
        this.creation = creation;
        return this;
    }

    public NWDPlayerDataStorageBuilder setModification(BigInteger modification) {
        this.modification = modification;
        return this;
    }

    public NWDPlayerDataStorageBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    public NWDPlayerDataStorageBuilder setTrashed(boolean trashed) {
        this.trashed = trashed;
        return this;
    }

    public NWDPlayerDataStorageBuilder setReference(BigInteger reference) {
        this.reference = reference;
        return this;
    }

    public NWDPlayerDataStorageBuilder setRowId(BigInteger rowId) {
        this.rowId = rowId;
        return this;
    }

    public NWDPlayerDataStorageBuilder setAccount(BigInteger account) {
        this.account = account;
        return this;
    }

    public NWDPlayerDataStorageBuilder setRange(int range) {
        this.range = range;
        return this;
    }

    public NWDPlayerDataStorageBuilder setProcess(NWDPlayerDataProcessKind process) {
        this.process = process;
        return this;
    }


    public NWDPlayerDataProcessKind process = NWDPlayerDataProcessKind.None;

    public NWDPlayerDataStorage build() {
        return new NWDPlayerDataStorage(this);
    }
}
