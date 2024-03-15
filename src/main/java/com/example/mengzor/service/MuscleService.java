
package com.example.mengzor.service;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.Muscle;
import com.example.mengzor.repository.ExerciseRepository;
import com.example.mengzor.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleService {
    private final MuscleRepository muscleRepository;

    @Autowired
    public MuscleService(MuscleRepository muscleRepository) {
        this.muscleRepository = muscleRepository;
    }

    public List<Muscle> getAllMuscles() {
        return muscleRepository.findAll();
    }

}
