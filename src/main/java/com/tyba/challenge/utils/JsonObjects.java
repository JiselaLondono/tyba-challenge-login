package com.tyba.challenge.utils;

public enum JsonObjects {
    TOKEN("token"),
    REASON("reason");

    private final String objectName;

    JsonObjects(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }
}
