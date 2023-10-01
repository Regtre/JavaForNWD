package fr.nwwdjavaspringboot.util;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataFactory;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDStudioDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDSyncInformation;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDUpPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDPlayerData;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class SendRequestUtil {

    public static HttpHeaders getHeader() {
        /*      HEADER       */
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> param = new HashMap<String, String>();
        param.put("Connection", "keep-alive");
        param.put("Accept", "*/*");
        param.put("Content-Type", "application/json");
        headers.setAll(param);
        return headers;
    }

    public static NWDUpPayloadDataSyncByIncrement createUpPayloadForAContact(NWDPlayerData playerData, NWDRequestPlayerToken token) {
        NWDUpPayloadDataSyncByIncrement rUpPayload = new NWDUpPayloadDataSyncByIncrement();
        List<NWDPlayerData> contactList = new ArrayList<>(
                Arrays.asList(playerData)
        );

        rUpPayload.PlayerDataList = NWDPlayerDataFactory.ToPlayerDataStorage(contactList, token.getPlayerReference());
        rUpPayload.PlayerDataSyncInformation = new NWDSyncInformation();
        rUpPayload.StudioDataList = new ArrayList<NWDStudioDataStorage>();
        rUpPayload.StudioDataSyncInformation = new NWDSyncInformation();

        return rUpPayload;
    }
}
