package com.example.mengzor.service;

import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.repository.ExerciseUnitRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseUnitService {

    private final ExerciseUnitRepository exerciseUnitRepository;

    public ExerciseUnitService(ExerciseUnitRepository exerciseUnitRepository) {
        this.exerciseUnitRepository = exerciseUnitRepository;
    }

    public ExerciseUnit save(ExerciseUnit exerciseUnit) {
        return exerciseUnitRepository.save(exerciseUnit);
    }

    public ExerciseUnit findById(Long id) {
        return exerciseUnitRepository.findById(id).orElse(null);
    }
}
