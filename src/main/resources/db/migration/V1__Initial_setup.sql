CREATE TABLE enum_execution_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE enum_exercise_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE enum_exercise_unit_status (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE muscle (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE exercise (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    execution_type_id INTEGER,
    CONSTRAINT fk_execution_type FOREIGN KEY (execution_type_id)
        REFERENCES enum_execution_type (id)
);

CREATE TABLE exercise_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE exercise_muscle (
    exercise_id INTEGER NOT NULL,
    muscle_id INTEGER NOT NULL,
    PRIMARY KEY (exercise_id, muscle_id),
    CONSTRAINT fk_exercise FOREIGN KEY (exercise_id) REFERENCES exercise (id),
    CONSTRAINT fk_muscle FOREIGN KEY (muscle_id) REFERENCES muscle (id)
);

CREATE TABLE exercise_exercise_type (
    exercise_id INTEGER NOT NULL,
    exercise_type_id INTEGER NOT NULL,
    PRIMARY KEY (exercise_id, exercise_type_id),
    CONSTRAINT fk_exercise_to_type FOREIGN KEY (exercise_id) REFERENCES exercise (id),
    CONSTRAINT fk_exercise_type FOREIGN KEY (exercise_type_id) REFERENCES exercise_type (id)
);

CREATE TABLE exercise_unit_set (
    id SERIAL PRIMARY KEY
);

CREATE TABLE exercise_unit (
    id SERIAL PRIMARY KEY,
    exercise_id INTEGER,
    exercise_unit_set_id INTEGER,
    status_id INTEGER,
    reps_should INTEGER,
    reps_done INTEGER,
    sets_should INTEGER,
    sets_done INTEGER,
    CONSTRAINT fk_exercise_to_unit FOREIGN KEY (exercise_id) REFERENCES exercise (id),
    CONSTRAINT fk_exercise_unit_set FOREIGN KEY (exercise_unit_set_id) REFERENCES exercise_unit_set (id),
    CONSTRAINT fk_exercise_unit_status FOREIGN KEY (status_id) REFERENCES enum_exercise_unit_status (id)
);

CREATE TABLE workout (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    startdate DATE,
    enddate DATE
);

CREATE TABLE workout_exercise_unit_set (
    workout_id INTEGER NOT NULL,
    exercise_unit_set_id INTEGER NOT NULL,
    PRIMARY KEY (workout_id, exercise_unit_set_id),
    CONSTRAINT fk_workout FOREIGN KEY (workout_id) REFERENCES workout (id),
    CONSTRAINT fk_exercise_unit_set_to_workout FOREIGN KEY (exercise_unit_set_id) REFERENCES exercise_unit_set (id)
);
