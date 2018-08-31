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
import model.entities.Cliente;
import model.entities.Funcionario;
import model.entities.Pessoa;

/**
 *
 * @author Enigma
 */
@Entity
@Table(name = "gerenciaCliente")
@AssociationOverrides({
    @AssociationOverride(name = "ok.funcionario",
            joinColumns = @JoinColumn(name = "idFuncionario"))
    ,
        @AssociationOverride(name = "ok.cliente",
            joinColumns = @JoinColumn(name = "idCliente"))})
public class GerenciaCliente implements java.io.Serializable {

    private GerenciaClienteId ok = new GerenciaClienteId();
    private Date dataAcesso;

    public GerenciaCliente() {
        this.dataAcesso = null;
    }

    @EmbeddedId
    public GerenciaClienteId getOk() {
        return ok;
    }

    public void setOk(GerenciaClienteId ok) {
        this.ok = ok;
    }

    @Transient
    public Pessoa getFuncionario() {
        return getOk().getFuncionario();
    }

    public void setFuncionario(Funcionario funcionario) {
        getOk().setFuncionario(funcionario);
    }

    @Transient
    public Cliente getCliente() {
        return getOk().getCliente();
    }

    public void setCliente(Cliente cliente) {
        getOk().setCliente(cliente);
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataAcesso", nullable = false, length = 10)
    public Date getDataAcesso() {
        return this.dataAcesso;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GerenciaCliente that = (GerenciaCliente) o;

        if (getOk() != null ? !getOk().equals(that.getOk())
                : that.getOk() != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return (getOk() != null ? getOk().hashCode() : 0);
    }
}

