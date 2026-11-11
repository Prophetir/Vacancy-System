package com.vacancy_bot.application.controller.impl;

import com.vacancy_bot.application.client.HhClient;
import com.vacancy_bot.application.controller.HhClientController;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@RequiredArgsConstructor
public class HhClientControllerImpl implements HhClientController {

    private final HhClient hhClient;

    @Override
    public String getToken() {
        System.out.println("getToken");
        return hhClient.getToken();
    }

    @Override
    public List<Update> getVacancies() {
        return hhClient.getVacancies();
    }
}
