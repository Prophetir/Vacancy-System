package com.vacancy_bot.telegram_bot.handlers.types;

import com.vacancy_bot.telegram_bot.handlers.UpdateHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
@RequiredArgsConstructor
public class MessageHandlerImpl implements UpdateHandler {

    private final TelegramClient telegramClient;

    @Override
    public void handle(Update update) throws TelegramApiException {
        telegramClient.execute(SendMessage
                .builder()
                .chatId(update.getMessage().getChatId())
                .text(update.getMessage().getText())
                .build());
    }
}