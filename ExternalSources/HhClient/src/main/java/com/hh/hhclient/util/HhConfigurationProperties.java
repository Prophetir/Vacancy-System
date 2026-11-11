package com.hh.hhclient.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Временный класс для разработки, думаю над заменой более надёжными способами.
 * **/
@ConfigurationProperties(prefix = "hh.api")
public record HhConfigurationProperties(
        String clientId,
        String clientSecret,
        String hhUserAgent,

        String grantTypeClientCredentials,
        String grantTypeRefreshToken,
        String grantTypeAuthorizationCode
) {}
