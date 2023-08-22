package fr.nwwdjavaspringboot.model.NWDBusiness;

public class NWDBasicModel extends NWDDatabaseBasicModel{

    public long projectId;

    public void CopyFrom(NWDBasicModel sOther){
        super.CopyFrom(sOther);
        projectId = sOther.projectId;
    }
}
