package com.example.mengzor.service;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.repository.ExerciseRepository;
import com.example.mengzor.repository.ExerciseUnitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ExerciseUnitService {

    private final ExerciseUnitRepository exerciseUnitRepository;
    private final ExerciseRepository exerciseRepository;

    public ExerciseUnitService(ExerciseUnitRepository exerciseUnitRepository, ExerciseRepository exerciseRepository) {
        this.exerciseUnitRepository = exerciseUnitRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Transactional
    public ExerciseUnit save(ExerciseUnit exerciseUnit) {
        if (exerciseUnit.getExercise() != null && exerciseUnit.getExercise().getId() == null) {
            Exercise managedExercise = exerciseRepository.save(exerciseUnit.getExercise());
            exerciseUnit.setExercise(managedExercise);
        }

        return exerciseUnitRepository.save(exerciseUnit);
    }

    public ExerciseUnit findById(UUID id) {
        return exerciseUnitRepository.findById(id).orElse(null);
    }
}
