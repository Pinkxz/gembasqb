package com.web_project.gembasqb.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class UserModel extends RepresentationModel<UserModel> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = true, length = 11)
    private double numero;

    @Column(nullable = false, unique = false, length = 30)
    private String nome;

    @OneToOne(mappedBy = "user")
    private CompanyModel company;

    @OneToMany(mappedBy = "user")
    private List<ServicosModel> servicos;

    @OneToMany(mappedBy = "user")
    private List<ProdutosModel> produtos;

    @OneToMany(mappedBy = "user")
    private List<ClientesModel> clientes;

    @OneToMany(mappedBy = "user")
    private List<CollabModel> colaboradores;

    @OneToMany(mappedBy = "user")
    private List<ComandaModel> comandas;
    
    public UserModel(String email, String password, double numero, String nome) {
        
        this.setEmail(email);
        this.setPassword(password);
        this.setNumero(numero);
        this.setNome(nome);
    }

    public UserModel() { 
        
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "UserModel email = " + email + ", password = " + password + ", whatsapp = " + numero + ", nome = " + nome;
    }

 
    
}
