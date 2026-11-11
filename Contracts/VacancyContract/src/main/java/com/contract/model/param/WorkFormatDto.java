package com.contract.model.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public record WorkFormatDto(
        @Column(name = "work_format_id") String id,
        @Column(name = "work_format_name") String name
) {}
