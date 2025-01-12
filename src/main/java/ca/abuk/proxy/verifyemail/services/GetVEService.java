package ca.abuk.proxy.verifyemail.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetVEService {

    public static ResponseEntity<Boolean> getVerifyEmail(String email, String code) {

        RestTemplate restTemplate = new RestTemplate();

        // Ensure email is encoded to handle special characters

        String contextPath = "/verifyemail/get/" + email + "/" + code;
        String serviceAtUrl = "http://localhost:8080" + contextPath;

        Boolean response = restTemplate.getForObject(serviceAtUrl, Boolean.class);
        return ResponseEntity.ok(response);
    }
}
