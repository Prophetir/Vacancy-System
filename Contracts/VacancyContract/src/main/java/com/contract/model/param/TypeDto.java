package com.contract.model.param;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record TypeDto(
        @Column(name = "type_id") String id,
        @Column(name = "type_name") String name
) {}
