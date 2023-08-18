package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import fr.nwwdjavaspringboot.util.SendRequestUtil;
import net.minidev.json.JSONObject;
import okhttp3.*;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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

        ResponseEntity<String> foo2 = restTemplate.exchange(URLPost, HttpMethod.POST, new HttpEntity<DataName>(name, SendRequestUtil.getHeader()), String.class);
        System.out.println(foo2);

    }

}
