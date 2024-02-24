package com.web_project.gembasqb.models;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Clientes")
public class ClientesModel extends RepresentationModel<ClientesModel> implements Serializable {
    
     @Column(nullable = false, unique = true, length = 20)
    private String nomeCliente;

    @Column(nullable = false, unique = true, length = 25)
    private String emailCliente;

    @Column(nullable = false, unique = true, length = 20)
    private String dataCadastro;

    @Column(nullable = true, unique = true)
    private double cpfcnpj;

    @Column(nullable = true, unique = true, length = 20)
    private double whatsapp;

    @Column(nullable = false, unique = true, length = 20)
    private String statusCliente;


    private String foto;


    public ClientesModel() {
    }


    public ClientesModel(String nomeCliente, String emailCliente, String dataCadastro, double cpfcnpj, double whatsapp,
            String statusCliente, String foto) {
        this.setNomeCliente(nomeCliente);
        this.setEmailCliente(emailCliente);
        this.setDataCadastro(dataCadastro);
        this.setCpfcnpj(cpfcnpj);
        this.setWhatsapp(whatsapp);
        this.setStatusCliente(statusCliente);
        this.setFoto(foto);
    }


    public String getNomeCliente() {
        return nomeCliente;
    }


    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }


    public String getEmailCliente() {
        return emailCliente;
    }


    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
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


    public String getStatusCliente() {
        return statusCliente;
    }


    public void setStatusCliente(String statusCliente) {
        this.statusCliente = statusCliente;
    }


    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
    }


    @Override
    public String toString() {
        return "ClientesModel [nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente + ", dataCadastro="
                + dataCadastro + ", cpfcnpj=" + cpfcnpj + ", whatsapp=" + whatsapp + ", statusCliente=" + statusCliente
                + ", foto=" + foto + "]";
    }

    

}
