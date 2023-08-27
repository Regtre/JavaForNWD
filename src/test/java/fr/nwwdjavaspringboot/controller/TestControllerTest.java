package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.TestRequest;
import fr.nwwdjavaspringboot.service.TestRequestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootTest
@Configuration(value = "static")
public class TestControllerTest {

    public TestRequestService testRequestService = new TestRequestService(new TestRequest());

    @Test
    public void testSendPost() throws IOException, InterruptedException {
        TestRequest testRequest = new TestRequest();
        testRequest.post();
    }
}