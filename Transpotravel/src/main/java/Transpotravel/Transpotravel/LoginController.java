package Transpotravel.Transpotravel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Conbd;
import model.ConbdXML;
import model.client;

public class LoginController implements Initializable{
	
	@FXML
    private Label LoginIncorrecte;
	
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistre;

    @FXML
    private PasswordField contrasenyaLogin;

    @FXML
    private TextField correuLogin;
    
    @FXML
    private ImageView imgVol;
    
    private Conbd conexio;
    
    static String correu = " ";
    
    static String idUsuari = " ";
    
    @FXML
    void loginBntOnAction(ActionEvent event) {
    	
    	//LoginIncorrecte.setText("Login incorrecte, torna a intentar-ho.");
    	
    	if(correuLogin.getText().isBlank() == false && contrasenyaLogin.getText().isBlank() == false) {
    		
    		validarLogin();
    		
    	}else {
    		
    		LoginIncorrecte.setText("       Posa l'usuari i la contrasenya");
        	
    	}
    	
    	
    	
    } 
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	   	
    	File fileLogin = new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\Imatges\\viatgeDef.jpg");
        Image imageLogin = new Image(fileLogin.toURI().toString());
        imgVol.setImage(imageLogin);
   
    }
    
    @FXML
    private void pantallaRegistre() throws IOException {
        App.setRoot("registre");
    }
    	
    
    void validarLogin() {
    	
    	ConbdXML conn = new ConbdXML();
    	Connection connectDB = conn.getConexio();

    	correu = correuLogin.getText();
    	String contrasenya = contrasenyaLogin.getText();
    	
    	String sql = "SELECT dni FROM transpotravelv2.persona where correu = '"+correu+"' and contrasenya = '"+contrasenya+"';";
    	
    	if(correu.equalsIgnoreCase("admin") && contrasenya.equalsIgnoreCase("admin")) {
    		
    		try {
    			
				App.setRoot("AdminVuelos");
				
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
    		
    	}else{
    			
    		try {
        		
        		Statement st = connectDB.createStatement();
        		ResultSet queryResult = st.executeQuery(sql);

    	    			
        		if(queryResult.next()) {
        			
        			idUsuari = queryResult.getString("dni");
        			App.setRoot("TranspoTravelDef");
        		
        				
        		}else {
        				
        			LoginIncorrecte.setText("Login incorrecte, torna a intentar-ho."); //prova2
        				
        		}
        		
        	}catch (Exception e) {
        		
        		e.printStackTrace();
        		e.getCause();
        		
        	}
    	
    	}
       	
    }
   
}
