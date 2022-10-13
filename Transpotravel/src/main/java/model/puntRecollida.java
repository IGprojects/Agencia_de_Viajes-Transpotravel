package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class puntRecollida {

	private int idPuntRecollida;
	private int idLocalitzacio;
	private String adreca;
	private String descripcio;

	
	public puntRecollida(int idPuntRecollida,int idLocalitzacio,String adreca,String descripcio) {
		this.idPuntRecollida = idPuntRecollida;
		this.idLocalitzacio = idLocalitzacio;
		this.adreca = adreca;
		this.descripcio = descripcio;

	}

	
	public int getIdLocalitzacio() {
		return idLocalitzacio;
	}


	public void setIdLocalitzacio(int idLocalitzacio) {
		this.idLocalitzacio = idLocalitzacio;
	}


	public String getDescripcio() {
		return descripcio;
	}


	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}


	public int getIdPuntRecollida() {
		return idPuntRecollida;
	}





	public void setIdPuntRecollida(int idPuntRecollida) {
		this.idPuntRecollida = idPuntRecollida;
	}





	public String getAdreca() {
		return adreca;
	}





	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}





	@Override
	public String toString() {
		return "puntRecollida [idPuntRecollida=" + idPuntRecollida + ", adreca=" + adreca + "]";
	}

	
}
