/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.relationships;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import model.entities.Funcionario;

/**
 *
 * @author Enigma
 */
@Embeddable
public class GerenciaFuncionarioId implements Serializable {

    private Funcionario funcionarioGerente;
    private Funcionario funcionario;

    @ManyToOne
    public Funcionario getFuncionarioGerente() {
        return funcionarioGerente;
    }

    public void setFuncionarioGerente(Funcionario funcionarioGerente) {
        this.funcionarioGerente = funcionarioGerente;
    }

    @ManyToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GerenciaFuncionarioId that = (GerenciaFuncionarioId) o;

        if (funcionarioGerente != null ? !funcionarioGerente.equals(that.funcionarioGerente) : that.funcionarioGerente != null) {
            return false;
        }
        if (funcionario != null ? !funcionario.equals(that.funcionario) : that.funcionario != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (funcionarioGerente != null ? funcionarioGerente.hashCode() : 0);
        result = 31 * result + (funcionario != null ? funcionario.hashCode() : 0);
        return result;
    }

}