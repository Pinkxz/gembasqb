package com.web_project.gembasqb.models;

import java.io.Serializable;

import org.hibernate.validator.constraints.EAN;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Produtos")
public class ProdutosModel extends RepresentationModel<ProdutosModel> implements Serializable {
    
    @Column(nullable = false, unique = true, length = 25)
    private String nomeProduto;

    @Column(nullable = false, unique = true, length = 50)
    private String  descricaoProduto;

    @Column(nullable = false, unique = true, length = 5)
    private int precoProduto;

    @Column(nullable = false, unique = true, length = 4)
    private int pesoProduto;

    @Column(nullable = false, unique = true, length = 20)
    private String categoriaProduto;

    @Column(nullable = false, unique = true, length = 10)
    private String statusProduto;

    private String fotoProduto;

    
    public ProdutosModel() {
    }


    public ProdutosModel(String nomeProduto, String descricaoProduto, int precoProduto, int pesoProduto,
            String categoriaProduto, String statusProduto, String fotoProduto) {
        this.setNomeProduto(nomeProduto);
        this.setDescricaoProduto(descricaoProduto);
        this.setPrecoProduto(precoProduto);
        this.setPesoProduto(pesoProduto);
        this.setCategoriaProduto(categoriaProduto);
        this.setStatusProduto(statusProduto);
        this.setFotoProduto(fotoProduto);
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


    public int getPrecoProduto() {
        return precoProduto;
    }


    public void setPrecoProduto(int precoProduto) {
        this.precoProduto = precoProduto;
    }


    public int getPesoProduto() {
        return pesoProduto;
    }


    public void setPesoProduto(int pesoProduto) {
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
