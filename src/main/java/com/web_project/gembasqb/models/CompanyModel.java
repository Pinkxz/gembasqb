package com.web_project.gembasqb.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Company_Instances")
public class CompanyModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String compNome;

    @Column(nullable = true, unique = false, length = 8 )
    private double cep;

    @Column(nullable = false, unique = false, length = 20)
    private String rua;

    @Column(nullable = false, unique = false, length = 25)
    private String bairro;

    @Column(nullable = false, unique = false, length = 4)
    private int numero;

    @Column(nullable = false, unique = false, length = 30)
    private String complemento;

    @Column(nullable = false, unique = false, length = 20)
    private String cidade;

    @Column(nullable = false, unique = false, length = 2)
    private String estado;
    
       public CompanyModel(UUID id, String compNome, String rua, String bairro, int numero, String complemento,
            String cidade, String estado) {
        this.setId(id);
        this.setCompNome(compNome);
        this.cep = 0;
        this.setRua(rua);
        this.setBairro(bairro);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setCidade(cidade);
        this.setEstado(estado);
    }

    public CompanyModel(UUID id, String compNome, double cep, String rua, String bairro, int numero, String complemento,
            String cidade, String estado) {
        this.setId(id);
        this.setCompNome(compNome);
        this.setCep(cep);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setCidade(cidade);
        this.setEstado(estado);
    }

    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "CompanyModel compNome = " + compNome + ", cep = " + cep + ", rua = " + rua + ", bairro = " + bairro
                + ", numero = " + numero + ", complemento = " + complemento + ", cidade = " + cidade + ", estado = " + estado;
    }

}
