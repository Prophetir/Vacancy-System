package com.core.gateway_core.service;

import org.springframework.web.servlet.function.ServerRequest;

public interface JournalService {

    void saveConnection(ServerRequest request);
}
