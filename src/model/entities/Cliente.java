package model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    private Collection<Carro> carros = new ArrayList<>();

    public Collection<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Collection<Carro> carros) {
        this.carros = carros;
    }

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, int numCasa,
            String bairro, String cidade, String estado, String telefone, String cnh) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone);
        this.cnh = cnh;
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
