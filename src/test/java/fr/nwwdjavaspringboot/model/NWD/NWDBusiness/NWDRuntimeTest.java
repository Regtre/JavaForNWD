package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.account.NWDAccountSign;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDExchangeDevice;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestRuntime;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDResponseRuntime;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDProjectKey;
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
        NWDRequestRuntime signInRequest = NWDRequestRuntime.CreateRequestSignIn(projectKey, playerToken,
                 account, exchangeOrigin, exchangeDevice);
        String response = nwdRuntime.postRequestRuntime(signInRequest);

        /* STEP  */
        System.out.printf(response);

        Gson gson = new GsonBuilder().create();
        NWDResponseRuntime responseRuntime = gson.fromJson(response, NWDResponseRuntime.class);

        System.out.println("test ->  " + responseRuntime.runtimeKind);

    }

    @Test
    public void SerializeAndDeSerializerTest(){
        String jsonString = """
      {
        "id": 1,
        "firstName": "lokesh",
        "lastName": "gupta",
        "dateOfBirth": "lived1999-01-01"
      }""";

        Gson gson = new GsonBuilder().create();

        User user = gson.fromJson(jsonString, User.class);

        System.out.println(user.firstName);
    }

    @Test
    public void signUpTest() throws IOException, ArgumentNullException {
        NWDRequestRuntime signUpRequest = NWDRequestRuntime.CreateRequestSignUp(projectKey, playerToken,
                account, exchangeOrigin, exchangeDevice);
       String response = nwdRuntime.postRequestRuntime(signUpRequest);

       /* STEP  */
        Gson gson = new GsonBuilder().create();
        NWDResponseRuntime responseRuntime = gson.fromJson(response, NWDResponseRuntime.class);

        System.out.println("test ->  " + responseRuntime.runtimeKind);
    }

}