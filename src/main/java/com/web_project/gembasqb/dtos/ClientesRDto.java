package com.web_project.gembasqb.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


public record ClientesRDto(
    @NotBlank(message = "O nome do cliente não pode estar em branco.")
    String nomeCliente,

    @NotBlank(message = "O e-mail do cliente não pode estar em branco.")
    @Email(message = "O e-mail deve ser válido.")
    String emailCliente,

    @NotNull(message = "A data de cadastro não pode ser nula.")
    Date dataCadastro,

    @Pattern(regexp = "^[0-9]{11}$|^[0-9]{14}$", message = "CPF deve ter 11 dígitos ou CNPJ deve ter 14 dígitos.")
    String cpfcnpj,

    @Positive(message = "O WhatsApp deve ser um número positivo.")
    double whatsapp,

    @NotBlank(message = "O status do cliente não pode estar em branco.")
    String statusCliente,

    String foto
) {
}
