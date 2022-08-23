package com.company.oath.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket infoApiAvailabilityHub() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Oath")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .paths(regex("/oath.*"))
                .build().directModelSubstitute(Object.class, java.lang.Void.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST services")
                .description("Documentation and client for all REST API services")
                .termsOfServiceUrl("Terms of service")
                .license("bankaya")
                .version("1.0")
                .build();
    }
}