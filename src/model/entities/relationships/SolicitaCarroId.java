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
import model.entities.Cliente;

/**
 *
 * @author Enigma
 */
@Embeddable
public class SolicitaCarroId implements Serializable {

    private Cliente cliente;
    private Carro carro;

    @ManyToOne
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

        SolicitaCarroId that = (SolicitaCarroId) o;

        if (cliente != null ? !cliente.equals(that.cliente) : that.cliente != null) {
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
        result = (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (carro != null ? carro.hashCode() : 0);
        return result;
    }

}
