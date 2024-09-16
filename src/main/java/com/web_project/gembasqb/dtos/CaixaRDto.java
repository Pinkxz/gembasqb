package com.web_project.gembasqb.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CaixaRDto(@NotNull float saldo, @NotBlank String dataAbertura, Date dataFechado, @NotBlank String horario, String descricao) {
    
}
