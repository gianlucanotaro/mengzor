package com.example.mengzor.controller;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.Muscle;
import com.example.mengzor.service.ExerciseService;
import com.example.mengzor.service.MuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



    @RestController
    @RequestMapping("/api/muscle") // Base path for all endpoints in this controller
    public class MuscleController {


        private final MuscleService muscleService;

        @Autowired
        public MuscleController(MuscleService muscleService) {
            this.muscleService = muscleService;
        }

        @GetMapping
        public List<Muscle> getAllMuscle() {
            return muscleService.getAllMuscles();
        }

    }
