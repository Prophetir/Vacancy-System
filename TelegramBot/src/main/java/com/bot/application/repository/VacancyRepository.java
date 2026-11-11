package com.vacancy_bot.application.repository;

import com.vacancy_bot.application.model.entity.VacancyEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacancyRepository extends JpaRepository<@NonNull VacancyEntity, @NonNull UUID> {
}
