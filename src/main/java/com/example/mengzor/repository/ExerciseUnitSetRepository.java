package com.example.mengzor.repository;

import com.example.mengzor.model.ExerciseUnitSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mengzor.model.ExerciseUnit;

@Repository
public interface ExerciseUnitSetRepository extends JpaRepository<ExerciseUnitSet, Long> {
}
