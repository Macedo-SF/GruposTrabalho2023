package com.sfm.grupostrabalho2023;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findNome", query = "SELECT p.nome FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findNomeEndereco", query = "SELECT p.nome, p.endereco FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findPessoaQueMoramEmAvenida", query = "SELECT p from Pessoa p " + "WHERE p.endereco.tipoLogradouro = 1"),
    @NamedQuery(name = "Pessoa.findPessoaQueNaoMoramEmPraca", query = "SELECT p from Pessoa p " + "WHERE NOT p.endereco.tipoLogradouro = 2"),
    @NamedQuery(name = "Pessoa.findNomeTelefones", query = "SELECT p.nome, t FROM Pessoa p JOIN p.telefones t")
})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65, nullable = false)
    private String nome;

    @Column(length = 250, nullable = false)
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate nascimento;

    @Transient
    private Byte idade;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Atuacao> atuacoes;

    @OneToMany(mappedBy = "lider",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Grupo> liderancas;

    public Pessoa() {
        telefones = new ArrayList<>();
        atuacoes = new ArrayList<>();
        liderancas = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        this.idade = (byte) (LocalDate.now().getYear() - this.nascimento.getYear());
    }

    public Byte getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public List<Grupo> getLiderancas() {
        return liderancas;
    }

    public void setLiderancas(List<Grupo> liderancas) {
        this.liderancas = liderancas;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="hash , tostring e equals">
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Pessoa{" 
                + "id=" + id 
                + ", nome=" + nome 
                + ", email=" + email 
                + ", nascimento=" + nascimento 
                + ", idade=" + idade 
                + ", endereco=" + endereco 
                + ", telefones=" + telefones 
                + ", atuacoes=" + atuacoes 
                + ", liderancas=" + liderancas 
                + '}';
    }
    //</editor-fold>
}