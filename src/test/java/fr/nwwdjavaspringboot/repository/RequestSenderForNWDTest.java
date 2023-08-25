package fr.nwwdjavaspringboot.repository;

import fr.nwwdjavaspringboot.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestStatus;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDResponseRuntime;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Configurable
public class RequestSenderForNWDTest {

    @Autowired
    RequestSenderForNWD requestSenderForNWD = new RequestSenderForNWD(new RuntimeCreatorForNWD());
    RuntimeCreatorForNWD runtimeCreatorForNWD = new RuntimeCreatorForNWD();

    public RequestSenderForNWDTest() throws ArgumentNullException, UnsupportedEncodingException {
    }

    @Test
    public void getTokenTest(){
        String token = requestSenderForNWD.getToken();
        System.out.println("TOKEN -> "+ token);
        assertNotNull(token);

    }

    @Test
    public void getAllPlayerDataSendTest() {
        String token = requestSenderForNWD.getToken();
        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.getAllPlayerDataRequest(token));
        assertNotSame(nwdResponseRuntime.status, NWDRequestStatus.Error);
        NWDRequestPlayerToken playerToken = nwdResponseRuntime.playerToken;
    }

    @Test
    public void syncDataSendTest() {
        String token = requestSenderForNWD.getToken();
        NWDResponseRuntime nwdResponseRuntime = requestSenderForNWD.send(runtimeCreatorForNWD.syncDataRequest(token));
        assertNotSame(nwdResponseRuntime.status, NWDRequestStatus.Error);
        NWDRequestPlayerToken playerToken = nwdResponseRuntime.playerToken;
    }
}