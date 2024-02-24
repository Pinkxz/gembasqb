package com.web_project.gembasqb.models;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comandas")
public class ComandaModel extends RepresentationModel<ComandaModel> implements Serializable {
    
    @Column(nullable = false, unique = true, length = 5)
    private int id;

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

    public ComandaModel(int id, String cliente, String servicos, String profissional, String status, String total) {
        this.setId(id);
        this.setCliente(cliente);
        this.setServicos(servicos);
        this.setProfissional(profissional);
        this.setStatus(status);
        this.setTotal(total);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ComandaModel [id=" + id + ", cliente=" + cliente + ", servicos=" + servicos + ", profissional="
                + profissional + ", status=" + status + ", total=" + total + "]";
    }
  
}
