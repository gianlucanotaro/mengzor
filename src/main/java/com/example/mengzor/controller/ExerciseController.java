package com.example.mengzor.controller;

import com.example.mengzor.dto.ExerciseDTO;
import com.example.mengzor.model.Exercise;
import com.example.mengzor.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises") // Base path for all endpoints in this controller
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody ExerciseDTO exerciseDTO) {
        Exercise createdExercise = exerciseService.createExercise(exerciseDTO);
        return ResponseEntity.status(201).body(createdExercise);
    }

}