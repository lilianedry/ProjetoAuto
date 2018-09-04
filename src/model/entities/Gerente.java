/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import model.entities.relationships.GerenciaFuncionario;

/**
 *
 * @author Enigma
 */
@Entity
@Table(name = "gerente")
@PrimaryKeyJoinColumn(name = "idGerente")
public class Gerente extends Funcionario implements Serializable {
    
    private Set<GerenciaFuncionario> gerenciados = new HashSet<>(0); //RELACIONAMENTO N:N FuncionariosGerenciados

    public Gerente() {
    }

    public Gerente(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, String numCasa, String bairro, String cidade, String estado, String telefone, String email, String cargo, String cargaHorSem, String salario, Date dataEntrada) {
        super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone, email, cargo, cargaHorSem, salario, dataEntrada);
    }
    
    
    
    @OneToMany(mappedBy = "lk.gerente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<GerenciaFuncionario> getGerenciados() {
        return gerenciados;
    }

    public void setGerenciados(Set<GerenciaFuncionario> gerenciados) {
        this.gerenciados = gerenciados;
    }

    @Override
    public String toString() {
        return "Gerente [id=" + getIdPessoa() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", rg=" + getRg() + ", sexo=" + getSexo()
                + ", dataNascimento=" + getDataNascimento() + ", rua=" + getRua() + ", numCasa=" + getNumCasa() + ", bairro=" + getBairro()
                + ", cidade=" + getCidade() + ", estado=" + getEstado() + ", telefone=" + getTelefone() + ", email=" + getEmail()
                + ", cargo=" + getCargo() + ", cargaHorSem=" + getCargaHorSem() + ", salario=" + getSalario()
                + ", dataEntrada=" + getDataEntrada() + ", ativo=" + isAtivo() + "]";
    }
    
    
}
