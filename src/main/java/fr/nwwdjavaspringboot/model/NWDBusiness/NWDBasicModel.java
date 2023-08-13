package fr.nwwdjavaspringboot.model.NWDBusiness;

public class NWDBasicModel extends NWDDatabaseBasicModel{

    private long ProjectId;

    public void CopyFrom(NWDBasicModel sOther){
        super.CopyFrom(sOther);
        ProjectId = sOther.ProjectId;
    }
}
