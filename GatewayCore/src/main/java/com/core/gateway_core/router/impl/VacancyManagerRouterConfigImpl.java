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
 * Служит для настройки router запросов поступающий в VacancyManager и из VacancyManager.
 *
 * роутер c uri(http://localhost:8082) направляет запрос из VacancyManager в HhClient
 * роутер c uri(http://localhost:9091) направляет запрос из HhClient в VacancyManager
 * **/
@Configuration
public class VacancyManagerRouterConfigImpl implements RouterConfig {

    @Bean(name = "VacancyManagerRouter")
    @Override
    public RouterFunction<@NonNull ServerResponse> routeRequest(
            @Qualifier("journalFilter") HandlerFilterFunction journalFilter) {
        return route("vacancy_hhClient_request_manager_router")
                .GET("/manager/vacancy/request/{vacancyId}", http())
                .POST("/manager/vacancy/request", http())
                .before(uri("http://localhost:8082"))
                .filter(journalFilter)
                .build()

                .and(route("vacancy_hhClient_response_manager_router")
                        .POST("/manager/vacancy/send", http())
                        .POST("/manager/vacancy/send/{vacancyId}", http())
                        .before(uri("http://localhost:9091"))
                        .filter(journalFilter)
                        .build());
    }
}
