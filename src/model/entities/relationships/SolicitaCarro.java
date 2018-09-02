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
            joinColumns = @JoinColumn(name = "idPessoa"))
    ,
        @AssociationOverride(name = "pk.carro",
            joinColumns = @JoinColumn(name = "idCarro"))})
public class SolicitaCarro implements java.io.Serializable {

    private SolicitaCarroId pk = new SolicitaCarroId();
    private Date dataRetirada;
    private Date prazoFinal;
    private Date dataEntrega;
    private boolean ativo;

    public SolicitaCarro() {
        this.dataEntrega = null;
        this.ativo = true;
    }

    @EmbeddedId
    public SolicitaCarroId getPk() {
        return pk;
    }

    public void setPk(SolicitaCarroId pk) {
        this.pk = pk;
    }

    @Transient
    public Cliente getCliente() {
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
    @Column(name = "dataRetirada", nullable = false, length = 10)
    public Date getDataRetirada() {
        return this.dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "prazoFinal", nullable = false, length = 10)
    public Date getPrazoFinal() {
        return prazoFinal;
    }

    public void setPrazoFinal(Date prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataEntrega", length = 10)
    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Column(name = "ativo")
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
