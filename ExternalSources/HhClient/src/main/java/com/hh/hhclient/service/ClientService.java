package com.hh.hhclient.service;

public interface ClientService {

    String getAccessToken();

    String getOauthToken();

    String getApplicationToken();

    String getRefreshToken();

    void saveAccessToken(String token);

    void saveOauthToken(String token);

    void saveApplicationToken(String token);
}
