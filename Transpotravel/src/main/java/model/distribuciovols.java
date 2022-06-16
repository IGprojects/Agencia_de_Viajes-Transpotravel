package model;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

import java.util.ArrayList;

import javafx.scene.image.ImageView;


//import javafx.scene.image.ImageView;

public class distribuciovols {

		int iddistribuciovols;
		String idorigen;
		String iddesti;
		int preu;
		LocalDateTime horaArribada;
		LocalDateTime horaSortida;
		int oferta;
		int recollida;
		String descripcio;
		ImageView ImatgeVirtual;
		String estat;
		int persones;
		int pes;
		
		
		public distribuciovols(int iddistribuciovols, String idorigen, String iddesti, int preu, LocalDateTime horaArribada,
				LocalDateTime horaSortida,int oferta,int recollida,String descripcio,ImageView ImatgeVirtual,String estat,int persones,
				int pes) {
			this.iddistribuciovols = iddistribuciovols;
			this.idorigen = idorigen;
			this.iddesti = iddesti;
			this.preu = preu;
			this.horaArribada = horaArribada;
			this.horaSortida = horaSortida;
			this.oferta=oferta;
			this.recollida = recollida;
			this.descripcio = descripcio;
			this.ImatgeVirtual = ImatgeVirtual;
			this.estat = estat;
			this.pes = pes;
			this.persones = persones;
	
		}
		

		public String getEstat() {
			return estat;
		}



		public void setEstat(String estat) {
			this.estat = estat;
		}

		

		public ImageView getImatgeVirtual() {
			return ImatgeVirtual;
		}


		public void setImatgeVirtual(ImageView imatgeVirtual) {
			ImatgeVirtual = imatgeVirtual;
		}
		

		public String getDescripcio() {
			return descripcio;
		}


		public void setDescripcio(String descripcio) {
			this.descripcio = descripcio;
		}

		
		public int getRecollida() {
			return recollida;
		}


		public void setRecollida(int recollida) {
			this.recollida = recollida;
		}

		
			

		public int getIddistribuciovols() {
			return iddistribuciovols;
		}		




		public void setIddistribuciovols(int iddistribuciovols) {
			this.iddistribuciovols = iddistribuciovols;
		}


		public String getIdorigen() {
			return idorigen;
		}


		public void setIdorigen(String idorigen) {
			this.idorigen = idorigen;
		}


		public String getIddesti() {
			return iddesti;
		}


		public void setIddesti(String iddesti) {
			this.iddesti = iddesti;
		}


		public int getPreu() {
			return preu;
		}


		public void setPreu(int preu) {
			this.preu = preu;
		}


		public LocalDateTime getHoraArribada() {
			return horaArribada;
		}


		public void setHoraArribada(LocalDateTime horaArribada) {
			this.horaArribada = horaArribada;
		}


		public LocalDateTime getHoraSortida() {
			return horaSortida;
		}


		public void setHoraSortida(LocalDateTime horaSortida) {
			this.horaSortida = horaSortida;
		}
		
		public void setIdoferta(int oferta) {
			this.oferta = oferta;
		}


		public int getoferta() {
			return oferta;
		}
		
		


		/*public ImageView getImatge() {
			return imatge;
		}


		public void setImatge(ImageView imatge) {
			this.imatge = imatge;
		}*/
		
		@Override
		public String toString() {
			return "distribuciovols [iddistribuciovols=" + iddistribuciovols + ", idorigen=" + idorigen + ", iddesti="
					+ iddesti + ", preu=" + preu + ", horaArribada=" + horaArribada + ", horaSortida=" + horaSortida
					+ ", oferta=" + oferta + ", puntrecollida=" + recollida + ", pes=" + pes
					+ ", persones=" + persones + " ]";
		}


		public int getPes() {
			return pes;
		}


		public void setPes(int pes) {
			this.pes = pes;
		}


		public int getPersones() {
			return persones;
		}


		public void setPersones(int persones) {
			this.persones = persones;
		}	
		

}
