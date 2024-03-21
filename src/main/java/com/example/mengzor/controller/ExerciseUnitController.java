package com.example.mengzor.controller;

import com.example.mengzor.service.ExerciseUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercise-unit")
public class ExerciseUnitController{

    private final ExerciseUnitService exerciseUnitService;

    @Autowired
    public ExerciseUnitController(ExerciseUnitService exerciseUnitService) {
        this.exerciseUnitService = exerciseUnitService;
    }


}
