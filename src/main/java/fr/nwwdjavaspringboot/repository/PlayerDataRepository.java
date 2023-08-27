package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDataRepository {

    private String token;
    private final RequestSenderForNWD nwdRequestSender = new RequestSenderForNWD(new RuntimeCreatorForNWD());


    public PlayerDataRepository() throws ArgumentNullException, UnsupportedEncodingException {
        initTokenIfEmpty();
    }

    public void initTokenIfEmpty() {
        if (token == null)
            token = nwdRequestSender.getToken();
    }

    public List<NWDPlayerDataStorage> findAll() {


        return new ArrayList<NWDPlayerDataStorage>();
    }
}
