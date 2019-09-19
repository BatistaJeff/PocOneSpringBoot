package com.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		
		Docket apiInfo = new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage("com.demo"))
			.paths(PathSelectors.any())
			.build().apiInfo(ApiInfo());
		
		return apiInfo;
	}

	private ApiInfo ApiInfo() {
		ApiInfo build = new ApiInfoBuilder()
			.title("Swagger API")
			.description("Documentação da API de acessp aos endpoints com Swagger")
			.version("1.0")
			.build();
		return build;
	}
	
	
}
