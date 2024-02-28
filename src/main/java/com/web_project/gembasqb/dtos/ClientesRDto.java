package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClientesRDto(@NotBlank String nomeCliente, @NotBlank String emailCliente, @NotBlank String dataCadastro, double cpfcnpj, 
                double whatsapp, @NotBlank String statusCliente, String foto) {
    
} 
