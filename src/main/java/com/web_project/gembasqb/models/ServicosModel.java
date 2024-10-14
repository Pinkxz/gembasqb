package com.web_project.gembasqb.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.web_project.gembasqb.exceptions.InvalidDataException; // Exceção personalizada

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
public class ServicosModel extends RepresentationModel<ServicosModel> implements Serializable {
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
        if (nomeServico == null || nomeServico.length() > 20) {
            throw new InvalidDataException("Nome do serviço não pode ser nulo e deve ter no máximo 20 caracteres.");
        }
        this.nomeServico = nomeServico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.length() > 20) {
            throw new InvalidDataException("Categoria não pode ser nula e deve ter no máximo 20 caracteres.");
        }
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco <= 0) {
            throw new InvalidDataException("Preço deve ser maior que 0.");
        }
        this.preco = preco;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        if (tempo <= 0) {
            throw new InvalidDataException("Tempo deve ser maior que 0.");
        }
        this.tempo = tempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.length() > 20) {
            throw new InvalidDataException("Status não pode ser nulo e deve ter no máximo 20 caracteres.");
        }
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.length() > 20) {
            throw new InvalidDataException("Descrição não pode ser nula e deve ter no máximo 20 caracteres.");
        }
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        if (imagem == null || imagem.length() > 20) {
            throw new InvalidDataException("Imagem não pode ser nula e deve ter no máximo 20 caracteres.");
        }
        this.imagem = imagem;
    }

    public int getComissao() {
        return comissao;
    }

    public void setComissao(int comissao) {
        if (comissao < 0 || comissao > 100) {
            throw new InvalidDataException("Comissão deve estar entre 0 e 100.");
        }
        this.comissao = comissao;
    }

    public String getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(String fidelidade) {
        if (fidelidade != null && fidelidade.length() > 20) {
            throw new InvalidDataException("Fidelidade deve ter no máximo 20 caracteres.");
        }
        this.fidelidade = fidelidade;
    }

    @Override
    public String toString() {
        return "ServicosModel [nomeServico=" + nomeServico + ", Categoria=" + categoria + ", preco=" + preco
                + ", tempo=" + tempo + ", status=" + status + "]";
    }

}
