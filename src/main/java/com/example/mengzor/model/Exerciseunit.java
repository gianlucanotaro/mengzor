package com.example.mengzor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exerciseunit")
@AllArgsConstructor
@NoArgsConstructor
public class Exerciseunit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @NotNull
    @Column(name = "exercisetype", nullable = false, length = Integer.MAX_VALUE)
    private String exercisetype;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @NotNull
    @Column(name = "executiontype", nullable = false, length = Integer.MAX_VALUE)
    private String executiontype;

    @NotNull
    @Column(name = "reps_should", nullable = false)
    private Integer repsShould;

    @NotNull
    @Column(name = "reps_done", nullable = false)
    private Integer repsDone;

    @NotNull
    @Column(name = "sets_should", nullable = false)
    private Integer setsShould;

    @NotNull
    @Column(name = "sets_done", nullable = false)
    private Integer setsDone;

    @NotNull
    @Column(name = "weight", nullable = false)
    private Integer weight;
}