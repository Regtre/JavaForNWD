package fr.nwwdjavaspringboot.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nwwdjavaspringboot.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestRuntime;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDResponseRuntime;
import fr.nwwdjavaspringboot.util.SendRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Repository
@Component
@Configurable
public class RequestSenderForNWD {

    private final RuntimeCreatorForNWD customProperties;
    public NWDRequestPlayerToken playerToken;
    private final RestTemplate restTemplate = new RestTemplate();


    @Autowired
    public RequestSenderForNWD(RuntimeCreatorForNWD customProperties) {
        this.customProperties = customProperties;
    }


    public NWDResponseRuntime send(NWDRequestRuntime request) {

        if (playerToken != null)
            request.PlayerToken.setPlayerReference(playerToken.getPlayerReference());

        ResponseEntity<String> responseEntity = restTemplate.exchange(customProperties.getApiUrl(), HttpMethod.POST,
                new HttpEntity<NWDRequestRuntime>(request, SendRequestUtil.getHeader()), String.class);

        /* check status code */
        if (responseEntity.getStatusCode() != HttpStatus.OK && responseEntity.getStatusCode() != HttpStatus.ACCEPTED)
            throw new HttpClientErrorException(responseEntity.getStatusCode(), "Request problem", responseEntity.getBody().getBytes(), Charset.defaultCharset());

        /* Translate */
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(responseEntity.getBody(), NWDResponseRuntime.class);

    }

    public String getToken() {
        playerToken = send(customProperties.signUpRequest()).getPlayerToken();
        String token = playerToken.getToken();
        if (token.isEmpty()) {
            playerToken = send(customProperties.signInRequest()).playerToken;
            token = playerToken.getToken();
        }
        if (token.isEmpty())
            throw new NullPointerException("Token empty");
        return token;

    }
}
