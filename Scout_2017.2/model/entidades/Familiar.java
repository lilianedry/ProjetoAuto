package model.entidades;

public class Familiar extends Pessoa {
	//private int idPessoa;
	private String cpfAluno;
    public String parentesco;
    public DocumentoFamiliar docF = new DocumentoFamiliar();
    
    public Familiar() {}
    
	/*public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}*/
    
	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
    
	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	// lalala

	public DocumentoFamiliar getDocFamiliar() {
		return docF;
	}

	public void setDocFamiliar(DocumentoFamiliar docF) {
		this.docF = docF;
	}
}
