package com.example.mengzor.dto;

import com.example.mengzor.model.Exercise;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExerciseUnitDto {
    private Exercise exercise;
    private String exerciseType;
    private String status;
    private String executionType;
    private Integer repsShould;
    private Integer repsDone;
    private Integer weight;
}
