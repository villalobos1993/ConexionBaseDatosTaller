package Vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Models.Container;
import Models.Validaciones;
import Models.Vehiculo;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import DAO.EditarDAO;
import DAO.MostrarVehiculoDAO;
import DAO.MostrarVehiculoDni;

import javax.swing.ImageIcon;

public class MostrarVehiculo {

	private JFrame frame8;
	private JLabel lblmatricula;
	private JLabel lblmarca;
	private JLabel lblmodelo;
	private JLabel lblNpuertas;
	private JLabel lblcolor;
	private JLabel lblCombustible;
	private JLabel lblAniomatriculacion;
	private JLabel lblDniCliente;
	private JButton btnatras;
	private JLabel lbcv;
	private JLabel lblvehiculo;
	private JLabel lblmatricula2;
	private JLabel lblmarca2;
	private JLabel lblmodelo2;
	private JLabel lblnpuertas2;
	private JLabel lblcolor2;
	private JLabel lblcombustible2;
	private JButton btnDatosClientes;
	private JButton btnLeft;
	private JButton btnEditar ;
	private static  int id=0;
	
	static public int getId() {
		return id;
	}

	

	private JButton btnRigth;
	private JLabel lblNvehiculos;
	private JButton btnFacturacion;
	private JButton btnGuardar;
	private JSpinner spinnerNP;
	private JSpinner spinnerAM ;
	public JFrame getFrame8() {
		return frame8;
	}

	public void setFrame8(JFrame frame8) {
		this.frame8 = frame8;
	}

	private JLabel lblaniomatriculacion2;
	private JLabel lblcv2;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textColor;
	private JTextField textComb;
	private JTextField textCv;
	private JTextField txtMatricula;
	private JButton btnCancelar;
    private String Datos;
    private String Eleccion;
    
	public MostrarVehiculo(String datos,String eleccion) {
		frame8 = new JFrame();
		frame8.getContentPane().setBackground(Color.ORANGE);
		frame8.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame8.getBackground();
        Datos = datos;
        Eleccion=eleccion;
		lblmatricula = new JLabel("Matricula:");
		lblmarca = new JLabel("Marca:");
		lblmodelo = new JLabel("Modelo:");
		lblNpuertas = new JLabel("N\u00BAPuertas:");
		lblcolor = new JLabel("Color:");
		lblCombustible = new JLabel("Combustible:");
		lblAniomatriculacion = new JLabel("AnioMatriculacion:");
		lblDniCliente = new JLabel("DNI Cliente:");
		btnatras = new JButton("Atras");
		btnatras.setBackground(Color.LIGHT_GRAY);
		lbcv = new JLabel("CV:");
		lblvehiculo = new JLabel("VEHICULO");

		lblmatricula2 = new JLabel("");

		lblmarca2 = new JLabel("");

		lblmodelo2 = new JLabel("");

		lblnpuertas2 = new JLabel("");

		lblcolor2 = new JLabel("");

		lblcombustible2 = new JLabel("");

		lblaniomatriculacion2 = new JLabel("");

		lblcv2 = new JLabel("");
		btnDatosClientes = new JButton("Datos Cliente");
		btnDatosClientes.setBackground(Color.LIGHT_GRAY);
		
		btnLeft = new JButton("");
		
		btnLeft.setIcon(new ImageIcon(MostrarVehiculo.class.getResource("/Imagenes/Arrow left-50.png")));
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnCancelar = new JButton("Cancelar");
		btnRigth = new JButton("");
		
		btnRigth.setIcon(new ImageIcon(MostrarVehiculo.class.getResource("/Imagenes/Arrow Rigth.png")));
		lblNvehiculos = new JLabel("");
		btnFacturacion = new JButton("<html>Datos <br>Facturaci\u00F3n</html>");
		btnFacturacion.setBackground(Color.LIGHT_GRAY);
		
		spinnerNP = new JSpinner();
		spinnerAM = new JSpinner();
		//

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Propiedades();
		eventos();
		if(Eleccion.equals("Matricula")){
		obtener2();}
		else{
		obtener1();
		}
		Mostrar();
	}

	


	private void Propiedades() {

		frame8.setBounds(100, 100, 482, 355);
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.getContentPane().setLayout(null);
		

		lblmatricula.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblmatricula.setBounds(18, 105, 101, 16);
		frame8.getContentPane().add(lblmatricula);

		lblmarca.setFont(new Font("DokChampa", Font.BOLD | Font.ITALIC, 13));
		lblmarca.setBounds(18, 153, 61, 16);
		frame8.getContentPane().add(lblmarca);

		lblmodelo.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblmodelo.setBounds(18, 193, 73, 16);
		frame8.getContentPane().add(lblmodelo);

		lblNpuertas.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblNpuertas.setBounds(18, 235, 101, 16);
		frame8.getContentPane().add(lblNpuertas);

		lblcolor.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblcolor.setBounds(228, 105, 61, 16);
		frame8.getContentPane().add(lblcolor);

		lblCombustible.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblCombustible.setBounds(228, 153, 106, 16);
		frame8.getContentPane().add(lblCombustible);

		lblAniomatriculacion.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblAniomatriculacion.setBounds(213, 193, 157, 16);
		frame8.getContentPane().add(lblAniomatriculacion);

		lbcv.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lbcv.setBounds(228, 235, 61, 16);
		frame8.getContentPane().add(lbcv);

		lblDniCliente.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 13));
		lblDniCliente.setBounds(173, 21, 95, 16);
		frame8.getContentPane().add(lblDniCliente);

		lblvehiculo.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 19));
		lblvehiculo.setBounds(18, 18, 145, 16);
		frame8.getContentPane().add(lblvehiculo);

		btnatras.setBounds(18, 262, 73, 43);
		frame8.getContentPane().add(btnatras);

		
		lblmatricula2.setBounds(129, 106, 101, 16);
		frame8.getContentPane().add(lblmatricula2);

		
		lblmarca2.setBounds(102, 153, 101, 16);
		frame8.getContentPane().add(lblmarca2);

		
		lblmodelo2.setBounds(103, 193, 100, 16);
		frame8.getContentPane().add(lblmodelo2);

		
		lblnpuertas2.setBounds(129, 236, 101, 16);
		frame8.getContentPane().add(lblnpuertas2);

		lblcolor2.setBounds(332, 105, 101, 16);
		frame8.getContentPane().add(lblcolor2);

		lblcombustible2.setBounds(335, 153, 98, 16);
		frame8.getContentPane().add(lblcombustible2);

		lblaniomatriculacion2.setBounds(372, 193, 68, 16);
		frame8.getContentPane().add(lblaniomatriculacion2);

		
		lblcv2.setBounds(273, 235, 61, 16);
		frame8.getContentPane().add(lblcv2);
		
		
		btnLeft.setBounds(10, 51, 61, 43);
		frame8.getContentPane().add(btnLeft);
		
		
		btnRigth.setBounds(139, 51, 64, 43);
		frame8.getContentPane().add(btnRigth);
		
		
		lblNvehiculos.setBounds(81, 64, 48, 30);
		frame8.getContentPane().add(lblNvehiculos);
		
		
		
		
		btnEditar.setBounds(139, 263, 90, 41);
		frame8.getContentPane().add(btnEditar);
		
		
		btnDatosClientes.setBounds(332, 11, 124, 43);
		frame8.getContentPane().add(btnDatosClientes);
		
		
		btnFacturacion.setBounds(355, 262, 101, 43);
		frame8.getContentPane().add(btnFacturacion);
		
		textMarca = new JTextField();
		textMarca.setBounds(102, 152, 86, 20);
		frame8.getContentPane().add(textMarca);
		textMarca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setBounds(101, 192, 86, 20);
		frame8.getContentPane().add(textModelo);
		textModelo.setColumns(10);
		
		
		spinnerNP.setBounds(127, 234, 61, 20);
		frame8.getContentPane().add(spinnerNP);
		
		textColor = new JTextField();
		textColor.setBounds(332, 104, 86, 20);
		frame8.getContentPane().add(textColor);
		textColor.setColumns(10);
		
		textComb = new JTextField();
		textComb.setBounds(332, 152, 86, 20);
		frame8.getContentPane().add(textComb);
		textComb.setColumns(10);
		
		
		spinnerAM.setModel(new SpinnerNumberModel(2017, 1900, 2017, 1));
		spinnerAM.setBounds(372, 192, 61, 20);
		frame8.getContentPane().add(spinnerAM);
		
		textCv = new JTextField();
		textCv.setBounds(273, 234, 86, 20);
		frame8.getContentPane().add(textCv);
		textCv.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(132, 104, 86, 20);
		frame8.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		
		btnGuardar.setBounds(256, 262, 89, 43);
		btnGuardar.setVisible(false);
		frame8.getContentPane().add(btnGuardar);
		
		
		btnCancelar.setBounds(140, 262, 89, 43);
		btnCancelar.setVisible(false);
		frame8.getContentPane().add(btnCancelar);
		
		textColor.setVisible(false);
		textComb.setVisible(false);
		textCv.setVisible(false);
		textMarca.setVisible(false);
		textModelo.setVisible(false);
		spinnerNP.setVisible(false);
		spinnerAM.setVisible(false);
		txtMatricula.setVisible(false);
	}

	private void eventos() {

		btnatras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Principal window = new Principal();
				window.getFrame2().setVisible(true);
				frame8.dispose();
				Container.getVehiculosAux().clear();
			}
		});
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtMatricula.setVisible(true);
				textColor.setVisible(true);
				textComb.setVisible(true);
				textCv.setVisible(true);
				textMarca.setVisible(true);
				textModelo.setVisible(true);
				spinnerNP.setVisible(true);
				spinnerAM.setVisible(true);
				
				
				lblaniomatriculacion2.setVisible(false);
				lblcolor2.setVisible(false);
				lblcombustible2.setVisible(false);
				lblcv2.setVisible(false);
				lblmatricula2.setVisible(false);
				lblmarca2.setVisible(false);
				lblnpuertas2.setVisible(false);
				lblmodelo2.setVisible(false);
				
				
				ocultarBotones();
				mostrarBotonesEdicion();
			}

		});
		
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mostrarBotones();
				ocultarBotonesEdicion();
				
				txtMatricula.setVisible(false);
				textColor.setVisible(false);
				textComb.setVisible(false);
				textCv.setVisible(false);
				textMarca.setVisible(false);
				textModelo.setVisible(false);
				spinnerNP.setVisible(false);
				spinnerAM.setVisible(false);
				
				
				lblaniomatriculacion2.setVisible(true);
				lblcolor2.setVisible(true);
				lblcombustible2.setVisible(true);
				lblcv2.setVisible(true);
				lblmatricula2.setVisible(true);
				lblmarca2.setVisible(true);
				lblnpuertas2.setVisible(true);
				lblmodelo2.setVisible(true);
			}
		});
		
		
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarCambios();
			}

			
		});
		
		btnDatosClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				MostrarCliente ventana = new MostrarCliente(Container.getVehiculosAux().get(id).getDniCliente());
				ventana.getFrame9().setVisible(true);
				frame8.setVisible(false);
			}
		});
		
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(id>0){
					id-=1;
				}
				Mostrar();
			}
		});
		
		btnRigth.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(id < Container.getVehiculosAux().size()-1){
					id+=1;
				}
				Mostrar();
			}
		});
		
		btnFacturacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Presupuesto ventana = new Presupuesto();
				ventana.getFrame7().setVisible(true);
				frame8.setVisible(false);
				
			}
		});
	}
	
	
	
       
       
       private void Mostrar() {
  
       
       System.out.println(Datos);
       System.out.println(Container.getVehiculosAux().size());
    	   String nPuertas;
    	   String Año;
    	   String cv;
    	
   		lblmatricula2.setText(Container.getVehiculosAux().get(id).getMatricula());
   		lblmarca2.setText(Container.getVehiculosAux().get(id).getMarca());
   		lblmodelo2.setText(Container.getVehiculosAux().get(id).getModelo());
   		nPuertas = String.valueOf(Container.getVehiculosAux().get(id).getNumPuertas());
   		lblnpuertas2.setText(nPuertas);
   		lblcolor2.setText(Container.getVehiculosAux().get(id).getColor());
   		lblcombustible2.setText(Container.getVehiculosAux().get(id).getTipoGas());
   		Año = String.valueOf(Container.getVehiculosAux().get(id).getAnioMatriculacion());
   		lblaniomatriculacion2.setText(Año);
   		cv = String.valueOf(Container.getVehiculosAux().get(id).getCv());
   		lblcv2.setText(cv);
    	lblNvehiculos.setText((id+1)+" de "+Container.getVehiculosAux().size());   
    	 
   
    		
  
   		
   	}
       
       
       private void ocultarBotones() {
    	   btnatras.setVisible(false);
    	   btnEditar.setVisible(false);
    	   btnDatosClientes.setVisible(false);
    	   btnFacturacion.setVisible(false);
    	   btnRigth.setVisible(false);
    	   btnLeft.setVisible(false);
		}
       
       private void mostrarBotones() {
    	   btnatras.setVisible(true);
    	   btnEditar.setVisible(true);
    	   btnDatosClientes.setVisible(true);
    	   btnFacturacion.setVisible(true);
    	   btnRigth.setVisible(true);
    	   btnLeft.setVisible(true);
		}
       
       private void mostrarBotonesEdicion() {
    	   btnGuardar.setVisible(true);
    	   btnCancelar.setVisible(true);
		}
       
       
       private void ocultarBotonesEdicion() {
    	   btnGuardar.setVisible(false);
    	   btnCancelar.setVisible(false);
		}
       
       
       private void guardarCambios() {
    	   String marca = null;
    	   String matricula = null;
    	   String color = null;
    	   String combustible;
    	   int caballos = 0;
    	   String modelo = null;
    	   int contCambios = 0;
			
   
			if(!textMarca.getText().equals("")){
				
				marca = Validaciones.validarmarca(textMarca.getText());
				
				if(marca != "0"){
					Container.getVehiculosAux().get(id).setMarca(marca);
					contCambios+=1;
				}
			}
			
			if(!txtMatricula.getText().equals("")){
				
				matricula = Validaciones.validarmatricula(txtMatricula.getText());
				
				if(matricula != "0"){
					Container.getVehiculosAux().get(id).setMatricula(matricula);
					contCambios+=1;
				}
			}
			
			if(!textColor.getText().equals("")){
				
				color = Validaciones.validarcolor(textColor.getText());
				if(color != "0"){
					Container.getVehiculosAux().get(id).setColor(color);
					contCambios+=1;
				}
			}
			
			if(!textComb.getText().equals("")){
				
				combustible = Validaciones.validarcombustible(textComb.getText());
				if(combustible != "0"){
					Container.getVehiculosAux().get(id).setTipoGas(combustible);
					contCambios+=1;
				}
			}
			
			
			if(!textCv.getText().equals("")){
				
				caballos = Validaciones.validarcv(textCv.getText());
				if(caballos != 0){
					Container.getVehiculosAux().get(id).setCv(caballos);
					contCambios+=1;
				}
			}
			
			
			if(!textModelo.getText().equals("")){
				
				modelo = Validaciones.validarmodelo(textModelo.getText());
				if(modelo != "0"){
					Container.getVehiculosAux().get(id).setModelo(modelo);
					contCambios+=1;
				}
			}
			
			if(contCambios > 0){
				JOptionPane.showMessageDialog(getFrame8(), contCambios + " campos actualizados");
			}
			
			actualizarDatos();
		}

	private void actualizarDatos() {
		lblmatricula2.setText(Container.getVehiculosAux().get(id).getMatricula());
   		lblmarca2.setText(Container.getVehiculosAux().get(id).getMarca());
   		lblmodelo2.setText(Container.getVehiculosAux().get(id).getModelo());
   		String nPuertas = String.valueOf(Container.getVehiculosAux().get(id).getNumPuertas());
   		int puertas = Integer.parseInt(nPuertas);
   		lblnpuertas2.setText(nPuertas);
   		lblcolor2.setText(Container.getVehiculosAux().get(id).getColor());
   		lblcombustible2.setText(Container.getVehiculosAux().get(id).getTipoGas());
   		String Año = String.valueOf(Container.getVehiculosAux().get(id).getAnioMatriculacion());
   		lblaniomatriculacion2.setText(Año);
   		String cv = String.valueOf(Container.getVehiculosAux().get(id).getCv());
   		int cvs=Container.getVehiculosAux().get(id).getCv();
   		lblcv2.setText(cv);	
   		
   		EditarDAO.EditarVehiculo(lblmatricula2.getText(), lblmarca2.getText(), lblmodelo2.getText(),cvs,lblcolor2.getText());
   		
   	
   		
   		txtMatricula.setVisible(false);
		textColor.setVisible(false);
		textComb.setVisible(false);
		textCv.setVisible(false);
		textMarca.setVisible(false);
		textModelo.setVisible(false);
		spinnerNP.setVisible(false);
		spinnerAM.setVisible(false);
		
		
		lblaniomatriculacion2.setVisible(true);
		lblcolor2.setVisible(true);
		lblcombustible2.setVisible(true);
		lblcv2.setVisible(true);
		lblmatricula2.setVisible(true);
		lblmarca2.setVisible(true);
		lblnpuertas2.setVisible(true);
		lblmodelo2.setVisible(true);
	}
	private void MostrarDni(){
		
		
	      
	       System.out.println(Datos);
	       System.out.println(Container.getVehiculosAux().size());
	    	   String nPuertas;
	    	   String Año;
	    	   String cv;
	    	
	   		lblmatricula2.setText(Container.getVehiculosAux().get(id).getMatricula());
	   		lblmarca2.setText(Container.getVehiculosAux().get(id).getMarca());
	   		lblmodelo2.setText(Container.getVehiculosAux().get(id).getModelo());
	   		nPuertas = String.valueOf(Container.getVehiculosAux().get(id).getNumPuertas());
	   		lblnpuertas2.setText(nPuertas);
	   		lblcolor2.setText(Container.getVehiculosAux().get(id).getColor());
	   		lblcombustible2.setText(Container.getVehiculosAux().get(id).getTipoGas());
	   		Año = String.valueOf(Container.getVehiculosAux().get(id).getAnioMatriculacion());
	   		lblaniomatriculacion2.setText(Año);
	   		cv = String.valueOf(Container.getVehiculosAux().get(id).getCv());
	   		lblcv2.setText(cv);
	    	lblNvehiculos.setText((id+1)+" de "+Container.getVehiculosAux().size());   }
	    	 
	    	
	

   private void obtener1(){
	 MostrarVehiculoDni.MostrarVehiculo(Datos);
	
   }
   private void obtener2(){
	   MostrarVehiculoDAO.MostrarVehiculo(Datos);
   }
}