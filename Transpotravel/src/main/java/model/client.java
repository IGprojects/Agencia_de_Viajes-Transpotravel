package model;

public class client extends persona{

	private boolean clientGold;
	static String correu;

	public client(String nom, String cognoms, String dni, String adreca, String correu, String telefon,
			boolean clientGold) {
		super(nom, cognoms, dni, adreca, correu, telefon);
		this.clientGold = clientGold;//
	}

	public boolean getClientGold() {
		return clientGold;
	}

	public void setClientGold(boolean clientGold) {
		this.clientGold = clientGold;
	}

	@Override
	public String toString() {
		return "client [clientGold=" + clientGold + "]";
	}
	
}
