package ca.abuk.proxy.rating.controller;

import ca.abuk.proxy.rating.services.GetRatingService;
import ca.abuk.proxy.rating.services.RunRatingService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "GetRandomRatingsController", description = "Controller for getting 4 random ratings based on ID")
@RestController
public class GetRatingController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getRand")
    public ResponseEntity<String> getRand() {
        return GetRatingService.getRand();
    }
}
