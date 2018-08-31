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
import model.entities.Funcionario;
import model.entities.Pessoa;

/**
 *
 * @author Enigma
 */
@Entity
@Table(name = "gerenciaFuncionario")
@AssociationOverrides({
    @AssociationOverride(name = "lk.funcionarioGerente",
            joinColumns = @JoinColumn(name = "idFuncionario"))
    ,
        @AssociationOverride(name = "lk.funcionario",
            joinColumns = @JoinColumn(name = "idFuncionario"))})
public class GerenciaFuncionario implements java.io.Serializable {

    private GerenciaFuncionarioId lk = new GerenciaFuncionarioId();
    private Date dataAcesso;

    public GerenciaFuncionario() {
        this.dataAcesso = null;
    }

    @EmbeddedId
    public GerenciaFuncionarioId getLk() {
        return lk;
    }

    public void setLk(GerenciaFuncionarioId lk) {
        this.lk = lk;
    }

    @Transient
    public Pessoa getFuncionarioGerente() {
        return getLk().getFuncionarioGerente();
    }

    public void setFuncionarioGerente(Funcionario funcionarioGerente) {
        getLk().setFuncionarioGerente(funcionarioGerente);
    }

    @Transient
    public Pessoa getFuncionario() {
        return getLk().getFuncionario();
    }

    public void setFuncionario(Funcionario funcionario) {
        getLk().setFuncionario(funcionario);
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

        GerenciaFuncionario that = (GerenciaFuncionario) o;

        if (getLk() != null ? !getLk().equals(that.getLk())
                : that.getLk() != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return (getLk() != null ? getLk().hashCode() : 0);
    }
}

