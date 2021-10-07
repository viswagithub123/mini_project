package com.minipro.common;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** swagger customization **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocument() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.minipro.controller"))
				.paths(PathSelectors.regex("/product.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"MY PRODUCT APP", 
				"SAMPLE", 
				"3.3GA", 
				"https://nareshit.in/", 
				new Contact("AA", "http://aa.com", "aa@gmail.com"), 
				"NIT Ltd", "https://nareshit.in/", Collections.EMPTY_LIST
				);
	}

}
