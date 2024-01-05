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

    public String getCompNome() {
        return compNome;
    }

    public void setCompNome(String compNome) {
        this.compNome = compNome;
    }

    public double getCep() {
        return cep;
    }

    public void setCep(double cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
