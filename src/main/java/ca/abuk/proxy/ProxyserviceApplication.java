package ca.abuk.proxy;

import ca.abuk.proxy.service.SendEmailVerifyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyserviceApplication.class, args);
		SendEmailVerifyService.callVerifyEmail(null);
	}

}
