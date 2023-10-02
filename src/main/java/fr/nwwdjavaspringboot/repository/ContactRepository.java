package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataFactory;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDStudioDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDResponseRuntime;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDSyncInformation;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDUpPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDDownPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDPlayerData;
import fr.nwwdjavaspringboot.model.NWD.NWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import fr.nwwdjavaspringboot.util.SendRequestUtil;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ContactRepository extends NWDRepository {

    public NWDRequestPlayerToken playerToken;
    RequestSenderForNWD requestSenderForNWD = new RequestSenderForNWD(new RuntimeCreatorForNWD());
    RuntimeCreatorForNWD runtimeCreatorForNWD = new RuntimeCreatorForNWD();

    NWDRepository nwdRepository = new NWDRepository();

    List<Contact> contacts;

    public ContactRepository() throws ArgumentNullException, UnsupportedEncodingException {
    }

    public NWDRequestPlayerToken simulatedUser() {
        return requestSenderForNWD.simulatedUser();
    }

    public List<Contact> findAll(NWDRequestPlayerToken token) {
        List<Contact> contacts = new ArrayList<Contact>();
        NWDDownPayloadDataSyncByIncrement data = nwdRepository.getAllData(token);
        if (data == null) return contacts;
        for (NWDPlayerDataStorage playerDataStorage :
                data.playerDataList) {
            contacts.add((Contact) NWDPlayerDataFactory.FromPlayerDataStorage(playerDataStorage, Contact.class));

        }

        return contacts;
    }

    public void remove(Contact contact) {
    }

    public void create(Contact contact, NWDRequestPlayerToken token) {

        NWDUpPayloadDataSyncByIncrement rUpPayload = SendRequestUtil.createUpPayloadForAContact(contact, token);
        NWDDownPayloadDataSyncByIncrement payload = nwdRepository.create(rUpPayload,token);
    }


    public void update(Contact contact) {
    }
}
