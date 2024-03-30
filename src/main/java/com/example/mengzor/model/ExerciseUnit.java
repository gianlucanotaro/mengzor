package com.example.mengzor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "exerciseunit")
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @NotNull
    @Column(name = "exercisetype", nullable = false, length = Integer.MAX_VALUE)
    private String exerciseType;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @NotNull
    @Column(name = "executiontype", nullable = false, length = Integer.MAX_VALUE)
    private String executionType;

    @NotNull
    @Column(name = "reps_should", nullable = false)
    private Integer repsShould;

    @NotNull
    @Column(name = "reps_done", nullable = false)
    private Integer repsDone;

    @NotNull
    @Column(name = "weight", nullable = false)
    private Integer weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseunitset_id", nullable = true) // This column should exist in ExerciseUnit table
    private ExerciseUnitSet exerciseUnitSet;

}