package com.web_project.gembasqb;

import org.junit.jupiter.api.Test;

import com.web_project.gembasqb.models.ClientesModel;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClientesModelTest {

    @Test
    void testSetNomeCliente() {
        ClientesModel cliente = new ClientesModel();
        cliente.setNomeCliente("João Silva");
        assertEquals("João Silva", cliente.getNomeCliente());
    }

    @Test
    void testSetEmailCliente() {
        ClientesModel cliente = new ClientesModel();
        cliente.setEmailCliente("joao.silva@example.com");
        assertEquals("joao.silva@example.com", cliente.getEmailCliente());
    }

    @Test
    void testSetWhatsapp() {
        ClientesModel cliente = new ClientesModel();
        double numero = 2198765411d;
        cliente.setWhatsapp(numero);
        assertEquals("21987654321", cliente.getWhatsapp());
    }

    @Test
    void testSetCpfCnpj() {
        ClientesModel cliente = new ClientesModel();
        cliente.setCpfcnpj("12345678901"); // CPF
        assertEquals("12345678901", cliente.getCpfcnpj());

        cliente.setCpfcnpj("12345678000195"); // CNPJ
        assertEquals("12345678000195", cliente.getCpfcnpj());
    }

    @Test
    void testSetDataCadastro() {
        ClientesModel cliente = new ClientesModel();
        Date data = Date.valueOf("2024-10-13");
        cliente.setDataCadastro(data);
        assertEquals(data, cliente.getDataCadastro());
    }

    @Test
    void testSetNomeClienteInvalid() {
        ClientesModel cliente = new ClientesModel();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cliente.setNomeCliente("");
        });
        assertEquals("O nome do cliente não pode ser nulo ou vazio.", exception.getMessage());
    }
}
