package com.web_project.gembasqb.models;

import java.io.Serializable;
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

@Entity
@Table(name = "Servicos")
public class ServicosModel  extends RepresentationModel<ServicosModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idServico;

    @Column(nullable = false, unique = false, length = 20)
    private String nomeServico;

    @Column(nullable = false, unique = false, length = 20)
    private String descricao;

    @Column(nullable = false, unique = false, length = 20)
    private String categoria;

    @Column(nullable = false, unique = false, length = 7)
    private float preco;

    @Column(nullable = false, unique = false, length = 4)
    private float tempo;

    @Column(nullable = false, unique = false, length = 20)
    private String status;

    @Column(nullable = false, unique = true, length = 20)
    private String imagem;

    @Column(nullable = false, unique = false, length = 4)
    private int comissao;

    @Column(nullable = true, unique = false, length = 20)
    private String fidelidade;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    public ServicosModel() {
    }

    public ServicosModel(String nomeServico, String categoria, float preco, float tempo, String status) {
        this.setNomeServico(nomeServico);
        this.setCategoria(categoria);
        this.setPreco(preco);
        this.setTempo(tempo);
        this.setStatus(status);
    }

    public ServicosModel(String nomeServico, String descricao, String categoria, float preco, float tempo, String status,
            String imagem, int comissao, String fidelidade) {
        this.setNomeServico(nomeServico);
        this.setCategoria(categoria);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setTempo(tempo);
        this.setStatus(status);
        this.setImagem(imagem);
        this.setComissao(comissao);
        this.setFidelidade(fidelidade);
    }

    public UUID getIdServico() {
        return idServico;
    }

    public void setIdServico(UUID idServico) {
        this.idServico = idServico;
    }


    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getComissao() {
        return comissao;
    }

    public void setComissao(int comissao) {
        this.comissao = comissao;
    }

    public String getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(String fidelidade) {
        this.fidelidade = fidelidade;
    }

    @Override
    public String toString() {
        return "ServicosModel [nomeServico=" + nomeServico + ", Categoria=" + categoria + ", preco=" + preco
                + ", tempo=" + tempo + ", status=" + status + "]";
    }

    
}
