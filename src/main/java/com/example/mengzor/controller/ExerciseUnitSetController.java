package com.example.mengzor.controller;

import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.service.ExerciseUnitService;
import com.example.mengzor.service.ExerciseUnitSetService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exerciseUnitSet")
public class ExerciseUnitSetController {

    private final ExerciseUnitSetService exerciseUnitSetService;
    private final ExerciseUnitService exerciseUnitService;

    @Autowired
    public ExerciseUnitSetController(ExerciseUnitSetService exerciseUnitSetService, ExerciseUnitService exerciseUnitService) {
        this.exerciseUnitSetService = exerciseUnitSetService;
        this.exerciseUnitService = exerciseUnitService;
    }

    @PostMapping
    public ResponseEntity<ExerciseUnitSet> addExerciseUnitSet(@RequestBody ExerciseUnitSet exerciseUnitSet) {
        ExerciseUnitSet savedSet = exerciseUnitSetService.save(exerciseUnitSet);
        return ResponseEntity.ok(savedSet);
    }

    @PostMapping("/{exerciseUnitSetId}/exerciseUnits")
    public ResponseEntity<?> addExerciseUnitToSet(@PathVariable UUID exerciseUnitSetId, @RequestBody ExerciseUnit exerciseUnit) {
        try {
            exerciseUnitService.addExerciseUnitToSet(exerciseUnitSetId, exerciseUnit);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseUnitSet> getExerciseUnitSet(@PathVariable UUID id) {
        ExerciseUnitSet exerciseUnitSet = exerciseUnitSetService.findById(id);
        if (exerciseUnitSet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exerciseUnitSet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseUnitSet(@PathVariable UUID id) {
        try {
            exerciseUnitSetService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
