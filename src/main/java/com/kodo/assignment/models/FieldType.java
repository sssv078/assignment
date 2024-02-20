package com.kodo.assignment.models;

public enum FieldType {

    TEXT("TEXT"),
    NUMBER("NUMBER");

    public String type;

    FieldType(String type) {
        this.type = type;
    }
}
