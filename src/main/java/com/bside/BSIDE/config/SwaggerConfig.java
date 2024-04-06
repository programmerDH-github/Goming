package com.bside.BSIDE.config;

import java.util.Arrays;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
	  public OpenAPI api() {
	    SecurityScheme apiKey = new SecurityScheme()
	      .type(SecurityScheme.Type.APIKEY)
	      .in(SecurityScheme.In.HEADER)
	      .name("Authorization");

	    SecurityRequirement securityRequirement = new SecurityRequirement()
	      .addList("Bearer Token");

	    return new OpenAPI()
	      .components(new Components().addSecuritySchemes("Bearer Token", apiKey))
	      .addSecurityItem(securityRequirement);
	  }

}
