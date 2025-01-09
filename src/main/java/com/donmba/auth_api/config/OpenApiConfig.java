package com.donmba.auth_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    final String securitySchemeName = "bearer auth";
    return new OpenAPI()
        .info(
            new Info()
                .title("Auth API")
                .version("v1")
                .description("API for user authentication and management"))
        .addServersItem(
            new Server().url("https://auth-api-development.up.railway.app")) // Development server
        .addServersItem(
            new Server()
                .url("https://auth-api-production-b852.up.railway.app")) // Production server
        .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
        .components(
            new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes(
                    securitySchemeName,
                    new SecurityScheme()
                        .name(securitySchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .in(SecurityScheme.In.HEADER)));
  }
}
