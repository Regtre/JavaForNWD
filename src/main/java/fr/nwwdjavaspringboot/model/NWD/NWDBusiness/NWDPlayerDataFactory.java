package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import com.google.gson.Gson;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDPlayerData;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class NWDPlayerDataFactory {

    public static NWDPlayerDataStorage ToDataPlayerStorage(NWDPlayerData sO, Type type, BigInteger sAccountReference) {
        Gson gson = new Gson();

        return new NWDPlayerDataStorageBuilder().setCreation(sO.creation).setModification(sO.modification)
                .setAvailableForWeb(sO.availableForWeb).setAvailableForApp(sO.availableForApp).setAvailableForGame(sO.availableForGame)
                .setDataTrack(sO.dataTrack).setClassName(type.getTypeName()).setJson(gson.toJson(sO)).setAccount(sO.account)
                .setReference(sO.reference).setTrashed(sO.trashed).build();
    }

    public static List<NWDPlayerDataStorage> ToPlayerDataStorage(List<NWDPlayerData> list, BigInteger sAccountReference) {
        return list.stream().filter(Objects::nonNull).map(tBasicModel -> ToDataPlayerStorage(tBasicModel, tBasicModel.getClass(), sAccountReference)).toList();
    }


    public static NWDPlayerData FromPlayerDataStorage(NWDPlayerDataStorage sData, Type tType) {
        NWDPlayerData tObject = new Gson().fromJson(sData.json, tType);
        if (tObject != null) {
            tObject.syncDatetime = sData.syncDatetime;
            tObject.commit = sData.commit;
            tObject.modification = sData.modification;
        }

        return tObject;
    }
}
