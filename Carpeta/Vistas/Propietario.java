package Vistas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import DAO.InsertClienteDAO;
import Models.Cliente;
import Models.Container;
import Models.Validaciones;
import Models.Vehiculo;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DropMode;
import javax.swing.JList;

public class Propietario {

	/**
	 * Atributos
	 */
	private JFrame frameaux;
	private JFrame frame7;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textDNI;
	private JTextField textTeléfono;
	private JTextField textEmail;
	private JTextField textDirección;
	private JLabel labelPropietario;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelDNI;
	private JLabel labelTeléfono;
	private JLabel labelEmail;
	private JLabel labelDirección;
	private JButton buttonVolver;
	private JButton buttonCrear;
	private JTextField textSApellido;
	private JTextField textLetra;
	private JLabel lblLetra;
	private JLabel lblfoto;
	
	/**
	 * Getter
	 * @return frame7
	 */
	public JFrame getFrame7() {
		return frame7;
	}

	
	

	
	/**
	 * Constructor
	 * @param frame6 
	 */
	public Propietario(JFrame frame6) {

		labelPropietario = new JLabel("PROPIETARIO");
		labelNombre = new JLabel("Nombre");
		textNombre = new JTextField();
		textApellido1 = new JTextField();
		labelApellido = new JLabel("Primero Apellido");
		labelDNI = new JLabel("DNI");
		textDNI = new JTextField();
		labelTeléfono = new JLabel("Tel\u00E9fono");
		textTeléfono = new JTextField();
		labelEmail = new JLabel("E-Mail");
		textEmail = new JTextField();
		labelDirección = new JLabel("Direcci\u00F3n");
		textDirección = new JTextField();
		buttonVolver = new JButton("VOLVER");

		buttonCrear = new JButton("CREAR");
		frameaux=frame6;
		frame7 = new JFrame();

		initialize();
	}

	/**
	 * inicializacion del frame
	 */

	private void initialize() {
		/**
		 * Propiedades del frame
		 */
		propiedades();
		/**
		 * Eventos del frame
		 */
		eventos();
	}

	/**
	 * Propiedades del frame
	 */
	public void propiedades() {

		labelPropietario.setBounds(180, 11, 83, 26);
		labelNombre.setBounds(9, 52, 53, 14);
		textNombre.setBounds(10, 71, 122, 20);
		textNombre.setColumns(10);
		textApellido1.setBounds(9, 114, 123, 20);
		textApellido1.setColumns(10);
		labelApellido.setBounds(9, 100, 105, 14);
		labelDNI.setBounds(10, 192, 43, 14);
		textDNI.setBounds(9, 206, 94, 20);
		textDNI.setColumns(10);
		labelTeléfono.setBounds(156, 145, 61, 14);
		textTeléfono.setBounds(156, 161, 142, 20);
		textTeléfono.setColumns(10);
		labelEmail.setBounds(156, 100, 41, 14);
		textEmail.setBounds(158, 114, 140, 20);
		textEmail.setColumns(10);
		labelDirección.setBounds(156, 52, 61, 14);
		textDirección.setBounds(158, 71, 140, 20);
		textDirección.setColumns(10);
		buttonVolver.setBounds(281, 275, 94, 50);
		buttonCrear.setBounds(83, 276, 94, 48);
		frame7.setTitle("PROPIETARIO");
		frame7.setBounds(100, 100, 465, 374);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame7.getContentPane().setLayout(null);
		frame7.getContentPane().add(labelPropietario);
		frame7.getContentPane().add(labelNombre);
		frame7.getContentPane().add(textNombre);
		frame7.getContentPane().add(textApellido1);
		frame7.getContentPane().add(labelApellido);
		frame7.getContentPane().add(labelDNI);
		frame7.getContentPane().add(textDNI);
		frame7.getContentPane().add(labelTeléfono);
		frame7.getContentPane().add(textTeléfono);
		frame7.getContentPane().add(labelEmail);
		frame7.getContentPane().add(textEmail);
		frame7.getContentPane().add(labelDirección);
		frame7.getContentPane().add(textDirección);
		frame7.getContentPane().add(buttonVolver);
		frame7.getContentPane().add(buttonCrear);

		textSApellido = new JTextField();
		textSApellido.setBounds(9, 161, 123, 20);
		frame7.getContentPane().add(textSApellido);
		textSApellido.setColumns(10);

		JLabel lblSApelldio = new JLabel("Segundo Apellido");
		lblSApelldio.setBounds(9, 145, 105, 14);
		frame7.getContentPane().add(lblSApelldio);

		textLetra = new JTextField();
		textLetra.setBounds(111, 206, 22, 20);
		frame7.getContentPane().add(textLetra);
		textLetra.setColumns(10);

		lblLetra = new JLabel("Letra");
		lblLetra.setBounds(111, 192, 46, 14);
		frame7.getContentPane().add(lblLetra);
		
		lblfoto = new JLabel("");
		lblfoto.setBounds(0, 0, 449, 336);
		Image img = new ImageIcon(Propietario.class.getResource("/Imagenes/propietario.jpg")).getImage();
		 Image newImg = img.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
		lblfoto.setIcon(new ImageIcon(newImg));
		frame7.getContentPane().add(lblfoto);
	}

	/**
	 * Eventos del frame
	 */
	public void eventos() {

		/**
		 * Boton crear Validara todos los datos requeridos por el programa si
		 * son validos creara el cliente y lo introducira en la base de datos
		 */
		buttonCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean escorrecto = true;
				String nombre;
				String apellido1;
				String apellido2;
				String Dni;
				String direccion;
				String Email;
				String telefono;

				/**
				 * Verificar Nombre
				 *
				 */

				nombre = Validaciones.validarNombre(textNombre.getText());
				if (nombre.equals("0")) {
					escorrecto = false;
				}

				/**
				 * Verificar apellido1
				 */

				apellido1 = Validaciones.apellido1(textApellido1.getText());
				if (apellido1.equals("0")) {
					escorrecto = false;
				}

				/**
				 * Verificar Apellido2
				 */

				apellido2 = Validaciones.apellido2(textSApellido.getText());
				if (apellido2.equals("0")) {
					escorrecto = false;
				}

				/**
				 * Validar DNI
				 */

				Dni = Validaciones.validarDni(textDNI.getText(), textLetra.getText());
				if (Dni.equals("0")) {
					JOptionPane.showMessageDialog(frame7, "El dni es incorrecto");
					escorrecto = false;
				}

				/**
				 * Direccion
				 */
				direccion=Validaciones.validarDireccion(textDirección.getText());
				if(direccion.equals("0")){
					escorrecto=false;
				}

				/**
				 * Email
				 */
                 Email=Validaciones.validarEmail(textEmail.getText());
				if(Email.equals("0")){
					escorrecto=false;
				}
                 
				/**
				 * Telefono
				 */
				telefono = Validaciones.validarTelefono(textTeléfono.getText());
                 int tlf = Integer.parseInt(telefono); 
				if (escorrecto) {
					
					Cliente cliente = new Cliente(Dni, nombre, apellido1,apellido2,direccion,tlf,Email);
					Container.getListaClientes().add(cliente);
					Container.getListaVehiculos().get(Container.getListaVehiculos().size()-1).setDniCliente(Dni);
				    InsertClienteDAO.InsertCliente(Dni, nombre,Container.getListaVehiculos().get(Container.getListaVehiculos().size()-1).getMatricula());
					Principal windows = new Principal();
					windows.getFrame2().setVisible(true);
					frame7.setVisible(false);
					frame7.dispose();

				}
			}

		});

		/**
		 * Boton Volver volvera al frame anterior
		 */
		buttonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frameaux.setVisible(true);
				
				frame7.setVisible(false);

			}
		});

	}
}
