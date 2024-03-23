package com.example.mengzor.service;

import com.example.mengzor.model.ExerciseUnitSet;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mengzor.repository.ExerciseUnitSetRepository;

@Service
public class ExerciseUnitSetService {

    private final ExerciseUnitSetRepository exerciseUnitSetRepository;

    @Autowired
    public ExerciseUnitSetService(ExerciseUnitSetRepository exerciseUnitSetRepository) {
        this.exerciseUnitSetRepository = exerciseUnitSetRepository;
    }

    public ExerciseUnitSet save(ExerciseUnitSet exerciseUnitSet) {
        return exerciseUnitSetRepository.save(exerciseUnitSet);
    }

}
