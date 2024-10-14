package com.web_project.gembasqb.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


public record CollabRDto(
    @NotBlank(message = "O nome do colaborador não pode estar em branco.")
    String nomeCollab,

    @NotBlank(message = "O e-mail do colaborador não pode estar em branco.")
    @Email(message = "O e-mail deve ser válido.")
    String emailCollab,

    @NotNull(message = "A data de cadastro não pode ser nula.")
    Date dataCadastro,

    @Pattern(regexp = "^[0-9]{11}$|^[0-9]{14}$", message = "CPF deve ter 11 dígitos ou CNPJ deve ter 14 dígitos.")
    double cpfcnpj,

    @Positive(message = "O WhatsApp deve ser um número positivo.")
    double whatsapp,

    @NotBlank(message = "O status do colaborador não pode estar em branco.")
    String statusCollab,

    @NotBlank(message = "A data de pagamento não pode estar em branco.")
    String dataPagamento,

    String foto
) {
}
