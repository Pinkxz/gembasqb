package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CaixaRDto(@NotNull float saldo, @NotBlank String dataAbertura, String dataFechado, @NotNull float horario) {
    
}
