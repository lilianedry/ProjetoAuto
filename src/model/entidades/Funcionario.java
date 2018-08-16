package model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends Pessoa implements Serializable {

    @Column(name = "Cargo")
    private String cargo;

    @Column(name = "CargaHorSem")
    private byte cargaHorSem;

    @Column(name = "Salario")
    private float salario;

    @Column(name = "DataEntrada")
    @Temporal(javax.persistence.TemporalType.DATE)
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public byte getCargaHorSem() {
        return cargaHorSem;
    }

    public void setCargaHorSem(byte cargaHorSem) {
        this.cargaHorSem = cargaHorSem;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public String toString() {
        return "Funcionario [idPessoaFunc=" + idPessoa + ", cargo=" + cargo + ", cargaHorSem=" + cargaHorSem
                + ", salario=" + salario + ", dataEntrada=" + dataEntrada + "]";
    }

}
