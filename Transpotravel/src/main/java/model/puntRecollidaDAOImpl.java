package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public class puntRecollidaDAOImpl implements puntRecollidaDAO {

	@Override
	public puntRecollida cercaPuntRecollida(ConbdXML conn, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(ConbdXML conn, puntRecollida punt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ConbdXML conn, int id, puntRecollida punt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ConbdXML conn, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void insertarPunt(ConbdXML conn,int idlocalitzacio,String Adreca,String Descripcio) {
    	
		String sql = "insert into transpotravelv2.puntrecollida(idLocalitzacio,adreca,descripcio) values ("+idlocalitzacio+",'"+Adreca+"','"+Descripcio+"');";
	    	PreparedStatement pst = null;
	    	
	    	try {
	    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	    		
	    		
	    	}catch (Exception e) {
	    		
	    		System.out.println("ERROR - distribuciovols controller - insertar punt" + e);
	    		
	    	}
	}
	
	public static int CercarIdLocalitzacioPunt(ConbdXML conn,String NomLocalitzacio) {
		String sql2 = "SELECT * FROM transpotravelv2.localitzacio where ciutat='"+NomLocalitzacio+"';";
		int id=0;
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				 id = rs.getInt("localitzacio.idLocalitzacio");
				
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR en el Buscar Id De LA Localitzacio");
			
		}

		return id;
	} 
	
	public static void ComboBoxPuntLocalitzacions(ConbdXML conn,List<String> ciutats) {
		
		String sql2 = "SELECT localitzacio.ciutat FROM transpotravelv2.localitzacio;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String ciutat = rs.getString("localitzacio.ciutat");
				ciutats.add(ciutat);
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR en el Combobox ciutats");
			
		}

		
	}
	
	public static void ActualitzarPunt(ConbdXML conn,int puntActualitzar,String Adreccanova) {
		
		String sql2 = "update puntrecollida set adreca='"+Adreccanova+"' where idLocalitzacio="+puntActualitzar+";";
    	PreparedStatement pst = null;

		try {
			
			pst = conn.getConexio().prepareStatement(sql2);
    		pst.execute();
			
					
		}catch(Exception e) {

			System.out.println("ERROR En l'actualitzacio de l'estat del vol");
			
		}
	}
	
	
	public static void ComboBoxPuntRecollida(ConbdXML conn,List<String> punts,String idDesti) {
		
		String sql2 = "SELECT localitzacio.ciutat,puntrecollida.adreca FROM transpotravelv2.puntrecollida  INNER JOIN localitzacio \r\n" + 
				"ON puntrecollida.idLocalitzacio = localitzacio.idLocalitzacio where localitzacio.ciutat='"+idDesti+"';";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String ciutat = rs.getString("localitzacio.ciutat");
				String adreca = rs.getString("puntrecollida.adreca");
				String resultatFinal = ciutat + " - " + adreca;
				punts.add(resultatFinal);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR en el Combobox puntsRecollida");
			
		}

		
	}
	
	public static void ComboBoxPuntRecollidaAct(ConbdXML conn,List<String> punts,String idDesti) {
		
		String sql2 = "SELECT localitzacio.ciutat,puntrecollida.adreca FROM transpotravelv2.puntrecollida  INNER JOIN localitzacio \r\n" + 
				"ON puntrecollida.idLocalitzacio = localitzacio.idLocalitzacio where localitzacio.ciutat=(Select localitzacio.ciutat from puntrecollida\r\n" + 
				" inner join localitzacio on puntrecollida.idLocalitzacio=localitzacio.idLocalitzacio where puntrecollida.adreca='"+idDesti+"');";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String ciutat = rs.getString("localitzacio.ciutat");
				String adreca = rs.getString("puntrecollida.adreca");
				String resultatFinal = ciutat + " - " + adreca;
				punts.add(resultatFinal);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR en el Combobox puntsRecollida");
			
		}

		
	}
	
	public static void ComboBoxPuntRecollidaAdmin(ConbdXML conn,List<String> punts) {
		
		String sql2 = "SELECT localitzacio.ciutat,puntrecollida.adreca FROM transpotravelv2.puntrecollida  INNER JOIN localitzacio \r\n" + 
				"ON puntrecollida.idLocalitzacio = localitzacio.idLocalitzacio;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String ciutat = rs.getString("localitzacio.ciutat");
				String adreca = rs.getString("puntrecollida.adreca");
				String resultatFinal = ciutat + " - " + adreca;
				punts.add(resultatFinal);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR en el Combobox puntsRecollida");
			
		}

		
	}
	
	@Override
	public int cercarPuntRecollidaInsertatPelClient(ConbdXML conn, String nomPunt) {
		int puntrecollidatrobat=1;
		String Parts[]=nomPunt.trim().split("-");
		String sql = "";
		
		if (Parts.length == 2) {
			sql = "select idPunt from puntrecollida where adreca = '"+Parts[1].trim()+"';";
		}

		else {
			sql = "select idPunt from puntrecollida where adreca = '"+Parts[0]+"';";
		}
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				puntrecollidatrobat = rs.getInt("idPunt");
			
			}
		}catch (Exception e) {
    		
    		System.out.println("ERROR - En la busqueda del punt de recollida");
    		
    	}
		
		return puntrecollidatrobat;
	
	}
	
	public static void CercarPunts(ConbdXML conn,List<puntRecollida> llista2) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM puntrecollida;";
				
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int idPunt = rs.getInt("idPunt");
				int idLocalitzacio = rs.getInt("idLocalitzacio");
				String adreca = rs.getString("adreca");
				String descripcio = rs.getString("descripcio");
	
				
				
				puntRecollida afegir = new puntRecollida(idPunt,idLocalitzacio,adreca,descripcio);

				llista2.add(afegir);			
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR En el Cercar vols oferta: " + e);
			
		}
				
	}
	
	public static void eliminarPunt(ConbdXML conn,String idpunt) {
    	
    	String sql = "delete from puntrecollida where idPunt="+idpunt+";";
    	PreparedStatement pst = null;
  
   	
    	try {
    		
    		pst = conn.getConexio().prepareStatement(sql);
    		pst.execute();
    		
    		
    		
    	}catch (Exception e) {
    		
    		System.out.println("ERROR - distribuciovols controller - eliminar punt" + e);
    		
    	}
	}

}
