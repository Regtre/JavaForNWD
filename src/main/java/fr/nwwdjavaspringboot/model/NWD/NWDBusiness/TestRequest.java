package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import fr.nwwdjavaspringboot.util.SendRequestUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component()
@Qualifier("TestRequest")
public class TestRequest {

    private String URLPost = "http://localhost:2050/NWDTestJava/Post";
    private String URLGet = "http://localhost:2050/NWDTestJava/Get";

    private final RestTemplate restTemplate = new RestTemplate();

    public TestRequest(){}


    public void post(){

        /*  ADD REQUEST  */
        DataName name = new DataName("Rémy");

        ResponseEntity<DataName> foo2 = restTemplate.exchange(URLPost, HttpMethod.POST, new HttpEntity<DataName>(name, SendRequestUtil.getHeader()), DataName.class);
        System.out.println(foo2.getBody().name);

    }

}
