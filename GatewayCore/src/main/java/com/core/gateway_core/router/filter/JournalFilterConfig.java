package com.core.gateway_core.router.filter;

import com.core.gateway_core.service.impl.JournalServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class JournalFilterConfig {

    private final JournalServiceImpl journalServiceImpl;

    @Bean(name = "journalFilter")
    public HandlerFilterFunction<@NonNull ServerResponse, @NonNull ServerResponse> journalFilter() {
        return (request, next) -> {

            System.out.println(
                    "\n----------| Journal Filter |----------\n" +
                    "          Journal Filter Called!          " +
                    "\n----------| Journal Filter |----------\n");

            //journalServiceImpl.saveConnection(request);

            return next.handle(request);
        };
    }
}