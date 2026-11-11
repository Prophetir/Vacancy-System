package com.contract.model.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public record SalaryDto(
        @Column(name = "salary_from") Integer from,
        @Column(name = "salary_to")   Integer to,

        @Column(name = "salary_currency") String currency,
        @Column(name = "salary_gross")    Boolean gross
) {}
