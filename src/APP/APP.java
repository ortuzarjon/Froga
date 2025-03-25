package APP;

import java.sql.SQLException;

import Controler.Controller;
import Modeloa.BBDD.BezeroConnect;
import Modeloa.BBDD.ErosketaConnect;
import Modeloa.BBDD.ProduktoConnect;
import Visual.MainWin;

public class APP {

	public static void main(String[] args) throws SQLException {
		MainWin mainWin=new MainWin();
		mainWin.setVisible(true);
		
		Controller controller=new Controller();
		ProduktoConnect poCon=new ProduktoConnect();
		poCon.datuakHartu();
		
		BezeroConnect bCon=new BezeroConnect();
		bCon.bezeroDatuak();
		
		ErosketaConnect eCon=new ErosketaConnect();
		eCon.erosketaDatuak();
	}

}
