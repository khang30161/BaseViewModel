package com.example.khang.newpro.data.enums;

public enum ExtraKeyType {

    DEFAULT_EXTRA("default_extra");

    private String value;

    ExtraKeyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
