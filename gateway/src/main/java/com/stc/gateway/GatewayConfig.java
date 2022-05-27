package com.stc.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/employee-api/**")
                        .uri("lb://employee-api/")
                ).route(predicateSpec -> predicateSpec
                        .path("/leave-api/**")
                        .uri("lb://leave-api/")
                ).build();
    }
}
