package com.example.mengzor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {
    private String name;
    private Long muscleWorkedId;
    private Long exerciseTypeId;
}
