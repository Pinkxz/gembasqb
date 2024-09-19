package com.web_project.gembasqb.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientesRDto(@NotBlank String nomeCliente, @NotBlank String emailCliente, @NotNull Date dataCadastro, String cpfcnpj, 
                double whatsapp, @NotBlank String statusCliente, String foto) {
    
} 
