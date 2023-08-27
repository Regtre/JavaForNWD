package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import java.math.BigInteger;

public class NWDBasicModel extends NWDDatabaseBasicModel{

    public BigInteger projectId;

    public void CopyFrom(NWDBasicModel sOther){
        super.CopyFrom(sOther);
        projectId = sOther.projectId;
    }
}
