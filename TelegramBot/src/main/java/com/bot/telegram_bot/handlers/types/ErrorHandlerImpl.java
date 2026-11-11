package com.vacancy_bot.telegram_bot.handlers.types;

import com.vacancy_bot.telegram_bot.handlers.UpdateHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class ErrorHandlerImpl implements UpdateHandler {

    @Override
    public void handle(Update update) throws TelegramApiException {

    }
}
