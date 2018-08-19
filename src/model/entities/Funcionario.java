package model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Funcionario")
@PrimaryKeyJoinColumn(name = "IDPessoa") //Herança Pessoa -> Funcionario
public class Funcionario extends Pessoa implements Serializable {
    
    private String cargo;
    private byte cargaHorSem;
    private float salario;
    private Date dataEntrada;

    public Funcionario() {
        
    }

    public Funcionario(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, int numCasa,
            String bairro, String cidade, String estado, String telefone, String cargo, byte cargaHorSem, float salario,
            Date dataEntrada) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone);
        this.cargo = cargo;
        this.cargaHorSem = cargaHorSem;
        this.salario = salario;
        this.dataEntrada = dataEntrada;
    }

    @Column(name = "Cargo")
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Column(name = "CargaHorSem")
    public byte getCargaHorSem() {
        return cargaHorSem;
    }

    public void setCargaHorSem(byte cargaHorSem) {
        this.cargaHorSem = cargaHorSem;
    }

    @Column(name = "Salario")
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Column(name = "DataEntrada")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public String toString() {
        return "Funcionario [idPessoa=" + idPessoa + ", nome=" + getNome() + ", cpf=" + getCpf() + ", rg=" + getRg() + ", sexo=" + getSexo()
                + ", dataNascimento=" + getDataNascimento() + ", rua=" + getRua() + ", numCasa=" + getNumCasa() + ", bairro=" + getBairro()
                + ", cidade=" + getCidade() + ", estado=" + getEstado() + ", telefone=" + getTelefone() + ", cargo=" + cargo + ", cargaHorSem=" + cargaHorSem
                + ", salario=" + salario + ", dataEntrada=" + dataEntrada + "]";
    }

}
