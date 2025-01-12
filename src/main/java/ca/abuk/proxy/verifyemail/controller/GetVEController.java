package ca.abuk.proxy.verifyemail.controller;

import ca.abuk.proxy.verifyemail.services.GetVEService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "GetVerifyEmailController", description = "Controller for getting the email verification code based off of email. Returns true/false")
@RestController
public class GetVEController {

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(
            summary = "Get Verify Email Service",
            description = "Used to get email verification code - compares inputted code and DB code ad returns true if matches and false otherwise",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully checked verification code"),
                    @ApiResponse(responseCode = "400", description = "Bad request, invalid parameters for check"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/getVE")
    public ResponseEntity<Boolean> getVE(
            @Parameter(description = "The email the code is registered under", required = true)
            @RequestParam(value = "email", required = true) String email,
            @Parameter(description = "The code to check if matches in DB", required = true)
            @RequestParam(value = "code", required = true) String code
    ) {
            return GetVEService.getVerifyEmail(email, code);
    }

}
