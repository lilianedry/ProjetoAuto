package model.entities;

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
@PrimaryKeyJoinColumn(name = "IDPessoa")
public class Cliente extends Pessoa {

    @Column(name = "CNH")
    private String cnh;
    
    //RELACIONAMENTO N:N SolicitaCarro
    @OneToMany(mappedBy = "Cliente", 
               fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<SolicitaCarro> solicitaCarro = new ArrayList<>();

    //RELACIONAMENTO 1:N CedeCarro
    @OneToMany(mappedBy = "Cliente", targetEntity = Carro.class, 
               fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Carro> carrosCedidos = new HashSet<>();

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, int numCasa,
            String bairro, String cidade, String estado, String telefone, String cnh) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone);
        this.cnh = cnh;
    }
    
    public Collection<SolicitaCarro> getSolicitaCarro() {
        return solicitaCarro;
    }

    public void setSolicitaCarro(Collection<SolicitaCarro> solicitaCarro) {
        this.solicitaCarro = solicitaCarro;
    }

    public Collection<Carro> getCarrosCedidos() {
        return carrosCedidos;
    }

    public void setCarrosCedidos(Collection<Carro> carrosCedidos) {
        this.carrosCedidos = carrosCedidos;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "Cliente [idPessoaCliente=" + idPessoa + ", cnh=" + cnh + "]";
    }

}
