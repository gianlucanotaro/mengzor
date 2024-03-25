package com.example.mengzor.service;

import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mengzor.repository.ExerciseUnitSetRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseUnitSetService {

    private final ExerciseUnitSetRepository exerciseUnitSetRepository;
    private final ExerciseUnitService exerciseUnitService;

    @Autowired
    public ExerciseUnitSetService(ExerciseUnitSetRepository exerciseUnitSetRepository, ExerciseUnitService exerciseUnitService) {
        this.exerciseUnitSetRepository = exerciseUnitSetRepository;
        this.exerciseUnitService = exerciseUnitService;
    }

    @Transactional
    public ExerciseUnitSet save(ExerciseUnitSet exerciseUnitSet) {
        if (exerciseUnitSet.getExerciseUnit() != null && exerciseUnitSet.getExerciseUnit().getId() == null) {
            ExerciseUnit managedExerciseUnit = exerciseUnitService.save(exerciseUnitSet.getExerciseUnit());
            exerciseUnitSet.setExerciseUnit(managedExerciseUnit);
        }

        return exerciseUnitSetRepository.save(exerciseUnitSet);
    }

}