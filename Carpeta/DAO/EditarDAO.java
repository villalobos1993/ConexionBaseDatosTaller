package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Models.Container;
import Models.Vehiculo;

public class EditarDAO {

	public static void EditarVehiculo( String matricula,String marca,String modelo,int cv,String color) {
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
		try{
		 	connection = DriverManager.getConnection(url);
		     String schema = connection.getSchema();
		     stmt = connection.createStatement();  
		     // Prepared statement to insert data
		     String insertSql = "UPDATE Vehiculos SET Matricula = ?, Marca = ?, Modelo =?, CV =?, Color = ? WHERE Matricula = ('"+matricula+"')";
		       

		     java.util.Date date = new java.util.Date();
		     java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
		     
		         
		     try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
		        
		    	 prep.setString(1, matricula);
                 prep.setString(2, marca);
                 prep.setString(3, modelo);
                 prep.setInt(4, cv);
                 prep.setString(5, color);
                  
                 

              prep.executeUpdate();  
		     }
		 }
		catch (Exception e) {
		 e.printStackTrace();
		}
			
	
		
}
		     }
