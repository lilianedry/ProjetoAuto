/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.relationships;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import model.entities.Empregado;
import model.entities.Gerente;

/**
 *
 * @author Enigma
 */
@Embeddable
public class GerenciaFuncionarioId implements Serializable {

    private Gerente gerente;
    private Empregado empregado;

    @ManyToOne
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @ManyToOne
    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
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
        if (gerente != null ? !gerente.equals(that.gerente) : that.gerente != null) {
            return false;
        }
        if (empregado != null ? !empregado.equals(that.empregado) : that.empregado != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (gerente != null ? gerente.hashCode() : 0);
        result = 31 * result + (empregado != null ? empregado.hashCode() : 0);
        return result;
    }
}
