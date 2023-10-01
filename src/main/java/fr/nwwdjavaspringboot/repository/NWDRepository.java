package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDResponseRuntime;
import fr.nwwdjavaspringboot.model.NWD.NWDDownPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.util.ArgumentNullException;

import java.io.UnsupportedEncodingException;

public class NWDRepository {

    RequestSenderForNWD requestSenderForNWD = new RequestSenderForNWD(new RuntimeCreatorForNWD());
    RuntimeCreatorForNWD runtimeCreatorForNWD = new RuntimeCreatorForNWD();

    public NWDRepository() throws ArgumentNullException, UnsupportedEncodingException {
    }

    protected NWDDownPayloadDataSyncByIncrement findAllPlayerData(NWDRequestPlayerToken token) {
        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.getAllPlayerDataRequest(token));
        return nwdResponseRuntime.getPayload(new NWDProjectInformation(), NWDDownPayloadDataSyncByIncrement.class);

    }

}
