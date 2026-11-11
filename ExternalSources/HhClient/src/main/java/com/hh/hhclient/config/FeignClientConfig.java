package com.hh.hhclient.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean("FeignQueryParamClientBuilder")
    public Feign.Builder feignQueryParamClientConfig() {
        return Feign.builder()
                .queryMapEncoder(new feign.querymap.FieldQueryMapEncoder());
    }
}
