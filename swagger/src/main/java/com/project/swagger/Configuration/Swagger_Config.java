package com.project.swagger.Configuration;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Swagger_Config {
	@Bean
	public OpenAPI openapi(@Value("${springdoc.api-docs.title}") String title,
			@Value("${springdoc.api-docs.description}") String description,
			@Value("${springdoc.api-docs.servers[0].url}") String serverUrl) {
		return new OpenAPI().info(new Info().title(title).description(description))
				.servers(List.of(new Server().url(serverUrl)));
	}

	@Bean
	public GroupedOpenApi groupOpenApi() {
		return GroupedOpenApi.builder().group("swagger_jpa").packagesToScan("com.project.swagger.Controller").build();
	}

}
