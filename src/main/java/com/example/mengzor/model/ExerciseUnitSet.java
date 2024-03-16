package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "exercise_unit_set")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseUnitSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "exerciseUnitSet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseUnit> exerciseUnitList;
}
