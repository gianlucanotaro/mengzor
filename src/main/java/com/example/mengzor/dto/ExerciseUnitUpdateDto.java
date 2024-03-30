package com.example.mengzor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ExerciseUnitUpdateDto {
    private UUID exerciseId;
    private String exerciseType;
    private String status;
    private String executionType;
    private Integer repsShould;
    private Integer repsDone;
    private Integer weight;

}
