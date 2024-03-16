package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "exercise_unit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_unit_set_id")
    private ExerciseUnitSet exerciseUnitSet;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @Enumerated(EnumType.STRING)
    private ExerciseUnitStatus exerciseUnitStatus;

    private Integer reps_should;
    private Integer reps_done;
    private Integer weight_should;
    private Integer weight_done;

}

