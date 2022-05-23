package com.ssafy.ssafit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				// ApiSelectorBuilder
				.select()
				// ApiSelectorBuilder
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.ssafit.controller"))
				// ApiSelectorBuilder
				.paths(PathSelectors.ant("/api/**"))
				// Docket
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// ApiInfoBuilder
				.title("SSAFY 최종관통PJT SSAFIT Backend API").description("SSAFIT REST API 테스트").version("1.0").build();
	}
}