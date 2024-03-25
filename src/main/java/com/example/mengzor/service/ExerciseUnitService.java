package com.example.mengzor.service;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.repository.ExerciseRepository;
import com.example.mengzor.repository.ExerciseUnitRepository;
import com.example.mengzor.repository.ExerciseUnitSetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseUnitService {

    private final ExerciseUnitRepository exerciseUnitRepository;
    private final ExerciseRepository exerciseRepository;
    private final ExerciseUnitSetRepository exerciseUnitSetRepository;

    public ExerciseUnitService(ExerciseUnitRepository exerciseUnitRepository, ExerciseRepository exerciseRepository, ExerciseUnitSetRepository exerciseUnitSetRepository) {
        this.exerciseUnitRepository = exerciseUnitRepository;
        this.exerciseRepository = exerciseRepository;
        this.exerciseUnitSetRepository = exerciseUnitSetRepository;
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

    @Transactional
    public void deleteExerciseUnitById(UUID exerciseUnitId) {
        // Optional: Fetch and disassociate the ExerciseUnit from its ExerciseUnitSet
        Optional<ExerciseUnitSet> optionalUnitSet = exerciseUnitSetRepository.findByExerciseUnitId(exerciseUnitId);
        if (optionalUnitSet.isPresent()) {
            ExerciseUnitSet unitSet = optionalUnitSet.get();
            unitSet.setExerciseUnit(null); // Disassociate the ExerciseUnit
            exerciseUnitSetRepository.save(unitSet); // Save the updated ExerciseUnitSet
        }

        // Delete the ExerciseUnit
        exerciseUnitRepository.deleteById(exerciseUnitId);
    }

    @Transactional
    public void deleteExerciseUnit(UUID exerciseUnitId) {
        // First, find the ExerciseUnitSet associated with the ExerciseUnit, if any
        Optional<ExerciseUnitSet> unitSetOpt = exerciseUnitSetRepository.findByExerciseUnitId(exerciseUnitId);

        // If present, disassociate the ExerciseUnit from the ExerciseUnitSet
        unitSetOpt.ifPresent(unitSet -> {
            unitSet.setExerciseUnit(null);
            exerciseUnitSetRepository.save(unitSet);
        });

        // Now, delete the ExerciseUnit
        exerciseUnitRepository.deleteById(exerciseUnitId);
    }
}
