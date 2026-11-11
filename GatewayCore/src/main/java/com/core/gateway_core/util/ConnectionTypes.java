package com.core.gateway_core.util;

import lombok.Getter;

@Getter
public enum ConnectionTypes {

    TG_BOT("TG_BOT"),
    HH_CLIENT("HH_CLIENT");

    private String value;

    ConnectionTypes(String value) {
        this.value = value;
    }
}
