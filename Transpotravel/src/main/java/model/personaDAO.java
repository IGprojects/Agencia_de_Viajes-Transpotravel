package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface personaDAO {
	
	persona cercaPersona(ConbdXML conn,int id);
	boolean create(ConbdXML conn,persona art);
	boolean update(ConbdXML conn,int id,persona art);
	boolean delete(ConbdXML conn,int id);
	
}
