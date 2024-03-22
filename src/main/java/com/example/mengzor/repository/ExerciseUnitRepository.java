package com.example.mengzor.repository;

import com.example.mengzor.model.Exerciseunit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseUnitRepository extends JpaRepository<Exerciseunit, Long> {

}
