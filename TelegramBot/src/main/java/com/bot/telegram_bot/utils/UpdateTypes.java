package com.vacancy_bot.telegram_bot.utils;

import lombok.Getter;

@Getter
public enum UpdateTypes {

    MESSAGE("message"),
    COMMAND("command"),
    HH_UPDATE("hh_update");

    private String type;

    UpdateTypes(String type) {
        this.type = type;
    }
}
