package model;

public class seguiment {

	private int idSeguiment;
	private desplacament refDesplacament;
	private equipatge refEquipatge;
	private String estat;
	
	public seguiment(int idSeguiment, desplacament refDesplacament, equipatge refEquipatge,
			String estat) {
		this.idSeguiment = idSeguiment;
		this.refDesplacament = refDesplacament;
		this.refEquipatge = refEquipatge;
		this.estat = estat;
	}

	public int getIdSeguiment() {
		return idSeguiment;
	}

	public void setIdSeguiment(int idSeguiment) {
		this.idSeguiment = idSeguiment;
	}

	public desplacament getRefDesplacament() {
		return refDesplacament;
	}

	public void setRefDesplacament(desplacament refDesplacament) {
		this.refDesplacament = refDesplacament;
	}

	
	public equipatge getRefEquipatge() {
		return refEquipatge;
	}

	public void setRefEquipatge(equipatge refEquipatge) {
		this.refEquipatge = refEquipatge;
	}
	
	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	@Override
	public String toString() {
		return "seguiment [idSeguiment=" + idSeguiment + ", Estat=" + estat + "]";
	}
	
}
