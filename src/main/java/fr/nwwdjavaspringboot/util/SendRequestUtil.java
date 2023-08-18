package fr.nwwdjavaspringboot.util;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class SendRequestUtil {

    public static HttpHeaders getHeader() {
        /*      HEADER       */
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> param = new HashMap<String, String>();
        param.put("Connection", "keep-alive");
        param.put("Accept", "*/*");
        param.put("Content-Type", "application/json");
        headers.setAll(param);
        return headers;
    }
}
