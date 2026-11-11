package com.contract.model.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public record EmployerDto (
        @Column(name = "employer_id") String id,
        @Column(name = "employer_name") String name,
        @Column(name = "employer_url") String url,

        @JsonProperty("alternative_url")
        @Column(name = "employer_alternative_url")
        String alternativeUrl,

        @JsonProperty("vacancies_url")
        @Column(name = "employer_vacancies_url")
        String vacanciesUrl,

        @JsonProperty("country_id")
        @Column(name = "employer_country_id")
        Integer countryId,

        @JsonProperty("accredited_it_employer")
        @Column(name = "employer_accredited")
        Boolean accredited,

        @JsonProperty("employer_on_additional_check")
        @Column(name = "employer_additional_check")
        Boolean additionalCheck,

        @Column(name = "trusted") Boolean trusted
){}
