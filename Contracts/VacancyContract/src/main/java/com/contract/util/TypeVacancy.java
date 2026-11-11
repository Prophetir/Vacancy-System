package com.contract.util;

/**
 * Существование этого enum-а стоит под вопросом. Пока что оставлю
 * **/
public enum TypeVacancy {

    OPEN("Открытая"),
    CLOSED("Закрытая"),
    ARCHIVED("В архиве");

    private final String type;

    TypeVacancy(String type) {
        this.type = type;
    }
}
