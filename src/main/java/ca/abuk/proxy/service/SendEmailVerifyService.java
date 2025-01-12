package ca.abuk.proxy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class SendEmailVerifyService {
    public static ResponseEntity<String> callVerifyEmail(String address) {

        RestTemplate restTemplate = new RestTemplate();
        String contextPath = "/verifyemail/hello";
        String serviceAUrl;

        if (address != null) {
            serviceAUrl = "http://" + address + contextPath;
        } else {
            serviceAUrl = "http://192.168.1.211:8080" + contextPath;
        }

        String response = restTemplate.getForObject(serviceAUrl, String.class);
        return ResponseEntity.ok("Received from Service A: " + response);
    }
}
