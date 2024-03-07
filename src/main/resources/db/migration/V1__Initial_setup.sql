-- Create exercise_type table
CREATE TABLE exercise_type (
    id SERIAL PRIMARY KEY,
    type VARCHAR(255) NOT NULL
);

-- Create muscle table
CREATE TABLE muscle (
    id SERIAL PRIMARY KEY,
    muscle_name VARCHAR(255) NOT NULL
);

-- Create exercise table
CREATE TABLE exercise (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    muscle_worked INT,
    exercise_type INT,
    CONSTRAINT fk_muscle FOREIGN KEY (muscle_worked) REFERENCES muscle(id),
    CONSTRAINT fk_exercise_type FOREIGN KEY (exercise_type) REFERENCES exercise_type(id)
);

-- Create exercise_unit table
CREATE TABLE exercise_unit (
    id SERIAL PRIMARY KEY,
    exercise INT NOT NULL,
    execution_type VARCHAR(255),
    reps INT,
    sets INT,
    status VARCHAR(100),
    CONSTRAINT fk_exercise FOREIGN KEY (exercise) REFERENCES exercise(id)
);

-- Create muscle_group table
CREATE TABLE muscle_group (
    id SERIAL PRIMARY KEY,
    muscle_names TEXT NOT NULL
);

-- Create workout table
CREATE TABLE workout (
    id SERIAL PRIMARY KEY,
    start_date TIMESTAMP WITH TIME ZONE NOT NULL,
    end_date TIMESTAMP WITH TIME ZONE,
    exercise_unit_list TEXT
);
