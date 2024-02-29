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
@Table(name = "Produtos")
public class ProdutosModel extends RepresentationModel<ProdutosModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto;

    @Column(nullable = false, unique = false, length = 25)
    private String nomeProduto;

    @Column(nullable = true, unique = false, length = 100)
    private String  descricaoProduto;

    @Column(nullable = false, unique = false, length = 7)
    private float precoProduto;

    @Column(nullable = false, unique = false, length = 5)
    private float pesoProduto;

    @Column(nullable = true, unique = false, length = 25)
    private String categoriaProduto;

    @Column(nullable = false, unique = false, length = 10)
    private String statusProduto;

    @Column(length = 10000)
    private String fotoProduto;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public ProdutosModel() {
    }


    public ProdutosModel(String nomeProduto, String descricaoProduto, float precoProduto, float pesoProduto,
            String categoriaProduto, String statusProduto, String fotoProduto) {
        this.setNomeProduto(nomeProduto);
        this.setDescricaoProduto(descricaoProduto);
        this.setPrecoProduto(precoProduto);
        this.setPesoProduto(pesoProduto);
        this.setCategoriaProduto(categoriaProduto);
        this.setStatusProduto(statusProduto);
        this.setFotoProduto(fotoProduto);
    }


    public UUID getIdProduto() {
        return idProduto;
    }


    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }  

    public String getNomeProduto() {
        return nomeProduto;
    }


    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    public String getDescricaoProduto() {
        return descricaoProduto;
    }


    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }


    public float getPrecoProduto() {
        return precoProduto;
    }


    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }


    public float getPesoProduto() {
        return pesoProduto;
    }


    public void setPesoProduto(float pesoProduto) {
        this.pesoProduto = pesoProduto;
    }


    public String getCategoriaProduto() {
        return categoriaProduto;
    }


    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }


    public String getStatusProduto() {
        return statusProduto;
    }


    public void setStatusProduto(String statusProduto) {
        this.statusProduto = statusProduto;
    }


    public String getFotoProduto() {
        return fotoProduto;
    }


    public void setFotoProduto(String fotoProduto) {    
        this.fotoProduto = fotoProduto;
    }


    @Override
    public String toString() {
        return "ProdutosModel [nomeProduto=" + nomeProduto + ", descricaoProduto=" + descricaoProduto
                + ", precoProduto=" + precoProduto + ", pesoProduto=" + pesoProduto + ", categoriaProduto="
                + categoriaProduto + ", statusProduto=" + statusProduto + ", fotoProduto=" + fotoProduto + "]";
    }

    
}
