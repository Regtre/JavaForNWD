package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDBasicModel;

public class NWDDataBasicStorageModel extends NWDBasicModel {

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

    public NWDDataBasicStorageModel() {
    }

}
