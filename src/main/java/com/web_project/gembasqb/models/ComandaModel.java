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
@Table(name = "Comandas")
public class ComandaModel extends RepresentationModel<ComandaModel> implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idComanda;

    @Column(nullable = false, unique = true, length = 20)
    private String cliente;

    @Column(nullable = false, unique = true, length = 40)
    private String servicos;
    
    @Column(nullable = false, unique = true, length = 20)
    private String profissional;

    @Column(nullable = false, unique = true, length = 20)
    private String status;

    @Column(nullable = false, unique = true, length = 20)
    private String total;

    @Column(nullable = false, unique = false, length = 20)
    private String dataInicio;


    
    public ComandaModel() {
    }


    public ComandaModel(String cliente, String servicos, String profissional, String status, String total) {
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
        this.cliente = cliente;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
  


    @Override
    public String toString() {
        return "ComandaModel " + ", cliente=" + cliente + ", servicos=" + servicos + ", profissional="
                + profissional + ", status=" + status + ", total=" + total + "dataInicio" + dataInicio;
    }


 

}

