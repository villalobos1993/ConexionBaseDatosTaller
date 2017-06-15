package Vistas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import DAO.LoginDAO;
import Models.Cliente;
import Models.Vehiculo;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login {
//
	private JFrame frame;
	private JTextField txtusuario;
	private JPasswordField txtpassword;
	private JLabel lblnombre;
	private JLabel lblusuario;
	private JLabel lblpassword;
	private JButton btnentrar;
	private JLabel lblfoto;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
		frame = new JFrame();
		lblnombre = new JLabel("REGISTRO DEL TALLER");
		lblusuario = new JLabel("Usuario");
		lblusuario.setForeground(Color.WHITE);
		txtusuario = new JTextField();
		lblpassword = new JLabel("Password");
		lblpassword.setForeground(Color.WHITE);
		btnentrar = new JButton("ENTRAR");
		txtpassword = new JPasswordField();
		lblfoto= new JLabel("");
		lblfoto.setForeground(Color.WHITE);
		
		
		initialize();
	}


	private void initialize() {
		
		propiedades();
		eventos();
	
	}
	private void propiedades()
	{
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblnombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblnombre.setBounds(114, 0, 196, 14);
		frame.getContentPane().add(lblnombre);
		
		lblusuario.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblusuario.setBounds(10, 50, 60, 26);
		frame.getContentPane().add(lblusuario);
		
		txtusuario.setBounds(93, 55, 85, 20);
		frame.getContentPane().add(txtusuario);
		txtusuario.setColumns(10);
		
		lblpassword.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblpassword.setBounds(10, 104, 70, 14);
		frame.getContentPane().add(lblpassword);
		
		
		btnentrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnentrar.setBounds(93, 158, 85, 64);
		frame.getContentPane().add(btnentrar);
		
		txtpassword.setBounds(93, 103, 85, 20);
		frame.getContentPane().add(txtpassword);
		
		
		lblfoto.setBounds(0, 0, 434, 262);
		
		lblfoto.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/logologin.jpg")));
		Image img = new ImageIcon(Login.class.getResource("/Imagenes/logologin.jpg")).getImage();
		 Image newImg = img.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
		lblfoto.setIcon(new ImageIcon(newImg));
		frame.getContentPane().add(lblfoto);
		
		
		
		
	}
	private void eventos()
	{
		btnentrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				boolean escorrecto=true;
				int pin;
				int contador = 0;
				
				
				if(txtusuario.getText().isEmpty())
				{
					
					JOptionPane.showMessageDialog(frame, "ERROR: El usuario esta vacio");
					escorrecto=false;
					
					
				}
			
				if(new String(txtpassword.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(frame, "ERROR: La contraseï¿½a esta vacia");
					escorrecto=false;
					
				}
				try{
					pin=Integer.parseInt(new String(txtpassword.getPassword()));
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(frame, "ERROR: El pin debe ser numerico");
					escorrecto=false;
					
				
				}
				
				if(new String(txtpassword.getPassword()).length()!=4)
				{
					JOptionPane.showMessageDialog(frame, "ERROR: La longitud del PIN no coincide");
					escorrecto=false;
					
				}
				
				
				
				
				if(escorrecto){
				try{
					pin=Integer.parseInt(new String(txtpassword.getPassword()));
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(frame, "ERROR: El pin debe ser numerico");
					escorrecto=false;
					
				
				}
				
				String contraseña = String.valueOf(txtpassword.getPassword());
				escorrecto=(LoginDAO.Login(txtusuario.getText(), contraseña));
				
				if(escorrecto)
				{
					Principal window=new Principal();
					window.getFrame2().setVisible(true);
					frame.dispose();
					
					Vehiculo.CochePrueba();
					
				}
				if(!escorrecto){
					
					JOptionPane.showMessageDialog(frame,"El usuario o contraseña son incorrectos" );
				}
				
				
				}
				
				
				
				
				
			}
		});

	
		
			
		
		
	}
}
