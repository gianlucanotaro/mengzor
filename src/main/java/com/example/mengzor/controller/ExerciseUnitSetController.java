package com.example.mengzor.controller;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.service.ExerciseUnitService;
import com.example.mengzor.service.ExerciseUnitSetService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/exerciseUnitSet")
public class ExerciseUnitSetController {

    private final ExerciseUnitSetService exerciseUnitSetService;
    private final ExerciseUnitService exerciseUnitService;

    @Autowired
    public ExerciseUnitSetController(ExerciseUnitSetService exerciseUnitSetService, ExerciseUnitService exerciseUnitService) {
        this.exerciseUnitSetService = exerciseUnitSetService;
        this.exerciseUnitService = exerciseUnitService;
    }

    @PostMapping
    public ExerciseUnitSet addExerciseUnitSet(@RequestBody ExerciseUnitSet exerciseUnitSet) {
        return exerciseUnitSetService.save(exerciseUnitSet);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExerciseUnit> updateExerciseUnitSetField(@PathVariable Long id,  @RequestBody @NotNull Map<String, Object> updates) {
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
}
