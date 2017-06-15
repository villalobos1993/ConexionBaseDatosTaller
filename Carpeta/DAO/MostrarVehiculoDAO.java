package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Models.Container;
import Models.Vehiculo;

public class MostrarVehiculoDAO {

 public static boolean MostrarVehiculo(String matricula) {

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
     String insertSql = "Select * from Vehiculos  where Matricula=('"+matricula+"')";

     java.util.Date date = new java.util.Date();
     java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
     
         
     try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
        

     	rs = stmt.executeQuery(insertSql);  
     	while (rs.next()) {  
     		
     		existe = true;
     		String marca= rs.getString("Marca");
     		String modelo= rs.getString("Modelo");
     		int puertas= rs.getInt("Puertas");
     		String color= rs.getString("Color");
     		int cv= rs.getInt("cv");
     		String cliente= rs.getString("cliente");
     		int fecha = rs.getInt("fechaMatriculacion");
     		float precio =0.0f;
     		String tipoVehiculo= "coche";
     		String tipoGas="Gasolina";
     		
     		Vehiculo c = new Vehiculo( matricula,marca, modelo,puertas, color,tipoGas,fecha, cv,cliente,precio,tipoVehiculo);
     		Container.getVehiculosAux().add(c);
	         }
 }
}
catch (Exception e) {
 e.printStackTrace();
}
	return existe;
 
}}
