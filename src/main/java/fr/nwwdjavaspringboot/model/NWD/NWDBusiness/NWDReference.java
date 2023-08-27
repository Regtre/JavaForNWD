package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;


public class NWDReference<T extends NWDDatabaseBasicModel> implements INWDSubModel {

    public long Reference;
    public NWDReference() {
    }

    public NWDReference(long sReference) {
        Reference = sReference;
    }

//    public NWDReference(T sObject) {
//        super(sObject != null ? sObject.getReference() : 0);
//    }
}
