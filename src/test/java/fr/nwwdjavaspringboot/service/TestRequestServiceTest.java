package fr.nwwdjavaspringboot.service;

import fr.nwwdjavaspringboot.model.NWDBusiness.TestRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestRequestServiceTest {

    @Test
    public void testSendPost() throws IOException, InterruptedException {
        TestRequest testRequest = new TestRequest();
        testRequest.post();
//        testRequest.postOkHttp();
    }
}