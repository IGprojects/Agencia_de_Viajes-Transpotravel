package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class desplacamentDAOImpl implements desplacamentDAO {

	@Override
	public boolean afegirClientADesplacament(ConbdXML conn, int usuari, int iddistribuciovols, int numequipatges,int places) {
		//Aqui el punt de recollida no te sentit jaque cada equipatge ja en te un assignat
		//String sql0="select * from desplacament where iddistribuciovols="+iddistribuciovols+" and dni="+usuari+";";
		String sql = "insert into desplacament(dni,iddistribuciovols,numequipatges,numplaces) values ("+usuari+","+iddistribuciovols+","+numequipatges+","+places+")";
		
		PreparedStatement pst = null;
    	//int placesactuals=0;
		/*PreparedStatement ps = conn.getConexio().prepareStatement(sql0);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			placesactuals = rs.getInt("numplaces");				
		}
		
		if(placesactuals==0) {*/
    	try {
    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
				return true;

			
    		
			
    		
    	}catch (Exception e) {
    		
    		return false;
    		
    	}
	}

}
