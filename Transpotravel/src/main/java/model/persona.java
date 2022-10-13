package model;

public class persona {

	private String nom;
	private String cognoms;
	private String dni;
	private String adreca;
	private String correu;
	private String telefon;
	
	
	public persona(String nom, String cognoms, String dni, String adreca, String correu, String telefon) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.adreca = adreca;
		this.correu = correu;
		this.telefon = telefon;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCognoms() {
		return cognoms;
	}


	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getAdreca() {
		return adreca;
	}


	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}


	public String getCorreu() {
		return correu;
	}


	public void setCorreu(String correu) {
		this.correu = correu;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	@Override
	public String toString() {
		return "persona [nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni + ", adreca=" + adreca + ", correu="
				+ correu + ", telefon=" + telefon + "]";
	}
	
	
	
}
