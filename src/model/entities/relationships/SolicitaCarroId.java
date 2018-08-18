/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.relationships;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import model.entities.Carro;
import model.entities.Pessoa;

/**
 *
 * @author Enigma
 */
@Embeddable
public class SolicitaCarroId implements java.io.Serializable {

    private Pessoa pessoa;
    private Carro carro;

    @ManyToOne
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

        if (pessoa != null ? !pessoa.equals(that.pessoa) : that.pessoa != null) {
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
        result = (pessoa != null ? pessoa.hashCode() : 0);
        result = 31 * result + (carro != null ? carro.hashCode() : 0);
        return result;
    }

}
