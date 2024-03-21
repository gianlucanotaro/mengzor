package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise_unit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "exercise_unit_set_id")
    private ExerciseUnitSet exerciseUnitSet;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ExerciseUnitStatus status;

    private Integer repsShould;
    private Integer repsDone;
    private Integer setsShould;
    private Integer setsDone;
}
