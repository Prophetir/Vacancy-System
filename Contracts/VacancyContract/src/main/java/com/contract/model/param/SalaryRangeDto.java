package com.contract.model.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public record SalaryRangeDto(
        @Embedded ModeDto      mode,
        @Embedded FrequencyDto frequency
) {}
