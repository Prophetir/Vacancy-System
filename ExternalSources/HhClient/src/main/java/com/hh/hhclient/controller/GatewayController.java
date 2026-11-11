package com.hh.hhclient.controller;

import com.contract.model.VacanciesResponseDto;
import com.contract.model.VacancyDto;
import com.contract.util.VacancyFilterParameters;
import com.hh.hhclient.model.GetVacancyParameters;
import org.springframework.web.bind.annotation.*;

/**
 * Служит для взаимодействия с GatewayCore.
 * В HhClient служит для отправки запросов VacancyManager
 * **/

@RequestMapping("/manager/vacancy")
public interface GatewayController {

    /**
     * Отправляет список вакансий на основе параметров фильтра VacancyFilterParameters
     * **/
    @PostMapping("/request")
    VacanciesResponseDto sendVacancies(@RequestBody VacancyFilterParameters parameters);

    /**
     * Отправляет одну вакансию по её id-номеру
     * **/
    @PostMapping("/request/{vacancyId}")
    VacancyDto sendVacancy(@PathVariable String vacancyId);
}
