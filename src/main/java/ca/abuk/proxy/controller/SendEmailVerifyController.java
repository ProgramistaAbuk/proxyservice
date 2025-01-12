package ca.abuk.proxy.controller;

import ca.abuk.proxy.service.SendEmailVerifyService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailVerifyController {
    @GetMapping("/send")
    public ResponseEntity<String> generateVerificationCode(
            @Parameter(description = "Address to send to (if empty will default to 192.168.1.211:8080)", required = false)
            @RequestParam(value = "address", required = false) String address
    ) {
        if (address == null || address.isEmpty()) {
            address = "192.168.1.211:8080"; // Default value if not provided
        }
        return SendEmailVerifyService.callVerifyEmail(address);
    }
}
