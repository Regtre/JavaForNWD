package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NWDDatabaseBasicModel {

    private long Creation;
    private long Modification;
    private boolean Active;
    private boolean Trashed;
    public long Reference;

    @JsonIgnore
    public long RowId;

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
    public long getCreation() {
        return Creation;
    }

    public void setCreation(long creation) {
        Creation = creation;
    }

    public long getModification() {
        return Modification;
    }

    public void setModification(long modification) {
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

    public long getReference() {
        return Reference;
    }

    public void setReference(long reference) {
        Reference = reference;
    }

    public long getRowId() {
        return RowId;
    }

    public void setRowId(long rowId) {
        RowId = rowId;
    }
}
