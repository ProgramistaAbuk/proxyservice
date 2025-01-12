package ca.abuk.proxy.verifyemail.controller;

import ca.abuk.proxy.verifyemail.services.RunVEService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Tag(name = "RunVerifyEmailController", description = "Controller for running the email verification process, create code, send code and put code into DB.")
@RestController
public class RunVEController {

    private final RunVEService runVEService;

    public RunVEController(RunVEService runVEService) {
        this.runVEService = runVEService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(
            summary = "Run Verify Email Service",
            description = "Used to run the verify email service to send email verification (DB, code and Email)",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully sent verification code"),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid parameters for verification"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/runVE")
    public ResponseEntity<String> generateVerificationCode(
//            @RequestParam(value = "address", required = false) String address,
            @Parameter(description = "The email of the user to send the verification email to", required = true)
            @RequestParam(value = "email", required = true) String email
    ) {
        try {
            // Decode the email to handle any double-encoding
            email = URLDecoder.decode(email, StandardCharsets.UTF_8);

            return RunVEService.runVerifyEmail(email);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return ResponseEntity.status(500).body("EMAIL = " + email + "An error occurred: " + e.getMessage());
        }
    }
}