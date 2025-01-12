package ca.abuk.proxy.verifyemail.services;

import ca.abuk.proxy.service.EncodingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RunVEService {
    public static ResponseEntity<String> runVerifyEmail(String email) {

        RestTemplate restTemplate = new RestTemplate();

        // Ensure email is encoded to handle special characters

        String contextPath = "/verifyemail/run/" + email;
        String serviceAtUrl = "http://localhost:8080" + contextPath;

        String response = restTemplate.getForObject(serviceAtUrl, String.class);
        return ResponseEntity.ok(response);
    }
}
