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
@Table(name = "Caixa")
public class CaixaModel extends RepresentationModel<CaixaModel> implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID caixaId;

    @Column(nullable = false, unique = false, length = 15)
    private float saldo;

    @Column(nullable = false, unique = false, length = 12)
    private String dataAbertura;

    @Column(nullable = true, unique = false, length = 12)
    private String dataFechado;

    @Column(nullable = true, unique = false, length = 10)
    private float horario;

    public CaixaModel() {
    }

    public CaixaModel(UUID caixaId, float saldo, String dataAbertura, String dataFechado, float horario) {
        this.setCaixaId(caixaId);
        this.setSaldo(saldo);
        this.setDataAbertura(dataAbertura);
        this.setDataFechado(dataFechado);
        this.setHorario(horario);
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

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechado() {
        return dataFechado;
    }

    public void setDataFechado(String dataFechado) {
        this.dataFechado = dataFechado;
    }

    public float getHorario() {
        return horario;
    }

    public void setHorario(float horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "CaixaModel [caixaId=" + caixaId + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura
                + ", dataFechado=" + dataFechado + ", horario=" + horario + "]";
    }

    
}
