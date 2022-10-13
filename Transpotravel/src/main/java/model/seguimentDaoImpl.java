package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class seguimentDaoImpl implements seguimentDAO {

	static String sql = "SELECT * FROM seguiment;";

	public static int Tots(ConbdXML conn, List<seguiment> llista) {
		
			try {
				
				PreparedStatement ps = conn.getConexio().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					
					String idEstat = rs.getString("idEstat");

					seguiment seguiment = new seguiment(0, null, null,idEstat);
					llista.add(seguiment);
					
				}
						
			}catch(Exception e) {
				
				System.out.println("ERROR de Consulta");
				
			}
			
		
			if (llista.size() == 0) {
				
				return 0;
				
			}

			else {
				
				return (llista.size() + 1);
				
			}
			
		}
	
	
	
	@Override
	public seguiment cercaArticle(ConbdXML conn, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(ConbdXML conn, seguiment art) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ConbdXML conn, int id, seguiment art) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ConbdXML conn, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
