package Transpotravel.Transpotravel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Conbd;
import model.ConbdXML;
import model.EquipatgeDAO;
import model.EquipatgeDAOImpl;
import model.client;
import model.desplacamentDAOImpl;
import model.distribuciovols;
import model.distribuciovolsDAO;
import model.distribuciovolsDAOImpl;
import model.equipatge;
import model.puntRecollida;
import model.puntRecollidaDAO;
import model.puntRecollidaDAOImpl;

public class TranspoTravelDefController implements Initializable{

    @FXML
    private Button BuscarEquipatge;

    @FXML
    private Button BuscarVol;
    
    @FXML
    private ComboBox<String> ComboboxActEquipatge;

    @FXML
    private TableColumn<equipatge, String> DestiEquipatge;

    @FXML
    private TableColumn<distribuciovols, String> DestiSeguimentVol;
    
    @FXML
    private Button EliminarEquipatgeLlista;

    @FXML
    private Button EnviarDadesContacte;
    
    @FXML
    private Button revisarEquipatge;

    @FXML
    private TableColumn<equipatge, String> EstatEquipatge;

    @FXML
    private TableColumn<distribuciovols, String> EstatSeguimentVol;

    @FXML
    private TableColumn<distribuciovols,LocalDateTime> HoraArribadaViatge;

    @FXML
    private TableColumn<distribuciovols,LocalDateTime> HoraSortidaViatge;
    
    @FXML
    private Button IDButtonBuscarVol;
    
    @FXML
    private TableView<distribuciovols> OfertesimatgeiDescripcio;

    @FXML
    private TableColumn<distribuciovols, String> OrigenSeguimentVol;

    @FXML
    private TableColumn<equipatge,String> PesEquipatgeCompra;

    @FXML
    private TableColumn<distribuciovols,Integer> PreuViatge;

    @FXML
    private TableColumn<distribuciovols,Integer> PuntRecollidaViatge;

    @FXML
    private TableView<equipatge> SeguimentEquipatge;

    @FXML
    private TableView<distribuciovols> SeguimentVol;

    @FXML
    private TextArea TextAreaContacte;

    @FXML
    private TextField TextFieldEquipatgeSelec;

    @FXML
    private ComboBox<String> ViatgeComboBoxDesti;

    @FXML
    private ComboBox<String> ViatgeComboBoxOrigen;

    @FXML
    private TableView<distribuciovols> ViatgesTaulaVols;

    @FXML
    private Button afegirLlistaEquipatgesCompra;
     
    @FXML
    private Button btnActEquipatge;
    
    @FXML
    private Button buttonComprarViatge;
    
    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnComprarViatge;

    @FXML
    private Button btnContacte;
    
    @FXML
    private Button btnElimEquipatge;
    
    @FXML
    private Button btnEquipatges;

    @FXML
    private Button btnOfertesViatges;

    @FXML
    private Button btnSeguimentViatge;

    @FXML
    private Button btnVolComprat;

    @FXML
    private Button cancelarCompra1;

    @FXML
    private Button cancelarCompra2;

    @FXML
    private Button cancelarCompra3;

    @FXML
    private Button cancelarVol;

    @FXML
    private ComboBox<String> comboBoxPuntsRecollida;

    @FXML
    private TableView<distribuciovols> confirmacioCompraViatge;

    @FXML
    private TableColumn<distribuciovols,String> confirmacioDesti;

    @FXML
    private TableColumn<distribuciovols, LocalDateTime> confirmacioHoraArribada;

    @FXML
    private TableColumn<distribuciovols, LocalDateTime> confirmacioHoraSortida;

    @FXML
    private TableColumn<distribuciovols, Integer> confirmacioNumeroEquipatges;

    @FXML
    private TableColumn<distribuciovols, Integer> confirmacioNumeroPlaces;

    @FXML
    private TableColumn<distribuciovols, String> confirmacioOrigen;

    @FXML
    private TableColumn<distribuciovols, Integer> confirmacioPreu;
    
    @FXML
    private CheckBox checkboxUbicacioPersonalitzada;
    
    @FXML
    private Label correuUsuari;

    @FXML
    private TableColumn<distribuciovols,String> destiVolsComprats;

    @FXML
    private TableView<equipatge> equipatgeCompra;

    @FXML
    private TableView<equipatge> equipatges;

    @FXML
    private Button finalitzarCompra;

    @FXML
    private TableColumn<distribuciovols,LocalDateTime> horaArribadaVolsComprats;

    @FXML
    private TableColumn<distribuciovols,LocalDateTime> horaSortidaVolsComprats;

    @FXML
    private TableColumn<equipatge,Integer> idEquipatgeEquipatges;

    @FXML
    private TextField idSeguimentVol;
    
    @FXML
	private Button visualitzarEquipatge;

    @FXML
    private TableColumn<distribuciovols,Integer> idSeguimentVolsComprats;
    
    @FXML
    private ImageView imatgeComprarViatge;

    @FXML
    private ImageView imatgeContacte;
    

    @FXML
    private TableColumn<distribuciovols, Image> imatgeOfertes;
    
    @FXML
    private ImageView imatgeOfertesViatges;

    @FXML
    private ImageView imatgeSeguimentViatge;

    @FXML
    private ImageView imatgeVolComprat;
    
    @FXML
    private ImageView imgEquipatges;
    
    @FXML
    private ImageView imgSeat;

    @FXML
    private Button modificarVol;
    
    @FXML
    private TableColumn<equipatge,Integer> nombreEquipatge;

    @FXML
    private TableColumn<distribuciovols,Integer> numeroEquipatgesVolsComprats;

    @FXML
    private TextField numeroPlaces1;

    @FXML
    private TextField numeroPlaces2;

    @FXML
    private TextField numeroPlaces3;

    @FXML
    private TableColumn<distribuciovols,Integer> numeroPlacesVolsComprats;
    
    @FXML
    private TableColumn<distribuciovols,String> destiComprarVol;
    
    @FXML
    private TableColumn<distribuciovols,String> origenComprarVol;

    @FXML
    private TableColumn<equipatge, String> origenEquipatge;

    @FXML
    private TableColumn<distribuciovols,String> origenVolsComprats;

    @FXML
    private TableColumn<equipatge,Integer> pesEquipatges;

    @FXML
    private TableColumn<distribuciovols,Integer> preuVolsComprats;

    @FXML
    private TableColumn<equipatge,String> puntRecollidaEquipatgeCompra;

    @FXML
    private TableColumn<equipatge,String> puntRecollidaEquipatges;

    @FXML
    private TableColumn<equipatge, String> puntRecollidaSeguimentVol;

    @FXML
    private Button seguentCompra1;

    @FXML
    private Button seguentCompra2;

    @FXML
    private Tab tabComprarViatge1;

    @FXML
    private Tab tabComprarViatge2;

    @FXML
    private Tab tabComprarViatge3;

    @FXML
    private Tab tabContacte;

    @FXML
    private Tab tabEquipatges;

    @FXML
    private Tab tabOfertes;
    
    @FXML
    private TabPane tabPaneMenu;
    
    @FXML
    private Tab tabPerfil;

    @FXML
    private Tab tabSeguiment;

    @FXML
    private Tab tabViatges;

    @FXML
    private TextField textPesEquipatgeCompra;

    @FXML
    private TextField textPuntRecollidaCompra;

    @FXML
    private TextField textfieldidEquipatge;

    @FXML
    private Button tornarPerfil;

    @FXML
    private TableView<distribuciovols> volsComprats;

    @FXML
    private TableColumn<distribuciovols,Integer> volsViatge;
    
    private ObservableList<equipatge> llistaEquipatge;
    
    private ObservableList<distribuciovols> llistaVolsClients;

    LoginController login;
    String idUsuari = " ";
    String IDdestiFiltrat;
    String IDorigenFiltrat;
    String IdPuntAct="";
	int IDE=0;
	int pes=0;

    @FXML
    void OnMouseClickMostrarIdEquipatge(MouseEvent event) {
    	equipatge equipatgeseleccionat=equipatges.getSelectionModel().getSelectedItem();
    	if(equipatgeseleccionat==null) {
    		TextFieldEquipatgeSelec.setText("Ningun Equipatge Seleccionat");
    	}else{
    		TextFieldEquipatgeSelec.setText(String.valueOf(equipatgeseleccionat.getIdEquipatge()));
    		IDE=equipatgeseleccionat.getIdEquipatge();
    		pes=equipatgeseleccionat.getPes();
    		
    		ObservableList <String> punts;
    		punts = FXCollections.observableArrayList();
        	puntRecollidaDAOImpl.ComboBoxPuntRecollidaAct(conexio2, punts,equipatgeseleccionat.getPuntRecollida());
        	ComboboxActEquipatge.setItems(punts);
    	}
    }
    
    @FXML
    void OnClickBorrarEquipatge(ActionEvent event) {
    	EquipatgeDAO equipatge = new EquipatgeDAOImpl();
    	if(IDE!=0) {
    		equipatge.eliminarEquipatge(conexio2, IDE,pes);
    	}else {
    		
    		Alert missatge=new Alert(AlertType.ERROR);
			missatge.setTitle("FALTEN DADES");
			missatge.setHeaderText("Has d'indicar algun equipatge!");
			missatge.showAndWait();
    		
    	}
    }
    
    @FXML
    void OnClickActualitzarEquipatge(ActionEvent event) {
    	EquipatgeDAO equipatge = new EquipatgeDAOImpl();
    	puntRecollidaDAO puntRec = new puntRecollidaDAOImpl();

    	if(IDE!=0) {
    		int P=0;
    		
        	P=puntRec.cercarPuntRecollidaInsertatPelClient(conexio2, IdPuntAct);
        	equipatge.actualitzarEquipatge(conexio2,IDE, P);
    	
    	}else {
    		
    		Alert missatge=new Alert(AlertType.ERROR);
			missatge.setTitle("FALTEN DADES");
			missatge.setHeaderText("Has d'indicar algun equipatge!");
			missatge.showAndWait();
    		
    	}
    }
    
    
    @FXML
    void onClicBuscarVolsFiltrats(ActionEvent event) {
    	int IDD=0;
    	int IDO=0;  	
    	
    	IDD=distribuciovolsDAOImpl.ObtenirID_Localitzacio(conexio2, IDdestiFiltrat, IDD);
    	IDO=distribuciovolsDAOImpl.ObtenirID_Localitzacio(conexio2, IDorigenFiltrat, IDO);

    	System.out.println("Desti:"+IDD+" Origen:"+IDO);

    	
    	ObservableList <distribuciovols>llistaVolsFiltrats;
    	llistaVolsFiltrats=FXCollections.observableArrayList();
    	if(IDD!=IDO) {
    		distribuciovolsDAOImpl.ObtenirVolsSeleccionats(conexio2, IDD, IDO, llistaVolsFiltrats);
        	ViatgesTaulaVols.setItems(llistaVolsFiltrats);
        	origenComprarVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
    		destiComprarVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
    		PreuViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
    		PuntRecollidaViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("recollida"));
    		HoraSortidaViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
    		HoraArribadaViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));	
    	}else {
    		
    		Alert missatge=new Alert(AlertType.ERROR);
			missatge.setTitle("Origen o Desti introduits incorrectes");
			missatge.setHeaderText("No hi han vols a una mateixa ciutat!");
			missatge.showAndWait();
    		
    	}
    	
    
    }
    
    @FXML
    void onClickAfegirEquipatgeLlista(ActionEvent event) {
    	  	
    	if (checkboxUbicacioPersonalitzada.isSelected()) {    		
    		if (textPuntRecollidaCompra.getText().isEmpty()) {
		    	Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("FALTEN DADES");
				missatge.setHeaderText("Has d'indicar el lloc del Punt Personalitzat!");
				missatge.showAndWait();
				
    		}
    		
    		else if (textPesEquipatgeCompra.getText().isEmpty()) {
		    	Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("FALTEN DADES");
				missatge.setHeaderText("Has d'indicar el Pes del Equipatge!");
				missatge.showAndWait();
    		}
    		else if(Integer.parseInt(textPesEquipatgeCompra.getText())>4) {
    			Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("MASSA PES");
				missatge.setHeaderText("El maxim de pes per equipatge es de 4kg!");
				missatge.showAndWait();
    		}
    		else if(equipatgeCompra.getItems().size()>4) {
    			Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("Capacitat d'equipatges Maxima");
				missatge.setHeaderText("El maxim d'equipatges per compres es de 5");
				missatge.showAndWait();
    		}
    		else {
    			
    			ObservableList<equipatge> afegirEquipatgeLlista;
    			afegirEquipatgeLlista = equipatgeCompra.getItems();
    			
    			equipatge equipatgeLlista = new equipatge(equipatgeCompra.getItems().size() + 1, Integer.parseInt(textPesEquipatgeCompra.getText()), null, null, null, null, textPuntRecollidaCompra.getText());
    			afegirEquipatgeLlista.add(equipatgeLlista);

    			equipatgeCompra.setItems(afegirEquipatgeLlista);
    			
    		}
    	}
    	
    	else {
    		
    		if (textPesEquipatgeCompra.getText().isEmpty()) {
		    	Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("FALTEN DADES");
				missatge.setHeaderText("Has d'indicar el Pes del Equipatge!");
				missatge.showAndWait();
    		}
    		
    		else if (comboBoxPuntsRecollida.getSelectionModel().isEmpty()){
		    	Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("FALTEN DADES");
				missatge.setHeaderText("Has d'indicar un Punt de Recollida!");
				missatge.showAndWait();
    		}	
    		else if(Integer.parseInt(textPesEquipatgeCompra.getText())>4) {
    			Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("MASSA PES");
				missatge.setHeaderText("El Pes de l'equipatge es massa elevat!");
				missatge.showAndWait();
    		}
    		else if(equipatgeCompra.getItems().size()>4) {
    			Alert missatge=new Alert(AlertType.ERROR);
				missatge.setTitle("Capacitat d'equipatges Maxima");
				missatge.setHeaderText("El maxim d'equipatges per compres es de 5");
				missatge.showAndWait();
    		}
    		else {
    			ObservableList<equipatge> afegirEquipatgeLlista;
    			afegirEquipatgeLlista = equipatgeCompra.getItems();
    			
    			equipatge equipatgeLlista = new equipatge(equipatgeCompra.getItems().size() + 1, Integer.parseInt(textPesEquipatgeCompra.getText()), null, null, null, null, comboBoxPuntsRecollida.getSelectionModel().getSelectedItem());
    			afegirEquipatgeLlista.add(equipatgeLlista);

    			equipatgeCompra.setItems(afegirEquipatgeLlista);
    			
    		}
    	}
    	
    	if (EliminarEquipatgeLlista.isDisable()) {
    		if (equipatgeCompra.getItems().size() > 0) {
    			EliminarEquipatgeLlista.setDisable(false);
    		}
    	}
    	
    }
    
    @FXML
    void onClickEliminarEquipatgeLlista(ActionEvent event) {
    	
    	if (equipatgeCompra.getSelectionModel().getSelectedItem() == null) {
	    	Alert missatge=new Alert(AlertType.ERROR);
			missatge.setTitle("FALTA LA SELECCIO");
			missatge.setHeaderText("Has d'indicar l'Equipatge a esborrar!");
			missatge.showAndWait();
    	}
    	
    	else {
    		
    		equipatgeCompra.getItems().remove(equipatgeCompra.getSelectionModel().getSelectedItem());
    		    		
			ObservableList<equipatge> llistaCanviIdEquipatge = FXCollections.observableArrayList();
			
    		for (int i = 0; i < equipatgeCompra.getItems().size(); i++) {
    			equipatge equipatgeCanviID = equipatgeCompra.getItems().get(i);
    			
    			equipatgeCanviID.setIdEquipatge(i + 1);
    			
    			llistaCanviIdEquipatge.add(equipatgeCanviID);    
    		}
    		
    		equipatgeCompra.setItems(llistaCanviIdEquipatge);
    		
    	}
    	
    }

    @FXML
    void onClickBuscarEquipatge(ActionEvent event) {
    	
    	if(!textfieldidEquipatge.getText().isEmpty()) {
    		
        	EquipatgeDAO equipatge = new EquipatgeDAOImpl();
        	equipatge equipatgeClient = equipatge.cercarEquipatge(conexio2, Integer.parseInt(textfieldidEquipatge.getText()));
        	
        	if (equipatgeClient != null) {
            	SeguimentEquipatge.setDisable(false);
            	llistaEquipatge.clear();
        		llistaEquipatge.add(equipatgeClient);
        	}
        	else {
    			Alert missatge=new Alert(AlertType.ERROR);
    			missatge.setTitle("ID INNEXISTENT!");
    			missatge.setContentText("L'ID introduït no existeix o no es troba.");
    			missatge.setHeaderText("Resultat:");
    			missatge.show();
        	}

    	}

    }

  
    
    @FXML
    void onClickBuscarVol(ActionEvent event) {
    	
    	if(!idSeguimentVol.getText().isEmpty()) {
    		
        	distribuciovolsDAO vols = new distribuciovolsDAOImpl();
        	distribuciovols volsClient = vols.cercarVolClient(conexio2, Integer.parseInt(idSeguimentVol.getText()));
        	
        	System.out.print(volsClient);
        	
        	if (volsClient != null) {
        		SeguimentVol.setDisable(false);
        		llistaVolsClients.clear();
        		llistaVolsClients.add(volsClient);
        		
        	}
        	else {
    			Alert missatge=new Alert(AlertType.ERROR);
    			missatge.setTitle("ID INNEXISTENT!");
    			missatge.setContentText("L'ID introduït no existeix o no es troba.");
    			missatge.setHeaderText("Resultat:");
    			missatge.show();
        	}

    	}

    }

    @FXML
    void onClickCancelarCompra(ActionEvent event) {
    	
    	if (tabAnteriorACancelar == tabComprarViatge1) {
    		numeroPlaces1.setText("0");
    		numeroPlaces2.setText("0");
    		numeroPlaces3.setText("0");
    	}
    	
    	else if (tabAnteriorACancelar == tabComprarViatge2) {
    		numeroPlaces1.setText("0");
    		numeroPlaces2.setText("0");
    		numeroPlaces3.setText("0");
    		
    		comboBoxPuntsRecollida.setValue(null);
    		textPesEquipatgeCompra.setText("");
    		checkboxUbicacioPersonalitzada.setSelected(false);
    		textPuntRecollidaCompra.setText("");
    		EliminarEquipatgeLlista.setDisable(true);
    		equipatgeCompra.getItems().clear();
    	}
    	
    	else {
    		numeroPlaces1.setText("0");
    		numeroPlaces2.setText("0");
    		numeroPlaces3.setText("0");
    		
    		comboBoxPuntsRecollida.setValue(null);
    		textPesEquipatgeCompra.setText("");
    		checkboxUbicacioPersonalitzada.setSelected(false);
    		textPuntRecollidaCompra.setText("");
    		EliminarEquipatgeLlista.setDisable(true);
    		equipatgeCompra.getItems().clear();
    		
        	confirmacioCompraViatge.getItems().clear();
    	}
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabAnterior);
    
    	
    }


    @FXML
    void onClickFinalitzarCompra(ActionEvent event) {
    	desplacamentDAOImpl daoDesplacament = new desplacamentDAOImpl();
    	
    	EquipatgeDAOImpl daoEquipatge = new EquipatgeDAOImpl();    	
    												
    	daoDesplacament.afegirClientADesplacament(conexio2, Integer.parseInt(idUsuari),confirmacioCompraViatge.getItems().get(0).getIddistribuciovols(), 
    			confirmacioCompraViatge.getItems().get(0).getPes(),confirmacioCompraViatge.getItems().get(0).getPersones());
    	
    	int pestotal=0;
    	for (int i = 0; i < equipatgeCompra.getItems().size(); i++) {
        	System.out.println(Integer.parseInt(idUsuari));
        	System.out.println(equipatgeCompra.getItems().get(i).getPes());
        	System.out.println(equipatgeCompra.getItems().get(i).getPuntRecollida());
        	System.out.println(confirmacioCompraViatge.getItems().get(0).getIddistribuciovols());
        	
        	if(equipatgeCompra.getItems().get(i).getPuntRecollida().contains("-")) {
        		int punt=0;
        		pestotal+=equipatgeCompra.getItems().get(i).getPes();
            	String Part []=equipatgeCompra.getItems().get(i).getPuntRecollida().split("-");
            	System.out.println("Part "+Part[1]);
            	punt=distribuciovolsDAOImpl.ObtenirID_Puntrecollida(conexio2, Part[1].trim(),punt);
            	System.out.println("Punt de recollida "+punt);
            	System.out.println("Pes Total "+pestotal);

            	daoEquipatge.afegirEquipatgeADesplacament(conexio2,Integer.parseInt(idUsuari),equipatgeCompra.getItems().get(i).getPes(),
            	String.valueOf(punt),confirmacioCompraViatge.getItems().get(0).getIddistribuciovols());	
        		
        	}else {
        		pestotal+=equipatgeCompra.getItems().get(i).getPes();
        		daoEquipatge.afegirEquipatgeADesplacament(conexio2,Integer.parseInt(idUsuari),equipatgeCompra.getItems().get(i).getPes(),
        	    equipatgeCompra.getItems().get(i).getPuntRecollida(),confirmacioCompraViatge.getItems().get(0).getIddistribuciovols());	
        	}
        	
        	
        	
    	}
    	
    	distribuciovolsDAOImpl.ActualitzarPlaces_Pes(conexio2,confirmacioCompraViatge.getItems().get(0).getPersones(), pestotal, confirmacioCompraViatge.getItems().get(0).getIddistribuciovols());
    	System.out.println("IDVOL"+confirmacioCompraViatge.getItems().get(0).getIddistribuciovols()+"Pes total;"+pestotal+" Persones "+confirmacioCompraViatge.getItems().get(0).getPersones());
    	ObservableList<distribuciovols> llistaAfegirEquipatgeAVolsComprats = FXCollections.observableArrayList();

    	for (int i = 0; i < volsComprats.getItems().size(); i++) {
        	llistaAfegirEquipatgeAVolsComprats.add(volsComprats.getItems().get(i));
    	}
    	
    	llistaAfegirEquipatgeAVolsComprats.add(confirmacioCompraViatge.getItems().get(0));
    	    	
    	volsComprats.setItems(llistaAfegirEquipatgeAVolsComprats);
 
    	Alert missatge=new Alert(AlertType.INFORMATION);
		missatge.setTitle("VOL COMPRAT CORRECTAMENT");
		missatge.setHeaderText("Moltes Gràcies per confiar en nosaltres!");
		missatge.showAndWait();
    	
		numeroPlaces1.setText("0");
		numeroPlaces2.setText("0");
		numeroPlaces3.setText("0");
		
		comboBoxPuntsRecollida.setValue(null);
		textPesEquipatgeCompra.setText("");
		checkboxUbicacioPersonalitzada.setSelected(false);
		textPuntRecollidaCompra.setText("");
		EliminarEquipatgeLlista.setDisable(true);
		equipatgeCompra.getItems().clear();
		
		equipatges.getItems().clear();
		
    	confirmacioCompraViatge.getItems().clear();
	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
	
    	tabPaneMenu.getTabs().add(tabPerfil);
    	
    	volsComprats.getSelectionModel().select(volsComprats.getItems().size() - 1);
    	
    }

    
    
    @FXML
    void onClickTornarPerfil(ActionEvent event) {
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabAnteriorEquipatges);

    }
    

    @FXML
    void onClickSeguentCompra1(ActionEvent event) {
    	
    	numPlaces = Integer.parseInt(numeroPlaces1.getText()) + Integer.parseInt(numeroPlaces2.getText()) + Integer.parseInt(numeroPlaces3.getText());
    	int placesdisp=0;
    	
    	placesdisp=distribuciovolsDAOImpl.ObtenirPlacesDisponibles(conexio2, volSeleccionat.getIddistribuciovols(), placesdisp);
    	//System.out.println("IDVOL "+volSeleccionat.getIddistribuciovols());
    	//System.out.println("PLACES "+placesdisp);
    	
    	if (numPlaces > 0 &&numPlaces < volSeleccionat.getPersones()) {
	    	tabAnteriorACancelar = tabComprarViatge2;
        	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
            tabPaneMenu.getTabs().add(tabComprarViatge2);
            
            ObservableList <String> puntsRecollida;
        	puntsRecollida = FXCollections.observableArrayList();
        	puntRecollidaDAOImpl.ComboBoxPuntRecollida(conexio2, puntsRecollida,volSeleccionat.getIddesti());
        	comboBoxPuntsRecollida.setItems(puntsRecollida);
    	}
    	
    	else {
	    	Alert missatge=new Alert(AlertType.ERROR);
			missatge.setTitle("FALTEN PLACES");
			missatge.setHeaderText("Has d'introduïr com a minim una Plaça o número de places introduit massa alt!");
			missatge.showAndWait();
    	}
  
    }
    
    @FXML
    void onClickSeguentCompra2(ActionEvent event) {
    	
    	tabAnteriorACancelar = tabComprarViatge3;

		ObservableList<distribuciovols> afegirConfirmarLlista;
		afegirConfirmarLlista = FXCollections.observableArrayList();
		
		afegirConfirmarLlista.add(volSeleccionat);
		
    	confirmacioCompraViatge.setItems(afegirConfirmarLlista);
    	
    	confirmacioCompraViatge.getItems().get(confirmacioCompraViatge.getItems().size() - 1).setPes(equipatgeCompra.getItems().size());
    	confirmacioCompraViatge.getItems().get(confirmacioCompraViatge.getItems().size() - 1).setPersones(numPlaces);
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
        	
        tabPaneMenu.getTabs().add(tabComprarViatge3);
        
    }
    
    @FXML
    void onClickOfertesViatges(ActionEvent event) {
    		
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabOfertes);
    	
    	numeroPlaces1.setText("0"); 
		numeroPlaces2.setText("0");
		numeroPlaces3.setText("0");
    
    }
    
    
    @FXML
    void onClickComprarViatge(ActionEvent event) { //

    	tabAnterior = tabViatges;
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabViatges);
    	  	
    }
    
    @FXML
    void onClickTornarComprarViatge(ActionEvent event) { //

    	tabAnterior = tabViatges;
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabViatges);
    	
    }
   
    @FXML
    void onClickSeguimentViatge(ActionEvent event) {
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabSeguiment);

    }
    
    @FXML
    void onClickVolComprat(ActionEvent event) {
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabPerfil);

    }
    
    @FXML
    void VolComprat(ActionEvent event) {
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabPerfil);
    	

    }
    
    @FXML
    void Contacte(ActionEvent event) {
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabContacte);
    	
    	//INSERT INTO transpotravel.contacteinfo (missatge) VALUES ("provaaa 12345");

    }
    
    @FXML
    void onClickVisualitzarEquipatge(ActionEvent event) {

    	tabAnteriorEquipatges = tabPerfil;
    	
    	ObservableList<equipatge> llistaAfegirEquipatgesVisualitzar = FXCollections.observableArrayList();
		
    	ArrayList<equipatge> llistaEquipatgesRebuts = new ArrayList<equipatge>();
    	
    	EquipatgeDAOImpl daoEquipatgeClient = new EquipatgeDAOImpl();
    	System.out.println(volSeleccionat.getIddistribuciovols());
    	llistaEquipatgesRebuts = daoEquipatgeClient.cercarEquipatgePerUsuari(conexio2, Integer.parseInt(idUsuari), volSeleccionat.getIddistribuciovols());
    	
		for (int i = 0; i < llistaEquipatgesRebuts.size(); i++) {			
			llistaAfegirEquipatgesVisualitzar.add(llistaEquipatgesRebuts.get(i));    
		}
		
		equipatges.setItems(llistaAfegirEquipatgesVisualitzar);
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
        tabPaneMenu.getTabs().add(tabEquipatges);
    	
    }
    
    @FXML
    void onClickContacte(ActionEvent event) {
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabContacte);

    }
    
    @FXML
    void onClickTornarSeients(ActionEvent event) {
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
        tabPaneMenu.getTabs().add(tabComprarViatge1);

    }
    
    @FXML
    void onClickRevisarEquipatge(ActionEvent event) {

    	tabAnteriorEquipatges = tabComprarViatge3;
    	
    	ObservableList<equipatge> llistaAfegirEquipatgesVisualitzar = FXCollections.observableArrayList();
		
		for (int i = 0; i < equipatgeCompra.getItems().size(); i++) {
			equipatge equipatgeNou = equipatgeCompra.getItems().get(i);
			
			llistaAfegirEquipatgesVisualitzar.add(equipatgeNou);    
		}
		
		equipatges.setItems(llistaAfegirEquipatgesVisualitzar);
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
        tabPaneMenu.getTabs().add(tabEquipatges);
    	
    }
	
    
   
    
    //private Conbd conexio2;
    private ConbdXML conexio2;
    
    private boolean mostrarOfertes = false;
    
    private distribuciovols volSeleccionat; // ALEX
    
    private Tab tabAnterior; // ALEX
    
    private int numPlaces = 0;
    
    private Tab tabAnteriorACancelar;
    
    private Tab tabAnteriorEquipatges;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	//Seguiment Equipatge
    	
    	llistaEquipatge = FXCollections.observableArrayList();

    	conexio2 = new ConbdXML();
    	
    	SeguimentEquipatge.setItems(llistaEquipatge);
    	
    	puntRecollidaSeguimentVol.setCellValueFactory(new PropertyValueFactory<equipatge, String>("puntRecollida"));
    	origenEquipatge.setCellValueFactory(new PropertyValueFactory<equipatge, String>("origen"));
    	DestiEquipatge.setCellValueFactory(new PropertyValueFactory<equipatge, String>("desti"));
    	EstatEquipatge.setCellValueFactory(new PropertyValueFactory<equipatge, String>("estat"));
    	
    	//Seguiment vol
    	
    	llistaVolsClients = FXCollections.observableArrayList();


    	SeguimentVol.setItems(llistaVolsClients);
    	
    	OrigenSeguimentVol.setCellValueFactory(new PropertyValueFactory<distribuciovols, String>("idorigen"));
    	DestiSeguimentVol.setCellValueFactory(new PropertyValueFactory<distribuciovols, String>("iddesti"));
    	EstatSeguimentVol.setCellValueFactory(new PropertyValueFactory<distribuciovols, String>("estat"));
    	
    	//Vista Viatges
    	  
		
    	
    	
    	
    	
    	// combobox - taula comprar viatges
    	
    	ObservableList <String> paisesdesti;
    	paisesdesti = FXCollections.observableArrayList();
    	distribuciovolsDAOImpl.ComboBoxVols(conexio2, paisesdesti);
    	ViatgeComboBoxDesti.setItems(paisesdesti);
    	
    	ObservableList <String>paisesorigen;
    	paisesorigen=FXCollections.observableArrayList();
    	distribuciovolsDAOImpl.ComboBoxVols(conexio2, paisesorigen);
    	ViatgeComboBoxOrigen.setItems(paisesorigen);
    	    	
	    ObservableList <distribuciovols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
	    	
	   
		distribuciovolsDAOImpl.cercarVols_nomciutat(conexio2, llistaVols);    //*****************
		ViatgesTaulaVols.setItems(llistaVols);
		origenComprarVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		destiComprarVol.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		PreuViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
		PuntRecollidaViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("recollida"));
		HoraSortidaViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		HoraArribadaViatge.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		
		//comprar viatge
        
        ViatgesTaulaVols.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<distribuciovols>() { // ALEX
    		@Override
			public void changed(ObservableValue<? extends distribuciovols> valorActual, distribuciovols valorAnterior, distribuciovols valorSeleccionat) {
				//per evitar errors de nullPointerException a l'hora de desseleccionar/actualitzar dades ens hem d'assegurar que el valorSeleccionat no sigui null
				if (valorSeleccionat!=null) {
					buttonComprarViatge.setDisable(false);
					volSeleccionat = valorSeleccionat;
				}
			}
		});
    	
    	//---------------------------------------------------------------------------------------------------------------------
    	
		/*ObservableList<distribuciovols>imatges=FXCollections.observableArrayList();
		
    	try {
			InputStream input= new FileInputStream(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\Imatges\\Barcelona - berlin.png");
	    	Image myimage =new Image(input);	
	    	ImageView em1 =new ImageView(myimage);
	    	distribuciovolsDAOImpl dao = new distribuciovolsDAOImpl();	    	
	    	distribuciovols ImatgeNova = dao.cercarVolClient(conexio2, 1);	    	
	    	ImatgeNova.setImatgeVirtual(em1);
	  
	    	
	    	imatges.add(ImatgeNova);
    	
    	
	    	InputStream input2= new FileInputStream(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\Imatges\\londres - lisboa.png");
	    	Image myimage2 =new Image(input2);	
	    	ImageView em2 =new ImageView(myimage2);  	
	    	distribuciovols ImatgeNova2 = dao.cercarVolClient(conexio2, 2);	    	
	    	ImatgeNova2.setImatgeVirtual(em2);
	    	imatges.add(ImatgeNova2);
	    	
    	
	    	imatges.add(null); 
	    	
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

   
    	imatgeOfertes.setCellValueFactory(new PropertyValueFactory<>("ImatgeVirtual"));

    	OfertesimatgeiDescripcio.setItems(imatges);*/
    	
    	
    	//tabPaneMenu.getTabs().remove(tabPaneMenu.getTabs().indexOf(tabEquipatges));
    	
    	tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    	
    	tabPaneMenu.getTabs().add(tabOfertes);
    	
    	
    	
    	//Ofertes Viatges
    	File fileOfertesViatges = new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\icons\\dollar.png");
        Image imageOfertesViatges = new Image(fileOfertesViatges.toURI().toString());
        imatgeOfertesViatges.setImage(imageOfertesViatges);
        
        
        //Comprar Viatges
        File fileComprarViatges= new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\icons\\plane.png");
        Image imageComprarViatges = new Image(fileComprarViatges.toURI().toString());
        imatgeComprarViatge.setImage(imageComprarViatges);
        
        //Seguiment Viatge
        File fileSeguimentViatge= new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\icons\\lupa.png");
        Image imageSeguimentViatge = new Image(fileSeguimentViatge.toURI().toString());
        imatgeSeguimentViatge.setImage(imageSeguimentViatge);
        
        //Vol Comprat
        File fileVolComprat= new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\icons\\volComprat.png");
        Image imageVolComprat = new Image(fileVolComprat.toURI().toString());
        imatgeVolComprat.setImage(imageVolComprat);
        
        //Contacte
        File fileContacte= new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\icons\\contacte.png");
        Image imageContacte = new Image(fileContacte.toURI().toString());
        imatgeContacte.setImage(imageContacte);
        
        //Seients
        File filePlaces= new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\icons\\seat.png");
        Image imagePlaces = new Image(filePlaces.toURI().toString());
        imgSeat.setImage(imagePlaces);
        
        
     	//Equipatges
        File fileEquipatges = new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\icons\\equipatge.png");
        Image imageEquipatges = new Image(fileEquipatges.toURI().toString());
        imgEquipatges.setImage(imageEquipatges);
        
        
        
        //comprar vols
        
        OfertesimatgeiDescripcio.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<distribuciovols>() {
    		@Override
			public void changed(ObservableValue<? extends distribuciovols> valorActual, distribuciovols valorAnterior, distribuciovols valorSeleccionat) {
				//per evitar errors de nullPointerException a l'hora de desseleccionar/actualitzar dades ens hem d'assegurar que el valorSeleccionat no sigui null
				if (valorSeleccionat!=null) {
					
					Alert missatge=new Alert(AlertType.CONFIRMATION);
					missatge.setTitle("Comprar Vol");
					missatge.setHeaderText("Estàs segur que vols comprar el vol?");
					//missatge.show();
					Optional<ButtonType> result = missatge.showAndWait();
					
					if(result.get() == ButtonType.OK) {
						
						tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
					    	
					    tabPaneMenu.getTabs().add(tabComprarViatge1);
						
				
					}
					

				}
			}
		});
        
        
        
     // Vista Ofertes // ALEX
    	
    	OfertesimatgeiDescripcio.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<distribuciovols>() {
    		@Override
			public void changed(ObservableValue<? extends distribuciovols> valorActual, distribuciovols valorAnterior, distribuciovols valorSeleccionat) {
				//per evitar errors de nullPointerException a l'hora de desseleccionar/actualitzar dades ens hem d'assegurar que el valorSeleccionat no sigui null    			
    			if (valorSeleccionat!=null) {
    				
    				enMostrarOfertes();
    				
    				if (mostrarOfertes) {
        		    	Alert missatge=new Alert(AlertType.CONFIRMATION);
        				missatge.setTitle("Comprar Vol");
        				missatge.setHeaderText("Estas segur que vols comprar el Vol?");
        				
        				ButtonType buttonTypeComprarViatge = new ButtonType("Comprar Viatge", ButtonData.OTHER);
        				ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        				
        				missatge.getButtonTypes().setAll(buttonTypeComprarViatge, buttonTypeCancel);
        				
        				Optional<ButtonType> result = missatge.showAndWait();

    					if (result.get() == buttonTypeComprarViatge){

    				    	tabAnterior = tabOfertes;				    	
    						volSeleccionat = valorSeleccionat;	
				
    						tabPaneMenu.getTabs().removeAll(tabPaneMenu.getTabs());
    		
    				    	tabPaneMenu.getTabs().add(tabComprarViatge1);

    					}
    					
    				}				
    																			
					OfertesimatgeiDescripcio.getSelectionModel().select(OfertesimatgeiDescripcio.getItems().size() - 1);	
    				    				
				}
			}    		
		});

        
        textPuntRecollidaCompra.setDisable(true);
        
        //correu Usuari
        
        correuUsuari.setText("Usuari: " + login.correu);
        
       
        ViatgeComboBoxDesti.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					IDdestiFiltrat=valorSeleccionat;
    				}
    		}
    	});
        
        ViatgeComboBoxOrigen.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					IDorigenFiltrat=valorSeleccionat;
    				}
    		}
    	});
        
        ComboboxActEquipatge.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					IdPuntAct=valorSeleccionat;
    				}
    		}
    	});
        
        //pillar el id usuario
        
        idUsuari = login.idUsuari;
        
        
       //*******************************************************************
        

        
		nombreEquipatge.setCellValueFactory(new PropertyValueFactory<equipatge,Integer>("idEquipatge"));
		PesEquipatgeCompra.setCellValueFactory(new PropertyValueFactory<equipatge,String>("pes"));
		puntRecollidaEquipatgeCompra.setCellValueFactory(new PropertyValueFactory<equipatge,String>("puntRecollida"));
		
		confirmacioOrigen.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		confirmacioDesti.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		confirmacioHoraSortida.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		confirmacioHoraArribada.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		confirmacioPreu.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
		confirmacioNumeroEquipatges.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("pes"));
		confirmacioNumeroPlaces.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("persones"));
                
		idEquipatgeEquipatges.setCellValueFactory(new PropertyValueFactory<equipatge,Integer>("idEquipatge"));
		pesEquipatges.setCellValueFactory(new PropertyValueFactory<equipatge,Integer>("pes"));
		puntRecollidaEquipatges.setCellValueFactory(new PropertyValueFactory<equipatge,String>("puntRecollida"));
		
        checkboxUbicacioPersonalitzada.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            	if (checkboxUbicacioPersonalitzada.isSelected()) {
            		comboBoxPuntsRecollida.setDisable(true);
            		textPuntRecollidaCompra.setDisable(false);
            	}
            	else {
            		comboBoxPuntsRecollida.setDisable(false);
            		textPuntRecollidaCompra.setDisable(true);
            	}
            }
        });
        
        numeroPlaces1.textProperty().addListener(new ChangeListener<String>() {
        	@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		if (newValue != null) {
        			if (!newValue.matches("\\d*")) {
        				numeroPlaces1.setText(newValue.replaceAll("[^\\d]", ""));
        	        }
        			if (newValue.matches("")) {
        				numeroPlaces1.setText(newValue.replaceAll("", "0"));
        			}	
        			if (oldValue.contains("0") && newValue.length() > 1) {
        				numeroPlaces1.setText(newValue);
        				numeroPlaces1.setText(numeroPlaces1.getText().substring(1, numeroPlaces1.getText().length()));
        			}
        		}
        	}
        });        

        numeroPlaces2.textProperty().addListener(new ChangeListener<String>() {
        	@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		if (newValue != null) {
        			if (!newValue.matches("\\d*")) {
        				numeroPlaces2.setText(newValue.replaceAll("[^\\d]", ""));
        	        }
        			if (newValue.matches("")) {
        				numeroPlaces2.setText(newValue.replaceAll("", "0"));
        			}	
        			if (oldValue.contains("0") && newValue.length() > 1) {
        				numeroPlaces2.setText(newValue);
        				numeroPlaces2.setText(numeroPlaces2.getText().substring(1, numeroPlaces2.getText().length()));
        			}
        		}
        	}
        });            
        
        numeroPlaces3.textProperty().addListener(new ChangeListener<String>() {
        	@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		if (newValue != null) {
        			if (!newValue.matches("\\d*")) {
        				numeroPlaces3.setText(newValue.replaceAll("[^\\d]", ""));
        	        }
        			if (newValue.matches("")) {
        				numeroPlaces3.setText(newValue.replaceAll("", "0"));
        			}	
        			if (oldValue.contains("0") && newValue.length() > 1) {
        				numeroPlaces3.setText(newValue);
        				numeroPlaces3.setText(numeroPlaces3.getText().substring(1, numeroPlaces3.getText().length()));
        			}
        		}
        	}
        });         
        
        textPesEquipatgeCompra.textProperty().addListener(new ChangeListener<String>() {
        	@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		if (newValue != null) {
        			if (!newValue.matches("\\d*")) {
        				textPesEquipatgeCompra.setText(newValue.replaceAll("[^\\d]", ""));
        	        }
        		}
        	}
        });         
        
        // Viatges Comprats
        
		idSeguimentVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("iddistribuciovols"));
		origenVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("idorigen"));
		destiVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,String>("iddesti"));
		horaSortidaVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaSortida"));
		horaArribadaVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,LocalDateTime>("horaArribada"));
		preuVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("preu"));
		numeroEquipatgesVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("pes"));
		numeroPlacesVolsComprats.setCellValueFactory(new PropertyValueFactory<distribuciovols,Integer>("persones"));
		
		
		ArrayList<String> dadesVolsComprats = new ArrayList<String>();
		
		ObservableList<distribuciovols> llistaAfegirVolsClient = FXCollections.observableArrayList();

		distribuciovolsDAOImpl dao = new distribuciovolsDAOImpl();
		
		dadesVolsComprats = dao.cercarTotsVolsClient(conexio2, Integer.parseInt(idUsuari));
		
		int idSeguimentComprat, preuComprat, equipatgesComprats, placesComprades;
		String origenComprat, destiComprat;
		LocalDateTime dataHoraSortidaComprada, dataHoraArribadaComprada;
		
		for (int i = 0; i < dadesVolsComprats.size(); i++) {
			
			idSeguimentComprat = Integer.parseInt(dadesVolsComprats.get(i).split("---")[0]);
			origenComprat = dadesVolsComprats.get(i).split("---")[1];
			destiComprat = dadesVolsComprats.get(i).split("---")[2];
			dataHoraSortidaComprada = LocalDateTime.parse(dadesVolsComprats.get(i).split("---")[3]);
			dataHoraArribadaComprada = LocalDateTime.parse(dadesVolsComprats.get(i).split("---")[4]);
			preuComprat = Integer.parseInt(dadesVolsComprats.get(i).split("---")[5]);
			equipatgesComprats = Integer.parseInt(dadesVolsComprats.get(i).split("---")[6]);
			placesComprades = Integer.parseInt(dadesVolsComprats.get(i).split("---")[7]);
			
			distribuciovols distribuciovolsCompra = new distribuciovols(idSeguimentComprat, origenComprat, destiComprat, preuComprat,
					dataHoraArribadaComprada, dataHoraSortidaComprada, 0, 1, null, null, "1", equipatgesComprats, placesComprades);
			
			llistaAfegirVolsClient.add(distribuciovolsCompra);
			
		}
		    	    	
    	volsComprats.setItems(llistaAfegirVolsClient);	
		
    	volsComprats.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<distribuciovols>() {
    		@Override
			public void changed(ObservableValue<? extends distribuciovols> valorActual, distribuciovols valorAnterior, distribuciovols valorSeleccionat) {
				//per evitar errors de nullPointerException a l'hora de desseleccionar/actualitzar dades ens hem d'assegurar que el valorSeleccionat no sigui null    			
    			if (valorSeleccionat!=null) {
    				volSeleccionat = valorSeleccionat;
    				
    				if (visualitzarEquipatge.isDisabled()) {
    					visualitzarEquipatge.setDisable(false);
    				}
    				
    			}
    			
    		}
		});
        
        
    	
    }
    
    public void enMostrarOfertes() {
    	if (mostrarOfertes) {
        	mostrarOfertes = false;    		
    	}
    	else {
        	mostrarOfertes = true;
    	}
    }
    
    @FXML
    private void pantallaRegistre() throws IOException {
        App.setRoot("registre");
    }

}
