package Vistas;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TipoVehiculo {

	private JFrame frame9;
	private JButton btncoche;
	private JButton btnmoto ;
	private JButton btncamion ;
	private JButton btnbici ;
	private String vehiculoenviado;
	
	public TipoVehiculo() {
		
		frame9 = new JFrame();
		 btncoche = new JButton("");

		 btnmoto = new JButton("");
	
		 btncamion = new JButton("");
		
		 btnbici = new JButton("");
		 

		initialize();
	}

	public JFrame getFrame9() {
		return frame9;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		propiedades();
		eventos();
		
	}
	
	private void propiedades()
	{
		
		
		frame9.setBounds(100, 100, 450, 300);
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame9.getContentPane().setLayout(null);
		
		btncoche.setBounds(0, 0, 206, 117);		
		 Image img = new ImageIcon(TipoVehiculo.class.getResource("/Imagenes/coche.png")).getImage();
		 Image newImg = img.getScaledInstance(btncoche.getWidth(), btncoche.getHeight(), java.awt.Image.SCALE_SMOOTH);
		 btncoche.setIcon((new ImageIcon(newImg)));		
		frame9.getContentPane().add(btncoche);
			
		btnmoto.setBounds(228, 0, 206, 117);
		 Image img2 = new ImageIcon(TipoVehiculo.class.getResource("/Imagenes/moto.jpg")).getImage();
		 Image newImg2 = img2.getScaledInstance(btnmoto.getWidth(), btnmoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
		 btnmoto.setIcon((new ImageIcon(newImg2)));
		frame9.getContentPane().add(btnmoto);
			
		btncamion.setBounds(0, 145, 206, 117);
		 Image img3 = new ImageIcon(TipoVehiculo.class.getResource("/Imagenes/camion.png")).getImage();
		 Image newImg3 = img3.getScaledInstance(btncamion.getWidth(), btncamion.getHeight(), java.awt.Image.SCALE_SMOOTH);
		 btncamion.setIcon(new ImageIcon(newImg3));
		frame9.getContentPane().add(btncamion);
			
		btnbici.setBounds(228, 145, 206, 117);
		 Image img4 = new ImageIcon(TipoVehiculo.class.getResource("/Imagenes/bicicleta.jpg")).getImage();
		 Image newImg4 = img4.getScaledInstance(btnbici.getWidth(), btnbici.getHeight(), java.awt.Image.SCALE_SMOOTH);
		btnbici.setIcon(new ImageIcon(newImg4));
		frame9.getContentPane().add(btnbici);
		
	}
	private void eventos()
	{
		btnbici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 vehiculoenviado="Bicicleta";
				CrearVehiculo window=new CrearVehiculo(vehiculoenviado );
				window.getFrame3().setVisible(true);
				frame9.setVisible(false);
				
			
				
			}
		});
		
		btncamion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 vehiculoenviado="Camion";
					CrearVehiculo window=new CrearVehiculo(vehiculoenviado );
					window.getFrame3().setVisible(true);
					frame9.setVisible(false);
			}
		});
		btnmoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 vehiculoenviado="Moto";
					CrearVehiculo window=new CrearVehiculo(vehiculoenviado );
					window.getFrame3().setVisible(true);
					frame9.setVisible(false);
			}
		});
		btncoche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				vehiculoenviado="Coche";
				CrearVehiculo window=new CrearVehiculo(vehiculoenviado );
				window.getFrame3().setVisible(true);
				frame9.setVisible(false);
			}
		});
		
	}
}
