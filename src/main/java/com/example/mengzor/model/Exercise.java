package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "exercise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "execution_type_id")
    private ExecutionType executionType;

    @ManyToMany
    @JoinTable(
            name = "exercise_muscle",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id")
    )
    private Set<Muscle> muscles;

    @ManyToMany
    @JoinTable(
            name = "exercise_exercise_type",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_type_id")
    )
    private Set<ExerciseType> exerciseTypes;
}
