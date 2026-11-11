package com.core.gateway_core.router;

import lombok.NonNull;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

public interface RouterConfig {

    RouterFunction<@NonNull ServerResponse> routeRequest(HandlerFilterFunction filter);
}
