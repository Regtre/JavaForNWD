package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.*;
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
        NWDRequestRuntime requestRuntime = NWDRequestRuntime.CreateRequestTest(projectKey,playerToken,exchangeOrigin,exchangeDevice);
        nwdRuntime.post(requestRuntime);

    }

    @Test
    public void signInTest() throws IOException {
        NWDRequestRuntime signInRequest = new NWDRequestRuntime(
                projectKey,playerToken,NWDExchangeRuntimeKind.SignIn,new NWDUpPayload(),exchangeOrigin,exchangeDevice
        );
        nwdRuntime.post(signInRequest);

    }

    @Test
    public void signUpTest() throws IOException {
        NWDRequestRuntime signInRequest = new NWDRequestRuntime(
                projectKey,playerToken,NWDExchangeRuntimeKind.SignUp,new NWDUpPayload(),exchangeOrigin,exchangeDevice
        );
        nwdRuntime.post(signInRequest);

    }

}