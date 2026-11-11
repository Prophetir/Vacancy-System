package com.contract.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VacanciesResponseDto(
        List<VacancyDto> items,

        int found,
        int pages,
        int page,

        @JsonProperty("per_page") int perPage,
        @JsonProperty("alternative_url") String alternativeUrl
) {}
