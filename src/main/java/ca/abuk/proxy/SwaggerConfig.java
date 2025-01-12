package ca.abuk.proxy;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SwaggerConfig {
    // Define API metadata and documentation details
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Proxy Service Project")
                        .description("Service that connects all Angular requests to other Java Services")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("Abuk Prod")
                                .email("abukproductions@gmail.com")
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }

    // Define package scanning with RequestHandlerSelectors for the controllers
//    @Bean
//    public GroupedOpenApi api() {
//        return GroupedOpenApi.builder()
//                .group("api")
//                .packagesToScan("controller")  // Specify your base package
//                .build();
//    }
}