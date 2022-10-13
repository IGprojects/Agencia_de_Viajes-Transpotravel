package Transpotravel.Transpotravel;
import java.io.FileInputStream;   
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Conbd;
import model.ConbdXML;
import model.distribuciovols;
import model.distribuciovolsDAOImpl;
import model.equipatge;
import model.puntRecollida;
import model.puntRecollidaDAOImpl;

public class AdminVuelosController implements Initializable{

    @FXML
    private Button ButoonBorrarPunt;
	
    @FXML
    private TableColumn<distribuciovols, String> ColumnIdVol;
    
    @FXML
    private TableColumn<puntRecollida, String> ColumnPuntAdrecaBorr;

    @FXML
    private TableColumn<puntRecollida, String> ColumnPuntDescBorr;

    @FXML
    private TableColumn<puntRecollida, Integer> ColumnPuntIdBorr;

    @FXML
    private TableColumn<puntRecollida, Integer> ColumnPuntLocaliBorr;
    
    @FXML
    private TableColumn<distribuciovols, Integer> ColumnaIDVOLestat;

    @FXML
    private TableColumn<distribuciovols, String> ColumndEstatEstat;
    
    @FXML
    private TableColumn<distribuciovols, String> ColumnorigenEstat;

    @FXML
    private TableColumn<distribuciovols, LocalDateTime> ColumndataarribadaEstat;

    @FXML
    private TableColumn<distribuciovols, LocalDateTime> Columndataarribada;

    @FXML
    private TableColumn<distribuciovols, LocalDateTime> Columndatasortida;

    @FXML
    private TableColumn<distribuciovols, LocalDateTime> ColumndatasortidaEstat;

    @FXML
    private TableColumn<distribuciovols, String> Columndesti;
    
    @FXML
    private TableColumn<distribuciovols, String> ColumndestiEstat;

    @FXML
    private TableColumn<distribuciovols, String> Columnorigen;

    @FXML
    private TableColumn<distribuciovols, Integer> Columnpreu;
    
    @FXML
    private ComboBox<String> Comboboxpuntsact;
    
    @FXML
    private Button IDButtonActualitzarEstats;

    @FXML
    private ComboBox<String> IDComboboxEstats;
    

    @FXML
    private TableView<puntRecollida> PuntsBorrats;
    
    @FXML
    private Button btnActualitzar;

    
    @FXML
    private Button IDButtonActualitzarPunts;

    @FXML
    private TableView<distribuciovols> TaulaEstatsVolsEstats;

    @FXML
    private TextField TextDisplayIDvol;

    @FXML
    private Button ButoonBorrar;
    
    @FXML
    private Button buttonCrearPunt;

    @FXML
    private Button buttonCrearVol;

    @FXML
    private CheckBox checkboxoferta;
    
    @FXML
    private ComboBox<String> combobosorigen;
    
    @FXML
    private ComboBox<String> comboboxcrearpuntrecollida;

    @FXML
    private ComboBox<String> comboboxdesti;

    @FXML
    private ComboBox<String> comboboxpuntrecollida;
    
    @FXML
    private TextField inputadrecapunt;

    @FXML
    private DatePicker inputdatarribada;

    @FXML
    private DatePicker inputdatasortida;

    @FXML
    private TextField inputdescripcio;
    
    @FXML
    private TextField inputdescripciopunt;
    
    @FXML
    private TextField inputpreu;
    
    @FXML
    private TextField inputidborrar;
    
    @FXML
    private TextField inputidborrarpunt;
    
    @FXML
    private TextField inputnovaadrecaact;
    
    @FXML
    private TextField inputpersones;

    @FXML
    private TextField inputpes;

    @FXML
    private TextField inputtimearribada;

    @FXML
    private TextField inputtimesort;
    
    
    @FXML
    private TableView<distribuciovols> volsComprats;
	
 	
    @FXML
    void OnClickActualitzarEstatVol(ActionEvent event) {
    	
    	EstatNouSeleccionat=distribuciovolsDAOImpl.ObtenirID_Estat(conexio2,EstatNouSeleccionat);

    	distribuciovolsDAOImpl.ActualitzarEstatVol(conexio2, EstatIDVolSeleccionat, EstatNouSeleccionat);
    	
    	ObservableList <distribuciovols>llistaVolsEstats;
		llistaVolsEstats=FXCollections.observableArrayList();
	    	
	   
		distribuciovolsDAOImpl.cercarVols(conexio2, llistaVolsEstats);    
		TaulaEstatsVolsEstats.setItems(llistaVolsEstats);
		ColumnaIDVOLestat.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("iddistribuciovols"));
		ColumnorigenEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		ColumndestiEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		ColumndatasortidaEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		ColumndataarribadaEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		ColumndEstatEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("estat"));
		
    	
    }
    
    @FXML
    void OnClickActualitzarPunt(ActionEvent event) {
    	String NovaAddres="";
    	String Parts[]=Punt_AdrecaAct.split("-");
    	int punt=0;
    	punt=puntRecollidaDAOImpl.CercarIdLocalitzacioPunt(conexio2, Parts[0].trim());
    	NovaAddres=inputnovaadrecaact.getText();
    	System.out.println(Parts[0]);
    	puntRecollidaDAOImpl.ActualitzarPunt(conexio2, punt, NovaAddres);

		
    	
    }
    
    
    @FXML
    void OnClickActualitzar(ActionEvent event) {
    	
    	
    	ObservableList <distribuciovols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
	    	
	   
		distribuciovolsDAOImpl.cercarVols(conexio2, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddistribuciovols"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
		
    }
    
    @FXML
    void OnMouseClickMostrarIdVol(MouseEvent event) {
    	
    	distribuciovols volseleccionat=TaulaEstatsVolsEstats.getSelectionModel().getSelectedItem();
    	if(volseleccionat==null) {
    		TextDisplayIDvol.setText("Ningun Vol Seleccionat");
    	}else{
    		TextDisplayIDvol.setText("Vol "+volseleccionat.getIddistribuciovols()+" seleccionat");
    		EstatIDVolSeleccionat=volseleccionat.getIddistribuciovols();
    	}
    }
    
    
    @FXML
    void OnClickInsertarVol(ActionEvent event) {
    	Preu=Integer.parseInt(inputpreu.getText());
		dataEnt=inputdatarribada.getValue();
		dataSort=inputdatasortida.getValue();
		String partsarribada[]=inputtimearribada.getText().split(":");
		String partssortida[]=inputtimesort.getText().split(":");
		DataentCompleta=dataEnt.atTime(Integer.parseInt(partsarribada[0]), Integer.parseInt(partsarribada[1]));
		DataSortCompleta=dataSort.atTime(Integer.parseInt(partssortida[0]), Integer.parseInt(partssortida[1]));
		if(checkboxoferta.isSelected()==true){Oferta=1;}else{Oferta=0;};
		Desc=inputdescripcio.getText();
    	personas=Integer.parseInt(inputpersones.getText());
    	pes=Integer.parseInt(inputpes.getText());
    	String Parts[]=ID_PuntRecollida.split("-");

		
    	int ID1=0;
    	int ID2=0;
    	int IDPR=0;
    	LocalDateTime Data_TempsArribada=DataentCompleta;
    	LocalDateTime Data_TempsSortida=DataSortCompleta;
    	

    	ID1=distribuciovolsDAOImpl.ObtenirID_Localitzacio(conexio2, ID_VueloSeleccionat1,ID1);
    	ID2=distribuciovolsDAOImpl.ObtenirID_Localitzacio(conexio2, ID_VueloSeleccionat2,ID2);
    	IDPR=puntRecollidaDAOImpl.CercarIdLocalitzacioPunt(conexio2, Parts[0].trim());
    	if(ID1!=ID2&&ID2!=IDPR) {
    	distribuciovolsDAOImpl.insertarVol(conexio2, ID1, ID2, Preu, Data_TempsSortida, Data_TempsArribada,Oferta,IDPR,Desc,personas,pes);
    	}else {
    		
    		Alert missatge=new Alert(AlertType.ERROR);
			missatge.setTitle("DADES INCORRECTES");
			missatge.setHeaderText("El Desti i l'Origen no poden ser el mateix o el punt de recollida ha de pertanyer al desti seleccion!");
			missatge.showAndWait();
    	}
    	
    }
    
    @FXML
    void OnClickInsertarPunt(ActionEvent event) {
    	
    	
    	
    	String AdrecaPunt=inputadrecapunt.getText();
    	String DescripcioPunt=inputdescripciopunt.getText();
    	int idnoupunt=puntRecollidaDAOImpl.CercarIdLocalitzacioPunt(conexio2, ID_Punt);
    	
    	System.out.println(idnoupunt);
    	puntRecollidaDAOImpl.insertarPunt(conexio2, idnoupunt, AdrecaPunt, DescripcioPunt);
    }
    
    
    @FXML
    void OnClickBorrarVol(ActionEvent event) {    	
    	distribuciovolsDAOImpl.eliminarVol(conexio2, inputidborrar.getText());
    	
    	
    	
    	ObservableList <distribuciovols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
    	
		distribuciovolsDAOImpl.cercarVols(conexio2, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddistribuciovols"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
    }
    
    @FXML
    void OnClickBorrarPunt(ActionEvent event) {    	
    	puntRecollidaDAOImpl.eliminarPunt(conexio2, inputidborrarpunt.getText());
    	
    	
    	
    	ObservableList <puntRecollida>llistaPunts;
    	llistaPunts=FXCollections.observableArrayList();
    	
	    puntRecollidaDAOImpl.CercarPunts(conexio2, llistaPunts);    
	    PuntsBorrats.setItems(llistaPunts);
	    ColumnPuntIdBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,Integer>("idPuntRecollida"));
	    ColumnPuntLocaliBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,Integer>("idLocalitzacio"));
	    ColumnPuntAdrecaBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,String>("adreca"));
	    ColumnPuntDescBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,String>("descripcio"));
    }
    
    @FXML
    void OnClickRefrescarTaula(ActionEvent event) {    	
    	    	
    	ObservableList <distribuciovols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
    	
		distribuciovolsDAOImpl.cercarVols(conexio2, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddistribuciovols"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
    }
    
   
    
 	//private Conbd conexio2;
 	private ConbdXML conexio2;
 	//Punts
 	String ID_Punt="";
 	String Punt_AdrecaAct="";
 	//Vols
	int EstatIDVolSeleccionat=0;
    String EstatNouSeleccionat=" ";
 	String ID_VueloSeleccionat1="";
 	String ID_VueloSeleccionat2="";
 	int Preu;
 	int personas; 
 	int pes;
    LocalDate dataEnt;
    LocalDate dataSort;
    LocalDateTime DataentCompleta;
    LocalDateTime DataSortCompleta;
    String Desc="";
 	String ID_PuntRecollida="";
	int Oferta=0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	//conexio2 = new Conbd();	
    	conexio2 = new ConbdXML();	
    	
    	ObservableList <String> Punts_Ciutats;
    	Punts_Ciutats = FXCollections.observableArrayList();
    	puntRecollidaDAOImpl.ComboBoxPuntRecollidaAdmin(conexio2, Punts_Ciutats);
    	comboboxpuntrecollida.setItems(Punts_Ciutats);
    	
    	ObservableList <String> Punts_Ciutats2;
    	Punts_Ciutats2 = FXCollections.observableArrayList();
    	puntRecollidaDAOImpl.ComboBoxPuntRecollidaAdmin(conexio2, Punts_Ciutats2);
    	Comboboxpuntsact.setItems(Punts_Ciutats2);
    	
    	ObservableList <String> Estats;
    	Estats = FXCollections.observableArrayList();
    	distribuciovolsDAOImpl.ComboBoxEstats(conexio2, Estats);
    	IDComboboxEstats.setItems(Estats);
    	
    	ObservableList <String> Punts;
    	Punts = FXCollections.observableArrayList();
    	puntRecollidaDAOImpl.ComboBoxPuntLocalitzacions(conexio2, Punts);
    	comboboxcrearpuntrecollida.setItems(Punts);
    	
    	
    	ObservableList <String> paisos_origen;
    	paisos_origen = FXCollections.observableArrayList();
    	distribuciovolsDAOImpl.ComboBoxVols(conexio2, paisos_origen);
    	combobosorigen.setItems(paisos_origen);
    	
    	ObservableList <String> paisos_destins;
    	paisos_destins = FXCollections.observableArrayList();
    	distribuciovolsDAOImpl.ComboBoxVols(conexio2, paisos_destins);
    	comboboxdesti.setItems(paisos_destins);

    	ObservableList <puntRecollida>llistaPunts;
    	llistaPunts=FXCollections.observableArrayList();
    	
	    puntRecollidaDAOImpl.CercarPunts(conexio2, llistaPunts);    
	    PuntsBorrats.setItems(llistaPunts);
	    ColumnPuntIdBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,Integer>("idPuntRecollida"));
	    ColumnPuntLocaliBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,Integer>("idLocalitzacio"));
	    ColumnPuntAdrecaBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,String>("adreca"));
	    ColumnPuntDescBorr.setCellValueFactory(new PropertyValueFactory<puntRecollida,String>("descripcio"));
    	
    	ObservableList <distribuciovols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
	    	
	   
		distribuciovolsDAOImpl.cercarVols(conexio2, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddistribuciovols"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
    
		
		ObservableList <distribuciovols>llistaVolsEstats;
		llistaVolsEstats=FXCollections.observableArrayList();
	    	
	   
		distribuciovolsDAOImpl.cercarVols(conexio2, llistaVolsEstats);    
		TaulaEstatsVolsEstats.setItems(llistaVolsEstats);
		ColumnaIDVOLestat.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("iddistribuciovols"));
		ColumnorigenEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		ColumndestiEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		ColumndatasortidaEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		ColumndataarribadaEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		ColumndEstatEstat.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("estat"));
    
		Comboboxpuntsact.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					Punt_AdrecaAct=valorSeleccionat;
    				}
    		}
    	});
		
		
		
		comboboxcrearpuntrecollida.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					ID_Punt=valorSeleccionat;
    					
    				}
    		}
    	});
    
		comboboxdesti.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					ID_VueloSeleccionat1=valorSeleccionat;
    					
    					
      				}
    		}
    	});
		
    	combobosorigen.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					ID_VueloSeleccionat2=valorSeleccionat;
    				}
    		}
    	});
		
		comboboxpuntrecollida.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					ID_PuntRecollida=valorSeleccionat;
    				}
    		}
    	});
		
		IDComboboxEstats.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					EstatNouSeleccionat=valorSeleccionat;
    				}
    		}
    	});
		
    }
    
}
