package com.hh.hhclient.controller.impl;

import com.hh.hhclient.client.HhClient;
import com.hh.hhclient.controller.HhClientController;
import com.hh.hhclient.service.ClientService;
import com.hh.hhclient.util.HhConfigurationProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

/**
 * Необходимо разобраться с refresh-token, но пока что отложу, т.к. нет необходимости сейчас.
 * Также не работает authorization для токена пользователя, но пока нет необходимости в нём.
 * **/

@RestController
@RequiredArgsConstructor
public class HhClientControllerImpl implements HhClientController {

    private final HhClient hhClient;
    private final ClientService service;

    private final HhConfigurationProperties properties;


    /**------------------------------| AUTHORIZATION |------------------------------**/

    @Override
    public String authorization() {
        return hhClient.authorization(buildMultiMap(properties.grantTypeAuthorizationCode()));
    }

    /**------------------------------| TOKEN |---------------------------------------**/

    /**
     * Система токенов совершенно не работает. Но сейчас это не важно, главное сейчас - основной функционал
     * **/
    @Override
    public String getAppToken() {
        String token = hhClient.token(properties.hhUserAgent(),
                buildMultiMap(properties.grantTypeClientCredentials()));

        service.saveApplicationToken(token);

        return token;
    }

    @Override
    public String refreshToken() {
        String token = hhClient.token(properties.hhUserAgent(),
                buildMultiMapRefreshToken(properties.grantTypeRefreshToken(), service.getRefreshToken()));

        return token;
    }

    /**------------------------------| OTHER |---------------------------------------**/

    @Override
    public String checkMe() {
        return hhClient.checkMe(properties.hhUserAgent(),
                service.getAccessToken());
    }

    /**------------------------------| UTILS |---------------------------------------**/

    private MultiValueMap<@NonNull String, String> buildMultiMap(String grantType) {
        MultiValueMap<@NonNull String, String> multiMap = new LinkedMultiValueMap<>();

        multiMap.add("client_id",     properties.clientId());
        multiMap.add("client_secret", properties.clientSecret());
        multiMap.add("grant_type",    grantType);

        return multiMap;
    }

    private MultiValueMap<@NonNull String, String> buildMultiMapRefreshToken(String grantType, String token) {
        MultiValueMap<@NonNull String, String> multiMap = new LinkedMultiValueMap<>();

        multiMap.add("grant_type",    grantType);
        multiMap.add("refresh_token", token);

        return multiMap;
    }
}
