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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.web_project.gembasqb.exceptions.InvalidDataException; // Exceção personalizada para dados inválidos

@Entity
@Table(name = "Companies") // Corrigido o nome da tabela para o plural correto
public class CompanyModel extends RepresentationModel<CompanyModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String compNome;

    @Column(nullable = false, unique = false, length = 30)
    private String tipoNegocio;

    @Column(nullable = true, unique = false, length = 13)
    private String cep;

    @Column(nullable = false, unique = false, length = 20)
    private String rua;

    @Column(nullable = false, unique = false, length = 25)
    private String bairro;

    @Column(nullable = false, unique = false)
    private int numeroEnd;

    @Column(nullable = false, unique = false, length = 20)
    private String cidade;

    @Column(nullable = false, unique = false, length = 14)
    private String estado;

    @Column(nullable = true, unique = false, length = 20)
    private String tamanhoEmpresa;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToMany(mappedBy = "company")
    private List<ServicosModel> servicos;

    @OneToMany(mappedBy = "company")
    private List<ProdutosModel> produtos;

    public CompanyModel() {
    }

    public CompanyModel(UUID id, String compNome, String tipoNegocio, String cep, String rua, String bairro,
            int numeroEnd, String cidade, String estado, String tamanhoEmpresa) {
        this.setId(id);
        this.setCompNome(compNome);
        this.setTipoNegocio(tipoNegocio);
        this.setCep(cep);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setNumeroEnd(numeroEnd);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setTamanhoEmpresa(tamanhoEmpresa);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCompNome() {
        return compNome;
    }

    public void setCompNome(String compNome) {
        if (compNome == null || compNome.length() > 30) {
            throw new InvalidDataException("Nome da empresa não pode ser nulo e deve ter no máximo 30 caracteres.");
        }
        this.compNome = compNome;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        if (tipoNegocio == null || tipoNegocio.length() > 30) {
            throw new InvalidDataException("Tipo de negócio não pode ser nulo e deve ter no máximo 30 caracteres.");
        }
        this.tipoNegocio = tipoNegocio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep != null && cep.length() > 13) {
            throw new InvalidDataException("CEP deve ter no máximo 13 caracteres.");
        }
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua == null || rua.length() > 20) {
            throw new InvalidDataException("Rua não pode ser nula e deve ter no máximo 20 caracteres.");
        }
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro == null || bairro.length() > 25) {
            throw new InvalidDataException("Bairro não pode ser nulo e deve ter no máximo 25 caracteres.");
        }
        this.bairro = bairro;
    }

    public int getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(int numeroEnd) {
        if (numeroEnd <= 0) {
            throw new InvalidDataException("Número do endereço deve ser maior que 0.");
        }
        this.numeroEnd = numeroEnd;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if (cidade == null || cidade.length() > 20) {
            throw new InvalidDataException("Cidade não pode ser nula e deve ter no máximo 20 caracteres.");
        }
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.length() > 14) {
            throw new InvalidDataException("Estado não pode ser nulo e deve ter no máximo 14 caracteres.");
        }
        this.estado = estado;
    }

    public String getTamanhoEmpresa() {
        return tamanhoEmpresa;
    }

    public void setTamanhoEmpresa(String tamanhoEmpresa) {
        if (tamanhoEmpresa != null && tamanhoEmpresa.length() > 20) {
            throw new InvalidDataException("Tamanho da empresa deve ter no máximo 20 caracteres.");
        }
        this.tamanhoEmpresa = tamanhoEmpresa;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        if (user == null) {
            throw new InvalidDataException("Usuário não pode ser nulo.");
        }
        this.user = user;
    }

    @Override
    public String toString() {
        return "CompanyModel [id=" + id + ", compNome=" + compNome + ", tipoNegocio=" + tipoNegocio + ", cep=" + cep
                + ", rua=" + rua + ", bairro=" + bairro + ", numeroEnd=" + numeroEnd + ", cidade=" + cidade
                + ", estado=" + estado + "]";
    }

    public void setIdCompanyUuid(UUID id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIdCompanyUuid'");
    }

}

