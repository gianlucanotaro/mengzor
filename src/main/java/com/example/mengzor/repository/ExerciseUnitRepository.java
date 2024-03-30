package com.example.mengzor.repository;

import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExerciseUnitRepository extends JpaRepository<ExerciseUnit, UUID> {

    @Query("SELECT u.exerciseUnitSet FROM ExerciseUnit u WHERE u.id = :id")
    Optional<ExerciseUnitSet> findExerciseUnitSetByExerciseUnitId(@Param("id") UUID id);

}
