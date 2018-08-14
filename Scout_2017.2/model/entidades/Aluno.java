package model.entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    //private int id;
	public String nomePessoa;
    private float distanciaCidade;
    private float rendaBruta;
    public int numFamiliares;
    public int tipoOferta;
    public int matriculaAluno;
    public String email;
    public List<Familiar> familiares = new ArrayList<Familiar>();

    public Aluno() {
    	
    }
    
    public void adicionaFamiliar(List<Familiar> familiares) {
		for(Familiar a : familiares) {
			this.familiares.add(a);
		}
	}
    
    public void imprimeFamiliares() {
    	System.out.println("Familiares de " + this.nomePessoa);
    	if(!this.familiares.isEmpty()) {
        	for (Familiar a : this.familiares)
        		System.out.println(a.getParentesco());
    	}
    }

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public float getDistanciaCidade() {
		return distanciaCidade;
	}

	public void setDistanciaCidade(float distanciaCidade) {
		this.distanciaCidade = distanciaCidade;
	}

	public float getRendaBruta() {
		return rendaBruta;
	}

	public void setRendaBruta(float rendaBruta) {
		this.rendaBruta = rendaBruta;
	}

	public int getNumFamiliares() {
		return numFamiliares;
	}

	public void setNumFamiliares(int numFamiliares) {
		this.numFamiliares = numFamiliares;
	}

	public int getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(int tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public int getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(int matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
}
