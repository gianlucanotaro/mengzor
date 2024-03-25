package com.example.mengzor.controller;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.repository.ExerciseUnitSetRepository;
import com.example.mengzor.service.ExerciseUnitService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/exerciseUnit")
public class ExerciseUnitController {

    private final ExerciseUnitService exerciseUnitService;

    @Autowired
    public ExerciseUnitController(ExerciseUnitService exerciseUnitService) {
        this.exerciseUnitService = exerciseUnitService;
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ExerciseUnit> updateExerciseUnitSetField(@PathVariable UUID id, @RequestBody @NotNull Map<String, Object> updates) {
        ExerciseUnit exerciseUnit = exerciseUnitService.findById(id);

        updates.forEach((key, value) -> {
            switch (key) {
                case "exercise":
                    exerciseUnit.setExercise((Exercise) value);
                    break;
                case "exerciseType":
                    exerciseUnit.setExerciseType((String) value);
                    break;
                case "status":
                    exerciseUnit.setStatus((String) value);
                    break;
                case "executionType":
                    exerciseUnit.setExecutionType((String) value);
                    break;
                case "repsShould":
                    exerciseUnit.setRepsShould((Integer) value);
                    break;
                case "repsDone":
                    exerciseUnit.setRepsDone((Integer) value);
                    break;
                case "weight":
                    exerciseUnit.setWeight((Integer) value);
                    break;
            }
        });
        return ResponseEntity.ok(exerciseUnitService.save(exerciseUnit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseUnit(@PathVariable UUID id) {
        exerciseUnitService.deleteExerciseUnit(id);
        return ResponseEntity.noContent().build();
    }

}
