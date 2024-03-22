package com.example.mengzor.controller;

import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.service.ExerciseUnitSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/exerciseUnitSet")
public class ExerciseUnitSetController {

    private final ExerciseUnitSetService exerciseUnitSetService;

    @Autowired
    public ExerciseUnitSetController(ExerciseUnitSetService exerciseUnitSetService) {
        this.exerciseUnitSetService = exerciseUnitSetService;
    }

    @PostMapping
    public ExerciseUnitSet addExerciseUnitSet(@RequestBody ExerciseUnitSet exerciseUnitSet) {
        return exerciseUnitSetService.save(exerciseUnitSet);
    }
}
