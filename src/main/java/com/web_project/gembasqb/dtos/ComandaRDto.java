package com.web_project.gembasqb.dtos;


import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ComandaRDto(
    @NotBlank(message = "O cliente não pode estar em branco.")
    String cliente,

    @NotBlank(message = "Os serviços não podem estar em branco.")
    String servicos,

    @NotBlank(message = "O profissional não pode estar em branco.")
    String profissional,

    @NotBlank(message = "O status não pode estar em branco.")
    String status,

    // Aqui não é necessário usar @NotNull, já que o total é opcional na entidade.
    float total, 

    @NotNull(message = "A data de início não pode ser nula.")
    Date dataInicio
) {
}
