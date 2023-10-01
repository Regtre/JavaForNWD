package fr.nwwdjavaspringboot.service;

import fr.nwwdjavaspringboot.model.Account;
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
import fr.nwwdjavaspringboot.repository.ContactRepository;
import fr.nwwdjavaspringboot.util.BigIntegerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public NWDRequestPlayerToken simulatedUser() {
        return contactRepository.simulatedUser();
    }

    public List<Contact> findAll(NWDRequestPlayerToken token) {
        return contactRepository.findAll(token);
    }

    public void remove(Contact contact) {
        contactRepository.remove(contact);
    }

    public void create(Contact contact, NWDRequestPlayerToken token) {

        contact.account = token.getPlayerReference();
        contact.reference = BigIntegerUtil.incrementTheBiggerValueInTheList(listOfAccountRef(
                contactRepository.findAll(token)
        ));

        contactRepository.create(contact, token);

    }

    public void update(Contact contact) {
    }


    private List<BigInteger> listOfAccountRef(List<Contact> contacts) {
        List<BigInteger> accountRef = new ArrayList<BigInteger>();
        contacts.stream().forEach(
                c ->
                {
                    if (c.reference != null) {
                        accountRef.add(c.reference);

                    }
                }
        );
        return accountRef;
    }

}
