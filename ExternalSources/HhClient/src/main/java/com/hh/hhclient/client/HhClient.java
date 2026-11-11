package com.hh.hhclient.client;

import com.contract.model.VacanciesResponseDto;
import com.contract.model.VacancyDto;
import com.contract.util.VacancyFilterParameters;
import com.hh.hhclient.config.FeignClientConfig;
import com.hh.hhclient.model.GetVacancyParameters;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

/**
 *  HhClient предназначен для отправки запросов на hh.ru и hh.api.ru
 * **/
@FeignClient(
        name = "HhClient",
        url = "https://api.hh.ru",
        configuration = FeignClientConfig.class
)
public interface HhClient {

    /**------------------------------| VACANCIES |------------------------------**/

    /**
     * Запрашивает одну вакансию по её id-номеру
     * **/
    @GetMapping("/vacancies/{vacancyId}")
    VacancyDto getVacancy(@RequestHeader("HH-User-Agent") String agent,
                          @RequestHeader("Authorization") String authorization,
                          @PathVariable String vacancyId);

    /**
     * Запрашивает список вакансий на основе параметров фильтра VacancyFilterParameters
     * **/
    @GetMapping("/vacancies")
    VacanciesResponseDto getVacancies(@RequestHeader("HH-User-Agent") String agent,
                                      @RequestHeader("Authorization") String authorization,
                                      @SpringQueryMap VacancyFilterParameters parameters);

    /**------------------------------| AUTHORIZATION |------------------------------**/

    @GetMapping("/oauth/authorize")
    String authorization(@RequestBody MultiValueMap<@NonNull String, String> multiMap);

    /**------------------------------| TOKEN |------------------------------**/

    @PostMapping("/token")
    String token(@RequestHeader("HH-User-Agent") String agent,
                 @RequestBody MultiValueMap<@NonNull String, String> multiMap);

    /**------------------------------| OTHER |------------------------------**/
    @GetMapping("/me")
    String checkMe(@RequestHeader("HH-User-Agent") String agent,
                   @RequestHeader("Authorization") String token);
}
