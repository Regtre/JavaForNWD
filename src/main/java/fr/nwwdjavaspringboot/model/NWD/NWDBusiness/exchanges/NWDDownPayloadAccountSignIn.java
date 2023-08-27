package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import java.util.List;

public class NWDDownPayloadAccountSignIn extends NWDDownPayload {
    public boolean Success;
    public long PlayerLastSync;
    public List<NWDPlayerDataStorage> PlayerDataList;
    public long StudioLastSync;
    public List<NWDStudioDataStorage> StudioDataList;

}
