package Modeloa;

public class DatuakGuztiak {
	private int id;
	private String bezeroa;
	private String produktua;
	private int kopurua;
	private double prezioa;
	private double prezioTotal;
	
	public DatuakGuztiak(int id, String bezeroa, String produktua, int kopurua, double prezioa, double prezioTotal) {
		this.id = id;
		this.bezeroa = bezeroa;
		this.produktua = produktua;
		this.kopurua = kopurua;
		this.prezioa = prezioa;
		this.prezioTotal = prezioTotal;
	}

	public DatuakGuztiak() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeroa() {
		return bezeroa;
	}

	public void setBezeroa(String bezeroa) {
		this.bezeroa = bezeroa;
	}

	public String getProduktua() {
		return produktua;
	}

	public void setProduktua(String produktua) {
		this.produktua = produktua;
	}

	public int getKopurua() {
		return kopurua;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public double getPrezioTotal() {
		return prezioTotal;
	}

	public void setPrezioTotal(double prezioTotal) {
		this.prezioTotal = prezioTotal;
	}
	
}
