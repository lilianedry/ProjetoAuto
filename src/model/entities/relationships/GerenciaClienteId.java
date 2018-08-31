/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.relationships;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import model.entities.Cliente;
import model.entities.Funcionario;

/**
 *
 * @author Enigma
 */
@Embeddable
public class GerenciaClienteId implements Serializable {

    private Funcionario funcionario;
    private Cliente cliente;

    @ManyToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @ManyToOne
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GerenciaClienteId that = (GerenciaClienteId) o;

        if (funcionario != null ? !funcionario.equals(that.funcionario) : that.funcionario != null) {
            return false;
        }
        if (cliente != null ? !cliente.equals(that.cliente) : that.cliente != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (funcionario != null ? funcionario.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        return result;
    }

}
