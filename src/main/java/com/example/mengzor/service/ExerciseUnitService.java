package com.example.mengzor.service;

import com.example.mengzor.dto.ExerciseUnitUpdateDto;
import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.repository.ExerciseRepository;
import com.example.mengzor.repository.ExerciseUnitRepository;
import com.example.mengzor.repository.ExerciseUnitSetRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public void deleteExerciseUnit(UUID exerciseUnitId) {
        Optional<ExerciseUnit> exerciseUnitOpt = exerciseUnitRepository.findById(exerciseUnitId);
        exerciseUnitOpt.ifPresent(exerciseUnit -> {
            ExerciseUnitSet unitSet = exerciseUnit.getExerciseUnitSet();
            if (unitSet != null) {
                unitSet.getExerciseUnits().remove(exerciseUnit);
                exerciseUnitSetRepository.save(unitSet);
            }
            exerciseUnitRepository.delete(exerciseUnit);
        });
    }

    @Transactional
    public ExerciseUnit addExerciseUnitToSet(UUID exerciseUnitSetId, ExerciseUnit exerciseUnit) {
        ExerciseUnitSet exerciseUnitSet = exerciseUnitSetRepository.findById(exerciseUnitSetId)
                .orElseThrow(() -> new EntityNotFoundException("ExerciseUnitSet not found with ID: " + exerciseUnitSetId));

        exerciseUnit.setExerciseUnitSet(exerciseUnitSet);

        exerciseUnitSet.getExerciseUnits().add(exerciseUnit);

        return exerciseUnitRepository.save(exerciseUnit);
    }

    @Transactional
    public ExerciseUnit updateExerciseUnit(UUID id, ExerciseUnitUpdateDto updateDto) {
        ExerciseUnit exerciseUnit = exerciseUnitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ExerciseUnit not found with ID: " + id));

        // Assume you have a method to fetch the Exercise by ID if necessary
        if (updateDto.getExerciseId() != null) {
            Exercise exercise = exerciseRepository.findById(updateDto.getExerciseId())
                    .orElseThrow(() -> new EntityNotFoundException("Exercise not found with ID: " + updateDto.getExerciseId()));
            exerciseUnit.setExercise(exercise);
        }
        exerciseUnit.setExerciseType(updateDto.getExerciseType());
        exerciseUnit.setStatus(updateDto.getStatus());
        exerciseUnit.setExecutionType(updateDto.getExecutionType());
        exerciseUnit.setRepsShould(updateDto.getRepsShould());
        exerciseUnit.setRepsDone(updateDto.getRepsDone());
        exerciseUnit.setWeight(updateDto.getWeight());

        return exerciseUnitRepository.save(exerciseUnit);
    }

}
