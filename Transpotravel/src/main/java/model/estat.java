package model;

public class estat {
	
	private int idEstat;
	private String descripcio;
	
	public estat(int idEstat, String descripcio) {
		this.idEstat = idEstat;
		this.descripcio = descripcio;
	}

	public int getIdEstat() {
		return idEstat;
	}
	public void setIdEstat(int idEstat) {
		this.idEstat = idEstat;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	@Override
	public String toString() {
		return "estat [idEstat=" + idEstat + ", descripcio=" + descripcio + "]";
	}
	
}
