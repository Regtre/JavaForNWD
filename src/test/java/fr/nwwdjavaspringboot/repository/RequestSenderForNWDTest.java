package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.NWD.NWDDownPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataFactory;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDStudioDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.*;
import fr.nwwdjavaspringboot.model.NWD.NWDPlayerData;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Configurable
public class RequestSenderForNWDTest {

    @Autowired
    RequestSenderForNWD requestSenderForNWD = new RequestSenderForNWD(new RuntimeCreatorForNWD());
    RuntimeCreatorForNWD runtimeCreatorForNWD = new RuntimeCreatorForNWD();

    public RequestSenderForNWDTest() throws ArgumentNullException, UnsupportedEncodingException {
    }

    @Test
    public void getTokenTest() {
        String token = requestSenderForNWD.getToken();
        System.out.println("TOKEN -> " + token);
        assertNotNull(token);

    }

    @Test
    public void getAllPlayerDataSendTest() {
        requestSenderForNWD.getToken();
        NWDRequestPlayerToken token = requestSenderForNWD.playerToken;
        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.getAllPlayerDataRequest(token));
        assertNotSame(nwdResponseRuntime.status, NWDRequestStatus.Error);
        NWDDownPayloadDataSyncByIncrement data = nwdResponseRuntime.getPayload(new NWDProjectInformation(), NWDDownPayloadDataSyncByIncrement.class);
    }

    @Test
    public void syncDataSendTest() {
        requestSenderForNWD.getToken();
        NWDRequestPlayerToken token = requestSenderForNWD.playerToken;

        NWDUpPayloadDataSyncByIncrement data = createSyncData(token.getPlayerReference());
        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.syncDataRequest(token, data));
        assertNotSame(nwdResponseRuntime.status, NWDRequestStatus.Error);
        NWDDownPayloadDataSyncByIncrement payload = nwdResponseRuntime.getPayload(new NWDProjectInformation(), NWDDownPayloadDataSyncByIncrement.class);
    }

    private NWDUpPayloadDataSyncByIncrement createSyncData(BigInteger sAccountReference) {
        NWDUpPayloadDataSyncByIncrement rUpPayload = new NWDUpPayloadDataSyncByIncrement();

        Contact c1 = new Contact("Lila", "Nickler");
        Contact c2 = new Contact("Remy", "Poissonnier");
        Contact c3 = new Contact("Sylvain", "Carton");
        List<NWDPlayerData> contactList = new ArrayList<>(
                Arrays.asList(c1, c2, c3)
        );

        rUpPayload.PlayerDataList = NWDPlayerDataFactory.ToPlayerDataStorage(contactList, sAccountReference);
        rUpPayload.PlayerDataSyncInformation = new NWDSyncInformation();
        rUpPayload.StudioDataList = new ArrayList<NWDStudioDataStorage>();
        rUpPayload.StudioDataSyncInformation = new NWDSyncInformation();
        return rUpPayload;
    }
}