package com.manager.controller.impl;

import com.manager.client.GatewayHhClient;
import com.manager.controller.VacancyController;
import com.manager.service.VacancyService;
import com.contract.util.VacancyFilterParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VacancyControllerImpl implements VacancyController {

    private final GatewayHhClient gatewayHhClient;

    private final VacancyService service;

    /**-----------------------------| REQUEST |-----------------------------**/

    @Override
    public void requestVacancies(VacancyFilterParameters filterParameters) {
        service.processVacancies(gatewayHhClient.requestVacancies(filterParameters));
    }

    @Override
    public void requestVacancy(String vacancyId) {
        service.processVacancy(gatewayHhClient.requestVacancy(vacancyId));
    }

    /**-----------------------------| SEND |-----------------------------**/

    @Override
    public void sendVacancies() {
        gatewayHhClient.sendVacancies(service.sendVacancies());
    }

    @Override
    public void sendVacancies(VacancyFilterParameters filter) {
        gatewayHhClient.sendVacancies(service.sendVacanciesFilter(filter));
    }

    @Override
    public void sendVacancy(String vacancyId) {
        gatewayHhClient.sendVacancy(service.sendVacancy(vacancyId));
    }
}
