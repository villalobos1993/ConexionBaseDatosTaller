package Vistas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Models.Cliente;
import Models.Container;
import Models.Validaciones;
import Models.Vehiculo;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import DAO.InsertCocheDAO;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.List;

import javax.swing.SwingConstants;

import java.awt.Choice;

public class CrearVehiculo {

	private JFrame frame3;
	private JLabel lblmatricula;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblPuertas;
	private JLabel lbltipodiesel;
	private JLabel lblanio;
	private JLabel lblcv;
	private JTextField txtmatricula;
	private JTextField txtmodelo;
	private JTextField txtcv;
	private JButton btncrear;
	private String[] marca;
	private String[] tipo;
	private String[] color;
	private Vehiculo coche;
	private JLabel lblColor;
	private JSpinner spinner;
	private JList listmarca;
	private JButton btnVolver;
	private JScrollPane scrollPanemarca;
	private JList listtipo;
	private JList listcolor;
	private JScrollPane scrollPanecolor;
	private JSpinner spinnerpuertas;
	private JButton btnempleado;
	private JLabel lbltipovehiculo ;
	private String[]tipovehiculo;
	private JList listtipovehiculo;
	private String tipoaux;
	private JLabel lblfoto;

	
	public CrearVehiculo(String vehiculoenviado) {

		frame3 = new JFrame();
		lblmatricula = new JLabel("Matricula:");

		lblMarca = new JLabel("Marca:");

		lblModelo = new JLabel("Modelo:");

		lblPuertas = new JLabel("Puertas:");

		lbltipodiesel = new JLabel("Diesel o Gasolina:");

		lblanio = new JLabel("A\u00F1o Matriculacion:");

		lblcv = new JLabel("CV:");

		txtmodelo = new JTextField();

		txtcv = new JTextField();

		btncrear = new JButton("CREAR");
		btncrear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

		spinner = new JSpinner();

		txtmatricula = new JTextField();

		tipo = new String[] { "Diesel", "Gasolina" };
		marca = new String[] { "Peugeot", "Dacia", "Citroen", "Volkswagen", "Seat", "Audi", "BMW", "KIA", "Mercedes",
				"Renault", "Ford", "Land Rover", "Mitsubishi", "Jaguar", "Range Rover" };
		color = new String[] { "Rojo", "Azul", "Verde", "Marrón", "Negro", "Blanco", "Veige", "Amarillo", "Lila",
				"Gris" };
		spinnerpuertas = new JSpinner();
		spinnerpuertas.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		listmarca = new JList(marca);
		listcolor = new JList(color);
		listtipo = new JList(tipo);
		tipovehiculo=new String[]{"Coche","Moto","Bicicleta","Camion"};

		scrollPanemarca = new JScrollPane(listmarca);

		scrollPanecolor = new JScrollPane(listcolor);

		btnempleado = new JButton("<html><br>CREAR PROPIETARIO<br></html>");

		btnempleado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnempleado.setVerticalAlignment(SwingConstants.TOP);
		lbltipovehiculo = new JLabel("TipoVehiculo:");
		listtipovehiculo = new JList(tipovehiculo);
		tipoaux=vehiculoenviado;
		coche=new Vehiculo();
		 
		btnVolver = new JButton("VOLVER");
		
		initialize();

	}

	private void initialize() {

		propiedades();
		eventos();
	}

	private void propiedades() {

		frame3.setBounds(120, 120, 470, 422);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		frame3.getContentPane().add(lblmatricula);
		frame3.getContentPane().add(lblMarca);
		frame3.getContentPane().add(lblModelo);
		frame3.getContentPane().add(lblPuertas);
		frame3.getContentPane().add(lbltipodiesel);
		frame3.getContentPane().add(lblanio);
		frame3.getContentPane().add(lblcv);
		frame3.getContentPane().add(txtmatricula);
		txtmatricula.setColumns(10);
		frame3.getContentPane().add(txtmodelo);
		txtmodelo.setColumns(10);
		txtmodelo.setBounds(100, 149, 90, 26);
		frame3.getContentPane().add(txtcv);
		txtcv.setColumns(10);
		txtcv.setBounds(343, 141, 97, 26);
		lblPuertas.setBounds(24, 200, 90, 14);
		lblPuertas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lbltipodiesel.setBounds(200, 103, 133, 14);
		lbltipodiesel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblModelo.setBounds(24, 153, 90, 14);
		lblModelo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMarca.setBounds(24, 103, 72, 14);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblmatricula.setBounds(24, 54, 90, 14);
		lblmatricula.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		frame3.getContentPane().add(btncrear);
		frame3.getContentPane().add(txtmatricula);
		txtmatricula.setColumns(10);
		txtmatricula.setBounds(99, 50, 90, 26);

		lblColor = new JLabel("Color:");
		lblColor.setBounds(200, 190, 61, 16);
		lblColor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame3.getContentPane().add(lblColor);

		spinner.setModel(new SpinnerNumberModel(2017, 1900, 2017, 1));
		frame3.getContentPane().add(spinner);

		listmarca.setBounds(99, 126, 89, 16);
		frame3.getContentPane().add(scrollPanemarca);
		frame3.getContentPane().add(listtipo);

		listcolor.setBounds(430, 214, -101, 14);
		frame3.getContentPane().add(scrollPanecolor);

		listtipo.setBounds(343, 91, 97, 39);

		lblcv.setBounds(200, 145, 66, 14);
		lblcv.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		spinnerpuertas.setBounds(100, 195, 89, 28);
		frame3.getContentPane().add(spinnerpuertas);

		btnempleado.setBounds(11, 309, 123, 64);
		frame3.getContentPane().add(btnempleado);
		btnempleado.setVisible(false);

		scrollPanecolor.setBounds(340, 182, 100, 46);

		scrollPanemarca.setBounds(99, 90, 95, 46);

		spinner.setBounds(337, 53, 107, 20);

		btncrear.setBounds(148, 309, 161, 64);

		lblanio.setBounds(200, 54, 133, 14);
		lblanio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		
		lbltipovehiculo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lbltipovehiculo.setBounds(200, 259, 133, 39);
		frame3.getContentPane().add(lbltipovehiculo);
		
		
		
		
		listtipovehiculo.setBounds(343, 239, 90, 78);
		frame3.getContentPane().add(listtipovehiculo);
		listtipovehiculo.setEnabled(false);
		
		lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(CrearVehiculo.class.getResource("/Imagenes/crearvehiculo.png")));
		lblfoto.setBounds(49, -36, 470, 409);
		frame3.getContentPane().add(lblfoto);
		
		
		btnVolver.setBounds(344, 332, 89, 23);
		frame3.getContentPane().add(btnVolver);
		for(int i=0;i<tipovehiculo.length;i++)
		{
			if(tipoaux.equals(tipovehiculo[i])){
				
				listtipovehiculo.setSelectedIndex(i);
				coche.setTipoVehiculo(tipovehiculo[i]);
			}
		}
		
		

	}

	public JFrame getFrame() {
		return frame3;
	}

	private void eventos() {
		btncrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean escorrecto = true;
				int contador = 0;

				/**
				 * Hacemos las validaciones ,desde las que tenemos en clase
				 * 
				 */

				// matricula

				String matricula = Validaciones.validarmatricula(txtmatricula.getText());
				if (matricula.equals("0")) {
					escorrecto = false;
				}

				// marca

				String marca = Validaciones.validarmarca((String) listmarca.getSelectedValue());
				if (marca.equals("0")) {
					escorrecto = false;
				}

				// modelo

				String modelo = Validaciones.validarmodelo(txtmodelo.getText());

				// puertas no necesita validacion

				// anho matriculacion tampoco

				// tipo gasoil
				String tipo = Validaciones.validarcombustible((String) listtipo.getSelectedValue());
				if (tipo.equals("0")) {
					escorrecto = false;
				}

				// CV

				int caballos = Validaciones.validarcv(txtcv.getText());
				if (caballos == 0) {
					escorrecto = false;
				}

				// color
				String color = Validaciones.validarcolor((String) listcolor.getSelectedValue());
				if (color.equals("0")) {
					escorrecto = false;
				}
				if (escorrecto) {

					coche.setMatricula(matricula);
					coche.setMarca(marca);
					coche.setModelo(modelo);
					coche.setNumPuertas((int)spinnerpuertas.getValue());
					coche.setColor(color);
					coche.setTipoGas(tipo);
					coche.setFechamatriculacion((int)spinner.getValue());
					coche.setCv(caballos);
					coche.setDniCliente(null);
					Container.getListaVehiculos().add(coche);
                    InsertCocheDAO.InsertCoche(matricula, marca, modelo,coche.getNumPuertas(),color,coche.getCv(),coche.getDniCliente());
					JOptionPane.showMessageDialog(frame3, "VEHICULO ANHADIDO");

					txtmatricula.setEnabled(false);
					scrollPanemarca.setEnabled(false);
					listmarca.setEnabled(false);
					txtmodelo.setEnabled(false);
					spinner.setEnabled(false);
					listtipo.setEnabled(false);
					txtcv.setEnabled(false);
					listcolor.setEnabled(false);
					scrollPanecolor.setEnabled(false);
					btncrear.setEnabled(false);

					btnempleado.setVisible(true);

				}

			}
		});

		// Accion del boton crear empleado

		btnempleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Propietario1 window = new Propietario1(frame3);
				window.getFrame6().setVisible(true);
				frame3.setVisible(false);
				// CREACION
			}
		});
		
		// Botón volver
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Principal window = new Principal();
				window.getFrame2().setVisible(true);
				frame3.dispose();
			}
		});

	}
	
	
	public JFrame getFrame3() {
		return frame3;
	}
	public JList getListtipovehiculo() {
		return listtipovehiculo;
	}

	public void setListtipovehiculo(JList listtipovehiculo) {
		this.listtipovehiculo = listtipovehiculo;
	}
}