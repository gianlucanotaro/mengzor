package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
