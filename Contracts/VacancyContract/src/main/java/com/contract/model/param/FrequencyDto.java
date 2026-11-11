package com.contract.model.param;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record FrequencyDto (
        @Column(name = "salary_frequency_id") String id,
        @Column(name = "salary_frequency_name") String name
){}
