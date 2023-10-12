package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.facade.IContactBack;
import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataFactory;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDUpPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDDownPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.service.NWDService;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import fr.nwwdjavaspringboot.util.SendRequestUtil;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactBack extends NWDService implements IContactBack {

    public NWDRequestPlayerToken playerToken;
    static RequestSenderForNWD requestSenderForNWD;

    static {
        try {
            requestSenderForNWD = new RequestSenderForNWD(new RuntimeCreatorForNWD());
        } catch (ArgumentNullException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    RuntimeCreatorForNWD runtimeCreatorForNWD = new RuntimeCreatorForNWD();

    NWDService nwdRepository = new NWDService();

    List<Contact> contacts;

    public ContactBack() throws ArgumentNullException, UnsupportedEncodingException {
    }

    public NWDRequestPlayerToken simulatedUser() {
        return requestSenderForNWD.simulatedUser();
    }

    public List<Contact> findAll(NWDRequestPlayerToken token) {
        List<Contact> contacts = new ArrayList<Contact>();
        Contact contact;
        NWDDownPayloadDataSyncByIncrement data = nwdRepository.getAllData(token);
        if (data == null) return contacts;
        for (NWDPlayerDataStorage playerDataStorage :
                data.playerDataList) {
            contact = ((Contact) NWDPlayerDataFactory.FromPlayerDataStorage(playerDataStorage, Contact.class));
            if (!contact.trashed)
                contacts.add((Contact) NWDPlayerDataFactory.FromPlayerDataStorage(playerDataStorage, Contact.class));

        }

        return contacts;
    }


    public void create(Contact contact, NWDRequestPlayerToken token) {

        NWDUpPayloadDataSyncByIncrement rUpPayload = SendRequestUtil.createUpPayloadForAContact(contact, token);
        NWDDownPayloadDataSyncByIncrement payload = nwdRepository.sync(rUpPayload, token);
    }

    public void remove(Contact contact, NWDRequestPlayerToken token) {
        contact.trashed = true;
        NWDUpPayloadDataSyncByIncrement rUpPayload = SendRequestUtil.createUpPayloadForAContact(contact, token);
        NWDDownPayloadDataSyncByIncrement payload = nwdRepository.sync(rUpPayload, token);
    }


    public void update(Contact contact, NWDRequestPlayerToken token) {
        NWDUpPayloadDataSyncByIncrement rUpPayload = SendRequestUtil.createUpPayloadForAContact(contact, token);
        NWDDownPayloadDataSyncByIncrement payload = nwdRepository.sync(rUpPayload, token);
    }
}
