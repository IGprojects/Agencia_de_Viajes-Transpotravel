package model;

import java.io.File; 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConbdXML {

	// Variables
	Connection connexio = null;
	private Statement stm;
	private String sql;
	private ResultSet rst;
	
	private String ip;
	private String port;
	private String nom;
	private String usuari;
	private String contrasenya;

	
	// Constructor
	public ConbdXML() {

	}	
	
	// Getters i Setters
	public String getSql() {
		return sql;
	}
	
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	// Metodes
	public Connection getConexio() {
		
		try {
			
			// Declarem e Inicialitzem una nova instancia
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();

			// Declarem e Inicialitzem un nou DocumentBuilder amb la instancia de factory
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Obtenim l'archiu
			Document document = builder.parse(new File("Dades.xml"));

			// Obtenim l'arrel
			Element root = document.getDocumentElement();
			//System.out.println(document.getDocumentElement().getNodeName());
			
			// Obtenim les etiquetes filles (IDs, noms, paisos)
			NodeList list = root.getElementsByTagName("conexio");
			
			//System.out.println(list.getLength());
			for (int temp = 0; temp < list.getLength(); temp++) {
				Node nNode = list.item(temp);
	            Element eElement = (Element) nNode;
	            ip=eElement.getElementsByTagName("ip").item(0).getTextContent();
	            port=eElement.getElementsByTagName("port").item(0).getTextContent();
	            nom=eElement.getElementsByTagName("nom").item(0).getTextContent();
	            usuari=eElement.getElementsByTagName("usuari").item(0).getTextContent();
	            contrasenya=eElement.getElementsByTagName("contrasenya").item(0).getTextContent();

            }
			
			
		}catch(IOException | SAXException | ParserConfigurationException e) {
            System.out.println(e);
        } 
		

		Properties props = new Properties();		
		props.put("user", usuari);
		props.put("password", contrasenya);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + nom,props);
			return conn;
			
		}catch(Exception e) {
			
			System.out.println("Error base de dades " + e.getMessage());
			return null;
			
		}
		
		
	}
	
	
	
	
	
	
	/*public ResultSet Consultar_DB(String sql) { // SELECT
		
		try {
			
			// Declarem e Inicialitzem una nova instancia
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();

			// Declarem e Inicialitzem un nou DocumentBuilder amb la instancia de factory
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Obtenim l'archiu
			Document document = builder.parse(new File("Dades.xml"));

			// Obtenim l'arrel
			Element root = document.getDocumentElement();
			
			// Obtenim les etiquetes filles (IDs, noms, paisos)
			NodeList list = root.getElementsByTagName("db");
			
			for (int i = 0; i < list.getLength(); i++) {
			    Element lan =  (Element) list.item(i);
				NodeList clist = lan.getChildNodes();
				for (int j = 0; j < clist.getLength(); j++) {
					Node c = clist.item(j);
					if (c instanceof Element) {
						if (c.getNodeName() == "ip") {
							ip = c.getTextContent();
						}
						
						else if (c.getNodeName() == "port") {
							port = c.getTextContent();
						}
						
						else if (c.getNodeName() == "nom") {
							nom = c.getTextContent();
						}
						
						else if (c.getNodeName() == "usuari") {
							usuari = c.getTextContent();
						}
						
						else if (c.getNodeName() == "contrasenya") {
							contrasenya = c.getTextContent();
						}
					}
				}				
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			connexio = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + nom, usuari, contrasenya);
			System.out.println(connexio);
			stm = connexio.createStatement();
			rst = stm.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Error de Conexió");
		}
				
		return rst;
		
	}*/
		
}

