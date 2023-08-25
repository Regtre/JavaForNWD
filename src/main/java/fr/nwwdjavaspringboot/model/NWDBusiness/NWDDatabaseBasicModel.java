package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;

public class NWDDatabaseBasicModel {

    public BigInteger Creation;
    public BigInteger Modification;
    public boolean Active;
    public boolean Trashed;
    public BigInteger Reference;

    @JsonIgnore
    public BigInteger RowId;

    public NWDDatabaseBasicModel() {}

    public void CopyFrom(NWDDatabaseBasicModel sOther)
    {
        Creation = sOther.Creation;
        Modification = sOther.Modification;
        Active = sOther.Active;
        Trashed = sOther.Trashed;
        Reference = sOther.Reference;
        RowId = sOther.RowId;
    }
    public BigInteger getCreation() {
        return Creation;
    }

    public void setCreation(BigInteger creation) {
        Creation = creation;
    }

    public BigInteger getModification() {
        return Modification;
    }

    public void setModification(BigInteger modification) {
        Modification = modification;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public boolean isTrashed() {
        return Trashed;
    }

    public void setTrashed(boolean trashed) {
        Trashed = trashed;
    }

    public BigInteger getReference() {
        return Reference;
    }

    public void setReference(BigInteger reference) {
        Reference = reference;
    }

    public BigInteger getRowId() {
        return RowId;
    }

    public void setRowId(BigInteger rowId) {
        RowId = rowId;
    }
}
