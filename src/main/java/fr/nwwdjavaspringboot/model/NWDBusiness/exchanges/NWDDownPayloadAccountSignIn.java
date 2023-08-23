package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account.NWDAccountSign;

import java.util.ArrayList;
import java.util.List;

public class NWDDownPayloadAccountSignIn extends NWDDownPayload {
    public boolean Success;
    public long PlayerLastSync;
    public List<NWDPlayerDataStorage> PlayerDataList;
    public long StudioLastSync;
    public List<NWDStudioDataStorage> StudioDataList;

}
