package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientesRDto(@NotBlank String nomeCliente, @NotNull String emailCliente, @NotBlank String dataCadastro, double cpfcnpj, 
                @NotBlank int whatsapp, @NotBlank String statusCliente, String foto) {
    
} 
