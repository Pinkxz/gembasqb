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
import jakarta.validation.constraints.Email;

import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "Servicos")
public class ServicosModel  extends RepresentationModel<ServicosModel> implements Serializable {
    

    @Column(nullable = false, unique = true, length = 20)
    private String nomeServico;

    @Column(nullable = false, unique = true, length = 20)
    private String categoria;

    @Column(nullable = false, unique = false, length = 7)
    private int preco;

    @Column(nullable = false, unique = false, length = 4)
    private float tempo;

    @Column(nullable = false, unique = true, length = 20)
    private String status;

    public ServicosModel(String nomeServico, String categoria, int preco, float tempo, String status) {
        this.setNomeServico(nomeServico);
        this.setCategoria(categoria);
        this.setPreco(preco);
        this.setTempo(tempo);
        this.setStatus(status);
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServicosModel [nomeServico=" + nomeServico + ", Categoria=" + categoria + ", preco=" + preco
                + ", tempo=" + tempo + ", status=" + status + "]";
    }

    
}
