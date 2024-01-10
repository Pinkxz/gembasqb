package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyRDto(@NotBlank String nome, @NotNull double cep, @NotBlank String rua, @NotBlank String bairro, 
                @NotBlank int numero, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String estado) {
                    
}
