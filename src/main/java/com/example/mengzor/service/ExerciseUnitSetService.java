package com.example.mengzor.service;

import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import jakarta.persistence.EntityNotFoundException;
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
        return exerciseUnitSetRepository.save(exerciseUnitSet);
    }

    public ExerciseUnitSet findById(UUID id) {
        return exerciseUnitSetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ExerciseUnitSet not found with ID: " + id));
    }

    @Transactional
    public void addExerciseUnitToSet(UUID exerciseUnitSetId, ExerciseUnit exerciseUnit) {
        ExerciseUnitSet exerciseUnitSet = findById(exerciseUnitSetId);

        exerciseUnit.setExerciseUnitSet(exerciseUnitSet);

        exerciseUnitService.save(exerciseUnit);
    }

    @Transactional
    public void delete(UUID id) {
        ExerciseUnitSet set = exerciseUnitSetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ExerciseUnitSet not found with ID: " + id));

        exerciseUnitSetRepository.delete(set);
    }


}
