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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExercise(@PathVariable Long id){
        exerciseService.deleteExercise(id);
        //TODO: delete exercise from every workout and create confirmation before deleting in frontend
        return ResponseEntity.ok().build();
    }



}