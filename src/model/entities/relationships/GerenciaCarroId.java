/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.relationships;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import model.entities.Carro;
import model.entities.Funcionario;

/**
 *
 * @author Enigma
 */
@Embeddable
public class GerenciaCarroId implements Serializable {

    private Funcionario funcionario;
    private Carro carro;

    @ManyToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @ManyToOne
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GerenciaCarroId that = (GerenciaCarroId) o;

        if (funcionario != null ? !funcionario.equals(that.funcionario) : that.funcionario != null) {
            return false;
        }
        if (carro != null ? !carro.equals(that.carro) : that.carro != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (funcionario != null ? funcionario.hashCode() : 0);
        result = 31 * result + (carro != null ? carro.hashCode() : 0);
        return result;
    }

}
