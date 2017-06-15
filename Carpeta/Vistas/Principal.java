package Vistas;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal {

	private static JFrame frame2;
	
	private JButton btnbuscar;
	private JButton btncrear;
	private JLabel lblfoto;

	public Principal() {

		 frame2 = new JFrame();
		btnbuscar = new JButton("<html>  BUSCAR<br/><br/>VEHICULO</html>");
		btncrear = new JButton("<html>  CREAR<br/><br/>VEHICULO</html>");
		lblfoto = new JLabel("");
		

		initialize();
	}



	private void initialize() {
		propiedades();
		eventos();
	}

	private void propiedades() {
		
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		btnbuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnbuscar.setBounds(41, 143, 157, 108);
		frame2.getContentPane().add(btnbuscar);

		btncrear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btncrear.setBounds(243, 144, 157, 108);
		frame2.getContentPane().add(btncrear);
		
		
		lblfoto.setBounds(10, -41, 434, 292);
		
		Image img = new ImageIcon(Login.class.getResource("/Imagenes/fotoprincipal.png")).getImage();
		 Image newImg = img.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
		lblfoto.setIcon(new ImageIcon(newImg));
		frame2.getContentPane().add(lblfoto);
	}

	private void eventos() {
		btncrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TipoVehiculo window=new TipoVehiculo();
				window.getFrame9().setVisible(true);
				frame2.dispose();
				
				
			}
		});
		
		
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Buscar window2 = new Buscar();
				 window2.getFrame4().setVisible(true);
				 frame2.setVisible(false);
			}
		});
	}
	public static JFrame getFrame2() {
		return frame2;
	}
	
}