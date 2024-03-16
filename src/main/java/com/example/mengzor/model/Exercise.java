package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "exercise")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "muscle_worked")
    private List<Muscle> muscleWorked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_type")
    private ExerciseType exerciseType;
}
