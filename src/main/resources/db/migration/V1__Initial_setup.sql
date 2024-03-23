CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE Exercise
(
    id           UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name         VARCHAR NOT NULL,
    muscle       VARCHAR NOT NULL,
    exercisetype VARCHAR NOT NULL
);

CREATE TABLE ExerciseUnit
(
    id            UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    exercise_id   UUID NOT NULL,
    exercisetype  VARCHAR NOT NULL,
    status        VARCHAR NOT NULL,
    executionType VARCHAR NOT NULL,
    reps_should   INTEGER NOT NULL,
    reps_done     INTEGER NOT NULL,
    sets_should   INTEGER NOT NULL,
    sets_done     INTEGER NOT NULL,
    FOREIGN KEY (exercise_id) REFERENCES Exercise (id)
);

CREATE TABLE ExerciseUnitSet
(
    id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    exerciseUnit_id UUID NOT NULL,
    FOREIGN KEY (exerciseUnit_id) REFERENCES ExerciseUnit (id)
);

CREATE TABLE Workout
(
    id        UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name      VARCHAR NOT NULL,
    startdate DATE NOT NULL,
    enddate   DATE NOT NULL
);

CREATE TABLE WorkoutExerciseUnitSets
(
    workout_id         UUID NOT NULL,
    exerciseUnitSet_id UUID NOT NULL,
    PRIMARY KEY (workout_id, exerciseUnitSet_id),
    FOREIGN KEY (workout_id) REFERENCES Workout (id),
    FOREIGN KEY (exerciseUnitSet_id) REFERENCES ExerciseUnitSet (id)
);
