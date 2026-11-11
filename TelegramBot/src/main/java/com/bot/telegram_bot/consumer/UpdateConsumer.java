package com.vacancy_bot.telegram_bot.consumer;

import com.vacancy_bot.telegram_bot.handlers.types.CommandHandlerImpl;
import com.vacancy_bot.telegram_bot.handlers.types.ErrorHandlerImpl;
import com.vacancy_bot.telegram_bot.handlers.types.MessageHandlerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.util.DefaultLongPollingUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Из VacancyBot поступают объекты Update.
 * Но как определить, какой именно передаётся объект: Command, Message, HhUpdate?
 * Через if-ы? Смежно и ненадёжно, но пока что пусть будет так. Следует проработать механизм обоснования по типу.
 * **/

@Component
@RequiredArgsConstructor
public class UpdateConsumer extends DefaultLongPollingUpdateConsumer {

    private final ErrorHandlerImpl errorHandler;
    private final CommandHandlerImpl commandHandler;
    private final MessageHandlerImpl messageHandler;

    @Override
    public void consume(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getCommand() == null)
                messageHandler.handle(update);
            else if (update.getMessage().getCommand() != null) {
                commandHandler.handle(update);
            }
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
