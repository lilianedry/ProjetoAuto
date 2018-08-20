/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.relationships;

import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import model.entities.Carro;
import model.entities.Cliente;
import model.entities.Pessoa;

/**
 *
 * @author Enigma
 */
@Entity
@Table(name = "solicitaCarro")
@AssociationOverrides({
        @AssociationOverride(name = "pk.cliente",
            joinColumns = @JoinColumn(name = "idPessoa")),
        @AssociationOverride(name = "pk.carro",
            joinColumns = @JoinColumn(name = "idCarro"))})
public class SolicitaCarro implements java.io.Serializable {

    private SolicitaCarroId pk = new SolicitaCarroId();
    private Date dataSolicitacao;

    public SolicitaCarro() {
    }

    @EmbeddedId
    public SolicitaCarroId getPk() {
        return pk;
    }

    public void setPk(SolicitaCarroId pk) {
        this.pk = pk;
    }

    @Transient
    public Pessoa getCliente() {
        return getPk().getCliente();
    }

    public void setCliente(Cliente cliente) {
        getPk().setCliente(cliente);
    }

    @Transient
    public Carro getCarro() {
        return getPk().getCarro();
    }

    public void setCarro(Carro carro) {
        getPk().setCarro(carro);
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataSolicitacao", nullable = false, length = 10)
    public Date getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SolicitaCarro that = (SolicitaCarro) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
