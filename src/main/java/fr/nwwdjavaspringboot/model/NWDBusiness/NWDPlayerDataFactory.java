package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWDPlayerData;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

public class NWDPlayerDataFactory {

    public static NWDPlayerDataStorage ToDataPlayerStorage(NWDPlayerData sO, BigInteger sAccountReference)
    {

        NWDPlayerDataStorage tPlayerData = new NWDPlayerDataStorage
                (
             sO.Creation,
                     sO.Modification,
                     sO.AvailableForWeb,
                      sO.AvailableForApp,
                      sO.AvailableForGame,
                      sO.DataTrack,
                      sO.GetType().AssemblyQualifiedName,
                      JsonConvert.SerializeObject(sO),
                      sO.Account,
                      sO.Reference,
                      sO.Trashed
                );
        return tPlayerData;
    }

    public static List<NWDPlayerDataStorage> ToPlayerDatasStorage(List<NWDPlayerData> list, BigInteger sAccountReference)
    {
        return list.stream().filter(tBasicModel -> tBasicModel != null).map(tBasicModel -> ToDataPlayerStorage(tBasicModel, sAccountReference)).toList();
    }


    public static NWDPlayerData FromPlayerDataStorage(NWDPlayerDataStorage sData, Type tType)
    {
        NWDPlayerData tObject = JsonConvert.DeserializeObject(sData.Json, tType) as NWDPlayerData;
        if (tObject != null)
        {
            tObject.SyncDatetime = sData.SyncDatetime;
            tObject.Commit = sData.Commit;
            tObject.Modification = sData.Modification;
        }

        return tObject;
    }
}
