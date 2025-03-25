package Modeloa.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modeloa.Bezeroa;
import Modeloa.Erosketa;
import Modeloa.Produktua;

public class ProduktoConnect {
	
	private static Connection connection() throws SQLException {
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/almacenmvc";
		String user="root";
		String password="";
		
		connection=DriverManager.getConnection(url,user,password);
		return connection;
	}
	
	public static ArrayList<Produktua> datuakHartu() throws SQLException{
		ArrayList<Produktua> produktoList=new ArrayList<Produktua>();
		Produktua produktua=new Produktua();
		Connection con=connection();
		Statement st=con.createStatement();
		
		String kontsulta="SELECT * FROM producto;";
		
		ResultSet rSet=st.executeQuery(kontsulta);
		
		while(rSet.next()) {
			produktua=new Produktua();
			produktua.setId(rSet.getInt("Id_producto"));
			produktua.setIzena(rSet.getString("Nombre"));
			produktua.setPrezioa(rSet.getDouble("Precio"));
			produktua.setKopurua(rSet.getInt("Cantidad"));
			
			produktoList.add(produktua);
		}
		return produktoList;
	}
	
	public boolean produktoGehitu(int id, String izena, double prezio, int kopurua) throws SQLException {
		Connection con=connection();
		Statement st=con.createStatement();
		
		String kontsulta="INSERT INTO producto(Id_producto,Nombre,Precio,Cantidad) VALUES('"+id+"','"+izena+"','"+prezio+"','"+kopurua+"');";
		
		ArrayList<Produktua> produktoList=datuakHartu();
		boolean badago=false;
		
		for(int i=0;i<produktoList.size();i++) {
			if(produktoList.get(i).getId()==id) {
				badago=true;
				break;
			}
		}
		
		if(badago==false) {
			st.execute(kontsulta);
		}
		
		return badago;
	}
}

	

