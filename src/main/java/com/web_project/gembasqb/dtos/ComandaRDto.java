package com.web_project.gembasqb.dtos;


import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ComandaRDto(@NotBlank String cliente, @NotBlank String servicos, @NotBlank String profissional, @NotBlank String status,
float total, @NotNull Date dataInicio) {
    
}
