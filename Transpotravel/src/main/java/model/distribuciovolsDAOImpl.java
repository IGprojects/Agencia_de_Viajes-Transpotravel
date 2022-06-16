package model;
import java.sql.ResultSet;        
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;

//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import java.time.LocalDateTime;


public class distribuciovolsDAOImpl implements distribuciovolsDAO{

	//static String sql = "SELECT * FROM distribuciovols;";

	
	public static void ComboBoxPuntsRecollida(ConbdXML conn,List<String> puntsrecollida) {
		String sql2 = "Select adreca from puntrecollida;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				
				String nompuntrecollida = rs.getString("adreca");
				
				puntsrecollida.add(nompuntrecollida);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox Punts de Recollida");
			
		}
	}
	
	
	
	public static void ComboBoxVols(ConbdXML conn,List<String> ciutats) {
		String sql2 = "Select ciutat from localitzacio;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String NomCiutat = rs.getString("ciutat");
				
				ciutats.add(NomCiutat);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox Totes les Ciutats");
			
		}
	}
		
	public static void ComboBoxDesti(ConbdXML conn,List<String> destins) {
		
		String sql2 = "select localitzacio.ciutat from distribuciovols inner join localitzacio on distribuciovols.iddesti=localitzacio.idLocalitzacio;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String iddestins = rs.getString("localitzacio.ciutat");
				
				destins.add(iddestins);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox desti");
			
		}

		
	}
	
	
	public static void ActualitzarEstatVol(ConbdXML conn,int volActualitzar,String EstatNou) {
		
		String sql2 = "update distribuciovols set estat='"+EstatNou+"' where iddistribuciovols="+volActualitzar+";";
    	PreparedStatement pst = null;

		try {
			
			pst = conn.getConexio().prepareStatement(sql2);
    		pst.execute();
			
					
		}catch(Exception e) {

			System.out.println("ERROR En l'actualitzacio de l'estat del vol");
			
		}
	}
	
	
	public static void ComboBoxOrigen(ConbdXML conn,List<String> origens) {
		String sql2 = "select localitzacio.ciutat from distribuciovols inner join localitzacio on distribuciovols.idorigen=localitzacio.idLocalitzacio;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String idorigens = rs.getString("localitzacio.ciutat");
				
				origens.add(idorigens);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox origen");
			
		}

		
	}
	
	
	public static void ComboBoxEstats(ConbdXML conn,List<String> Estats) {
		String sql2 = "select descripcio from estat;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String estat = rs.getString("descripcio");
				
				Estats.add(estat);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox Estats");
			
		}

		
	}
	
	
	
	
	public static void cercarVols(ConbdXML conn,List<distribuciovols> llista2) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM distribuciovols;";
				
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int iddistribuciovols = rs.getInt("iddistribuciovols");
				String idorigen = rs.getString("idorigen");
				String iddesti = rs.getString("iddesti");
				int preu = rs.getInt("preu");
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
				int oferta = rs.getInt("oferta");
				int idpuntrecollida = rs.getInt("idPuntRecollida");
				String descripcio = rs.getString("descripcio");
				String estat = rs.getString("estat");
				int persones = rs.getInt("personas");
				int pes = rs.getInt("pes");

				
				distribuciovols afegir = new distribuciovols(iddistribuciovols, idorigen,iddesti, preu,horaArribada,horaSortida,oferta,idpuntrecollida,descripcio,null,estat,persones,pes);

				llista2.add(afegir);			
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR En el Cercar vols oferta: " + e);
			
		}
				
	}
	
	public static void cercarVols_nomciutat(ConbdXML conn,List<distribuciovols> llista2) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM distribuciovols where oferta = 0;";
				
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String idorigen="";
				String iddesti ="";
				
				int iddistribuciovols = rs.getInt("iddistribuciovols");
				idorigen=ObtenirCiutat(conn,idorigen,Integer.parseInt(rs.getString("idorigen")));
				iddesti=ObtenirCiutat(conn,iddesti,Integer.parseInt(rs.getString("iddesti")));
				int preu = rs.getInt("preu");
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
				int oferta = rs.getInt("oferta");
				int idpuntrecollida = rs.getInt("idPuntRecollida");
				String descripcio = rs.getString("descripcio");
				String estat = rs.getString("estat");
				int persones = rs.getInt("personas");
				int pes = rs.getInt("pes");
				
				distribuciovols afegir = new distribuciovols(iddistribuciovols, idorigen,iddesti, preu,horaArribada,horaSortida,oferta,idpuntrecollida,descripcio,null,estat,persones,pes);

				llista2.add(afegir);			
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR En el Cercar vols oferta: " + e);
			
		}
				
	}
	
	public ArrayList<String> cercarTotsVolsClient(ConbdXML conn, int id) {
		
		ArrayList<String> stringRetorn = new ArrayList<String>();
		
		String sql = "select distribuciovols.iddistribuciovols, distribuciovols.preu,distribuciovols.horaSortida,distribuciovols.horaArribada,A.ciutat,B.ciutat,numequipatges,numplaces from desplacament " + 
				"inner join distribuciovols on desplacament.iddistribuciovols=distribuciovols.iddistribuciovols " + 
				"inner join localitzacio as A on distribuciovols.idorigen=A.idLocalitzacio " + 
				"inner join localitzacio as B on distribuciovols.iddesti=B.idLocalitzacio " + 
				"where desplacament.dni='" + id + "';";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
						
			while(rs.next()) {
				
				String idPunt = rs.getString("iddistribuciovols");
				String origen = rs.getString("A.ciutat");
				String desti = rs.getString("B.ciutat");
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
				int preu = rs.getInt("preu");
				int equipatges = rs.getInt("numequipatges");
				int places = rs.getInt("numplaces");
								
				stringRetorn.add(i, idPunt + "---" + origen + "---" + desti + "---" + horaSortida + "---" + horaArribada + "---"
						+ preu + "---" + equipatges + "---" + places);
				
			}
			
		}catch(Exception e) {
			System.out.println("ERROR AL CERCAR ELS VOLS COMPRATS: " + e);	
		}
		
		return stringRetorn;
		
	}
	
	@Override
	public distribuciovols cercarVolClient(ConbdXML conn, int id) {
		
		distribuciovols distribuciovolsClient = null;
		
		String sql = "select distribuciovols.iddistribuciovols,A.ciutat, B.ciutat, estat.descripcio, " + 
				"distribuciovols.preu, distribuciovols.horaSortida, distribuciovols.horaArribada " +
				"from transpotravelv2.distribuciovols " + 
				"inner join estat on distribuciovols.estat = estat.idEstat " + 
				"inner join localitzacio as A on distribuciovols.idorigen = A.idLocalitzacio " + 
				"inner join localitzacio as B on distribuciovols.iddesti = B.idLocalitzacio " + 
				"where iddistribuciovols = " + id + ";";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				String idPunt = rs.getString("iddistribuciovols");
				String origen = rs.getString("A.ciutat");
				String desti = rs.getString("B.ciutat");
				String estat = rs.getString("descripcio");	
				int preu = rs.getInt("preu");
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
				int persones = rs.getInt("personas");
				int pes = rs.getInt("pes");
				
				distribuciovolsClient = new distribuciovols(Integer.parseInt(idPunt), origen, desti, preu, horaArribada, horaSortida, 0, 0, " ", null,estat,persones,pes);
			}
			
		}catch(Exception e) {
			System.out.println("ERROR AL CERCAR VOL: " + e);	
		}
		
		return distribuciovolsClient;
		
		}
	
	
	public static void eliminarVol(ConbdXML conn,String idvol) {
    	
    	String sql = "delete from distribuciovols where iddistribuciovols="+idvol+";";
    	
    	PreparedStatement pst = null;
  
   	
    	try {
    		
    		pst = conn.getConexio().prepareStatement(sql);
    		pst.execute();
    		
    		
    		
    	}catch (Exception e) {
    		
    		System.out.println("ERROR - distribuciovols controller - eliminar vol" + e);
    		
    	}
	}
	
	public static void insertarVol(ConbdXML conn,int idorigen,int iddesti,int preu,LocalDateTime horaSortida,LocalDateTime horaArribada,int oferta,int IdPuntRecollida,String Descripcio,int personas,int pes) {
    	
		String sql = "insert into distribuciovols(idorigen,iddesti,preu,horaSortida,horaArribada,oferta,idPuntRecollida,descripcio,estat,personas,pes) values ("+idorigen+","+iddesti+","+preu+",'"+horaSortida+"','"+horaArribada+"',"+oferta+","+IdPuntRecollida+",'"+Descripcio+"',1,"+personas+","+pes+");";
	    	PreparedStatement pst = null;
	    	
	    	try {
	    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	    		
	    		
	    	}catch (Exception e) {
	    		
	    		System.out.println("ERROR - distribuciovols controller - insertar vol" + e);
	    		
	    	}
	}
	
	
	public static void ActualitzarPlaces_Pes(ConbdXML conn,int persones,int pes,int idvol) {
    	System.out.println("Estic dins");
		String sql = "update distribuciovols set personas=personas-"+persones+",pes=pes-"+pes+" where iddistribuciovols="+idvol+";";
	    	PreparedStatement pst = null;
	    	
	    	try {
	        	System.out.println("Estic dins1");

	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	        	System.out.println("Estic dins2");

	    		
	    	}catch (Exception e) {
	    		
	    		System.out.println("ERROR - distribuciovols controller - Actualitzar places y pesdel vol" + e);
	    		
	    	}
	}
    	
	public static int ObtenirID_Puntrecollida(ConbdXML conn,String PuntRecollida,int IDPuntRecollida) {
		String sql2 = "select idPunt from puntrecollida where adreca='"+PuntRecollida+"';";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				IDPuntRecollida = rs.getInt("idPunt");
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En otenur idpuntrecollida");
			
		}
		return IDPuntRecollida;
	}
	
	public static int ObtenirPlacesDisponibles(ConbdXML conn,int idvolseleccionat,int placesdisp) {
		String sql2 = "select personas from distribuciovols where iddistribuciovols="+idvolseleccionat+";";

		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				placesdisp = rs.getInt("personas");
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En otenir places disp");
			
		}
		return placesdisp;
	}
	
	public static String ObtenirID_Estat(ConbdXML conn,String Estat) {
		String sql2 = "select idEstat from estat where descripcio='"+Estat+"';";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int idEstat_Obtingut = rs.getInt("idEstat");
				Estat=String.valueOf(idEstat_Obtingut);
				//Despues s'ha de fer un parseint quan es passi a la consult pq la id es un int
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En obtenir la id del estat");
			
		}
		return Estat;
	}
	
	
	
	public static void ObtenirVolsSeleccionats(ConbdXML conn,int idDesti,int idOrigen,List<distribuciovols> llistaVolsFiltrats) {
		String sql2 = "select * from transpotravelv2.distribuciovols where idorigen="+idOrigen+" and iddesti="+idDesti+" and personas>0;";

		try {
			System.out.println(sql2);
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int iddistribuciovols = rs.getInt("iddistribuciovols");
				String idorigen = rs.getString("idorigen");
				String iddesti = rs.getString("iddesti");
				int preu = rs.getInt("preu");
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
				int oferta = rs.getInt("oferta");
				int idpuntrecollida = rs.getInt("idPuntRecollida");
				String descripcio = rs.getString("descripcio");
				String estat = rs.getString("estat");
				int persones = rs.getInt("personas");
				int pes = rs.getInt("pes");
				
				descripcio = ObtenirCiutat(conn,descripcio,Integer.parseInt(idorigen));
				estat = ObtenirCiutat(conn,estat,Integer.parseInt(iddesti));
			
				distribuciovols afegir = new distribuciovols(iddistribuciovols, descripcio,estat, preu,horaArribada,horaSortida,oferta,idpuntrecollida,descripcio,null,estat,persones,pes);
				llistaVolsFiltrats.add(afegir);
			
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En Seleccionar els vols filtrats");
			
		}
	}
	
	public static int ObtenirID_Localitzacio(ConbdXML conn,String ciutat,int ID) {
		String sql2 = "select idLocalitzacio from localitzacio where ciutat='"+ciutat+"';";
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int idlocalitzacio = rs.getInt("idLocalitzacio");
				ID=idlocalitzacio;
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En l'obtencio de la id de localitzacio");
			
		}
		return ID;
	}
	
	
	
	public static String ObtenirCiutat(ConbdXML conn,String ciutat,int ID) {
		String sql2 = "select ciutat from localitzacio where idLocalitzacio="+ID+";";
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String CiutatObtenida=rs.getString("ciutat");
				ciutat=CiutatObtenida;
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En l'obtencio la ciutat");
			
		}
		return ciutat;
	}
}
