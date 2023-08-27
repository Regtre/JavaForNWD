package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataFactory;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDStudioDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.*;
import fr.nwwdjavaspringboot.model.NWD.NWDDownPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDPlayerData;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ContactRepository {

    RequestSenderForNWD requestSenderForNWD = new RequestSenderForNWD(new RuntimeCreatorForNWD());
    RuntimeCreatorForNWD runtimeCreatorForNWD = new RuntimeCreatorForNWD();

    public ContactRepository() throws ArgumentNullException, UnsupportedEncodingException {
    }

    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<Contact>();

        return contacts;
    }

    public void remove(Contact contact){}
    public void create(Contact contact){

        requestSenderForNWD.getToken();
        NWDRequestPlayerToken token = requestSenderForNWD.playerToken;

        NWDUpPayloadDataSyncByIncrement rUpPayload = new NWDUpPayloadDataSyncByIncrement();
        List<NWDPlayerData> contactList = new ArrayList<>(
                Arrays.asList(contact)
        );

        rUpPayload.PlayerDataList = NWDPlayerDataFactory.ToPlayerDataStorage(contactList, token.getPlayerReference());
        rUpPayload.PlayerDataSyncInformation = new NWDSyncInformation();
        rUpPayload.StudioDataList = new ArrayList<NWDStudioDataStorage>();
        rUpPayload.StudioDataSyncInformation = new NWDSyncInformation();

        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.syncDataRequest(token, rUpPayload));
        NWDDownPayloadDataSyncByIncrement payload = nwdResponseRuntime.getPayload(new NWDProjectInformation(), NWDDownPayloadDataSyncByIncrement.class);

    }
    public void update(Contact contact){}
    public void delete(Contact contact){}
}
