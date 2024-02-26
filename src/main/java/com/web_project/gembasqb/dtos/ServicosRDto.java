package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicosRDto(@NotBlank String nomeServico, String descricao, @NotNull float preco, String categoria, @NotNull float tempo, @NotBlank String status,
    String imagem, @NotNull int comissao, @NotBlank String fidelidade) {
    
}
