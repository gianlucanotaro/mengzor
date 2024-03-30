ALTER TABLE ExerciseUnitSet DROP COLUMN exerciseUnit_id;

ALTER TABLE ExerciseUnit
    ADD COLUMN exerciseUnitSet_id UUID NULL,
    ADD CONSTRAINT fk_exerciseUnit_exerciseUnitSet
        FOREIGN KEY (exerciseUnitSet_id)
            REFERENCES ExerciseUnitSet (id)
            ON DELETE SET NULL;
