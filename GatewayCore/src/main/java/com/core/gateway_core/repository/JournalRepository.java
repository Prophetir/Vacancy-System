package com.core.gateway_core.repository;

import com.core.gateway_core.model.entity.ConnectionEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JournalRepository extends JpaRepository<@NonNull ConnectionEntity, @NonNull UUID> {
}
