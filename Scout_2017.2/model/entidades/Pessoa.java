package model.entidades;

public class Pessoa {
	private int idPessoa;
	private String CPFPessoa;
	private String RGPessoa;
	private boolean carteiraTrabalho;
	private boolean extratoBancario;
	
	public Pessoa() {}
	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getCPFPessoa() {
		return CPFPessoa;
	}
	public void setCPFPessoa(String cPFPessoa) {
		CPFPessoa = cPFPessoa;
	}
	public String getRGPessoa() {
		return RGPessoa;
	}
	public void setRGPessoa(String rGPessoa) {
		RGPessoa = rGPessoa;
	}
	public boolean isCarteiraTrabalho() {
		return carteiraTrabalho;
	}
	public void setCarteiraTrabalho(boolean carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	public boolean isExtratoBancario() {
		return extratoBancario;
	}
	public void setExtratoBancario(boolean extratoBancario) {
		this.extratoBancario = extratoBancario;
	}
}
