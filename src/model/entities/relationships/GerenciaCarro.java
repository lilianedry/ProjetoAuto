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
import model.entities.Funcionario;
import model.entities.Pessoa;

/**
 *
 * @author Enigma
 */
@Entity
@Table(name = "gerenciaCarro")
@AssociationOverrides({
    @AssociationOverride(name = "ik.funcionario",
            joinColumns = @JoinColumn(name = "idFuncionario"))
    ,
        @AssociationOverride(name = "ik.carro",
            joinColumns = @JoinColumn(name = "idCarro"))})
public class GerenciaCarro implements java.io.Serializable {

    private GerenciaCarroId ik = new GerenciaCarroId();
    private Date dataAcesso;

    public GerenciaCarro() {
        this.dataAcesso = null;
    }

    @EmbeddedId
    public GerenciaCarroId getIk() {
        return ik;
    }

    public void setIk(GerenciaCarroId ik) {
        this.ik = ik;
    }

    @Transient
    public Pessoa getFuncionario() {
        return getIk().getFuncionario();
    }

    public void setFuncionario(Funcionario funcionario) {
        getIk().setFuncionario(funcionario);
    }

    @Transient
    public Carro getCarro() {
        return getIk().getCarro();
    }

    public void setCarro(Carro carro) {
        getIk().setCarro(carro);
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

        GerenciaCarro that = (GerenciaCarro) o;

        if (getIk() != null ? !getIk().equals(that.getIk())
                : that.getIk() != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return (getIk() != null ? getIk().hashCode() : 0);
    }
}
