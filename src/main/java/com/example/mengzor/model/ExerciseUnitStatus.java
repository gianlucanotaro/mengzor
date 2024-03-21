package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enum_exercise_unit_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseUnitStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
