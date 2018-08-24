package model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import model.entities.relationships.SolicitaCarro;

@Entity
@Table(name = "carro")
public class Carro implements Serializable {

    private int idCarro;
    private String placa;
    private String tipoCambio;
    private String modelo;
    private String cor;
    private String anoModelo;
    private String chassi;
    private String combustivel;
    private String quilometragem;
    private String opcionais;
    private boolean ativo;
    private Set<SolicitaCarro> solicitaCarro = new HashSet<>(0); //RELACINAMENTO N:N SolicitaCarro
    private Cliente cliente; //RELACIONAMENTO 1:N CedeCarro

    public Carro() {

    }

    public Carro(String placa, String tipoCambio, String modelo, String cor, String anoModelo, String chassi,
            String combustivel, String quilometragem, String opcionais, boolean ativo) {
        this.placa = placa;
        this.tipoCambio = tipoCambio;
        this.modelo = modelo;
        this.cor = cor;
        this.anoModelo = anoModelo;
        this.chassi = chassi;
        this.combustivel = combustivel;
        this.quilometragem = quilometragem;
        this.opcionais = opcionais;
        this.ativo = ativo;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.carro")
    public Set<SolicitaCarro> getSolicitaCarro() {
        return solicitaCarro;
    }

    public void setSolicitaCarro(Set<SolicitaCarro> solicitaCarro) {
        this.solicitaCarro = solicitaCarro;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarro", unique = true, nullable = false)
    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    @Column(name = "placa")
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(name = "tipoCambio")
    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Column(name = "modelo")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(name = "cor")
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Column(name = "anoModelo")
    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Column(name = "chassi")
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Column(name = "combustivel")
    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    @Column(name = "quilometragem")
    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Column(name = "opcionais")
    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public String toString() {
        return "Carro [idCarro=" + getIdCarro() + ", placa=" + getPlaca() + ", tipoCambio=" + getTipoCambio() + ", modelo=" + getModelo()
                + ", cor=" + getCor() + ", anoModelo=" + getAnoModelo() + ", chassi=" + getChassi() + ", combustivel=" + getCombustivel()
                + ", quilometragem=" + getQuilometragem() + ", opcionais=" + getOpcionais() + "]";
    }

}
