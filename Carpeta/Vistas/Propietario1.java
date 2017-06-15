package Vistas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Cliente;
import Models.Container;
import Models.Validaciones;
import java.awt.Font;
public class Propietario1 {

	/**
	 * Atributos
	 */
	private JFrame frameaux;
	private JFrame frame6;
	private JButton btnAsignar;
	private JButton btnCrear;
	private JButton btnVolver;
	private JTextField textNDni;
	private JButton btnBuscar;
	private JLabel lblNdni;
	private JButton btnVolver2;
	private JTextField textLetra;
	private JLabel lblLetra;
	private JLabel lblfoto;


	/**
	 * Constructor
	 * @param frame3 
	 */
	public Propietario1(JFrame frame3) {
		frame6 = new JFrame();
		btnAsignar = new JButton("<html>Asignar<br>a<br> cliente</html>");
		btnAsignar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCrear = new JButton("<html>Crear <br> cliente</html>");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNdni = new JLabel("numero dni");
		lblNdni.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textNDni = new JTextField();
		btnVolver2 = new JButton("Volver");
		lblLetra = new JLabel("letra");
		lblLetra.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textLetra = new JTextField();
		frameaux=frame3;
		initialize();
	}

	public JFrame getFrame6() {
		return frame6;
	}

	/**
	 * Inicializacion de los contenidos del frame
	 */
	private void initialize() {
		/**
		 * Las propiedades del frame
		 */
		propiedades();
		
		/**
		 * los eventos del frame
		 */
		eventos();

	}

	/**
	 * Propiedades del frame
	 */
	public void propiedades() {
		frame6.setBounds(100, 100, 450, 300);
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.getContentPane().setLayout(null);
		frame6.getContentPane().add(btnAsignar);

		btnAsignar.setBounds(40, 156, 102, 95);
		frame6.getContentPane().add(btnCrear);
		btnCrear.setBounds(283, 156, 102, 95);

		btnVolver.setBounds(169, 206, 89, 45);
		frame6.getContentPane().add(btnVolver);

		lblNdni.setBounds(157, 76, 89, 14);
		frame6.getContentPane().add(lblNdni);
		lblNdni.setVisible(false);

		textNDni.setBounds(169, 106, 72, 20);
		frame6.getContentPane().add(textNDni);
		textNDni.setColumns(10);
		textNDni.setVisible(false);
		
		btnBuscar.setBounds(169, 148, 82, 47);
		frame6.getContentPane().add(btnBuscar);

		
		
		btnVolver2.setBounds(169, 206, 89, 45);
		frame6.getContentPane().add(btnVolver2);
		
		
		textLetra.setBounds(251, 106, 20, 20);
		frame6.getContentPane().add(textLetra);
		textLetra.setColumns(10);
		
		
		lblLetra.setBounds(252, 76, 46, 14);
		frame6.getContentPane().add(lblLetra);
		
		lblfoto = new JLabel("");
		lblfoto.setBounds(0, 0, 434, 262);
		Image img = new ImageIcon(Propietario1.class.getResource("/Imagenes/propietario1.jpg")).getImage();
		 Image newImg = img.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
		lblfoto.setIcon(new ImageIcon(newImg));
		frame6.getContentPane().add(lblfoto);
		btnBuscar.setVisible(false);
		btnVolver2.setVisible(false);
		lblLetra.setVisible(false);
		textLetra.setVisible(false);
	}

	
	/**
	 * Eventos del frame
	 */
	public void eventos() {
		/**
		 * Boton Asignar
		 * su funcion hace que cuando queremos asignar un vehiculo a un cliente ya existente
		 * se lo asignaremos por el dni
		 */
		btnAsignar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNdni.setVisible(true);
				textNDni.setVisible(true);
				btnBuscar.setVisible(true);
				lblNdni.setText("Introduzca dni");
                btnVolver.setVisible(false);
                btnVolver2.setVisible(true);
				btnCrear.setVisible(false);
				btnAsignar.setVisible(false);
				lblLetra.setVisible(true);
				textLetra.setVisible(true);
				
				
			}
		});

		/**
		 * Boton CrearCliente
		 * su funcion es cuando le des te saltara a otro frame de creacion de cliente
		 */
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Propietario ventana = new Propietario(frame6);
				ventana.getFrame7().setVisible(true);
				frame6.setVisible(false);

			}
		});
		
		/**
		 * Boton Buscar
		 * Cuando le demos a buscar mirara si el dni esta introducido,
		 * si existe clientes en el arrayList
		 * y recorrera un for buscando si existe el dni. 
		 */
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			    String dni;
			    int decision=-1;
			    boolean escorrecto=false;
			    if(Container.getListaClientes().isEmpty()){
			    	JOptionPane.showMessageDialog(frame6,"No hay clientes en la base de datos");
			    	
			    }
				dni=Validaciones.validarDni(textNDni.getText(), textLetra.getText());
				
				
				for (int i = 0; i < Container.getListaClientes().size(); i++) {
					if (Container.getListaClientes().get(i).getNif().toUpperCase().equals(dni.toUpperCase())) {
						
						escorrecto=true;
					}
					
				}
				if(escorrecto){
				decision = JOptionPane.showConfirmDialog(frame6,"Quiere añadir este vehiculo a el cliente con dni: " + dni);
				
				if(decision==JOptionPane.YES_OPTION){
					Container.getListaVehiculos().get(Container.getListaClientes().size()-1).setDniCliente(dni);
					JOptionPane.showMessageDialog(frame6, "Se le ha asignado el cliente al vehiculo");	
				    Principal.getFrame2().setVisible(true);
					frame6.dispose();
				
				}
				if(decision == JOptionPane.NO_OPTION){
					textLetra.setText("");
					textNDni.setText("");
					JOptionPane.showMessageDialog(frame6, "Usted ha eligido no");
				}
				if(decision == JOptionPane.CANCEL_OPTION){
					JOptionPane.showMessageDialog(frame6, "Cancelado");
				}
				}
				if(decision==-1){
					JOptionPane.showMessageDialog(frame6, "El Cliente no existe");
				}

			}

		});

		/**
		 * boton volver 
		 * Volvera al frame anterior
		 */
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame6.setVisible(false);
				frameaux.setVisible(true);
				frame6.dispose();
				
			}
		});
		
		/**
		 * Boton volverAtras
		 * Volvera a asignar y crear.
		 * 		 */
		btnVolver2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblNdni.setVisible(false);
				textNDni.setVisible(false);
				btnBuscar.setVisible(false);
				btnVolver.setVisible(true);
				btnVolver2.setVisible(false);
				btnCrear.setVisible(true);
				btnAsignar.setVisible(true);
				lblLetra.setVisible(false);
				textLetra.setVisible(false);
				
			}
		});

	}
}