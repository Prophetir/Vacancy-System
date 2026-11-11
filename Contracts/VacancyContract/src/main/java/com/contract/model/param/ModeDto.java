package com.contract.model.param;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record ModeDto (
        @Column(name = "salary_mode_id") String id,
        @Column(name = "salary_mode_name") String name
){}
