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
@Table(name = "gerente")
@PrimaryKeyJoinColumn(name = "idGerente")
public class Gerente extends Funcionario implements Serializable {
    
    private Set<GerenciaFuncionario> gerenciados = new HashSet<>(0); //RELACIONAMENTO N:N FuncionariosGerenciados
    
    @OneToMany(mappedBy = "lk.gerente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<GerenciaFuncionario> getGerenciados() {
        return gerenciados;
    }

    public void setGerenciados(Set<GerenciaFuncionario> gerenciados) {
        this.gerenciados = gerenciados;
    }
    
    
}
