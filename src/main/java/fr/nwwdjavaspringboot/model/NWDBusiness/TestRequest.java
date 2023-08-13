package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.minidev.json.JSONObject;
import org.apache.catalina.User;
import org.apache.http.client.methods.HttpPost;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


@Component()
@Qualifier("TestRequest")
public class TestRequest {

    private String URLPost = "http://localhost:2050/NWDTestJava/Post";
    private String URLGet = "http://localhost:2050/NWDTestJava/Get";

    public TestRequest(){}
    public String post() throws IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> param = new HashMap<String,String>();
        param.put("Connection", "keep-alive");
        param.put("Accept", "*/*");
        param.put("Content-Type", "application/json");
        headers.setAll(param);
        JSONObject jsonObject= new JSONObject();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(new DataName("Rémy"));

        HttpPost post = new HttpPost();

        HttpEntity<String> request = new HttpEntity<String>(json,headers);
        String foo = restTemplate.postForObject(URLPost, request, String.class);
        ResponseEntity<String> foo2 = restTemplate.exchange(URLPost, HttpMethod.POST, request, String.class);

        return " ";
    }
}
