package com.web_project.gembasqb.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CollabModel  extends RepresentationModel<CollabModel> implements Serializable {
    
        
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCollabUuid;

     @Column(nullable = false, unique = true, length = 20)
    private String nomeCollab;

    @Column(nullable = false, unique = true, length = 25)
    private String emailCollab;

    @Column(nullable = true, unique = true, length = 20)
    private String dataCadastro;

    @Column(nullable = true, unique = true)
    private double cpfcnpj;

    @Column(nullable = true, unique = true, length = 20)
    private double whatsapp;

    @Column(nullable = false, unique = true, length = 20)
    private String statusCollab;

    @Column(nullable = false, unique = false)
    private String dataPagamento;

    private String foto;


    public CollabModel() {
    }


    public CollabModel(String nomeCollab, String emailCollab, String dataCadastro, double cpfcnpj, double whatsapp,
            String statusCollab, String dataPagamento, String foto) {
        this.nomeCollab = nomeCollab;
        this.emailCollab = emailCollab;
        this.dataCadastro = dataCadastro;
        this.cpfcnpj = cpfcnpj;
        this.whatsapp = whatsapp;
        this.statusCollab = statusCollab;
        this.dataPagamento = dataPagamento;
        this.foto = foto;
    }


    public String getNomeCollab() {
        return nomeCollab;
    }


    public void setNomeCollab(String nomeCollab) {
        this.nomeCollab = nomeCollab;
    }


    public String getEmailCollab() {
        return emailCollab;
    }


    public void setEmailCollab(String emailCollab) {
        this.emailCollab = emailCollab;
    }


    public String getDataCadastro() {
        return dataCadastro;
    }


    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public double getCpfcnpj() {
        return cpfcnpj;
    }


    public void setCpfcnpj(double cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }


    public double getWhatsapp() {
        return whatsapp;
    }


    public void setWhatsapp(double whatsapp) {
        this.whatsapp = whatsapp;
    }


    public String getStatusCollab() {
        return statusCollab;
    }


    public void setStatusCollab(String statusCollab) {
        this.statusCollab = statusCollab;
    }


    public String getDataPagamento() {
        return dataPagamento;
    }


    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
    }


    @Override
    public String toString() {
        return "CollabModel [nomeCollab=" + nomeCollab + ", emailCollab=" + emailCollab + ", dataCadastro="
                + dataCadastro + ", cpfcnpj=" + cpfcnpj + ", whatsapp=" + whatsapp + ", statusCollab=" + statusCollab
                + ", dataPagamento=" + dataPagamento + ", foto=" + foto + "]";
    }

    
}