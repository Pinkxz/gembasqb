package com.web_project.gembasqb.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CollabRDto(@NotBlank String nomeCollab, @NotNull String emailCollab, @NotNull Date dataCadastro, double cpfcnpj, 
             double whatsapp, @NotBlank String statusCollab, @NotBlank Date dataPagamento, String foto) {
    
}
