package com.web_project.gembasqb.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CaixaRDto(
    @NotNull(message = "O saldo não pode ser nulo.")
    @Positive(message = "O saldo deve ser um valor positivo.")
    float saldo,

    @NotNull(message = "A data de abertura não pode ser nula.")
    Date dataAbertura,

    @NotNull(message = "A data de fechamento não pode ser nula.")
    Date dataFechado,

    @NotBlank(message = "O horário não pode estar em branco.")
    String horario,

    @Size(max = 50)

    String descricao
) {
}

