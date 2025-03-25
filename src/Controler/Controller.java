package Controler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Modeloa.Bezeroa;
import Modeloa.DatuakGuztiak;
import Modeloa.Erosketa;
import Modeloa.Produktua;
import Modeloa.BBDD.BezeroConnect;
import Modeloa.BBDD.ErosketaConnect;
import Modeloa.BBDD.ProduktoConnect;

public class Controller {
	
	Produktua produktua=new Produktua();
	static ProduktoConnect produktoCon=new ProduktoConnect();
	static ErosketaConnect erosketaCon=new ErosketaConnect(); 
	static BezeroConnect bezeroCon=new BezeroConnect();
	
	public static ArrayList<DatuakGuztiak> tablaBete(){
		ArrayList<Bezeroa> bezeroList=new ArrayList<Bezeroa>();
		
		DatuakGuztiak datuGuzti=new DatuakGuztiak();
		
		ArrayList<Produktua> produktoList=new ArrayList<Produktua>();
		try {
			produktoList=produktoCon.datuakHartu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bezeroList=bezeroCon.bezeroDatuak();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Erosketa> erosketaList=new ArrayList<Erosketa>();
		try {
			erosketaList=erosketaCon.erosketaDatuak();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<DatuakGuztiak> datuList=new ArrayList<DatuakGuztiak>();
		double prezioTotal=0;
		
		for(int i=0;i<erosketaList.size();i++) {
			
			datuGuzti.setId(erosketaList.get(i).getBezeroId());
			datuGuzti.setKopurua(erosketaList.get(i).getKopurua());
				
			for(int j=0;j<produktoList.size();j++) {
				if(erosketaList.get(i).getProduktuId()==produktoList.get(j).getId()) {
					datuGuzti.setProduktua(produktoList.get(j).getIzena());
					datuGuzti.setPrezioa(produktoList.get(j).getPrezioa());
				}
			}
			
			datuGuzti.setPrezioTotal(datuGuzti.getPrezioa()*datuGuzti.getKopurua());
			datuList.add(datuGuzti);
		}
		
		return datuList;
	}
	public static boolean produktuGehitu(int id, String izena, double prezio, int kopurua) throws SQLException, FileNotFoundException {
		boolean badago=produktoCon.produktoGehitu(id,izena,prezio,kopurua);
		
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(new File("./src/APP/Binario.bin")));
		
		try {
			dos.writeUTF("Produktu_berria");
			dos.writeInt(id);
			dos.writeUTF(izena);
			dos.writeInt(kopurua);
			dos.writeDouble(prezio);
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return badago;
	}
	
	public static boolean Erosi(int bezeroId, String bezeroIzena, int kopurua, String marka) throws SQLException, FileNotFoundException {
		boolean badago=erosketaCon.produktoErosi(bezeroId,bezeroIzena,kopurua,marka);
		
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(new File("./src/APP/Binario.bin")));
		
		try {
			dos.writeUTF("Erosketa");
			dos.writeInt(bezeroId);
			dos.writeUTF(bezeroIzena);
			dos.writeInt(kopurua);
			dos.writeUTF(marka);
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return badago;
	}
	
	public static ArrayList<Bezeroa> bezeroDatuak() throws SQLException{
		ArrayList<Bezeroa> bezeroList=bezeroCon.bezeroDatuak();
		return bezeroList;
	}
	
	public static ArrayList<Produktua> produktoDatuak() throws SQLException{
		ArrayList<Produktua> produktoList=produktoCon.datuakHartu();
		return produktoList;
	}
}
