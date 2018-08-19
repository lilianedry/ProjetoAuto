package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import model.entities.relationships.SolicitaCarro;

@Entity
@Table(name = "Cliente")
@PrimaryKeyJoinColumn(name = "IDPessoa") //Herança: Pessoa -> Cliente
public class Cliente extends Pessoa implements Serializable {

    private String cnh;
    private Collection<SolicitaCarro> solicitaCarro = new ArrayList<>(); //RELACIONAMENTO N:N SolicitaCarro
    private Collection<Carro> carrosCedidos = new HashSet<>(); //RELACIONAMENTO 1:N CedeCarro

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, int numCasa,
            String bairro, String cidade, String estado, String telefone, String cnh) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone);
        this.cnh = cnh;
    }
    //SolicitaCarro
    @OneToMany(mappedBy = "Cliente", targetEntity = Carro.class, 
               fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<SolicitaCarro> getSolicitaCarro() {
        return solicitaCarro;
    }

    public void setSolicitaCarro(Collection<SolicitaCarro> solicitaCarro) {
        this.solicitaCarro = solicitaCarro;
    }
    //SolicitaCarro
    //CedeCarro
    @OneToMany(mappedBy = "Cliente", 
               fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    public Collection<Carro> getCarrosCedidos() {
        return carrosCedidos;
    }

    public void setCarrosCedidos(Collection<Carro> carrosCedidos) {
        this.carrosCedidos = carrosCedidos;
    }
    //CedeCarro
    
    @Column(name = "CNH")
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
                + ", cidade=" + getCidade() + ", estado=" + getEstado() + ", telefone=" + getTelefone() + ", cnh=" + getCnh() + "]";
    }

    
}
