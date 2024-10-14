package com.web_project.gembasqb;


import org.junit.jupiter.api.Test;

import com.web_project.gembasqb.dtos.CollabRDto;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollabRDtoTest {

    @Test
    void testCollabRDtoCreation() {
        CollabRDto dto = new CollabRDto("Maria Silva", "maria.silva@example.com", 
                Date.valueOf("2024-10-13"), 12345678901d, 21987654321d, 
                "Ativo", "2024-10-30", null);
        
        assertEquals("Maria Silva", dto.nomeCollab());
        assertEquals("maria.silva@example.com", dto.emailCollab());
        assertEquals(Date.valueOf("2024-10-13"), dto.dataCadastro());
        assertEquals(12345678901d, dto.cpfcnpj());
        assertEquals(21987654321d, dto.whatsapp());
        assertEquals("Ativo", dto.statusCollab());
        assertEquals("2024-10-30", dto.dataPagamento());
    }
}
