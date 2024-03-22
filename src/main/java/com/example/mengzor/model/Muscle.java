package com.example.mengzor.model;

public enum Muscle {

    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    FOREARMS("Forearms"),
    ABS("Abs"),
    QUADS("Quads"),
    HAMSTRINGS("Hamstrings"),
    CALVES("Calves");

    private final String muscle;

    Muscle(String muscle) {
        this.muscle = muscle;
    }

    public String getValue() {
        return muscle;
    }
}
