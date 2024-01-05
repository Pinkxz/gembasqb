package com.web_project.gembasqb.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CompanyDto {

    @NotBlank
    @Size(max = 30)
    private String compNome;

    @Column(nullable = true, unique = false, length = 8 )
    @Size(max = 8)
    private double cep;

    @NotBlank
    @Size(max = 20)
    private String rua;

    @NotBlank
    @Size(max = 25)
    private String bairro;

    @NotBlank
    @Size(max = 4)
    private int numero;

    @NotBlank
    @Size(max = 30)
    private String complemento;

    @NotBlank
    @Size(max = 20)
    private String cidade;

    @NotBlank
    @Size(max = 2)
    private String estado;
}
