package com.web_project.gembasqb;


import com.web_project.gembasqb.controllers.CollabController;
import com.web_project.gembasqb.dtos.CollabRDto;
import com.web_project.gembasqb.models.CollabModel;
import com.web_project.gembasqb.repositories.CollabRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CollabControllerTest {

    @InjectMocks
    private CollabController collabController;

    @Mock
    private CollabRepository collabRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCollab() {
        CollabRDto collabRDto = new CollabRDto("Maria Silva", "maria.silva@example.com",
                Date.valueOf("2024-10-13"), 12345678901d, 21987654321d,
                "Ativo", "2024-10-30", null);

        CollabModel savedCollab = new CollabModel();
        savedCollab.setIdCollabUuid(UUID.randomUUID());
        when(collabRepository.save(any(CollabModel.class))).thenReturn(savedCollab);

        ResponseEntity<CollabModel> response = collabController.saveCollab(collabRDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedCollab, response.getBody());
    }

    @Test
    void testGetAllCollabs() {
        CollabModel collab = new CollabModel("Maria Silva", "maria.silva@example.com", 
                Date.valueOf("2024-10-13"), 12345678901d, 21987654321d, "Ativo", 
                "2024-10-30", null);
        when(collabRepository.findAll()).thenReturn(Collections.singletonList(collab));

        ResponseEntity<List<CollabModel>> response = collabController.getAllCollabs();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetOneCollab() {
        UUID id = UUID.randomUUID();
        CollabModel collab = new CollabModel();
        when(collabRepository.findById(id)).thenReturn(Optional.of(collab));

        ResponseEntity<Object> response = collabController.getOneCollab(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(collab, response.getBody());
    }

    @Test
    void testDeleteCollab() {
        UUID id = UUID.randomUUID();
        CollabModel collab = new CollabModel();
        when(collabRepository.findById(id)).thenReturn(Optional.of(collab));

        ResponseEntity<Object> response = collabController.deleteCollab(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(collabRepository).delete(collab);
    }

    @Test
    void testUpdateCollab() {
        UUID id = UUID.randomUUID();
        CollabRDto collabRDto = new CollabRDto("Maria Silva", "maria.silva@example.com", 
                Date.valueOf("2024-10-13"), 12345678901d, 21987654321d, "Ativo", 
                "2024-10-30", null);

        CollabModel existingCollab = new CollabModel();
        existingCollab.setIdCollabUuid(id);
        when(collabRepository.findById(id)).thenReturn(Optional.of(existingCollab));
        when(collabRepository.save(any(CollabModel.class))).thenReturn(existingCollab);

        ResponseEntity<Object> response = collabController.updateCollab(id, collabRDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
