package com.fruugo.enums;

public enum ConversionType {
    REV("REV"),
    SEV("SEV"),
    TRM("TRM"),
    ASC("ASC"),
    COMP("COMP");

    private String  value;

    private ConversionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
