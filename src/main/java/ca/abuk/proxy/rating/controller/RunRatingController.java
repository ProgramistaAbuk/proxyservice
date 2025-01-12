package ca.abuk.proxy.rating.controller;

import ca.abuk.proxy.rating.services.RunRatingService;
import ca.abuk.proxy.verifyemail.services.GetVEService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "RunRatingController", description = "Controller for running the rating service based on email, rating value, and description")
@RestController
public class RunRatingController {

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(
            summary = "Run Rating Service",
            description = "Used to run the rating service 'runR', sends and email for rating confirmation and adds email, rating and description to DB.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully processed the rating request"),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid parameters for Rating"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/runR")
    public ResponseEntity<String> runR(
            @Parameter(description = "The email of the user to process rating for", required = true)
            @RequestParam(value = "email", required = true) String email,

            @Parameter(description = "The rating value to assign to user", required = true)
            @RequestParam(value = "rating", required = true) Integer rating,

            @Parameter(description = "The rating description", required = true)
            @RequestParam(value = "description", required = true) String description,

            @Parameter(description = "The rating title", required = true)
            @RequestParam(value = "title", required = false) String title
    ) {
        return RunRatingService.runR(email, rating, description, title);
    }
}
