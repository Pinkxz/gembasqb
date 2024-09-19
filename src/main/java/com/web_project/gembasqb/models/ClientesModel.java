package com.web_project.gembasqb.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Clientes")
public class ClientesModel extends RepresentationModel<ClientesModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;

     @Column(nullable = false, unique = false, length = 20)
    private String nomeCliente;

    @Column(nullable = false, unique = true, length = 25)
    private String emailCliente;

    @Column(nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(nullable = true, unique = true)
    private String cpfcnpj;

    @Column(nullable = true, unique = true, length = 20)
    private double whatsapp;

    @Column(nullable = false, unique = false, length = 20)
    private String statusCliente;

    @Column(length = 10000)
    private String foto;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel user;

    public ClientesModel() {
    }


    public ClientesModel(String nomeCliente, String emailCliente, Date dataCadastro, String cpfcnpj, double whatsapp,
            String statusCliente, String foto) {
        this.setNomeCliente(nomeCliente);
        this.setEmailCliente(emailCliente);
        this.setDataCadastro(dataCadastro);
        this.setCpfcnpj(cpfcnpj);
        this.setWhatsapp(whatsapp);
        this.setStatusCliente(statusCliente);
        this.setFoto(foto);
    }

     
    
    public UUID getIdCliente() {
        return idCliente;
    }


    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
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


    public Date getDataCadastro() {
        return dataCadastro;
    }


    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public String getCpfcnpj() {
        return cpfcnpj;
    }


    public void setCpfcnpj(String cpfcnpj) {
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
