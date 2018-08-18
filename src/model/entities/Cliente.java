package model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente extends Pessoa {

    @Column(name = "CNH")
    private String cnh;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Solicita",
            joinColumns = {
                @JoinColumn(name = "IDPessoa")},
            inverseJoinColumns = {
                @JoinColumn(name = "IDCarro")}
    )
    private Collection<Carro> carrosSolicitados = new ArrayList<>();

    @OneToMany(mappedBy = "Cliente", targetEntity = Carro.class, 
               fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Carro> carrosCedidos = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, int numCasa,
            String bairro, String cidade, String estado, String telefone, String cnh) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone);
        this.cnh = cnh;
    }
    
    public Collection<Carro> getCarrosSolicitados() {
        return carrosSolicitados;
    }

    public void setCarrosSolicitados(Collection<Carro> carrosSolicitados) {
        this.carrosSolicitados = carrosSolicitados;
    }

    public Collection<Carro> getCarrosCedidos() {
        return carrosCedidos;
    }

    public void setCarrosCedidos(Collection<Carro> carrosCedidos) {
        this.carrosCedidos = carrosCedidos;
    }

    public Collection<Carro> getCarros() {
        return carrosSolicitados;
    }

    public void setCarros(Collection<Carro> carrosSolicitados) {
        this.carrosSolicitados = carrosSolicitados;
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
