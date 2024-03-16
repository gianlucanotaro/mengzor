-- Enum types for ExerciseType and ExerciseUnitStatus
CREATE TYPE exercise_type AS ENUM ('CARDIO', 'STRENGTH', 'FLEXIBILITY', 'BALANCE', 'PLYOMETRICS', 'OTHER');
CREATE TYPE exercise_unit_status AS ENUM ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED', 'FAILED', 'SKIPPED');
CREATE TYPE execution_type AS ENUM ('FAILURE', 'NORMAL', 'DROPSET', 'REP_MAX', 'ONE_REP_MAX');
CREATE TYPE muscle AS ENUM ('CALVES', 'HAMSTRINGS', 'QUADRICEPS', 'GLUTES', 'BICEPS', 'TRICEPS', 'FOREARMS', 'TRAPEZIUS', 'LATISSIMUS_DORSI', 'SHOULDERS');

-- Muscle Worked is assumed to be a separate table
CREATE TABLE muscle_worked (
    id BIGSERIAL PRIMARY KEY,
    muscle_name muscle
);

-- Workout table, containing a list of ExerciseUnitSets
CREATE TABLE workout (
    id BIGSERIAL PRIMARY KEY,
    start_date TIMESTAMP WITH TIME ZONE,
    end_date TIMESTAMP WITH TIME ZONE
);

-- Exercise table
CREATE TABLE exercise (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    muscle_worked_id BIGINT REFERENCES muscle_worked(id),
    exercise_type exercise_type
);

-- ExerciseUnitSet table
CREATE TABLE exercise_unit_set (
    id BIGSERIAL PRIMARY KEY,
    workout_id BIGINT REFERENCES workout(id)
);

-- ExerciseUnit table
CREATE TABLE exercise_unit (
    id BIGSERIAL PRIMARY KEY,
    exercise_id BIGINT REFERENCES exercise(id),
    exercise_unit_set_id BIGINT REFERENCES exercise_unit_set(id),
    exercise_type exercise_type,
    exercise_unit_status exercise_unit_status,
    reps_should INTEGER,
    reps_done INTEGER,
    weight_should INTEGER,
    weight_done INTEGER
);
