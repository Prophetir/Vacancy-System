package com.core.gateway_core.service.impl;

import com.core.gateway_core.model.entity.ConnectionEntity;
import com.core.gateway_core.repository.JournalRepository;
import com.core.gateway_core.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;

/**
 * Служит для управления connections.
 * В основном connecions небходимы для статистики.
 * **/
@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepository repository;

    /**
     * Сохраняет connection в БД
     * **/
    @Override
    public void saveConnection(ServerRequest request) {
        repository.save(ConnectionEntity.builder()
                .build());
    }
}
