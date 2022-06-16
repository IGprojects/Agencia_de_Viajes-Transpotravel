package model;

public class supervisor extends persona{

	private int idSupervidor;

	public supervisor(String nom, String cognoms, String dni, String adreca, String correu, String telefon,
			int idSupervidor) {
		super(nom, cognoms, dni, adreca, correu, telefon);
		this.idSupervidor = idSupervidor;
	}
	
	public int getIdSupervidor() {
		return idSupervidor;
	}

	public void setIdSupervidor(int idSupervidor) {
		this.idSupervidor = idSupervidor;
	}

	@Override
	public String toString() {
		return "supervisor [idSupervidor=" + idSupervidor + "]";
	}
	
}
