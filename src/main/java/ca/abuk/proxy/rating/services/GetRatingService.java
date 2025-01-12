package ca.abuk.proxy.rating.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetRatingService {
    public static ResponseEntity<String> getRand() {

        RestTemplate restTemplate = new RestTemplate();

        // Ensure email is encoded to handle special characters


        String contextPath = "/rating/getRand";
        String serviceAtUrl = "http://localhost:8080" + contextPath;

        String response = restTemplate.getForObject(serviceAtUrl, String.class);
        return ResponseEntity.ok(response);
    }
}
