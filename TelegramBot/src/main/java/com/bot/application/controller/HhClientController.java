package com.vacancy_bot.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@RequestMapping("/hh-control")
@RestController
public interface HhClientController {

    @GetMapping("/token")
    String getToken();

    @GetMapping("/vacancies")
    List<Update> getVacancies();
}
