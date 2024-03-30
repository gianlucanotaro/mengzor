package com.example.mengzor.controller;


import com.example.mengzor.model.ExerciseUnit;
import com.example.mengzor.model.ExerciseUnitSet;
import com.example.mengzor.service.ExerciseUnitService;
import com.example.mengzor.service.ExerciseUnitSetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExerciseUnitSetController.class)
public class ExerciseUnitSetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExerciseUnitSetService exerciseUnitSetService;

    @MockBean
    private ExerciseUnitService exerciseUnitService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void addExerciseUnitSet_Success() throws Exception {
        ExerciseUnitSet exerciseUnitSet = new ExerciseUnitSet(); // Mock the request body
        when(exerciseUnitSetService.save(any(ExerciseUnitSet.class))).thenReturn(exerciseUnitSet);

        mockMvc.perform(post("/api/exerciseUnitSet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(exerciseUnitSet)))
                .andExpect(status().isOk());
    }

    @Test
    public void addExerciseUnitToSet_Success() throws Exception {
        UUID exerciseUnitSetId = UUID.randomUUID();
        ExerciseUnit exerciseUnit = new ExerciseUnit();
        ExerciseUnit savedExerciseUnit = new ExerciseUnit();

        when(exerciseUnitService.addExerciseUnitToSet(eq(exerciseUnitSetId), any(ExerciseUnit.class)))
                .thenReturn(savedExerciseUnit);

        mockMvc.perform(post("/api/exerciseUnitSet/{exerciseUnitSetId}/exerciseUnits", exerciseUnitSetId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(exerciseUnit)))
                .andExpect(status().isOk());
    }


    @Test
    public void getExerciseUnitSet_Success() throws Exception {
        UUID id = UUID.randomUUID();
        ExerciseUnitSet exerciseUnitSet = new ExerciseUnitSet();
        when(exerciseUnitSetService.findById(id)).thenReturn(exerciseUnitSet);

        mockMvc.perform(get("/api/exerciseUnitSet/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteExerciseUnitSet_Success() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(exerciseUnitSetService).delete(id);

        mockMvc.perform(delete("/api/exerciseUnitSet/{id}", id))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteExerciseUnitSet_NotFound() throws Exception {
        UUID id = UUID.randomUUID();
        doThrow(new EntityNotFoundException()).when(exerciseUnitSetService).delete(id);

        mockMvc.perform(delete("/api/exerciseUnitSet/{id}", id))
                .andExpect(status().isNotFound());
    }
}
