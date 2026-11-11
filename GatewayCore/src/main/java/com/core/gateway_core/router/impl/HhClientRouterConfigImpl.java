package com.core.gateway_core.router.impl;

import com.core.gateway_core.router.RouterConfig;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;

/**
 * Служит для настройки router запросов поступающий в Gateway извне в HhClient.
 * Пока что используется для тестирования.
 *
 * роутер c uri(http://localhost:8082) направляет запрос из VacancyManager в HhClient
 * **/
@Configuration
public class HhClientRouterConfigImpl implements RouterConfig {

    @Bean(name = "HhRouter")
    @Override
    public RouterFunction<@NonNull ServerResponse> routeRequest(
            @Qualifier("journalFilter") HandlerFilterFunction journalFilter) {
        return route("hh_client_route")
                .GET("external/hh/vacancy/**", http())
                .POST("external/hh/token/**", http())
                .before(uri("http://localhost:8082"))
                //.filter(journalFilter)
                .build();
    }
}