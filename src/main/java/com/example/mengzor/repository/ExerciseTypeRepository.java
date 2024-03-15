package com.example.mengzor.repository;

import com.example.mengzor.model.Exercise;
import com.example.mengzor.model.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Long> {
}