package com.sam09.logging;

public enum LoggerEnum {
    LOGGER("logger");

    private String enumValue;

    LoggerEnum(String logger) {
        this.enumValue = logger;
    }

    public String getEnumValue() {
        return enumValue;
    }
}
