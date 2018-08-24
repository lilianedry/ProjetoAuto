package model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import model.entities.relationships.SolicitaCarro;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "idPessoa") //Herança: Pessoa -> Cliente
public class Cliente extends Pessoa implements Serializable {

    private String cnh;
    private Set<SolicitaCarro> solicitaCarro = new HashSet<>(0); //RELACIONAMENTO N:N SolicitaCarro
    private Set<Carro> carrosCedidos = new HashSet<>(0); //RELACIONAMENTO 1:N CedeCarro

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, String numCasa,
            String bairro, String cidade, String estado, String telefone, String email, String cnh) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone, email);
        this.cnh = cnh;
    }
    //SolicitaCarro
    @OneToMany(mappedBy = "pk.cliente", 
               fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<SolicitaCarro> getSolicitaCarro() {
        return solicitaCarro;
    }

    public void setSolicitaCarro(Set<SolicitaCarro> solicitaCarro) {
        this.solicitaCarro = solicitaCarro;
    }
    //SolicitaCarro
    //CedeCarro
    @OneToMany(mappedBy = "cliente", 
               fetch = FetchType.LAZY)
    public Set<Carro> getCarrosCedidos() {
        return carrosCedidos;
    }

    public void setCarrosCedidos(Set<Carro> carrosCedidos) {
        this.carrosCedidos = carrosCedidos;
    }
    //CedeCarro
    
    @Column(name = "cnh")
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "Cliente [idPessoa=" + getIdPessoa() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", rg=" + getRg() + ", sexo=" + getSexo()
                + ", dataNascimento=" + getDataNascimento() + ", rua=" + getRua() + ", numCasa=" + getNumCasa() + ", bairro=" + getBairro()
                + ", cidade=" + getCidade() + ", estado=" + getEstado() + ", telefone=" + getTelefone() + ", email=" + getEmail()
                + ", cnh=" + getCnh() + ", ativo=" + isAtivo() + "]";
    }

    
}
