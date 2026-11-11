package com.manager.service;

import com.contract.model.VacanciesResponseDto;
import com.contract.model.VacancyDto;
import com.contract.util.VacancyFilterParameters;

import java.util.List;

public interface VacancyService {

    /**-----------------------------| SEND |-----------------------------**/

    /**
     * Отправляет список всех вакансий
     * **/
    List<VacancyDto> sendVacancies();

    /**
     * Отправляет вакансию по её id-номеру
     * **/
    VacancyDto sendVacancy(String vacancyId);

    /**
     * Отправляет список вакансий на основе параметров фильтра
     * **/
    List<VacancyDto> sendVacanciesFilter(VacancyFilterParameters filter);

    /**-----------------------------| PROCESS |-----------------------------**/

    /**
     * Обрабатывает поступивший список вакансий. Сохраняет записи в БД
     * **/
    void processVacancies(VacanciesResponseDto response);

    /**
     * Обрабатывает поступившую вакансию. Записывает запись в БД
     * **/
    void processVacancy(VacancyDto vacancy);
}
