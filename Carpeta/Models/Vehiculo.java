package Models;

import java.sql.Date;

public class Vehiculo {
	private String matricula;
	private String marca;
	private String modelo;
	private int numPuertas;
	private String color;
	private String tipoGas;
	private int fechamatriculacion;
	private int cv;
	private String dniCliente;
	private float precioReparacion;
	private String tipoVehiculo;
	
	
	public Vehiculo(String matricula, String marca, String modelo, int numPuertas, String color, String tipoGas,
			int anioMatriculacion, int cv,String dni,float precioReparacion,String tipoVehiculo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.numPuertas = numPuertas;
		this.color = color;
		this.tipoGas = tipoGas;
		this.fechamatriculacion = anioMatriculacion;
		this.cv = cv;
		this.dniCliente=dni;
		this.precioReparacion=precioReparacion;
		this.tipoVehiculo=tipoVehiculo;
	}
	
	
	

	public Vehiculo(){
		this.matricula = "";
		this.marca = "";
		this.modelo = "";
		this.numPuertas = 0;
		this.color = "";
		this.tipoGas = "";
		this.fechamatriculacion=0;
		this.cv = 0;
		this.precioReparacion=0.0f;
		this.tipoVehiculo="";
	}


	public int getFechamatriculacion() {
		return fechamatriculacion;
	}




	public void setFechamatriculacion(int fechamatriculacion) {
		this.fechamatriculacion = fechamatriculacion;
	}




	public float getPrecioReparacion() {
		return precioReparacion;
	}




	public void setPrecioReparacion(float precioReparacion) {
		this.precioReparacion = precioReparacion;
	}



	public String getTipoVehiculo() {
		return tipoVehiculo;
	}




	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getNumPuertas() {
		return numPuertas;
	}


	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getTipoGas() {
		return tipoGas;
	}


	public void setTipoGas(String tipoGas) {
		this.tipoGas = tipoGas;
	}


	public int getAnioMatriculacion() {
		return fechamatriculacion;
	}


	public void setAnioMatriculacion(int aniomatriculacion) {
		this.fechamatriculacion = 0;
	}


	public int getCv() {
		return cv;
	}


	public void setCv(int cv) {
		this.cv = cv;
	}

	public String getDniCliente() {
		return dniCliente;
	}


	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}


	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", numPuertas="
				+ numPuertas + ", color=" + color + ", tipoGas=" + tipoGas + ", anioMatriculacion=" + fechamatriculacion
				+ ", cv=" + cv + "]";
	}
	
	static public void CochePrueba(){
		
		Vehiculo v = new Vehiculo("1234asd","ferrai","z",3,"Rojo","Gasolina",1993,123,"12345678Q",0,"Coche");
		Vehiculo c= new Vehiculo("1264asd","citroen","z",3,"Verde","Gasolina",1993,123,"12345678Q",0,"Coche");
		Vehiculo h = new Vehiculo("1234asd","ferrai","z",3,"Rojo","Gasolina",1993,123,"12345678g",0,"Coche");
		Vehiculo i = new Vehiculo("1234asd","ferrai","z",3,"Rojo","Gasolina",1993,123,"12345678Q",0,"Coche");
		Vehiculo z = new Vehiculo("1294asd","chevroler","z",3,"azul","Gasolina",1993,123,"12345678g",0,"Coche");
		Vehiculo d = new Vehiculo("2234asd","ferrai","z",3,"Rojo","Gasolina",1993,123,"24578975f",0,"Coche");
		Vehiculo vp = new Vehiculo("1234asd","ferrai","z",3,"Rojo","Gasolina",1993,123,"24578975f",0,"Coche");
		Vehiculo vc = new Vehiculo("4234asd","peugeot","z",3,"amarillo","Gasolina",1993,123,"12345678Q",0,"Coche");
		Vehiculo ve= new Vehiculo("1934asd","ferrai","z",3,"Rojo","Gasolina",1993,123,"23567806q",0,"Coche");
		Container.getListaVehiculos().add(v);
		Container.getListaVehiculos().add(c);
		Container.getListaVehiculos().add(h);
		Container.getListaVehiculos().add(i);
		Container.getListaVehiculos().add(z);
		Container.getListaVehiculos().add(d);
		Container.getListaVehiculos().add(vp);
		Container.getListaVehiculos().add(vc);
		Container.getListaVehiculos().add(ve);
		
		
	}
	
}
