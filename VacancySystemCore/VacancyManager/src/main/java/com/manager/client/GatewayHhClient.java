package com.manager.client;

import com.contract.model.VacanciesResponseDto;
import com.contract.model.VacancyDto;
import com.contract.util.VacancyFilterParameters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Служит для отправки запросов в HhClient через Gateway.
 * **/

@FeignClient(
        name = "GatewayHhClient",
        url = "http://localhost:8081/manager/vacancy"
)
public interface GatewayHhClient {

    /**
     * Запрашивает список вакансий по параметрам фильтра VacancyFilterParameters
     * **/
    @PostMapping("/request")
    VacanciesResponseDto requestVacancies(@RequestBody VacancyFilterParameters parameters);

    /**
     * Запрашивает вакансию по её id-номеру
     * **/
    @GetMapping("/request/{vacancyId}")
    VacancyDto requestVacancy(@PathVariable String vacancyId);

    /**
     * Отправляет список всех вакансий TelegramBot или VacancyAnalitic
     * !Доработать для TelegramBot и VacancyAnalitic!
     * **/
    @PostMapping("/send/all")
    void sendVacancies(@RequestBody List<VacancyDto> vacancies);

    /**
     * Отправляет одну вакансию TelegramBot или VacancyAnalitic
     * !Доработать для TelegramBot и VacancyAnalitic!
     * **/
    @PostMapping("/send/one")
    void sendVacancy(VacancyDto vacancy);
}
