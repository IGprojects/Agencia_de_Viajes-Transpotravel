package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EquipatgeDAOImpl implements EquipatgeDAO {
	
	@Override
	public equipatge cercarEquipatge(ConbdXML conn, int id) {
		
		equipatge equipatgeClient = null;
		
		String sql = "select * from equipatge";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				String puntRecollida = rs.getString("adreca");
				int idEquipatge = rs.getInt("idEquipatge");
				int pes = rs.getInt("pes");
				String dni = rs.getString("dni");
				String origen = rs.getString("A.ciutat");
				String desti = rs.getString("B.ciutat");
				String estat = rs.getString("descripcio");
				
				equipatgeClient = new equipatge(idEquipatge, pes,dni,origen,desti,estat,puntRecollida);
			}
					
		}catch(Exception e) {	
			
			System.out.println("ERROR AL CERCAR EQUIPATGE: " + e);
			
		}
		
		
				
		return equipatgeClient;
	}
	@Override
	public void eliminarEquipatge(ConbdXML conn,int idequipatge,int pes) {
    	
    	String sql = "delete from equipatge where idEquipatge="+idequipatge+";";
    	String sql2 = "update distribuciovols set pes=pes+"+pes+" where distribuciovols.iddistribuciovols=(select idDistrivuciovol from equipatge where equipatge.idEquipatge="+idequipatge+");";
    	PreparedStatement pst = null;
  
   	
    	try {
    		
    		pst = conn.getConexio().prepareStatement(sql);
    		pst.execute();
    		pst = conn.getConexio().prepareStatement(sql2);
    		pst.execute();
    		
    		
    	}catch (Exception e) {
    		
    		System.out.println("ERROR - equipatge controller - eliminar equipatge" + e);
    		
    	}
	}

	@Override
	public void actualitzarEquipatge(ConbdXML conn,int idequipatge,int idpunt) {
    	
    	String sql = "update equipatge set idPunt="+idpunt+" where idEquipatge="+idequipatge+";";
    	PreparedStatement pst = null;
  
   	
    	try {
    		
    		pst = conn.getConexio().prepareStatement(sql);
    		pst.execute();

    		
    		
    	}catch (Exception e) {
    		
    		System.out.println("ERROR - equipatge controller - actualitzar equipatge" + e);
    		
    	}
	}
	
	@Override
	public ArrayList<equipatge> cercarEquipatgePerUsuari(ConbdXML conn, int idUsuari, int idVol) {
		
		ArrayList<equipatge> equipatgesClient = new ArrayList<equipatge>();
		
		String sql = "select equipatge.idEquipatge, equipatge.pes, equipatge.adrecaPerz, puntrecollida.adreca " + 
				"from equipatge " + 
				"inner join puntrecollida on equipatge.idPunt = puntrecollida.idPunt " + 
				"where dni = " + idUsuari + " and idDistrivuciovol = " + idVol + ";";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				String puntRecollida = rs.getString("adreca");
				int idEquipatge = rs.getInt("idEquipatge");
				int pes = rs.getInt("pes");
				String puntRecollidaPerz = rs.getString("adrecaPerz");
				
				if (puntRecollidaPerz == null) {
					equipatgesClient.add(new equipatge(idEquipatge, pes,null,null,null,null,puntRecollida));
				}
				
				else {
					equipatgesClient.add(new equipatge(idEquipatge, pes,null,null,null,null,puntRecollidaPerz));
				}
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR AL CERCAR EQUIPATGE: " + e);
			
		}
		
		return equipatgesClient;

	}
	
	@Override
	public boolean afegirEquipatgeADesplacament(ConbdXML conn,int usuari, int pes, String punt, int iddistribuciovol) {	
		
		puntRecollidaDAO daoPR = new puntRecollidaDAOImpl();
		int puntFinal = daoPR.cercarPuntRecollidaInsertatPelClient(conn, punt);
		
		if (puntFinal == 1) {
			String sql = "insert into equipatge (dni,pes,idEstat,idPunt,idDistrivuciovol,adrecaPerz) values('"+usuari+"','"+pes+"',1,"+punt+","+iddistribuciovol+",null);";
	    	PreparedStatement pst = null;
			System.out.println(sql);

	    	try {
	    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	    		return true;
	    		
	    	}catch (Exception e) {
				System.out.println("ERROR En insertar equipatges");

	    		return false;
	    		
	    	}
	    	
		}
		
		else {
			String sql = "insert into equipatge (dni,pes,idEstat,idPunt,idDistrivuciovol,adrecaPerz) values('"+usuari+"','"+pes+"',1,"+punt+","+iddistribuciovol+",'"+punt+"');";
			System.out.println(sql);

	    	PreparedStatement pst = null;
	    	
	    	try {
	    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	    		return true;
	    		
	    	}catch (Exception e) {
				System.out.println("ERROR En insertar equipatges");

	    		return false;
	    		
	    	}
	    	
		}
    	
	}
	
}
