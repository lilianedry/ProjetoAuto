package model.entidades;

public class DocumentoFamiliar {

    private int idPessoa;
    public boolean certidao;
    //public boolean tutelaAluno;
    public boolean comprRenda;
    public boolean DecImpRenda;
    
    public DocumentoFamiliar() {}
    
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public boolean getCertidao() {
		return certidao;
	}
	public void setCertidao(boolean certidao) {
		this.certidao = certidao;
	}
	/*public boolean getTutelaAluno() {
		return tutelaAluno;
	}
	public void setTutelaAluno(boolean tutelaAluno) {
		this.tutelaAluno = tutelaAluno;
	}*/
	public boolean getComprRenda() {
		return comprRenda;
	}
	public void setComprRenda(boolean comprRenda) {
		this.comprRenda = comprRenda;
	}
	public boolean getDecImpRenda() {
		return DecImpRenda;
	}
	public void setDecImpRenda(boolean decImpRenda) {
		DecImpRenda = decImpRenda;
	}
	//lalala
}
