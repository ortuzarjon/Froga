package Modeloa;

public class Erosketa {
	@Override
	public String toString() {
		return "Erosketa [eroskteaid=" + eroskteaid + ", bezeroId=" + bezeroId + ", produktuId=" + produktuId
				+ ", kopurua=" + kopurua + "]";
	}

	private int eroskteaid;
	private int bezeroId;
	private int produktuId;
	private int kopurua;
	
	public Erosketa(int eroskteaid, int bezeroId, int produktuId,int kopurua) {
		this.eroskteaid = eroskteaid;
		this.bezeroId = bezeroId;
		this.produktuId = produktuId;
		this.kopurua=kopurua;
	}

	public Erosketa() {
	}

	public int getEroskteaid() {
		return eroskteaid;
	}

	public void setEroskteaid(int eroskteaid) {
		this.eroskteaid = eroskteaid;
	}

	public int getBezeroId() {
		return bezeroId;
	}

	public void setBezeroId(int bezeroId) {
		this.bezeroId = bezeroId;
	}

	public int getProduktuId() {
		return produktuId;
	}

	public void setProduktuId(int produktuId) {
		this.produktuId = produktuId;
	}

	public int getKopurua() {
		return kopurua;
	}

	public void setKopurua(int kopurura) {
		this.kopurua = kopurura;
	}
}
