package com.hh.hhclient.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/hh")
public interface HhClientController {

    /**------------------------------| AUTHORIZATION |------------------------------**/

    /**
     * Служит для авторизации пользователя приложения.
     * Запрашивает accessToken и refreshToken.
     * Необходимо для работы пользователям.
     * **/
    @GetMapping("/oauth/authorize")
    String authorization();

    /**------------------------------| TOKEN |------------------------------**/

    /**
     * Запрашивает accessToken токен приложения.
     * Токен необходим для работы от имени приложения.
     * **/
    @PostMapping("/token/get")
    String getAppToken();

    /**
     * Обновляет срок действия accessToken
     * **/
    @PostMapping("/token/refresh")
    String refreshToken();

    /**------------------------------| FUNCTIONAL |------------------------------**/

    /**
     * Запрашивает информацию о пользователе.
     * **/
    @GetMapping("/me")
    String checkMe();
}
