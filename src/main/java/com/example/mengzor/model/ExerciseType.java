package com.example.mengzor.model;

public enum ExerciseType {

    WEIGHT("weight"),
    CARDIO("cardio"),
    BODYWEIGHT("bodyweight");

    private final String value;

    ExerciseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
