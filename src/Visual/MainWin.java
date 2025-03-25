package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controler.Controller;
import Modeloa.DatuakGuztiak;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainWin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ProduktoId;
	private JTextField ProduktoIzena;
	private JTextField Prezioa;
	private JTextField BezeroId;
	private JTextField BezeroIzena;
	private JTextField Kopurua;
	private Controller controller;
	private JTextField Kantitatea;
	private JTextField ErantzunaPro;
	private JTextField ErantzunaEros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MainWin() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produktuaren id-a");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 126, 27);
		contentPane.add(lblNewLabel);
		
		ProduktoId = new JTextField();
		ProduktoId.setBounds(176, 10, 187, 27);
		contentPane.add(ProduktoId);
		ProduktoId.setColumns(10);
		
		ProduktoIzena = new JTextField();
		ProduktoIzena.setColumns(10);
		ProduktoIzena.setBounds(176, 47, 187, 27);
		contentPane.add(ProduktoIzena);
		
		JLabel lblProduktuarenIzena = new JLabel("Produktuaren izena");
		lblProduktuarenIzena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProduktuarenIzena.setBounds(10, 47, 156, 27);
		contentPane.add(lblProduktuarenIzena);
		
		Prezioa = new JTextField();
		Prezioa.setColumns(10);
		Prezioa.setBounds(176, 84, 187, 27);
		contentPane.add(Prezioa);
		
		JLabel lblNewLabel_1_1 = new JLabel("Produktuaren prezioa");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 84, 156, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JButton Gorde = new JButton("Gorde");
		Gorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(ProduktoId.getText());
				String izena=ProduktoIzena.getText();
				double prezio=Double.parseDouble(Prezioa.getText());
				int kopurua=Integer.parseInt(Kantitatea.getText());
				boolean badago=false;
				
				try {
					try {
						badago=controller.produktuGehitu(id,izena,prezio,kopurua);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(badago==false) {
					ErantzunaPro.setText("Ondo sortu da");
				}
				else {
					ErantzunaPro.setText("Ezin izan da sortu");
				}
			}
		});
		Gorde.setFont(new Font("Tahoma", Font.BOLD, 15));
		Gorde.setBounds(247, 167, 116, 38);
		contentPane.add(Gorde);
		
		JComboBox Lista = new JComboBox();
		Lista.setEditable(true);
		Lista.setModel(new DefaultComboBoxModel(new String[] {"PS4", "XBOX", "SWITCH"}));
		Lista.setBounds(493, 9, 101, 32);
		contentPane.add(Lista);
		
		JLabel lblProduktua = new JLabel("Produktua");
		lblProduktua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProduktua.setBounds(403, 10, 80, 27);
		contentPane.add(lblProduktua);
		
		JLabel lblBezeroarenIda = new JLabel("Bezeroaren id-a");
		lblBezeroarenIda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBezeroarenIda.setBounds(403, 54, 116, 27);
		contentPane.add(lblBezeroarenIda);
		
		BezeroId = new JTextField();
		BezeroId.setColumns(10);
		BezeroId.setBounds(529, 56, 184, 27);
		contentPane.add(BezeroId);
		
		BezeroIzena = new JTextField();
		BezeroIzena.setEnabled(false);
		BezeroIzena.setColumns(10);
		BezeroIzena.setBounds(529, 93, 184, 27);
		contentPane.add(BezeroIzena);
		
		JLabel lblBezeroarenIzenna = new JLabel("Bezeroaren izena");
		lblBezeroarenIzenna.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBezeroarenIzenna.setBounds(403, 91, 126, 27);
		contentPane.add(lblBezeroarenIzenna);
		
		JLabel lblKopurua = new JLabel("Kopurua");
		lblKopurua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKopurua.setBounds(403, 130, 126, 27);
		contentPane.add(lblKopurua);
		
		Kopurua = new JTextField();
		Kopurua.setColumns(10);
		Kopurua.setBounds(529, 132, 184, 27);
		contentPane.add(Kopurua);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(373, 10, 20, 195);
		contentPane.add(separator);
		
		JButton Erosi = new JButton("Erosi");
		Erosi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int bezeroId=Integer.parseInt(BezeroId.getText());
				String bezeroIzena=BezeroIzena.getText();
				int kopurua=Integer.parseInt(Kopurua.getText());
				String marka=(String) Lista.getSelectedItem();
				boolean badago=false;
				Controller controller=new Controller();
				try {
					try {
						badago=controller.Erosi(bezeroId,bezeroIzena,kopurua,marka);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(badago==true) {
					ErantzunaEros.setText("Erosketa ondo egin da");
				}
				else {
					ErantzunaEros.setText("Erosketa ezin izan da egin");
				}
			}
		});
		Erosi.setFont(new Font("Tahoma", Font.BOLD, 15));
		Erosi.setBounds(587, 167, 126, 38);
		contentPane.add(Erosi);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 214, 703, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox ListaTabla = new JComboBox();
		ListaTabla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ListaTabla.setModel(new DefaultComboBoxModel(new String[] {"Denak", "Erosleak bakarrik"}));
		ListaTabla.setBounds(10, 10, 112, 29);
		panel.add(ListaTabla);
		
		JButton Aurkitu = new JButton("Aurkitu");
		Aurkitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String erabaki=(String) ListaTabla.getSelectedItem();
			}
		});
		Aurkitu.setFont(new Font("Tahoma", Font.BOLD, 15));
		Aurkitu.setBounds(576, 11, 117, 27);
		panel.add(Aurkitu);
		
		Kantitatea = new JTextField();
		Kantitatea.setColumns(10);
		Kantitatea.setBounds(176, 130, 187, 27);
		contentPane.add(Kantitatea);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Produktuaren kantitatea");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 130, 227, 27);
		contentPane.add(lblNewLabel_1_1_1);
		
		ErantzunaPro = new JTextField();
		ErantzunaPro.setEnabled(false);
		ErantzunaPro.setBounds(10, 167, 227, 38);
		contentPane.add(ErantzunaPro);
		ErantzunaPro.setColumns(10);
		
		ErantzunaEros = new JTextField();
		ErantzunaEros.setEnabled(false);
		ErantzunaEros.setColumns(10);
		ErantzunaEros.setBounds(390, 167, 187, 38);
		contentPane.add(ErantzunaEros);
		
		JTable table=tablaBete();
		panel.add(table);
	}
	
	public JTable tablaBete() {
		
		JTable table=new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_BEZEROA", "BEZEROA", "PRODUKTUA", "KOPURUA", "PREZIOA", "PREZIO_TOTALA"
			}
		));
		table.setBounds(10, 49, 683, 158);
		
		return table;
		
	}
}
