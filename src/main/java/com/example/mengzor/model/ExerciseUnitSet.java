package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "exercise_unit_set")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseUnitSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "exerciseUnitSet")
    private Set<ExerciseUnit> exerciseUnits;
}
