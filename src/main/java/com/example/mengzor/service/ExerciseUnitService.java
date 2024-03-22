package com.example.mengzor.service;

import com.example.mengzor.repository.ExerciseUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseUnitService {

    private final ExerciseUnitRepository exerciseUnitRepository;

    @Autowired
    public ExerciseUnitService(ExerciseUnitRepository exerciseUnitRepository) {
        this.exerciseUnitRepository = exerciseUnitRepository;
    }

}
