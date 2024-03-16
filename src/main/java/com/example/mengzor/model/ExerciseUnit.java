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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_unit")
    private Exercise exercise;

    private ExerciseType executionType;
    private Integer sets;
    private List<Integer> reps_should;
    private List<Integer> reps_done;
    private List<Integer> weight_should;
    private List<Integer> weight_done;
    private ExerciseUnitStatus exerciseUnitStatus;

}

