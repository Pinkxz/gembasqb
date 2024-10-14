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
@Table(name = "Comandas")
public class ComandaModel extends RepresentationModel<ComandaModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = false, length = 30)
    private String cliente;

    @Column(nullable = false, unique = false, length = 100)
    private String servicos;

    @Column(nullable = false, unique = false, length = 30)
    private String profissional;

    @Column(nullable = false, unique = false, length = 20)
    private String status;

    @Column(nullable = true, unique = false, length = 20)
    private float total;

    @Column(nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idComanda;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public ComandaModel() {
    }

    public ComandaModel(String cliente, String servicos, String profissional, String status, float total, Date dataInicio) {
        this.setCliente(cliente);
        this.setServicos(servicos);
        this.setProfissional(profissional);
        this.setStatus(status);
        this.setTotal(total);
        this.setDataInicio(dataInicio);
    }

    public UUID getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(UUID idComanda) {
        this.idComanda = idComanda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if (cliente == null || cliente.isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio.");
        }
        if (cliente.length() > 30) {
            throw new IllegalArgumentException("O nome do cliente não pode exceder 30 caracteres.");
        }
        this.cliente = cliente;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        if (servicos == null || servicos.isEmpty()) {
            throw new IllegalArgumentException("Os serviços não podem ser nulos ou vazios.");
        }
        if (servicos.length() > 100) {
            throw new IllegalArgumentException("A descrição dos serviços não pode exceder 100 caracteres.");
        }
        this.servicos = servicos;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        if (profissional == null || profissional.isEmpty()) {
            throw new IllegalArgumentException("O nome do profissional não pode ser nulo ou vazio.");
        }
        if (profissional.length() > 30) {
            throw new IllegalArgumentException("O nome do profissional não pode exceder 30 caracteres.");
        }
        this.profissional = profissional;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("O status da comanda não pode ser nulo ou vazio.");
        }
        if (status.length() > 20) {
            throw new IllegalArgumentException("O status da comanda não pode exceder 20 caracteres.");
        }
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        if (total < 0) {
            throw new IllegalArgumentException("O valor total não pode ser negativo.");
        }
        this.total = total;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        if (dataInicio == null) {
            throw new IllegalArgumentException("A data de início não pode ser nula.");
        }
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "ComandaModel [cliente=" + cliente + ", servicos=" + servicos + ", profissional=" + profissional
                + ", status=" + status + ", total=" + total + ", dataInicio=" + dataInicio + "]";
    }

}
