package fr.nwwdjavaspringboot.service;

import fr.nwwdjavaspringboot.facade.IContactBack;
import fr.nwwdjavaspringboot.facade.IContactService;
import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.repository.ContactBack;
import fr.nwwdjavaspringboot.util.BigIntegerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    @Autowired
    private IContactBack contactBack;

    private static List<Contact> contacts = new ArrayList<Contact>();

    @Autowired
    public ContactService(IContactBack cb) {
        contactBack = cb;
    }

    public NWDRequestPlayerToken simulatedUser() {
        return contactBack.simulatedUser();
    }

    public List<Contact> findAll(NWDRequestPlayerToken token) {
        contacts = contactBack.findAll(token);
        return contacts;
    }

    public void remove(BigInteger contactReference, NWDRequestPlayerToken token) {
        Optional<Contact> contactOp = contacts.stream().filter(
                        c -> c.reference != null)
                .filter( c -> c.reference.equals(contactReference))
                .findFirst();
        contactOp.ifPresent(contact -> contactBack.remove(contact, token));
    }

    public void create(Contact contact, NWDRequestPlayerToken token) {

        contact.account = token.getPlayerReference();
        contact.reference = BigIntegerUtil.incrementTheBiggerValueInTheList(listOfAccountRef(
                contactBack.findAll(token)
        ));
        contactBack.create(contact, token);
    }

    public void update(Contact contact, NWDRequestPlayerToken token){
        contact.account = token.getPlayerReference();
        contactBack.update(contact, token);
    }


    private List<BigInteger> listOfAccountRef(List<Contact> contacts) {
        List<BigInteger> accountRef = new ArrayList<BigInteger>();
        contacts.stream().filter(c -> c.reference != null)
                        .forEach(c -> accountRef.add(c.reference));
        return accountRef;
    }

    public Contact find(BigInteger contactReference) {
        Optional<Contact> contactOp = contacts.stream()
                .filter(c -> c.reference != null)
                .filter( c -> c.reference.equals(contactReference))
                .findAny();
        return contactOp.orElse(null);
    }
}
