package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditarClienteDAO {
	
	
	public static void EditarCliente(String dni,String nombre,String apellido1,String apellido2,String direccion,int telefono,String Email) {
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
		     String insertSql =   "UPDATE Clientes SET NIF = ?, Nombre = ?, Apellido1 =?, Apellido2 = ? ,Direccion =?,numerodeContacto =?, Email =? WHERE NIF= ('"+dni+"')";
		   

		     java.util.Date date = new java.util.Date();
		     java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
		     
		         
		     try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
		        
                    
                prep.setString(1, dni);
                 prep.setString(2, nombre);
                 prep.setString(3, apellido1);
                 prep.setString(4, apellido2);
                 prep.setString(5, direccion);
                 prep.setInt(6, telefono);
                 prep.setString(7, Email);
                 
                 

              prep.executeUpdate();  
		     }
		 }
		catch (Exception e) {
		 e.printStackTrace();
		}

}
}