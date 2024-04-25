package cibertec;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DialogVenderCocina extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblcantidadidad;
	private JComboBox cboModelo;
	private JTextField txtVenderPrecio;
	private JTextField txtVendercantidadidad;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnVender;
	private JButton btnCerrar;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public void abrirVentana() {
		try {
			DialogVenderCocina dialog = new DialogVenderCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogVenderCocina() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Vender Cocina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 199, 523, 207);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setColumnHeaderView(txtS);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(0, 0, 594, 176);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(35, 18, 220, 140);
		panel_1.add(panel);
		panel.setBackground(new Color(0, 128, 192));
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 20, 20);
		panel.setLayout(fl_panel);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		panel.add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setForeground(new Color(255, 255, 255));
		panel.add(lblPrecio);
		
		txtVenderPrecio = new JTextField();
		txtVenderPrecio.setText(String.valueOf(Main.precio0));
		txtVenderPrecio.setEditable(false);
		panel.add(txtVenderPrecio);
		txtVenderPrecio.setColumns(10);
		
		lblcantidadidad = new JLabel("Cantidad");
		lblcantidadidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcantidadidad.setForeground(new Color(255, 255, 255));
		panel.add(lblcantidadidad);
		
		txtVendercantidadidad = new JTextField();
		panel.add(txtVendercantidadidad);
		txtVendercantidadidad.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(403, 37, 148, 101);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		btnVender = new JButton("Procesar Venta");
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVender.setForeground(new Color(255, 255, 255));
		btnVender.setBorder(null);
		btnVender.setBounds(0, 0, 148, 44);
		panel_2.add(btnVender);
		btnVender.addActionListener(this);
		btnVender.setBackground(new Color(88, 176, 0));
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(new Color(234, 85, 85));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(0, 57, 148, 44);
		panel_2.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}
	protected void actionPerformedBtnVender(ActionEvent e) {
		
        //Declaracion de variables
		double precio = 0, impCompra = 0, impDes = 0, impPag;
		int cantidad, modeloSeleccionado = 0;
		String obs = null, modelo;

		// Lectura de datos
		modeloSeleccionado = cboModelo.getSelectedIndex();
		modelo = cboModelo.getSelectedItem().toString();
		cantidad = Integer.parseInt(txtVendercantidadidad.getText());

		// Precios

		switch (modeloSeleccionado) {
		case 0:
			precio = Main.precio0;
			impCompra = Main.precio0 * cantidad;
			break;
		case 1:
			precio = Main.precio1;
			impCompra = Main.precio1 * cantidad;
			break;
		case 2:
			precio = Main.precio2;
			impCompra = Main.precio2 * cantidad;
			break;
		case 3:
			precio = Main.precio3;
			impCompra = Main.precio3 * cantidad;
			break;
		case 4:
			precio = Main.precio4;
			impCompra = Main.precio4 * cantidad;
			break;

		default:
			break;
		}

		// Importe de Descuento
		if (cantidad > 1 && cantidad <= 5)
			impDes = impCompra * 0.075;

		else if (cantidad > 5 && cantidad <= 10)
			impDes = impCompra * 0.10;

		else if (cantidad > 10 && cantidad <= 15)
			impDes = impCompra * 0.125;

		else if (cantidad > 15)
			impDes = impCompra * 0.15;

		// Importe a Pagar
		impPag = impCompra - impDes;

		// Obsequio por la cantidadidad
		if (cantidad == 1)
			obs = "Cafetera";
		else if (cantidad >= 2 && cantidad <= 5)
			obs = "Licuadora";
		if (cantidad > 5)
			obs = "Extractor";


		// salida de resultados
		txtS.setText("BOLETA DE VENTAS" + "\n");
		txtS.append("Modelo                          : " + modelo + "\n");
		txtS.append("Precio                          : S/ " + precio + "\n");
		txtS.append("Cantidad 	                : " + cantidad + "\n");
		txtS.append("Importe Compra                  : S/ " + impCompra + "\n");
		txtS.append("Importe Descuento               : S/ " + impDes + "\n");
		txtS.append("Importe Pagar                   : S/ " + impPag + "\n");
		txtS.append("Obsequio                        : " + obs);

	}
		

	protected void actionPerformedCboModelo(ActionEvent e) {
		int modeloSeleccionado = cboModelo.getSelectedIndex();

		switch (modeloSeleccionado) {
		case 0:
			txtVenderPrecio.setText(String.valueOf(Main.precio0));
			break;
		case 1:
			txtVenderPrecio.setText(String.valueOf(Main.precio1));
			break;
		case 2:
			txtVenderPrecio.setText(String.valueOf(Main.precio2));
			break;
		case 3:
			txtVenderPrecio.setText(String.valueOf(Main.precio3));
			break;
		case 4:
			txtVenderPrecio.setText(String.valueOf(Main.precio4));
			break;

		default:
			txtVenderPrecio.setText(String.valueOf(Main.precio0));
			break;
		}

	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}