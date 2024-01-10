package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRDto(@NotBlank String emial, @NotBlank String password, @NotNull double numero, @NotBlank String nome) {
    
}
