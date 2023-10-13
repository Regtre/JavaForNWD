package fr.nwwdjavaspringboot.facade;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.util.BigIntegerUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IContactService {

    public void remove(BigInteger contactReference, NWDRequestPlayerToken token) ;

    public void create(Contact contact, NWDRequestPlayerToken token) ;

    public void update(Contact contact, NWDRequestPlayerToken token);

    public Contact find(BigInteger contactReference) ;
}
