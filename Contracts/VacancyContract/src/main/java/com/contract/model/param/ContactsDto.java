package com.contract.model.param;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record ContactsDto(
        @Column(name = "contacts_name")   String name,
        @Column(name = "contacts_phones") String[] phones
) {}
