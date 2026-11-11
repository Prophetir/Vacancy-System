package com.vacancy_bot.telegram_bot.config;

import com.vacancy_bot.telegram_bot.consumer.UpdateConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;

@Component
@RequiredArgsConstructor
public class BotConfig implements SpringLongPollingBot {

    @Value("${bot.token}")
    private String botToken;

    private final UpdateConsumer updateConsumer;

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return updateConsumer;
    }
}
