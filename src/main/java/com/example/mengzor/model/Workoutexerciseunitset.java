package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workoutexerciseunitsets")
@AllArgsConstructor
@NoArgsConstructor
public class Workoutexerciseunitset {
    @EmbeddedId
    private WorkoutexerciseunitsetId id;

    @MapsId("workoutId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @MapsId("exerciseunitsetId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exerciseunitset_id", nullable = false)
    private Exerciseunitset exerciseUnitSet;

}