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
@Table(name = "Colaboradores")
public class CollabModel extends RepresentationModel<CollabModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCollabUuid;

    @Column(nullable = false, unique = false, length = 25)
    private String nomeCollab;

    @Column(nullable = false, unique = true, length = 25)
    private String emailCollab;

    @Column(nullable = true, unique = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(nullable = true, unique = true)
    private double cpfcnpj;

    @Column(nullable = true, unique = true, length = 20)
    private double whatsapp;

    @Column(nullable = false, unique = false, length = 20)
    private String statusCollab;

    @Column(nullable = false, unique = false)
    private String dataPagamento;

    @Column(length = 10000)
    private String foto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public CollabModel() {
    }

    public CollabModel(String nomeCollab, String emailCollab, Date dataCadastro, double cpfcnpj, double whatsapp,
            String statusCollab, String dataPagamento, String foto) {
        this.setNomeCollab(nomeCollab);
        this.setEmailCollab(emailCollab);
        this.setDataCadastro(dataCadastro);
        this.setCpfcnpj(cpfcnpj);
        this.setWhatsapp(whatsapp);
        this.setStatusCollab(statusCollab);
        this.setDataPagamento(dataPagamento);
        this.setFoto(foto);
    }

    public UUID getIdCollabUuid() {
        return idCollabUuid;
    }

    public void setIdCollabUuid(UUID idCollabUuid) {
        if (idCollabUuid == null) {
            throw new IllegalArgumentException("ID do colaborador não pode ser nulo.");
        }
        this.idCollabUuid = idCollabUuid;
    }

    public String getNomeCollab() {
        return nomeCollab;
    }

    public void setNomeCollab(String nomeCollab) {
        if (nomeCollab == null || nomeCollab.isEmpty()) {
            throw new IllegalArgumentException("O nome do colaborador não pode ser nulo ou vazio.");
        }
        if (nomeCollab.length() > 25) {
            throw new IllegalArgumentException("O nome do colaborador não pode exceder 25 caracteres.");
        }
        this.nomeCollab = nomeCollab;
    }

    public String getEmailCollab() {
        return emailCollab;
    }

    public void setEmailCollab(String emailCollab) {
        if (emailCollab == null || emailCollab.isEmpty()) {
            throw new IllegalArgumentException("O e-mail do colaborador não pode ser nulo ou vazio.");
        }
        if (emailCollab.length() > 25) {
            throw new IllegalArgumentException("O e-mail do colaborador não pode exceder 25 caracteres.");
        }
        this.emailCollab = emailCollab;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(double cpfcnpj) {
        if (cpfcnpj < 0) {
            throw new IllegalArgumentException("O CPF/CNPJ não pode ser negativo.");
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

    public String getStatusCollab() {
        return statusCollab;
    }

    public void setStatusCollab(String statusCollab) {
        if (statusCollab == null || statusCollab.isEmpty()) {
            throw new IllegalArgumentException("O status do colaborador não pode ser nulo ou vazio.");
        }
        if (statusCollab.length() > 20) {
            throw new IllegalArgumentException("O status do colaborador não pode exceder 20 caracteres.");
        }
        this.statusCollab = statusCollab;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        if (dataPagamento == null || dataPagamento.isEmpty()) {
            throw new IllegalArgumentException("A data de pagamento não pode ser nula ou vazia.");
        }
        this.dataPagamento = dataPagamento;
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
        return "CollabModel [nomeCollab=" + nomeCollab + ", emailCollab=" + emailCollab + ", dataCadastro="
                + dataCadastro + ", cpfcnpj=" + cpfcnpj + ", whatsapp=" + whatsapp + ", statusCollab=" + statusCollab
                + ", dataPagamento=" + dataPagamento + ", foto=" + foto + "]";
    }

}
