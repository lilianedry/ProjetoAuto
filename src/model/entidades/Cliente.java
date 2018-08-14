package model.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente extends Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDPessoaCliente")
	private int idPessoaCliente;

	@Column(name = "CNH")
	private String cnh;

	public Cliente(String nome, String cpf, String rg, String sexo, Date dataNascimento, String rua, int numCasa,
			String bairro, String cidade, String estado, String telefone, String cnh) {
		super(nome, cpf, rg, sexo, dataNascimento, rua, numCasa, bairro, cidade, estado, telefone);
		this.cnh = cnh;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "SolicitaCarro", 
        joinColumns = { @JoinColumn(name = "IDPessoaCliente") }, 
        inverseJoinColumns = { @JoinColumn(name = "IDCarro") }
    )
    Set<Carro> Carros = new HashSet<>();

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	@Override
	public String toString() {
		return "Cliente [idPessoaCliente=" + idPessoaCliente + ", cnh=" + cnh + "]";
	}

}
