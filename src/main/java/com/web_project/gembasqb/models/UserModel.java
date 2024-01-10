package com.web_project.gembasqb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class UserModel {

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String password;

    @Column(nullable = false, unique = true, length = 11)
    private double whatsapp;

    @Column(nullable = false, unique = true, length = 30)
    private String nome;
    
    public UserModel(String email, String password, double whatsapp, String nome) {
        
        this.setEmail(email);
        this.setPassword(password);
        this.setWhatsapp(whatsapp);
        this.setNome(nome);
    }

    public UserModel() { 
        
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

    public double getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(double whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "UserModel email = " + email + ", password = " + password + ", whatsapp = " + whatsapp + ", nome = " + nome;
    }

    
}
