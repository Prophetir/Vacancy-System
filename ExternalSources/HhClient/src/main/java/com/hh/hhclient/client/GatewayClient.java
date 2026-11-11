package com.hh.hhclient.client;

import com.contract.model.VacanciesResponseDto;
import com.contract.model.VacancyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "GatewayClient",
        url = "http://localhost:8081/manager/vacancy"
)
public interface GatewayClient {

    @PostMapping("/send")
    void sendVacancies(@RequestBody VacanciesResponseDto vacancies);

    @PostMapping("/send/{vacancyId}")
    void sendVacancy(@RequestBody VacancyDto vacancy);
}
