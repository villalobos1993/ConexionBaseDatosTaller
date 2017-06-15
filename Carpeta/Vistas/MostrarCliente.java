package Vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.EditarClienteDAO;
import DAO.MostrarClienteDAO;
import Models.Cliente;
import Models.Container;
import Models.Validaciones;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MostrarCliente {

	private JFrame frame9;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textEmail;
    private JLabel lblNombre;
	private JLabel lblPrimerApellido;
	private JLabel lblSegundoApellido;
	private JLabel lblCliente;
	private JLabel lblDni;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
    private JLabel lblEmail;
    private JButton btnVolver;
    private  JButton btnEditar;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private String DNI;
    /**
	 * Create the application.
	 */
	public MostrarCliente(String dni) {
		frame9 = new JFrame();
		 DNI = dni;
		 lblNombre = new JLabel("Nombre");
		 lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		 lblPrimerApellido = new JLabel("Primer Apellido");
		 lblPrimerApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		 lblSegundoApellido = new JLabel("Segundo Apellido");
		 lblSegundoApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		 lblCliente = new JLabel("Cliente");
		 lblDni = new JLabel("");
		 lblDireccion = new JLabel("Direccion");
		 lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		 lblTelefono = new JLabel("Telefono");
		 lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		 lblEmail = new JLabel("Email");
		 lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		 textNombre = new JTextField();
		 textApellido1 = new JTextField();
		 textApellido2 = new JTextField();
		 textDireccion = new JTextField();
		 textTelefono = new JTextField();
		 textEmail = new JTextField();
		 btnVolver = new JButton("Volver");
		 btnVolver.setBackground(Color.LIGHT_GRAY);
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
			
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		propiedades();
		eventos();
		mostrar();
	}
	
	
	public void propiedades(){
		frame9.setBounds(100, 100, 450, 300);
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame9.getContentPane().setLayout(null);
		
		
		lblNombre.setBounds(10, 67, 46, 14);
		frame9.getContentPane().add(lblNombre);
		
		
		textNombre.setBounds(144, 64, 86, 20);
		frame9.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		
		lblPrimerApellido.setBounds(10, 92, 96, 14);
		frame9.getContentPane().add(lblPrimerApellido);
		
		
		textApellido1.setBounds(144, 89, 86, 20);
		frame9.getContentPane().add(textApellido1);
		textApellido1.setColumns(10);
		
		
		textApellido2.setBounds(144, 115, 86, 20);
		frame9.getContentPane().add(textApellido2);
		textApellido2.setColumns(10);
		
		
		lblSegundoApellido.setBounds(10, 118, 120, 14);
		frame9.getContentPane().add(lblSegundoApellido);
		
		
		lblCliente.setBounds(10, 21, 46, 14);
		frame9.getContentPane().add(lblCliente);
		
		
		lblDni.setBounds(84, 21, 86, 14);
		frame9.getContentPane().add(lblDni);
		
		
		lblDireccion.setBounds(10, 143, 70, 14);
		frame9.getContentPane().add(lblDireccion);
		
		
		lblTelefono.setBounds(10, 168, 70, 14);
		frame9.getContentPane().add(lblTelefono);
		
		
		lblEmail.setBounds(10, 193, 70, 14);
		frame9.getContentPane().add(lblEmail);
		
		
		textDireccion.setBounds(144, 140, 86, 20);
		frame9.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		
		textTelefono.setBounds(144, 165, 86, 20);
		frame9.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		
		textEmail.setBounds(144, 190, 180, 20);
		frame9.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		
		btnVolver.setBounds(10, 227, 89, 23);
		frame9.getContentPane().add(btnVolver);
		
		
		btnEditar.setBounds(144, 227, 89, 23);
		frame9.getContentPane().add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		
		btnGuardar.setBounds(269, 227, 89, 23);
		frame9.getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		
		btnCancelar.setBounds(141, 227, 89, 23);
		frame9.getContentPane().add(btnCancelar);
		
		JLabel lblfoto = new JLabel("");
	
		
		lblfoto.setBounds(-111, 0, 633, 283);
		Image img = new ImageIcon(MostrarCliente.class.getResource("/Imagenes/cliente.png")).getImage();
		 Image newImg = img.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
		lblfoto.setIcon(new ImageIcon(newImg));
		
		frame9.getContentPane().add(lblfoto);
		btnCancelar.setVisible(false);
		btnGuardar.setVisible(false);
	
	}
	
	public JFrame getFrame9() {
		return frame9;
	}

	
	public void eventos(){
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				MostrarVehiculo ventana = new MostrarVehiculo(null,null);
				ventana.getFrame8().setVisible(true);
				frame9.setVisible(false);
				
				
			}
		});
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCancelar.setVisible(true);
				btnEditar.setVisible(false);
				btnGuardar.setVisible(true);
				
			}
		});
		
		
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
            boolean escorrecto = true;
				
				for(Cliente c : Container.getListaClientesAux()){
				
					
				if(!textNombre.getText().equals(c.getNombre())){
					Validaciones.validarNombre(textNombre.getText());
					if(textNombre.getText().equals("0")){
						escorrecto=false;
					}
				}
				if(!textApellido1.getText().equals(c.getApellido1())){
					Validaciones.apellido1(textApellido1.getText());
					if(textApellido1.getText().equals("0")){
						escorrecto=false;
					}
				}
				if(!textApellido2.getText().equals(c.getApellido2())){
					Validaciones.apellido2(textApellido2.getText());
					if(textApellido2.getText().equals("0")){
						escorrecto=false;
					}
				}
				if(!textDireccion.getText().equals(c.getDireccion())){
					Validaciones.validarDireccion(textDireccion.getText());
					if(textDireccion.getText().equals("0")){
						escorrecto=false;
					}
				}
				if(!textEmail.getText().equals(c.getEmial())){
					Validaciones.validarEmail(textEmail.getText());
					if(textEmail.getText().equals("0")){
						escorrecto=false;
					}
				}
			    if(!textTelefono.getText().equals(c.getTlf())){
			    	Validaciones.validarTelefono(textTelefono.getText());
			    	if(textTelefono.getText().equals("0")){
						escorrecto=false;
					}
				}
			    
			    if(escorrecto){	
			    	
			    	
			    }
			      Container.getListaClientesAux().get(0).setNombre(textNombre.getText());
			      Container.getListaClientesAux().get(0).setApellido1(textApellido1.getText());
			      Container.getListaClientesAux().get(0).setApellido2(textApellido2.getText());
			      Container.getListaClientesAux().get(0).setDireccion(textDireccion.getText());
			      int tlf = Integer.parseInt(textTelefono.getText());
			      Container.getListaClientesAux().get(0).setTlf(tlf);
			      Container.getListaClientesAux().get(0).setEmial(textEmail.getText());
			      
			      EditarClienteDAO.EditarCliente(DNI,textNombre.getText(),textApellido1.getText(), textApellido2.getText(),textDireccion.getText(), tlf, textEmail.getText());
				}
			
			}
		});
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				btnCancelar.setVisible(false);
				btnEditar.setVisible(true);
				btnGuardar.setVisible(false);
				
			}
		});
	}
	
	private void mostrar(){
		
		    	
		MostrarClienteDAO.MostrarCliente(DNI);
		lblDni.setText(Container.getListaClientesAux().get(0).getNif());
		textNombre.setText(Container.getListaClientesAux().get(0).getNombre());
        textApellido1.setText(Container.getListaClientesAux().get(0).getApellido1());
	    textApellido2.setText(Container.getListaClientesAux().get(0).getApellido2());
		textDireccion.setText(Container.getListaClientesAux().get(0).getDireccion());
		textEmail.setText(Container.getListaClientesAux().get(0).getEmial());
		String tlf =String.valueOf(Container.getListaClientesAux().get(0).getTlf());
	    textTelefono.setText(tlf);
			
		}
		
	}

