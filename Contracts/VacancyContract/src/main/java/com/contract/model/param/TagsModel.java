package com.contract.model.param;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record TagsModel(
        @Column(name = "tags_id") String id,
        @Column(name = "tags_text") String text
) {}
