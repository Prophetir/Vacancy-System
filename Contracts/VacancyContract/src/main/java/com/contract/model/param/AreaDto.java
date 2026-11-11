package com.contract.model.param;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record AreaDto (
        @Column(name = "area_id")   String id,
        @Column(name = "area_name") String name,
        @Column(name = "area_url")  String url
) {}
