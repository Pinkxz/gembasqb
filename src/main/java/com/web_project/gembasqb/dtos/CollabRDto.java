package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CollabRDto(@NotBlank String nomeCollab, @NotNull String emailCollab, @NotBlank String dataCadastro, double cpfcnpj, 
             double whatsapp, @NotBlank String statusCollab, @NotBlank String dataPagamento, String foto) {
    
}
