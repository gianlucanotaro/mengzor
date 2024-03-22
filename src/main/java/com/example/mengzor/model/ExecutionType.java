package com.example.mengzor.model;

public enum ExecutionType {

    REPS("reps"),
    FAILURE("failure"),
    TIME("time"),
    DROPSET("dropset");

    private final String value;

    ExecutionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
