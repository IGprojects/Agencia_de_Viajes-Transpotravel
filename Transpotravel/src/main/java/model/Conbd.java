package model;

import java.sql.*;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conbd {
	
	Connection conn = null;
	private String servidor = "localhost";
	private String baseDades = "TranspotravelV2?useSSL=false & useLegacyDatetimeCode = false & serverTimezone = UTC";
	private String usuari = "root";
	private String password = "root";
	
	public Connection getConexio() {
		
		Properties props = new Properties();		
		props.put("user", usuari);
		props.put("password", password);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + baseDades,props);
			
			return conn;
			
		}catch(Exception e) {
			
			System.out.println("Error base de dades " + e.getMessage());
			return null;
			
		}
		
		
	}
	
}
