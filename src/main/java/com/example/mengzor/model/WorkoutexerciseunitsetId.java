package com.example.mengzor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class WorkoutexerciseunitsetId implements Serializable {
    private static final long serialVersionUID = 8394061137933130497L;
    @NotNull
    @Column(name = "workout_id", nullable = false)
    private Integer workoutId;

    @NotNull
    @Column(name = "exerciseunitset_id", nullable = false)
    private Integer exerciseunitsetId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WorkoutexerciseunitsetId entity = (WorkoutexerciseunitsetId) o;
        return Objects.equals(this.exerciseunitsetId, entity.exerciseunitsetId) &&
                Objects.equals(this.workoutId, entity.workoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseunitsetId, workoutId);
    }

}