package com.web_project.gembasqb;


import com.web_project.gembasqb.controllers.ClientesController;
import com.web_project.gembasqb.dtos.ClientesRDto;
import com.web_project.gembasqb.models.ClientesModel;
import com.web_project.gembasqb.repositories.ClientesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ClientesControllerTest {

    @InjectMocks
    private ClientesController clientesController;

    @Mock
    private ClientesRepository clientesRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCliente() {
        ClientesRDto clienteRDto = new ClientesRDto("João Silva", "joao.silva@example.com",
                Date.valueOf("2024-10-13"), "12345678901", Double.parseDouble("21987654321" ), "Ativo", "blank");

        ClientesModel savedCliente = new ClientesModel();
        savedCliente.setIdCliente(UUID.randomUUID());
        when(clientesRepository.save(any(ClientesModel.class))).thenReturn(savedCliente);

        ResponseEntity<ClientesModel> response = clientesController.saveCliente(clienteRDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedCliente, response.getBody());
    }

    @Test
    void testGetAllClientes() {
        // Implementar o teste para obter todos os clientes
    }

    @Test
    void testGetOneCliente() {
        UUID id = UUID.randomUUID();
        ClientesModel cliente = new ClientesModel();
        when(clientesRepository.findById(id)).thenReturn(Optional.of(cliente));

        ResponseEntity<Object> response = clientesController.getOneCliente(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    void testUpdateCliente() {
        UUID id = UUID.randomUUID();
        ClientesRDto clienteRDto = new ClientesRDto("João Silva", "joao.silva@example.com",
                Date.valueOf("2024-10-13"), "12345678901", 21987646721d, "Ativo", "blank");

        ClientesModel existingCliente = new ClientesModel();
        existingCliente.setIdCliente(id);
        when(clientesRepository.findById(id)).thenReturn(Optional.of(existingCliente));
        when(clientesRepository.save(any(ClientesModel.class))).thenReturn(existingCliente);

        ResponseEntity<Object> response = clientesController.updateCliente(id, clienteRDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testDeleteCliente() {
        UUID id = UUID.randomUUID();
        ClientesModel cliente = new ClientesModel();
        when(clientesRepository.findById(id)).thenReturn(Optional.of(cliente));

        ResponseEntity<Object> response = clientesController.deleteCliente(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(clientesRepository).delete(cliente);
    }
}
