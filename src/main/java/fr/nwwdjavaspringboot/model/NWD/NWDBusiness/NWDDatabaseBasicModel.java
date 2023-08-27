package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class NWDDatabaseBasicModel {

    public BigInteger creation;
    public BigInteger modification;
    public boolean active;
    public boolean trashed;
    public BigInteger reference;

    public BigInteger rowId;

    public NWDDatabaseBasicModel() {}

    public void CopyFrom(NWDDatabaseBasicModel sOther)
    {
        creation = sOther.creation;
        modification = sOther.modification;
        active = sOther.active;
        trashed = sOther.trashed;
        reference = sOther.reference;
        rowId = sOther.rowId;
    }

    public void setCreation(BigInteger creation) {
        this.creation = creation;
    }

    public void setModification(BigInteger modification) {
        this.modification = modification;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTrashed(boolean trashed) {
        this.trashed = trashed;
    }

    public void setReference(BigInteger reference) {
        this.reference = reference;
    }

    public void setRowId(BigInteger rowId) {
        this.rowId = rowId;
    }
}
