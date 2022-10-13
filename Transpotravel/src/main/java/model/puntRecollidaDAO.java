package model;

import java.util.List;

public interface puntRecollidaDAO {
	
	puntRecollida cercaPuntRecollida(ConbdXML conn,int id);
	boolean create(ConbdXML conn,puntRecollida punt);
	boolean update(ConbdXML conn,int id,puntRecollida punt);
	boolean delete(ConbdXML conn,int id);
	public static void insertarPunt(ConbdXML conn,int idlocalitzacio,String Adreca,String Descripcio) {
	}
	public static int CercarIdLocalitzacioPunt(ConbdXML conn,String NomLocalitzacio) {
		return 0;
	}	
	public static void ComboBoxPuntRecollida(ConbdXML conn,List<String> punts,String idDesti) {
	}
	public static void ComboBoxPuntRecollidaAct(ConbdXML conn,List<String> punts,String idDesti) {
	}
	public static void ComboBoxPuntRecollidaAdmin(ConbdXML conn,List<String> punts) {
	}
	public static void ComboBoxPuntLocalitzacions(ConbdXML conn,List<String> ciutats) {
	}
	public static void ActualitzarPunt(ConbdXML conn,int puntActualitzar,String Adreccanova) {
	}
	int cercarPuntRecollidaInsertatPelClient(ConbdXML conn,String nomPunt);
	public static void CercarPunts(ConbdXML conn,List<puntRecollida> llista2) {
	}
	public static void eliminarPunt(ConbdXML conn,String idpunt) {
	}
}
