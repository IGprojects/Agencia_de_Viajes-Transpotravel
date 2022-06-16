package model;

public class desplacament {

	private int idDesplacament;
	private String puntRecollida;
	private String dni;
	private String distribucioVols;
	private String numEquipatges;

	public desplacament(int idDesplacament, String puntRecollida, String dni, String distribucioVols, String numEquipatges) {
		this.idDesplacament = idDesplacament;
		this.puntRecollida = puntRecollida;
		this.dni = dni;
		this.distribucioVols = distribucioVols;
		this.numEquipatges = numEquipatges;
	}

	public int getIdDesplacament() {
		return idDesplacament;
	}

	public void setIdDesplacament(int idDesplacament) {
		this.idDesplacament = idDesplacament;
	}

	public String getPuntRecollida() {
		return puntRecollida;
	}

	public void setPuntRecollida(String puntRecollida) {
		this.puntRecollida = puntRecollida;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDistribucioVols() {
		return distribucioVols;
	}

	public void setDistribucioVols(String distribucioVols) {
		this.distribucioVols = distribucioVols;
	}

	public String getNumEquipatges() {
		return numEquipatges;
	}

	public void setNumEquipatges(String numEquipatges) {
		this.numEquipatges = numEquipatges;
	}

	@Override
	public String toString() {
		return "desplacament [idDesplacament=" + idDesplacament + ", puntRecollida=" + puntRecollida + ", dni=" + dni
				+ ", distribucioVols=" + distribucioVols + ", numEquipatges=" + numEquipatges + "]";
	}	
	
}

