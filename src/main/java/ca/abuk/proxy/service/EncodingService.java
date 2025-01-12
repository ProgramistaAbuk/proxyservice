package ca.abuk.proxy.service;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class EncodingService {
    public static String encode(String input) {
        try {
            // Encode the input string to URL format
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // Handle encoding exception
            throw new RuntimeException("Encoding failed", e);
        }
    }
}
