package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Models.Cliente;
import Models.Container;
import Models.Vehiculo;

public class MostrarClienteDAO {

	
	public static void MostrarCliente(String dni) {

		   // Connect to database
	 String hostName = "PC102\\SQLALEJANDRO";
	 String dbName = "Taller";
	 String user = "Ale";
	 String password = "1234";
	 String url = String.format("jdbc:sqlserver://172.16.100.36\\SQLALEJANDRO:1433;" + "databaseName=Taller;user=Admin;password=1234");
	 Connection connection = null;
	 boolean existe = false;
	 Connection con = null;  
	 Statement stmt = null;  
	 ResultSet rs = null;  

	 try {
	 	connection = DriverManager.getConnection(url);
	     String schema = connection.getSchema();
	     stmt = connection.createStatement();  
	     // Prepared statement to insert data
	     String insertSql = "Select * from Clientes  where NIF=('"+dni+"')";

	     java.util.Date date = new java.util.Date();
	     java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
	     
	         
	     try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
	        

	     	rs = stmt.executeQuery(insertSql);  
	     	while (rs.next()) {  
	     		
	     		existe = true;
	     		String dnis= rs.getString("NIF");
	     		String nombre= rs.getString("Nombre");
	     		String apellido1= rs.getString("Apellido1");
	     		String apellido2= rs.getString("Apellido2");
	     		String dire= rs.getString("Direccion");
	     		int tlf = rs.getInt("numerodeContacto");
	       		String Email=rs.getString("Email");
	     		
	     		Cliente c = new Cliente( dnis,nombre, apellido1,apellido2, dire,tlf,Email);
	     		Container.getListaClientesAux().add(c);
		         }
	 }
	}
	catch (Exception e) {
	 e.printStackTrace();
	}
		
	}
}