package com.contract.model.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public record AddressDto(
        @Column(name = "address_id")       String id,
        @Column(name = "address_city")     String city,
        @Column(name = "address_street")   String street,
        @Column(name = "address_building") String building,
        @Column(name = "address_raw")      String raw,
        @Column(name = "address_description") String description
) {}
