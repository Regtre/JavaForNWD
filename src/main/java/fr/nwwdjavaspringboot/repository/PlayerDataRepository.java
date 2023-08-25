package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDPlayerDataStorage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDataRepository {

    private String token;
    private RequestSenderForNWD nwdRequestSender;

    public PlayerDataRepository() {
        initTokenIfEmpty();
    }

    public void initTokenIfEmpty() {
        if (token.isEmpty())
            token = nwdRequestSender.getToken();
    }

    public List<NWDPlayerDataStorage> findAll() {


        return new ArrayList<NWDPlayerDataStorage>();
    }
}
