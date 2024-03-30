package com.example.mengzor.repository;

import com.example.mengzor.model.ExerciseUnitSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExerciseUnitSetRepository extends JpaRepository<ExerciseUnitSet, UUID> {

    Optional<ExerciseUnitSet> findByExerciseUnitId(@Param("exerciseunit_id") UUID exerciseUnitId);


}
