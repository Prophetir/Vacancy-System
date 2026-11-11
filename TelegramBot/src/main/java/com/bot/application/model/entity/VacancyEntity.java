package com.vacancy_bot.application.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class VacancyEntity {

    @Id
    private UUID id;
}
