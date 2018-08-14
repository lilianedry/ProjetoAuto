package model.entidades;

public class DocumentoAluno {

    //private int idPessoa;
	public String cpfAluno;
    public boolean formInscricao;
    public boolean compInscricao;
    public boolean atestDeMatricula;
    public boolean docRecebeAuxilio;
    public boolean docSUS;
    public boolean historicoEscolar;
    public boolean dispesaMoradia;
    public boolean dispesaSaude;
    
    public DocumentoAluno() {}
    
	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	/*public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}*/

	public boolean isFormInscricao() {
		return formInscricao;
	}

	public void setFormInscricao(boolean formInscricao) {
		this.formInscricao = formInscricao;
	}

	public boolean isCompInscricao() {
		return compInscricao;
	}

	public void setCompInscricao(boolean compInscricao) {
		this.compInscricao = compInscricao;
	}

	public boolean isAtestDeMatricula() {
		return atestDeMatricula;
	}

	public void setAtestDeMatricula(boolean atestDeMatricula) {
		this.atestDeMatricula = atestDeMatricula;
	}

	public boolean isDocRecebeAuxilio() {
		return docRecebeAuxilio;
	}

	public void setDocRecebeAuxilio(boolean docRecebeAuxilio) {
		this.docRecebeAuxilio = docRecebeAuxilio;
	}

	public boolean isDocSUS() {
		return docSUS;
	}

	public void setDocSUS(boolean docSUS) {
		this.docSUS = docSUS;
	}

	public boolean isHistoricoEscolar() {
		return historicoEscolar;
	}

	public void setHistoricoEscolar(boolean historicoEscolar) {
		this.historicoEscolar = historicoEscolar;
	}

	public boolean isDispesaMoradia() {
		return dispesaMoradia;
	}

	public void setDispesaMoradia(boolean dispesaMoradia) {
		this.dispesaMoradia = dispesaMoradia;
	}

	public boolean isDispesaSaude() {
		return dispesaSaude;
	}

	public void setDispesaSaude(boolean dispesaSaude) {
		this.dispesaSaude = dispesaSaude;
	}
}
