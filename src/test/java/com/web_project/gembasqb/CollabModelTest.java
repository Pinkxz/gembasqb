package com.web_project.gembasqb;


import org.junit.jupiter.api.Test;

import com.web_project.gembasqb.models.CollabModel;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CollabModelTest {

    @Test
    void testSetNomeCollab() {
        CollabModel collab = new CollabModel();
        collab.setNomeCollab("Maria Silva");
        assertEquals("Maria Silva", collab.getNomeCollab());
    }

    @Test
    void testSetEmailCollab() {
        CollabModel collab = new CollabModel();
        collab.setEmailCollab("maria.silva@example.com");
        assertEquals("maria.silva@example.com", collab.getEmailCollab());
    }

    @Test
    void testSetDataCadastro() {
        CollabModel collab = new CollabModel();
        Date data = Date.valueOf("2024-10-13");
        collab.setDataCadastro(data);
        assertEquals(data, collab.getDataCadastro());
    }

    @Test
    void testSetCpfCnpj() {
        CollabModel collab = new CollabModel();
        collab.setCpfcnpj(12345678901d); // CPF
        assertEquals(12345678901d, collab.getCpfcnpj());

        collab.setCpfcnpj(12345678000195d); // CNPJ
        assertEquals(12345678000195d, collab.getCpfcnpj());
    }

    @Test
    void testSetWhatsapp() {
        CollabModel collab = new CollabModel();
        collab.setWhatsapp(21987654321d);
        assertEquals(21987654321d, collab.getWhatsapp());
    }

    @Test
    void testSetStatusCollab() {
        CollabModel collab = new CollabModel();
        collab.setStatusCollab("Ativo");
        assertEquals("Ativo", collab.getStatusCollab());
    }

    @Test
    void testSetDataPagamento() {
        CollabModel collab = new CollabModel();
        collab.setDataPagamento("2024-10-30");
        assertEquals("2024-10-30", collab.getDataPagamento());
    }

    @Test
    void testSetFoto() {
        CollabModel collab = new CollabModel();
        collab.setFoto("url_da_foto.jpg");
        assertEquals("url_da_foto.jpg", collab.getFoto());
    }

    @Test
    void testSetNomeCollabInvalid() {
        CollabModel collab = new CollabModel();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            collab.setNomeCollab("");
        });
        assertEquals("O nome do colaborador não pode ser nulo ou vazio.", exception.getMessage());
    }

    // Adicione outros testes de validação conforme necessário
}
