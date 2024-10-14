package com.web_project.gembasqb;


import com.web_project.gembasqb.controllers.ServicosController;
import com.web_project.gembasqb.dtos.ServicosRDto;
import com.web_project.gembasqb.models.ServicosModel;
import com.web_project.gembasqb.repositories.ServicosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ServicosControllerTest {

    @InjectMocks
    private ServicosController servicosController;

    @Mock
    private ServicosRepository servicosRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveServico() {
        ServicosRDto servicosRDto = new ServicosRDto("Serviço 1", "Descrição do Serviço 1", 100.0f,
                "Categoria 1", 2.0f, "Ativo", "imagem1.png", 10, null);

        ServicosModel savedServico = new ServicosModel();
        savedServico.setIdServico(UUID.randomUUID());
        when(servicosRepository.save(any(ServicosModel.class))).thenReturn(savedServico);

        ResponseEntity<ServicosModel> response = servicosController.saveServico(servicosRDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedServico, response.getBody());
    }

    @Test
    void testGetAllServicos() {
        ServicosModel servico = new ServicosModel("Serviço 1", "Descrição do Serviço 1", 100.0f,
                2.0f, "Ativo");
        when(servicosRepository.findAll()).thenReturn(Collections.singletonList(servico));

        ResponseEntity<List<ServicosModel>> response = servicosController.getAllServicos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetOneServico() {
        UUID id = UUID.randomUUID();
        ServicosModel servico = new ServicosModel();
        when(servicosRepository.findById(id)).thenReturn(Optional.of(servico));

        ResponseEntity<Object> response = servicosController.getOneServico(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(servico, response.getBody());
    }

    @Test
    void testDeleteServico() {
        UUID id = UUID.randomUUID();
        ServicosModel servico = new ServicosModel();
        when(servicosRepository.findById(id)).thenReturn(Optional.of(servico));

        ResponseEntity<Object> response = servicosController.deleteServico(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(servicosRepository).delete(servico);
    }

    @Test
    void testUpdateServico() {
        UUID id = UUID.randomUUID();
        ServicosRDto servicosRDto = new ServicosRDto("Serviço 1", "Descrição do Serviço 1", 100.0f,
                "Categoria 1", 2.0f, "Ativo", "imagem1.png", 10, null);

        ServicosModel existingServico = new ServicosModel();
        existingServico.setIdServico(id);
        when(servicosRepository.findById(id)).thenReturn(Optional.of(existingServico));
        when(servicosRepository.save(any(ServicosModel.class))).thenReturn(existingServico);

        ResponseEntity<Object> response = servicosController.updateServico(id, servicosRDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
