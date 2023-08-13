package com.solaluna.wiki.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Wiki Documentation/Swagger")
                        .url("https://springdoc.org/v2"));
    }

    private Info apiInfo() {
        return new Info()
                .title("Wiki Demo API Doc")
                .description("springfox swagger 3.0 demo")
                .version("1.0.0")
                .contact(new Contact()
                        .name("Cello")
                        .url("https://github.com/Yukitaka2115")
                        .email("415723763@qq.com")
                )
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.txt")
                );
    }
}
