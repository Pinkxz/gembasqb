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

    @Column(nullable = true, unique = true, length = 14)
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
        if (idCliente == null) {
            throw new IllegalArgumentException("ID do cliente não pode ser nulo.");
        }
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio.");
        }
        if (nomeCliente.length() > 20) {
            throw new IllegalArgumentException("O nome do cliente não pode exceder 20 caracteres.");
        }
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        if (emailCliente == null || emailCliente.isEmpty()) {
            throw new IllegalArgumentException("O e-mail do cliente não pode ser nulo ou vazio.");
        }
        if (emailCliente.length() > 25) {
            throw new IllegalArgumentException("O e-mail do cliente não pode exceder 25 caracteres.");
        }
        this.emailCliente = emailCliente;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        if (dataCadastro == null) {
            throw new IllegalArgumentException("A data de cadastro não pode ser nula.");
        }
        this.dataCadastro = dataCadastro;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        if (cpfcnpj != null && cpfcnpj.length() > 14) {
            throw new IllegalArgumentException("O CPF/CNPJ não pode exceder 14 caracteres.");
        }
        this.cpfcnpj = cpfcnpj;
    }

    public double getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(double whatsapp) {
        if (whatsapp < 0) {
            throw new IllegalArgumentException("O número de WhatsApp não pode ser negativo.");
        }
        this.whatsapp = whatsapp;
    }

    public String getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(String statusCliente) {
        if (statusCliente == null || statusCliente.isEmpty()) {
            throw new IllegalArgumentException("O status do cliente não pode ser nulo ou vazio.");
        }
        if (statusCliente.length() > 20) {
            throw new IllegalArgumentException("O status do cliente não pode exceder 20 caracteres.");
        }
        this.statusCliente = statusCliente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        if (foto != null && foto.length() > 10000) {
            throw new IllegalArgumentException("A foto não pode exceder 10000 caracteres.");
        }
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "ClientesModel [nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente + ", dataCadastro="
                + dataCadastro + ", cpfcnpj=" + cpfcnpj + ", whatsapp=" + whatsapp + ", statusCliente=" + statusCliente
                + ", foto=" + foto + "]";
    }

}
