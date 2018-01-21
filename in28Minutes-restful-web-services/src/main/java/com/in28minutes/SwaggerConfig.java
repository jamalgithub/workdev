package com.in28minutes;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * What content types does your API support?
	 */
	private static final HashSet<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
	/**
	 * the contact information of the API
	 */
	private static final Contact DEFAULT_CONTACT = new Contact("Ranga Karanam", "http://www.in28minutes.com", "in28minutes@gmail.com");
	/**
	 * Meta information about the API - Description, Licensing etc.
	 */
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
													.title("My awesome API")
													.description("My awesome API Description")
													.version("1.0")
													.contact(DEFAULT_CONTACT)
													.license("Apache 2.0")
													.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
													.build();
	
	@Bean
	public Docket api() {
		//Docket to decide what kind of APIs you would want to document.
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.pathMapping("/");
	}

	/*private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("My awesome API")
				.description("My awesome API Description")
				.version("1.0")
				.contact(new Contact("Ranga", "http://www.in28minutes.com",	"in28minutes@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}*/
	
	// Bean - Docket
	// Swagger 2
	// All the paths
	// All the apis
}