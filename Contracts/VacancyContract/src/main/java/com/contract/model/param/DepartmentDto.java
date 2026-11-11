package com.contract.model.param;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record DepartmentDto(
        @Column(name = "department_id") String id,
        @Column(name = "department_name") String name
) {}
