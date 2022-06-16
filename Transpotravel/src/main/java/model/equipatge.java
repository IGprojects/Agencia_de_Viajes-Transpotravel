package model;

public class equipatge {

	private int idEquipatge;
	private int pes;
	private String dni;
	private String origen;
	private String desti;
	private String estat;
	private String puntRecollida;
	
	
	public equipatge(int idEquipatge, int pes, String dni, String origen, String desti, String estat, String puntRecollida) {
		this.idEquipatge = idEquipatge;
		this.pes = pes;
		this.dni = dni;
		this.origen = origen;
		this.desti = desti;
		this.estat = estat;
		this.puntRecollida = puntRecollida;
	}


	
	public int getIdEquipatge() {
		return idEquipatge;
	}


	public void setIdEquipatge(int idEquipatge) {
		this.idEquipatge = idEquipatge;
	}


	public int getPes() {
		return pes;
	}


	public void setPes(int pes) {
		this.pes = pes;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDesti() {
		return desti;
	}


	public void setDesti(String desti) {
		this.desti = desti;
	}


	public String getEstat() {
		return estat;
	}


	public void setEstat(String estat) {
		this.estat = estat;
	}


	public String getPuntRecollida() {
		return puntRecollida;
	}


	public void setPuntRecollida(String puntRecollida) {
		this.puntRecollida = puntRecollida;
	}



	@Override
	public String toString() {
		return "equipatge [idEquipatge=" + idEquipatge + ", pes=" + pes + ", dni=" + dni + ", origen=" + origen
				+ ", desti=" + desti + ", estat=" + estat + ", puntRecollida=" + puntRecollida + "]";
	}
	
}
