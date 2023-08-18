package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.google.gson.Gson;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDRequestRuntime;
import fr.nwwdjavaspringboot.util.SendRequestUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component()
@Qualifier("TestRequestNWDRuntime")
public class NWDRuntime {

    private final String URLPost = "http://localhost:2050/NWDRuntime";
    public NWDRuntime(){}


    public void post(NWDRequestRuntime request) throws IOException {
        /*      HEADER       */
        RestTemplate restTemplate = new RestTemplate();

        /*  ADD REQUEST  */

        ResponseEntity<String> response = restTemplate.exchange(URLPost, HttpMethod.POST,
                new HttpEntity<NWDRequestRuntime>(request, SendRequestUtil.getHeader()), String.class);
        System.out.println(response);

    }

}
