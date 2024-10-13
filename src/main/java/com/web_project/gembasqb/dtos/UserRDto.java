package com.web_project.gembasqb.dtos;

import com.web_project.gembasqb.models.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRDto(

    @NotBlank(message = "O e-mail não pode estar em branco")
    @Email(message = "Formato de e-mail inválido")
    String login,  // Sem restrição do caractere '.'

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).*$", message = "A senha deve conter pelo menos 1 letra maiúscula e 1 número")
    @Pattern(regexp = "^[^\\.]+$", message = "A senha não pode conter o caractere '.'")
    String password,

    @NotNull(message = "O número não pode ser nulo")
    @Pattern(regexp = "^\\d{10,11}$", message = "O numero deve conter entre 10 a 11 digitos")
    @Pattern(regexp = "^[^\\.]+$", message = "O número não pode conter o caractere '.'")
    String numero,

    @NotBlank(message = "O nome não pode estar em branco")
    @Pattern(regexp = "^[^\\.]+$", message = "O nome não pode conter o caractere '.'")
    String nome,

    UserRole role
) {

}
