package fr.nwwdjavaspringboot.facade;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataFactory;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDUpPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDDownPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.repository.RequestSenderForNWD;
import fr.nwwdjavaspringboot.service.NWDService;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import fr.nwwdjavaspringboot.util.SendRequestUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public interface IContactBack {

    public NWDRequestPlayerToken simulatedUser();
    public List<Contact> findAll(NWDRequestPlayerToken token) ;

    public void create(Contact contact, NWDRequestPlayerToken token) ;
    public void remove(Contact contact, NWDRequestPlayerToken token) ;

    public void update(Contact contact, NWDRequestPlayerToken token);
}
