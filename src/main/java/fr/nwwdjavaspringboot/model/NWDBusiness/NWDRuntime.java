package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestRuntime;
import fr.nwwdjavaspringboot.util.SendRequestUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


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

    public ResponseEntity<String> postRequestRuntime(NWDRequestRuntime request){
        /*      HEADER       */
        RestTemplate restTemplate = new RestTemplate();

        /*  ADD AND SEND REQUEST  */

        return restTemplate.exchange(URLPost, HttpMethod.POST,
                new HttpEntity<NWDRequestRuntime>(request, SendRequestUtil.getHeader()), String.class);

    }

}
