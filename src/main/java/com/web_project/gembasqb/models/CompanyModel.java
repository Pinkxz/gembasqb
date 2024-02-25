package com.web_project.gembasqb.models;

import java.io.Serializable;
import java.util.UUID;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Companys")
public class CompanyModel extends RepresentationModel<CompanyModel> implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String compNome;

    @Column(nullable = false, unique = false, length = 30)
    private String tipoNegocio;

    @Column(nullable = true, unique = false, length = 8 )
    private double cep;

    @Column(nullable = false, unique = false, length = 20)
    private String rua;

    @Column(nullable = false, unique = false, length = 25)
    private String bairro;

    @Column(nullable = false, unique = false, length = 4)
    private int numeroEnd;

    @Column(nullable = false, unique = false, length = 20)
    private String cidade;

    @Column(nullable = false, unique = false, length = 10)
    private String estado;

    
    public CompanyModel() {
    }

    public CompanyModel(UUID id, String compNome, String tipoNegocio, double cep, String rua, String bairro,
            int numeroEnd, String cidade, String estado) {
        this.setId(id);
        this.setCompNome(compNome);
        this.setTipoNegocio(tipoNegocio);
        this.setCep(cep);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setNumeroEnd(numeroEnd);
        this.setCidade(cidade);
        this.setEstado(estado);
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
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

    public int getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(int numeroEnd) {
        this.numeroEnd = numeroEnd;
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
        return "CompanyModel [id=" + id + ", compNome=" + compNome + ", tipoNegocio=" + tipoNegocio + ", cep=" + cep
                + ", rua=" + rua + ", bairro=" + bairro + ", numeroEnd=" + numeroEnd + ", cidade=" + cidade
                + ", estado=" + estado + "]";
    }

}
    
