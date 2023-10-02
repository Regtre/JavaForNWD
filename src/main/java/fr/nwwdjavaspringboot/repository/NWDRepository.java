package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDPlayerDataFactory;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDDownPayload;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDResponseRuntime;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDUpPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDDownPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import fr.nwwdjavaspringboot.util.SendRequestUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class NWDRepository {

    RequestSenderForNWD requestSenderForNWD = new RequestSenderForNWD(new RuntimeCreatorForNWD());
    RuntimeCreatorForNWD runtimeCreatorForNWD = new RuntimeCreatorForNWD();

    public NWDRepository() throws ArgumentNullException, UnsupportedEncodingException {
    }

    private NWDDownPayloadDataSyncByIncrement updateTokenAndGetPayload(NWDResponseRuntime nwdResponseRuntime,
                                                                       NWDRequestPlayerToken token) {
        token.setToken(nwdResponseRuntime.playerToken.getToken());
        token.setOldToken(nwdResponseRuntime.playerToken.getOldToken());
        return nwdResponseRuntime.getPayload(new NWDProjectInformation(), NWDDownPayloadDataSyncByIncrement.class);
    }

    protected NWDDownPayloadDataSyncByIncrement findAllPlayerData(NWDRequestPlayerToken token) {
        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.getAllPlayerDataRequest(token));
        return nwdResponseRuntime.getPayload(new NWDProjectInformation(), NWDDownPayloadDataSyncByIncrement.class);

    }

    public NWDDownPayloadDataSyncByIncrement getAllData(NWDRequestPlayerToken token) {
        List<Contact> contacts = new ArrayList<Contact>();

        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.getAllPlayerDataRequest(token));
        return updateTokenAndGetPayload(nwdResponseRuntime, token);

    }

    public void remove(Contact contact) {
    }

    public NWDDownPayloadDataSyncByIncrement create(NWDUpPayloadDataSyncByIncrement rUpPayload, NWDRequestPlayerToken token) {
        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.syncDataRequest(token, rUpPayload));
        return updateTokenAndGetPayload(nwdResponseRuntime, token);
    }


}
