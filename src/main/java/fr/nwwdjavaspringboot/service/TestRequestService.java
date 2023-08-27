package fr.nwwdjavaspringboot.service;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestRequestService {
    private final TestRequest testRequest;

    public TestRequest getTestRequest() {
        return testRequest;
    }

    @Autowired
    public TestRequestService(TestRequest testRequest) {
        this.testRequest = testRequest;
    }
}
