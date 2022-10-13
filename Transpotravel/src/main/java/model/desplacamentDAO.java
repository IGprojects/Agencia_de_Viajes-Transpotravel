package model;

public interface desplacamentDAO {

	boolean afegirClientADesplacament(ConbdXML conn, int usuari, int iddistribuciovols, int numequipatges,int places);
	
}
