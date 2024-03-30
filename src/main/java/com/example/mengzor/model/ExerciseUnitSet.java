package com.example.mengzor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "exerciseunitset")
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseUnitSet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @OneToMany(mappedBy = "exerciseUnitSet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseUnit> exerciseUnits = new ArrayList<>();

}