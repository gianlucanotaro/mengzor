CREATE TABLE execution_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


INSERT INTO execution_type (name) VALUES
('failure'),
('normal'),
('dropset'),
('repmax'),
('onerepmax');
