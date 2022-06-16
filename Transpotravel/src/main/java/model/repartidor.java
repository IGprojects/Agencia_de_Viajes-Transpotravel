package model;

public class repartidor extends persona{

	private int idRepartidor;

	public repartidor(String nom, String cognoms, String dni, String adreca, String correu, String telefon,
			int idRepartidor) {
		super(nom, cognoms, dni, adreca, correu, telefon);
		this.idRepartidor = idRepartidor;
	}

	public int getIdRepartidor() {
		return idRepartidor;
	}

	public void setIdRepartidor(int idRepartidor) {
		this.idRepartidor = idRepartidor;
	}

	@Override
	public String toString() {
		return "repartidor [idRepartidor=" + idRepartidor + "]";
	}

	
}
