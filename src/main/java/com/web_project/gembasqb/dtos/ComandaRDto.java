package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ComandaRDto(@NotNull int id, @NotBlank String cliente, @NotBlank String servicos, @NotBlank String profissional, 
@NotBlank String total, @NotBlank String dataInicio) {
    
}
