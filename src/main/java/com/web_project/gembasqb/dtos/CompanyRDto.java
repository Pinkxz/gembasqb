package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyRDto(@NotBlank String compNome, @NotBlank String tipoNegocio, @NotBlank String cep, @NotBlank String rua, @NotBlank String estado, 
                @NotBlank String cidade, @NotBlank String bairro, @NotNull int numeroEnd, String tamanhoEmpresa) {
                    
}
