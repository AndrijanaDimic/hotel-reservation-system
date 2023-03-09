package com.raf.bookreservationservice.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.raf.bookreservationservice.controller.HotelController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.basePackage(HotelController.class.getPackage().getName()))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfo("API", "API swagger definition", "1.0.0"
                , "Terms of service", new Contact("Mihailo Radovic", "", "mradovic@raf.rs")
                , "", "", Collections.emptyList());
    }

}