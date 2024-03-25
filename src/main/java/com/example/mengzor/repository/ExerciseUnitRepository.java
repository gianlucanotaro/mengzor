package com.example.mengzor.repository;

import com.example.mengzor.model.ExerciseUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerciseUnitRepository extends JpaRepository<ExerciseUnit, UUID> {
}
