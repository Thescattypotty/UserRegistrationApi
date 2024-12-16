package org.authentication.userRegistration.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
    
    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
            .info(
                new Info()
                    .title("User Registration API")
                    .description("API for Managing User Registration with Validation")
                    .version("1.0.O")
            );
    }
}
