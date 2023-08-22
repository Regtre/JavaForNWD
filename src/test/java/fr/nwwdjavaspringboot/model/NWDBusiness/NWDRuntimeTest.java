package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.*;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account.NWDAccountSign;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeDevice;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange.NWDExchangeRuntimeKind;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestRuntime;
import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDProjectKey;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class NWDRuntimeTest {

    private NWDRuntime nwdRuntime;
    private INWDProjectKey projectKey;
    private NWDRequestPlayerToken playerToken;
    private NWDExchangeOrigin exchangeOrigin;
    private NWDExchangeDevice exchangeDevice;
    private NWDAccountSign accountMail;
    private NWDAccountSign account;


    @BeforeEach
    public void setUp() throws ArgumentNullException, UnsupportedEncodingException {
        nwdRuntime = new NWDRuntime();

        NWDProjectInformation projectInformation = new NWDProjectInformation();
        projectKey = projectInformation;
        playerToken = new NWDRequestPlayerToken(projectInformation);
//        accountMail = NWDAccountSign.CreateEmailPassword("r.poissonnier@hotmail.fr", "REMY_le_KING", playerToken.getProjectId());
        account = NWDAccountSign.CreateLoginPassword("LeKing", "REMY_le_KING", playerToken.getProjectId());



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
    public void signUpTest() throws IOException, ArgumentNullException {
        NWDRequestRuntime signUpRequest = NWDRequestRuntime.CreateRequestSignUp(projectKey, playerToken,
                account, exchangeOrigin, exchangeDevice);
        System.out.println(nwdRuntime.postRequestRuntime(signUpRequest).toString());
    }

}