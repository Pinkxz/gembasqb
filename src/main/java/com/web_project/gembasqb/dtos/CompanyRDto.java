package com.web_project.gembasqb.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CompanyRDto(
    
    @NotBlank(message = "O nome da empresa não pode estar em branco")
    String compNome,

    @NotBlank(message = "O tipo de negócio não pode estar em branco")
    String tipoNegocio,

    @NotBlank(message = "O CEP não pode estar em branco")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 12345-678")
    String cep,

    @NotBlank(message = "A rua não pode estar em branco")
    String rua,

    @NotBlank(message = "O estado não pode estar em branco")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 letras")
    String estado,

    @NotBlank(message = "A cidade não pode estar em branco")
    String cidade,

    @NotBlank(message = "O bairro não pode estar em branco")
    String bairro,

    @NotNull(message = "O número não pode estar vazio")
    @Min(value = 1, message = "O número deve ser pelo menos 1")
    @Max(value = 9999, message = "O número deve ser no máximo 9999")
    int numeroEnd,

    @NotBlank(message = "O tamanho da empresa não pode estar em branco")
    String tamanhoEmpresa,

    UUID userId // Adicionando o campo para a UUID do usuário
) {
    // Método que retorna o userId
    public UUID getUserId() {
        return userId;
    }
}

