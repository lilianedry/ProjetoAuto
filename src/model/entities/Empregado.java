/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import model.entities.relationships.GerenciaFuncionario;

/**
 *
 * @author Enigma
 */
@Entity
@Table(name = "empregado")
@PrimaryKeyJoinColumn(name = "idEmpregado")
public class Empregado extends Funcionario implements Serializable {
    
    private Set<GerenciaFuncionario> gerentes = new HashSet<>(0); //RELACIONAMENTO N:N FuncionariosGerenciados

    @OneToMany(mappedBy = "lk.empregado", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<GerenciaFuncionario> getGerentes() {
        return gerentes;
    }

    public void setGerentes(Set<GerenciaFuncionario> gerentes) {
        this.gerentes = gerentes;
    }
    
}
