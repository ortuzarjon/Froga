package Modeloa.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modeloa.Bezeroa;

public class BezeroConnect {
	private static Connection connection() throws SQLException {
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/almacenmvc";
		String user="root";
		String password="";
		
		connection=DriverManager.getConnection(url,user,password);
		return connection;
	}
	
	public static ArrayList<Bezeroa> bezeroDatuak() throws SQLException{
		
		Bezeroa bezeroa=new Bezeroa();
		ArrayList<Bezeroa> bezeroList=new ArrayList<Bezeroa>();
		
		Connection con=connection();
		
		Statement st=con.createStatement();
		String kontsulta="SELECT * FROM cliente;";
		
		ResultSet rSet=st.executeQuery(kontsulta);
		
		while(rSet.next()) {
			bezeroa=new Bezeroa();
			bezeroa.setId(rSet.getInt("Id_cliente"));
			bezeroa.setIzena(rSet.getString("Nombre"));
			bezeroa.setAbizena(rSet.getString("Apellido"));
			
			bezeroList.add(bezeroa);
		}
		return bezeroList;
	}
}
