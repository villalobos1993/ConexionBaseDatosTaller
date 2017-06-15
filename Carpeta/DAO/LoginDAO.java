package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {

	 public static boolean Login(String usuario,String contraseña) {  
          
	      // Create a variable for the connection string.  
	      String connectionUrl = "jdbc:sqlserver://172.16.100.36\\SQLALEJANDRO:1433;" +  
	         "databaseName=Taller;user=Admin;password=1234";  

	      // Declare the JDBC objects. 
	      boolean login =false;
	      String sql=("SELECT * FROM Empleados WHERE Usuario='"+usuario+"' AND pin=('"+contraseña+"')");  
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  

	      try {  
	         // Establish the connection.  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         con = DriverManager.getConnection(connectionUrl);  

	         // Create and execute an SQL statement that returns some data.   
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(sql);  

	         // Iterate through the data in the result set and display it.  
	         while (rs.next()) {  
	            login=true;
	         }
	      }  

	      // Handle any errors that may have occurred.  
	      catch (Exception e) {  
	         e.printStackTrace();  
	      }  
	      finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}  
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	         if (con != null) try { con.close(); } catch(Exception e) {}  
	      }
		
	      
	      return login;  
	   }

}
