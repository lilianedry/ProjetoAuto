package model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "idPessoa") //Herança Pessoa -> Funcionario
public class Funcionario extends Pessoa implements Serializable {
    
    
    private String login;
    private String senha;
    private String cargo;
    private String cargaHorSem;
    private String salario;
    private Date dataEntrada;

    public Funcionario() {
        
    }

    public Funcionario(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, String numCasa,
            String bairro, String cidade, String estado, String telefone, String email, String cargo, String cargaHorSem,
            String salario, Date dataEntrada) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone, email);
        this.cargo = cargo;
        this.cargaHorSem = cargaHorSem;
        this.salario = salario;
        this.dataEntrada = dataEntrada;
    }
    
    @Column(name = "login")
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Column(name = "cargo")
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Column(name = "cargaHorSem")
    public String getCargaHorSem() {
        return cargaHorSem;
    }

    public void setCargaHorSem(String cargaHorSem) {
        this.cargaHorSem = cargaHorSem;
    }

    @Column(name = "salario")
    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Column(name = "dataEntrada")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public String toString() {
        return "Funcionario [idPessoa=" + getIdPessoa() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", rg=" + getRg() + ", sexo=" + getSexo()
                + ", dataNascimento=" + getDataNascimento() + ", rua=" + getRua() + ", numCasa=" + getNumCasa() + ", bairro=" + getBairro()
                + ", cidade=" + getCidade() + ", estado=" + getEstado() + ", telefone=" + getTelefone() + ", email=" + getEmail()
                + ", cargo=" + getCargo() + ", cargaHorSem=" + getCargaHorSem() + ", salario=" + getSalario()
                + ", dataEntrada=" + getDataEntrada() + ", ativo=" + isAtivo() + "]";
    }

}
