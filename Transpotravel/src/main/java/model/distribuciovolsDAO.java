package model;

import java.time.LocalDateTime; 
import java.util.ArrayList;
import java.util.List;




public interface distribuciovolsDAO {

	
	public static void ActualitzarEstatVol(ConbdXML conn,int volActualitzar,String EstatNou) {
	}
	public static void ComboBoxOrigen(ConbdXML conn,List<String> origens) {
	}
	public static void ComboBoxDesti(ConbdXML conn, List<String> destins) {
	}
	public static void ComboBoxEstats(ConbdXML conn,List<String> Estats) {
	}
	public static void cercarVols(ConbdXML conn,List<distribuciovols> llista2) {
		
		
	}
	public static void ComboBoxVols(ConbdXML conn,List<String> ciutats) {}
	public static void insertarVol(ConbdXML conn,int idorigen,int iddesti,int preu,LocalDateTime horaSortida,LocalDateTime horaArribada,int oferta,int IdPuntRecollida,String Descripcio) {
	}
	public static void ActualitzarPlaces_Pes(ConbdXML conn,int persones,int pes,int idvol) {
	}
	public static void eliminarVol(ConbdXML conn,String idvol) {	
	}

	public static void ObtenirVolsSeleccionats(ConbdXML conn,int idDesti,int idOrigen,List<distribuciovols> llistaVolsFiltrats) {
	}
	public static String ObtenirCiutat(ConbdXML conn,String ciutat,int ID) {
		return ciutat;
	}
	
	public static int ObtenirID_Puntrecollida(ConbdXML conn,String PuntRecollida,int IDPuntRecollida) {
		return IDPuntRecollida;
	}
	public static int ObtenirPlacesDisponibles(ConbdXML conn,int idvolseleccionat,int placesdisp) {
		return placesdisp;
	}
	public static String ObtenirID_Estat(ConbdXML conn,String Estat) {
		return Estat;
	}
	public static int ObtenirID_Localitzacio(ConbdXML conn,String ciutat,int ID) {
		return ID;
	}

	distribuciovols cercarVolClient(ConbdXML conn, int id);
	
	public ArrayList<String> cercarTotsVolsClient(ConbdXML conn, int id);
	
}
