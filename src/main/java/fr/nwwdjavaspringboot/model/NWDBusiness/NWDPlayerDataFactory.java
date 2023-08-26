package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.google.gson.Gson;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWDPlayerData;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class NWDPlayerDataFactory {

    public static NWDPlayerDataStorage ToDataPlayerStorage(NWDPlayerData sO, Type type, BigInteger sAccountReference) {
        Gson gson = new Gson();

        return new NWDPlayerDataStorageBuilder().setCreation(sO.creation).setModification(sO.modification)
                .setAvailableForWeb(sO.AvailableForWeb).setAvailableForApp(sO.AvailableForApp).setAvailableForGame(sO.AvailableForGame)
                .setDataTrack(sO.DataTrack).setClassName(type.getTypeName()).setJson(gson.toJson(sO)).setAccount(sO.Account)
                .setReference(sO.reference).setTrashed(sO.trashed).build();
    }

    public static List<NWDPlayerDataStorage> ToPlayerDataStorage(List<NWDPlayerData> list, BigInteger sAccountReference) {
        return list.stream().filter(Objects::nonNull).map(tBasicModel -> ToDataPlayerStorage(tBasicModel, tBasicModel.getClass(), sAccountReference)).toList();
    }


    public static NWDPlayerData FromPlayerDataStorage(NWDPlayerDataStorage sData, Type tType) {
        NWDPlayerData tObject = new Gson().fromJson(sData.json, tType);
        if (tObject != null) {
            tObject.SyncDatetime = sData.syncDatetime;
            tObject.Commit = sData.commit;
            tObject.modification = sData.modification;
        }

        return tObject;
    }
}
