package com.hh.hhclient.controller.impl;

import com.contract.model.VacanciesResponseDto;
import com.contract.model.VacancyDto;
import com.contract.util.VacancyFilterParameters;
import com.hh.hhclient.client.HhClient;
import com.hh.hhclient.controller.GatewayController;
import com.hh.hhclient.service.ClientService;
import com.hh.hhclient.util.HhConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GatewayControllerImpl implements GatewayController {

    private final HhClient hhClient;
    private final ClientService service;

    private final HhConfigurationProperties properties;

    @Override
    public VacanciesResponseDto sendVacancies(VacancyFilterParameters parameters) {
        System.out.println(
                "\n--------------| Send Vacancies |--------------\n" +
                        "                Метод вызван"                     +
                        "\n--------------| Send Vacancies |--------------\n"
        );


        return hhClient.getVacancies(
                properties.hhUserAgent(),
                service.getApplicationToken(),
                parameters);
    }

    @Override
    public VacancyDto sendVacancy(@PathVariable String vacancyId) {
        return hhClient.getVacancy(
                properties.hhUserAgent(),
                service.getApplicationToken(),
                vacancyId
        );
    }
}
