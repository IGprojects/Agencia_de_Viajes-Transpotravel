package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.text.html.ImageView;

public interface ClientDAOImple {

	static String sql = "SELECT * FROM article;";

	public static int Tots(ConbdXML conn, List<ImageView> llista) {
		
			try {
				
				PreparedStatement ps = conn.getConexio().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					int idArticle = rs.getInt("id_article");
					String descripcio = rs.getString("descripcio");
					double preu_compra = rs.getFloat("preu_compra");
					double preu_venta = rs.getFloat("preu_venda");
					
				}
						
			}catch(Exception e) {
				
				System.out.println("ERROR");
				
		}
			
			if (llista.size() == 0) {
				
				return 0;
				
			}

			else {
				
				return (llista.size() + 1);
				
			}	
		}
	
	
}
