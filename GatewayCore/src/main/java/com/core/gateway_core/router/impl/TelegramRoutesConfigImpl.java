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

/**
 * Служит для настройки router запросов поступающие в TelegramBot из VacancyManager.
 *
 * роутер c uri(http://localhost:) направляет запрос из
 * **/
@Configuration
public class TelegramRoutesConfigImpl implements RouterConfig {

    @Bean(name = "TelegramRouter")
    @Override
    public RouterFunction<@NonNull ServerResponse> routeRequest(
            @Qualifier("journalFilter") HandlerFilterFunction journalFilter
    ) {
        return route()
                .GET("/get-vacancies", http())
                //.filter(journalFilter)
                .build();
    }
}
