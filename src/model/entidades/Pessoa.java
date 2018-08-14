package model.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Pessoa")
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "IDPessoa")
	public int idPessoa;
	
	@Column (name = "Nome")
	private String nome;
	
	@Column (name = "CPF")
	private String cpf;
	
	@Column (name = "RG")
	private String rg;
	
	@Column (name = "Sexo")
	private String sexo;
	
	@Column (name = "DataNasc")
	private Date dataNascimento;
	
	@Column (name = "Rua")
	private String rua;
	
	@Column (name = "NumCasa")
	private int numCasa;
	
	@Column (name = "Bairro")
	private String bairro;
	
	@Column (name = "Cidade")
	private String cidade;
	
	@Column (name = "Estado")
	private String estado;
	
	@Column (name = "Telefone")
	private String telefone;
	
	public Pessoa(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, int numCasa,
			String bairro, String cidade, String estado, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.rua = rua;
		this.numCasa = numCasa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", sexo=" + sexo
				+ ", dataNascimento=" + dataNascimento + ", rua=" + rua + ", numCasa=" + numCasa + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", telefone=" + telefone + "]";
	}

}