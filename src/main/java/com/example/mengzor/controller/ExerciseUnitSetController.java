package com.example.mengzor.controller;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.service.ExerciseUnitService;
import com.example.mengzor.service.ExerciseUnitSetService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
