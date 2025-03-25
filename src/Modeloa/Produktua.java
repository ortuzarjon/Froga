package Modeloa;

public class Produktua {
	private int id;
	private String izena;
	private double prezioa;
	private int kopurua;
	
	public Produktua(int id, String izena, double prezioa, int kopurua) {
		this.id = id;
		this.izena = izena;
		this.prezioa = prezioa;
		this.kopurua = kopurua;
	}

	public Produktua() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public int getKopurua() {
		return kopurua;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}
}
