package fr.nwwdjavaspringboot.service;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.repository.ContactBack;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import fr.nwwdjavaspringboot.util.BigIntegerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactBack contactRepository;

    private static List<Contact> contacts = new ArrayList<Contact>();

    @Autowired
    public ContactService(ContactBack cb) {
        contactRepository = cb;
    }

    public NWDRequestPlayerToken simulatedUser() {
        return contactRepository.simulatedUser();
    }

    public List<Contact> findAll(NWDRequestPlayerToken token) {
        contacts = contactRepository.findAll(token);
        return contacts;
    }

    public void remove(BigInteger contactReference, NWDRequestPlayerToken token) throws ArgumentNullException, UnsupportedEncodingException {
        Optional<Contact> contactOp = contacts.stream().filter(
                        c -> {
                            if (c.reference != null)
                                return c.reference.equals(contactReference);
                            else
                                return false;
                        }
                )
                .findFirst();
        if (contactOp.isPresent()) new ContactBack().remove(contactOp.get(), token);
    }

    public void create(Contact contact, NWDRequestPlayerToken token) {

        contact.account = token.getPlayerReference();
        contact.reference = BigIntegerUtil.incrementTheBiggerValueInTheList(listOfAccountRef(
                contactRepository.findAll(token)
        ));

        contactRepository.create(contact, token);

    }

    public void update(Contact contact, NWDRequestPlayerToken token) throws ArgumentNullException, UnsupportedEncodingException {
        contact.account = token.getPlayerReference();
        new ContactBack().update(contact, token);
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

    public Contact find(BigInteger contactReference) {
        Optional<Contact> contactOp = contacts.stream().filter(
                        c -> {
                            if (c.reference != null)
                                return c.reference.equals(contactReference);
                            else
                                return false;
                        }
                )
                .findAny();
        return contactOp.orElse(null);
    }
}
