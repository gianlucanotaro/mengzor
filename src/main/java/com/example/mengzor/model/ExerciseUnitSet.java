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
@Table(name = "exerciseunitset")
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseUnitSet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "exerciseunit_id", nullable = true) // Ensure this is nullable
    private ExerciseUnit exerciseUnit;
}