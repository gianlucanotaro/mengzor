package com.example.mengzor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {
    private String name;
    private List<Long> muscleWorkedIds;
    private Long exerciseTypeId;
}

