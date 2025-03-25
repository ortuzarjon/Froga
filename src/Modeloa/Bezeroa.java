package Modeloa;

public class Bezeroa {
	@Override
	public String toString() {
		return "Bezeroa [id=" + id + ", izena=" + izena + ", abizena=" + abizena + "]";
	}

	private int id;
	private String izena;
	private String abizena;
	
	public Bezeroa(int id, String izena, String abizena) {
		this.id = id;
		this.izena = izena;
		this.abizena = abizena;
	}

	public int getId() {
		return id;
	}

	public Bezeroa() {
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

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	
}
