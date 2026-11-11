package com.contract.model;

import com.contract.model.param.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;

import java.util.Date;
import java.util.List;

/**
 * Нужны ли поля label и tags?
 * **/
@JsonIgnoreProperties(ignoreUnknown = true)
public record VacancyDto(
        String  id,
        String  name,
        TypeDto type,
        Boolean archived,
        String  url,
        @Embedded DepartmentDto department,
        @Embedded ContactsDto contacts,

        @Embedded SalaryDto salary,

        @Embedded
        @JsonProperty("salary_range")
        SalaryRangeDto salaryRange,

        @Embedded
        @JsonProperty("work_format")
        List<WorkFormatDto> workFormat,

        @Embedded EmployerDto employer,

        @Embedded AreaDto    area,
        @Embedded AddressDto address,

        @JsonProperty("alternative_url") String alternativeUrl,
        @JsonProperty("response_url")    String responseUrl,
        @JsonProperty("show_contacts")   Boolean showContacts,

        @JsonProperty("published_at") Date publishedAt,
        @JsonProperty("created_at")   Date createdAt
) {}
