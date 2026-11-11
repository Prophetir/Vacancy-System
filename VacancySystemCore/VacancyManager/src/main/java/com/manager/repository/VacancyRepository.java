package com.manager.repository;

import com.manager.model.entity.VacancyEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacancyRepository extends JpaRepository<@NonNull VacancyEntity, @NonNull UUID> {
    Object findByVacancyId(String vacancyId);
}
