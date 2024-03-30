package com.example.mengzor.controller;

import com.example.mengzor.dto.ExerciseUnitUpdateDto;
import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.service.ExerciseUnitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExerciseUnitController.class)
public class ExerciseUnitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExerciseUnitService exerciseUnitService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateExerciseUnit_Success() throws Exception {
        UUID id = UUID.randomUUID();
        ExerciseUnitUpdateDto updateDto = new ExerciseUnitUpdateDto(); // Assume this is populated with valid update data
        ExerciseUnit exerciseUnit = new ExerciseUnit(); // Assume this is populated with the expected updated state

        Mockito.when(exerciseUnitService.updateExerciseUnit(id, updateDto)).thenReturn(exerciseUnit);

        mockMvc.perform(patch("/api/exerciseUnit/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk());
    }

    @Test
    void updateExerciseUnit_NotFound() throws Exception {
        UUID id = UUID.randomUUID();
        ExerciseUnitUpdateDto updateDto = new ExerciseUnitUpdateDto(); // Assume this is populated with valid update data

        Mockito.when(exerciseUnitService.updateExerciseUnit(id, updateDto))
                .thenThrow(new EntityNotFoundException("ExerciseUnit not found"));

        mockMvc.perform(patch("/api/exerciseUnit/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteExerciseUnit_Success() throws Exception {
        UUID id = UUID.randomUUID();
        Mockito.doNothing().when(exerciseUnitService).deleteExerciseUnit(id);

        mockMvc.perform(delete("/api/exerciseUnit/{id}", id))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteExerciseUnit_NotFound() throws Exception {
        UUID id = UUID.randomUUID();
        doThrow(new EntityNotFoundException("ExerciseUnit not found"))
                .when(exerciseUnitService).deleteExerciseUnit(id);

        mockMvc.perform(delete("/api/exerciseUnit/{id}", id))
                .andExpect(status().isNotFound());
    }
}
