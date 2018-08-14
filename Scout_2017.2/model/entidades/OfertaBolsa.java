package model.entidades;
import java.util.Date;

public class OfertaBolsa implements Comparable <OfertaBolsa> {
	private Integer codOferta;
	private int tipoOferta;
    private int numVagas;
    private Date dataInicio;
    private Date dataFim;
    
    public OfertaBolsa() {}

	public Integer getCodOferta() {
		return codOferta;
	}

	public void setCodOferta(Integer codOferta) {
		this.codOferta = codOferta;
	}

	public int getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(int tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public int getNumVagas() {
		return numVagas;
	}

	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public static int compareTo(OfertaBolsa ob1, OfertaBolsa ob2) {
		return Integer.compare(ob1.getTipoOferta(), ob2.getTipoOferta());
	}

	@Override
	public int compareTo(OfertaBolsa ob) {
		if(this.getTipoOferta()>ob.getTipoOferta())
			return 1;
		else if(this.getTipoOferta()<ob.getTipoOferta())
			return -1;
		else return 0;
	}
	
}
