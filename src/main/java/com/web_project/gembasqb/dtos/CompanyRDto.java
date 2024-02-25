package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyRDto(@NotBlank String compNome, @NotBlank String tipoNegocio, @NotNull double cep, @NotBlank String rua, @NotBlank String bairro, 
                @NotNull int numeroEnd, @NotBlank String cidade, @NotBlank String estado) {
                    
}
