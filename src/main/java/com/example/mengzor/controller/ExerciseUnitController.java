package com.example.mengzor.controller;

import com.example.mengzor.dto.ExerciseUnitUpdateDto;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.service.ExerciseUnitService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exerciseUnit")
public class ExerciseUnitController {

    private final ExerciseUnitService exerciseUnitService;

    @Autowired
    public ExerciseUnitController(ExerciseUnitService exerciseUnitService) {
        this.exerciseUnitService = exerciseUnitService;
    }

    @PatchMapping("/{id}")
   public   ResponseEntity<ExerciseUnit> updateExerciseUnit(@PathVariable UUID id, @RequestBody ExerciseUnitUpdateDto updateDto) {
        try {
            ExerciseUnit updatedExerciseUnit = exerciseUnitService.updateExerciseUnit(id, updateDto);
            return ResponseEntity.ok(updatedExerciseUnit);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseUnit(@PathVariable UUID id) {
        exerciseUnitService.deleteExerciseUnit(id);
        return ResponseEntity.noContent().build();
    }
}
