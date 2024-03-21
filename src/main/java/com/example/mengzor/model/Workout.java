package com.example.mengzor.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "workout")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "workout_exercise_unit_set",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_unit_set_id")
    )
    private Set<ExerciseUnitSet> exerciseUnitSets;
}
