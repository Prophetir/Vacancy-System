package com.vacancy_bot.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@FeignClient(value = "hh-client", url = "https://api.hh.ru")
public interface HhClient {

    @PostMapping("/token")
    String getToken();

    @Scheduled(fixedRate = 3600000)
    @GetMapping("/vacancies")
    List<Update> getVacancies();
} 