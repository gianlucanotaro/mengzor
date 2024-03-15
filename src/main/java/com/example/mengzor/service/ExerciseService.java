package com.example.mengzor.service;

import com.example.mengzor.dto.ExerciseDTO;
import com.example.mengzor.model.Exercise;
import com.example.mengzor.repository.ExerciseRepository;
import com.example.mengzor.repository.ExerciseTypeRepository;
import com.example.mengzor.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mengzor.model.Muscle;
import com.example.mengzor.model.ExerciseType;

import java.util.List;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseTypeRepository exerciseTypeRepository;
    private final MuscleRepository muscleRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseTypeRepository exerciseTypeRepository, MuscleRepository muscleRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseTypeRepository = exerciseTypeRepository;
        this.muscleRepository = muscleRepository;
    }


    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise createExercise(ExerciseDTO exerciseDTO) {
        // Check if Muscle and ExerciseType exist
        Muscle muscle = muscleRepository.findById(exerciseDTO.getMuscleWorkedId())
                .orElseThrow(() -> new RuntimeException("Muscle not found"));
        ExerciseType exerciseType = exerciseTypeRepository.findById(exerciseDTO.getExerciseTypeId())
                .orElseThrow(() -> new RuntimeException("ExerciseType not found"));

        Exercise exercise = Exercise.builder()
                .name(exerciseDTO.getName())
                .muscleWorked(muscle)
                .exerciseType(exerciseType)
                .build();

        return exerciseRepository.save(exercise);
    }
}
