package Modeloa.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controler.Controller;
import Modeloa.Bezeroa;
import Modeloa.Erosketa;
import Modeloa.Produktua;

public class ErosketaConnect {
	private static Connection connection() throws SQLException {
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/almacenmvc";
		String user="root";
		String password="";
		
		connection=DriverManager.getConnection(url,user,password);
		return connection;
	}
	
	public static ArrayList<Erosketa> erosketaDatuak() throws SQLException{
		ArrayList<Erosketa> erosketaList=new ArrayList<Erosketa>();
		Erosketa erosketa=new Erosketa();
		
		Connection con=connection();
		Statement st=con.createStatement();
		String kontsulta="SELECT * FROM compras";
		
		ResultSet rSet=st.executeQuery(kontsulta);
		
		while(rSet.next()) {
			erosketa=new Erosketa();
			erosketa.setEroskteaid(rSet.getInt("Id_compra"));
			erosketa.setBezeroId(rSet.getInt("Id_cliente"));
			erosketa.setProduktuId(rSet.getInt("Id_producto"));
			erosketa.setKopurua(rSet.getInt("cantidad_comprada"));
			
			erosketaList.add(erosketa);
		}
		return erosketaList;
	}
	
	public static boolean produktoErosi(int bezeroId, String bezeroIzena, int kopurua, String marka) throws SQLException {
		Connection con=connection();
		Statement st=con.createStatement();
		Controller controller =new Controller();
		
		ArrayList<Produktua> produktoList=controller.produktoDatuak();
		
		boolean badago=false;
		
		ArrayList<Bezeroa> bezeroList= controller.bezeroDatuak();
		ArrayList<Erosketa> erosketaList=erosketaDatuak();
		int produktoId=0;
		
		System.out.println(marka);
		for(int i=0;i<produktoList.size();i++) {
			System.out.println(produktoList.get(i).getId());
			System.out.println(produktoList.get(i).getIzena());
			if(produktoList.get(i).getIzena().equalsIgnoreCase(marka)) {
				produktoId=produktoList.get(i).getId();
				System.out.println(produktoId);
				break;
			}
		}
		System.out.println(produktoId);
		int compraId=erosketaList.size()+1;
		
		String kontsulta="INSERT INTO compras(Id_compra,Id_cliente,Id_producto,cantidad_comprada) VALUES('"+compraId+"','"+
				bezeroId+"','"+produktoId+"','"+kopurua+"');";
		String kontsulta2="UPDATE producto SET Cantidad=Cantidad-"+kopurua+" WHERE Id_producto="+produktoId+";";
		
		System.out.println("Hasi");
		for(int i=0;i<bezeroList.size();i++) {
			System.out.println(bezeroList.get(i).toString());
			if(bezeroList.get(i).getId()==bezeroId) {
				System.out.println(bezeroList.get(i).toString());
					for(int n=0;n<produktoList.size();n++) {
						System.out.println(produktoList.get(i).toString());
						if(produktoList.get(i).getKopurua()>=kopurua){
							System.out.println(produktoList.get(i).toString());
							produktoList.get(i).setKopurua(produktoList.get(i).getKopurua()-kopurua);
							badago=true;
							break;
						}
					}
				}
			}
		if(badago==true) {
			st.execute(kontsulta);
			st.execute(kontsulta2);
		}
		
		return badago;
	}
}
