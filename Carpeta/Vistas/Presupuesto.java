package Vistas;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Vistas.CrearVehiculo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import Models.Container;
import Models.Tiempo;
import Models.Vehiculo;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Color;

public class Presupuesto {

	private JFrame frame7;
	private JLabel lblInicio;
	private JLabel lblCosteP;
	private JLabel lblReparacion;
	private JButton btnFinalizar;
	private JButton btnVolver;
	private JTextField txtPrecioMateriales;
	private String[] estados = { "No Reparado", "Reparado y esperando al cliente", "Reparado y entregado" };
	private JTextField textToal;
	private JButton btnInicio;
	private boolean inicio = false;
	private Tiempo t = new Tiempo();
	private JLabel lblTiempo;
	private static int segundos;
	private JLabel lblNewLabel;
	private JLabel lblDineroTotal;

	public JFrame getFrame7() {
		return frame7;
	}

	

	/**
	 * Create the application.
	 */
	public Presupuesto() {
		frame7 = new JFrame();
		frame7.getContentPane().setBackground(Color.ORANGE);
		lblInicio = new JLabel("Tiempo");
		lblInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCosteP = new JLabel("Coste Piezas");
		lblCosteP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReparacion = new JLabel("Reparacion");
		lblReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBackground(Color.LIGHT_GRAY);

		btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		
		txtPrecioMateriales = new JTextField();
		txtPrecioMateriales.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInicio = new JButton("Iniciar");
		btnInicio.setBackground(Color.LIGHT_GRAY);
		textToal = new JTextField();
		lblTiempo = new JLabel("");
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 13));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		propiedades();

		eventos();
	}

	public void propiedades() {
		frame7.setBounds(100, 100, 450, 300);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.getContentPane().setLayout(null);

		lblInicio.setBounds(10, 62, 77, 14);
		frame7.getContentPane().add(lblInicio);

		lblCosteP.setBounds(10, 99, 77, 14);
		frame7.getContentPane().add(lblCosteP);

		lblReparacion.setBounds(10, 11, 145, 14);
		frame7.getContentPane().add(lblReparacion);

		btnFinalizar.setBounds(321, 189, 101, 56);
		frame7.getContentPane().add(btnFinalizar);
		btnVolver.setBounds(10, 184, 89, 67);
		frame7.getContentPane().add(btnVolver);

		txtPrecioMateriales.setBounds(134, 96, 86, 20);
		frame7.getContentPane().add(txtPrecioMateriales);
		txtPrecioMateriales.setColumns(10);

		btnInicio.setBounds(321, 122, 101, 56);
		frame7.getContentPane().add(btnInicio);

		JLabel lblManoObra = new JLabel("Mano de obra");
		lblManoObra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblManoObra.setBounds(10, 142, 114, 14);
		frame7.getContentPane().add(lblManoObra);

		textToal.setBounds(134, 140, 86, 20);
		frame7.getContentPane().add(textToal);
		textToal.setColumns(10);

		lblTiempo.setBounds(134, 62, 86, 14);
		frame7.getContentPane().add(lblTiempo);

		lblNewLabel = new JLabel("Total");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(109, 210, 57, 14);
		frame7.getContentPane().add(lblNewLabel);

		lblDineroTotal = new JLabel("");
		lblDineroTotal.setBounds(165, 210, 89, 14);
		frame7.getContentPane().add(lblDineroTotal);

	}

	public void eventos() {
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (inicio == false) {
					inicio = true;
					String segundos;
					t.Contar(lblTiempo);

				}
			}
		});
		
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				MostrarVehiculo ventana = new MostrarVehiculo(null,null);
				ventana.getFrame8().setVisible(true);
				frame7.setVisible(false);
				frame7.dispose();
				
			}
		});

		btnFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(inicio){
				t.Detener();
				inicio = false;
				boolean escorrecto = true;
				int segundos = 0;
				float precio = 0.016f;
				float dineroTotal = 0;
				float dineroM = 0;
				float iva = 0.21f;
				float dineroMateriales = 0;

				if (!txtPrecioMateriales.getText().equals("")) {
					try {
						dineroMateriales = Float.parseFloat(txtPrecioMateriales.getText());

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame7, "El dinero del precio materiales es incorrecto.");
						escorrecto = false;
					}
				}

				if (escorrecto) {
					segundos = t.getSegundos();
					dineroM = segundos * precio;
					dineroTotal = iva * dineroM + dineroMateriales;
					if (dineroM < 1) {
						textToal.setText("1 euro");
						dineroTotal += 1;

					} else {
						textToal.setText(String.format("%.2f Euros", dineroM));
					}
					if (dineroTotal > 1) {
						lblDineroTotal.setText(String.format("%.2f Euros", dineroTotal));
					}
                 
				
					Container.getListaVehiculos().get(MostrarVehiculo.getId()).setPrecioReparacion(dineroTotal);
				}
			}
				else{
					JOptionPane.showMessageDialog(frame7,"El contador no esta activado");
				}
			}
			
		});

	}

}
