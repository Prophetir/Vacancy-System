package com.manager.controller;

import com.contract.util.VacancyFilterParameters;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/manager/vacancy")
public interface VacancyController {

    /**-----------------------------| REQUEST |-----------------------------**/

    /**
     * Запрашивает у HhClient список вакансий по параметрам фильтра VacancyFilterParameters
     * **/
    @PostMapping("/request")
    void requestVacancies(@RequestBody VacancyFilterParameters filterParameters);

    /**
     * Запрашивает у HhClient одну вакансию по её id-номеру
     * **/
    @GetMapping("/request/{vacancyId}")
    void requestVacancy(@PathVariable String vacancyId);

    /**-----------------------------| SEND |-----------------------------**/

    /**
     * Отправляет список всех вакансий
     * **/
    @PostMapping("/send/all")
    void sendVacancies();

    /**
     * Отправляет список вакансий по параметрам фильтра VacancyFilterParameters
     * **/
    @PostMapping("/send/filter")
    void sendVacancies(@RequestBody VacancyFilterParameters filter);

    /**
     * Отправляет одну вакансию по её id-номеру
     * **/
    @PostMapping("/send/{vacancyId}")
    void sendVacancy(@PathVariable String vacancyId);
}