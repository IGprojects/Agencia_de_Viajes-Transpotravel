package model;

import java.util.List;

public interface seguimentDAO {
	
public static int Tots(Conbd conn, List<seguiment> llista){
		
		return 0;
		
	}
	
	seguiment cercaArticle(ConbdXML conn,int id);
	boolean create(ConbdXML conn,seguiment art);
	boolean update(ConbdXML conn,int id,seguiment art);
	boolean delete(ConbdXML conn,int id);

}
