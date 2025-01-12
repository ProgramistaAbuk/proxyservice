package ca.abuk.proxy.controller;

import ca.abuk.proxy.service.EncodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncodingController {

    @Autowired
    private EncodingService urlEncodingService;

    @GetMapping("/encode")
    public String encodeString(@RequestParam String input) {
        return urlEncodingService.encode(input);
    }
}
