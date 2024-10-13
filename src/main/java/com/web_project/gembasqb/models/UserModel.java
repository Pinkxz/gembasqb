package com.web_project.gembasqb.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class UserModel extends RepresentationModel<UserModel> implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;

    @Column(nullable = false, unique = true, length = 30)
    private String login;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = true, length = 11)
    private double numero;

    @Column(nullable = false, unique = false, length = 30)
    private String nome;

    @Column(nullable = false, unique = true, length = 5)
    private UserRole role;

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
    
    public UserModel(String login, String password, double numero, String nome, UserRole role) {
        
        this.setLogin(login);
        this.setPassword(password);
        this.setNumero(numero);
        this.setNome(nome);
        this.setRole(role);
    }

    public UserModel() { 
        
    }



    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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


    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserModel login = " + login + ", password = " + password + ", whatsapp = " + numero + ", nome = " + nome;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }

 
    
}
