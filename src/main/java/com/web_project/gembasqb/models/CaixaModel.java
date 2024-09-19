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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Caixa")
public class CaixaModel extends RepresentationModel<CaixaModel> implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID caixaId;

    @Column(nullable = false, unique = false, length = 15)
    private float saldo;

    @Column(nullable = false, unique = false)
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

    @Column(nullable = true, unique = false) 
    @Temporal(TemporalType.DATE)
    private Date dataFechado;

    @Column(nullable = true, unique = false, length = 10)
    private String horario;

    @Column(nullable = true, unique = false, length = 50)
    private String descricao;

    public CaixaModel() {
    }

    public CaixaModel(UUID caixaId, float saldo, Date dataAbertura, Date dataFechado, String horario, String descricao) {
        this.setCaixaId(caixaId);
        this.setSaldo(saldo);
        this.setDataAbertura(dataAbertura);
        this.setDataFechado(dataFechado);
        this.setHorario(horario);
        this.setDescricao(descricao);
    }

    public UUID getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(UUID caixaId) {
        this.caixaId = caixaId;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechado() {
        return dataFechado;
    }

    public void setDataFechado(Date dataFechado) {
        this.dataFechado = dataFechado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "CaixaModel [caixaId=" + caixaId + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura
                + ", dataFechado=" + dataFechado + ", horario=" + horario + "descricao=" + descricao;
    }
    
}
