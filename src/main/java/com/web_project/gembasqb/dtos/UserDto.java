package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotBlank
    @Size(max = 30)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String password;

    @NotBlank
    @Size(max = 11)
    private double whatsapp;

    @NotBlank
    @Size(max = 30)
    private String nome;
}
