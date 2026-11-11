package com.manager.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "TelegramBotClient"
)
public interface TelegramBotClient {
}
