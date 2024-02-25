package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;

public record ComandaRDto(@NotBlank String cliente, @NotBlank String servicos, @NotBlank String profissional, 
@NotBlank String total, @NotBlank String dataInicio) {
    
}
