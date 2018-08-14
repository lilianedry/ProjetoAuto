package model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Carro")
public class Carro{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idCarro")
	private int idCarro;
	
	@Column(name = "Placa")
	private String placa;

	@Column(name = "TipoCambio")
	private byte tipoCambio;
	
	@Column(name = "Modelo")
	private String modelo;
		
	@Column(name = "Cor")
	private String cor;
	
	@Column(name = "AnoModelo")
	private int anoModelo;

	@Column(name = "Chassi")
	private String chassi;
		
	@Column(name = "Combustivel")
	private String combustivel;
	
	@Column(name = "Quilometragem")
	private double quilometragem;
	
	@Column(name = "Opcionais")
	private String opcionais;
	
	public Carro() {
		
	}

	public Carro(String placa, byte tipoCambio, String modelo, String cor, int anoModelo, String chassi,
			String combustivel, double quilometragem, String opcionais) {
		this.placa = placa;
		this.tipoCambio = tipoCambio;
		this.modelo = modelo;
		this.cor = cor;
		this.anoModelo = anoModelo;
		this.chassi = chassi;
		this.combustivel = combustivel;
		this.quilometragem = quilometragem;
		this.opcionais = opcionais;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public byte getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(byte tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(String opcionais) {
		this.opcionais = opcionais;
	}

	@Override
	public String toString() {
		return "Carro [idCarro=" + idCarro + ", placa=" + placa + ", tipoCambio=" + tipoCambio + ", modelo=" + modelo
				+ ", cor=" + cor + ", anoModelo=" + anoModelo + ", chassi=" + chassi + ", combustivel=" + combustivel
				+ ", quilometragem=" + quilometragem + ", opcionais=" + opcionais + "]";
	}
		
}
