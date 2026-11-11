package com.hh.hhclient.service.impl;

import com.hh.hhclient.service.ClientService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Отложу разработку до подходящего момента, сейчас не вижу смысла в сервисе.
 * Сейчас сохранение токенов в файлах - это временная мера для тестирования.
 *
 * Не доработал сохранение connections. Думаю убрать логику connections.
 **/

@Service
public class ClientServiceImpl implements ClientService {

    private final Path accessPath =      null;
    private final Path oauthPath =       null;
    private final Path applicationPath = null;
    private final Path refreshPath =     null;

    @Override
    public String getAccessToken() {

        String token = null;

        try {
            if (Files.notExists(accessPath)) {
                System.out.println(
                        "\n----------| Reade Access Token |----------\n" +
                        "               Токен не найден                " +
                        "\n----------| Reade Access Token |----------\n");
                throw new IOException("Файл токена не был найден.");
            }

            token = Files.readString(accessPath).trim();
        } catch (IOException e) { e.printStackTrace(); }

        return token;
    }

    @Override
    public String getOauthToken() {
        String token = null;

        try {
            if (Files.notExists(oauthPath)) {
                System.out.println(
                        "\n----------| Reade Oauth Token |----------\n" +
                        "               Токен не найден                " +
                        "\n----------| Reade Oauth Token |----------\n");
                throw new IOException("Файл токена не был найден.");
            }

            token = Files.readString(oauthPath).trim();
        } catch (IOException e) { e.printStackTrace(); }

        return token;
    }

    @Override
    public String getApplicationToken() {
        String token = null;

        try {
            if (Files.notExists(applicationPath)) {
                System.out.println(
                        "\n----------| Reade Application Token |----------\n" +
                        "                 Токен не найден                   " +
                        "\n----------| Reade Application Token |----------\n");
                throw new IOException("Файл токена не был найден.");
            }

            token = Files.readString(applicationPath).trim();
        } catch (IOException e) { e.printStackTrace(); }

        return token;
    }

    @Override
    public String getRefreshToken() {
        String token = null;

        try {
            if (Files.notExists(refreshPath)) {
                System.out.println(
                        "\n----------| Reade Refresh Token |----------\n" +
                        "               Токен не найден                " +
                        "\n----------| Reade Refresh Token |----------\n");
                throw new IOException("Файл токена не был найден.");
            }

            token = Files.readString(refreshPath).trim();
        } catch (IOException e) { e.printStackTrace(); }

        return token;
    }

    @Override
    public void saveAccessToken(String token) {
        try {
            if (Files.notExists(accessPath))
                Files.createFile(accessPath);

            Files.write(accessPath, token.trim().getBytes());
        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public void saveOauthToken(String token) {
        try {
            if (Files.notExists(oauthPath))
                Files.createFile(oauthPath);

            Files.write(oauthPath, token.trim().getBytes());
        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public void saveApplicationToken(String token) {
        try {
            if (Files.notExists(applicationPath))
                Files.createFile(applicationPath);

            Files.write(applicationPath, token.trim().getBytes());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
