package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.*;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account.NWDAccountSign;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeDevice;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeRuntimeKind;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestRuntime;
import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDProjectKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class NWDRuntimeTest {

    private NWDRuntime nwdRuntime;
    private INWDProjectKey projectKey;
    private NWDRequestPlayerToken playerToken;
    private NWDExchangeOrigin exchangeOrigin;
    private NWDExchangeDevice exchangeDevice;

    @BeforeEach
    public void setUp() {
        nwdRuntime = new NWDRuntime();

        NWDProjectInformation projectInformation = new NWDProjectInformation();
        projectKey = projectInformation;
        playerToken = new NWDRequestPlayerToken(projectInformation);
        exchangeDevice = NWDExchangeDevice.Web;
        exchangeOrigin = NWDExchangeOrigin.Web;

    }

    @Test
    public void postTest() throws IOException {
        NWDRequestRuntime requestRuntime = NWDRequestRuntime.CreateRequestTest(projectKey, playerToken, exchangeOrigin, exchangeDevice);
        nwdRuntime.post(requestRuntime);

    }

    @Test
    public void signInTest() throws IOException {
        NWDRequestRuntime signInRequest = new NWDRequestRuntime(
                projectKey, playerToken, NWDExchangeRuntimeKind.SignIn, new NWDUpPayload(), exchangeOrigin, exchangeDevice
        );
        nwdRuntime.post(signInRequest);

    }

    @Test
    public void signUpTest() throws IOException {
        NWDAccountSign accountSign =  new NWDAccountSign();
        accountSign.Name = "Remy";
        NWDRequestRuntime signUpRequest = NWDRequestRuntime.CreateRequestSignUp(projectKey, playerToken,
                accountSign,exchangeOrigin, exchangeDevice);
        System.out.println( nwdRuntime.postRequestRuntime(signUpRequest).toString());
    }

}