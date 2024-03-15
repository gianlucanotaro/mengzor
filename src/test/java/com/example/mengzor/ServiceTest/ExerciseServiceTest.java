package com.example.mengzor.ServiceTest;


import com.example.mengzor.model.Exercise;
import com.example.mengzor.repository.ExerciseRepository;
import com.example.mengzor.service.ExerciseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ExerciseServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseService exerciseService;

    @Test
    void createExerciseTest() {
        Exercise exercise = new Exercise(); // Setup your exercise
        when(exerciseRepository.save(any(Exercise.class))).thenReturn(exercise);

        exerciseService.createExercise(exercise);

        verify(exerciseRepository, times(1)).save(any(Exercise.class));
    }
}
