package model.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import model.entities.relationships.GerenciaCarro;
import model.entities.relationships.SolicitaCarro;

@Entity
@Table(name = "carro")
public class Carro implements Serializable {

    private Integer idCarro;
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
    private boolean emprestado;  
    private Set<SolicitaCarro> solicitaCarro = new HashSet<>(0); //RELACINAMENTO N:N SolicitaCarro
    private Cliente cliente; //RELACIONAMENTO 1:N CedeCarro
    private Date dataCede;
    private Set<GerenciaCarro> gerenciaCarro = new HashSet<>(0); //RELACINAMENTO N:N GerenciaCarro

    public Carro() {
        this.ativo = true;
        this.emprestado = false;
    }

    public Carro(String placa, String tipoCambio, String modelo, String cor, String anoModelo, String chassi,
            String combustivel, String quilometragem, String opcionais) {
        this.placa = placa;
        this.tipoCambio = tipoCambio;
        this.modelo = modelo;
        this.cor = cor;
        this.anoModelo = anoModelo;
        this.chassi = chassi;
        this.combustivel = combustivel;
        this.quilometragem = quilometragem;
        this.opcionais = opcionais;
        this.ativo = true;
        this.emprestado = false;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.carro")
    public Set<SolicitaCarro> getSolicitaCarro() {
        return solicitaCarro;
    }

    public void setSolicitaCarro(Set<SolicitaCarro> solicitaCarro) {
        this.solicitaCarro = solicitaCarro;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDataCede() {
        return dataCede;
    }

    public void setDataCede(Date dataCede) {
        this.dataCede = dataCede;
    }
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ik.carro")
    public Set<GerenciaCarro> getGerenciaCarro() {
        return gerenciaCarro;
    }

    public void setGerenciaCarro(Set<GerenciaCarro> gerenciaCarro) {
        this.gerenciaCarro = gerenciaCarro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarro", unique = true)
    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
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
    @Column(name = "emprestado")
    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    
    @Column(name = "ativo")
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
                + ", quilometragem=" + getQuilometragem() + ", opcionais=" + getOpcionais() + ", emprestado=" + isEmprestado() + ", ativo=" + isAtivo() + "]";
    }

}
