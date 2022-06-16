package model;

import java.util.ArrayList;
import java.util.List;


public interface EquipatgeDAO {
	
	equipatge cercarEquipatge(ConbdXML conn,int id);
	
	public boolean afegirEquipatgeADesplacament(ConbdXML conn,int usuari, int pes, String punt, int iddistribuciovol);	
	public ArrayList<equipatge> cercarEquipatgePerUsuari(ConbdXML conn, int idUsuari, int idVol);
	public void eliminarEquipatge(ConbdXML conn,int idequipatge,int pes);
	public void actualitzarEquipatge(ConbdXML conn,int idequipatge,int idpunt);
}
