package DAO;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	public class InsertClienteDAO {


		   public static void InsertCliente(String NIF,String Nombre, String matricula) {

		        // Connect to database
		        String hostName = "PC102\\SQLALEJANDRO";
		        String dbName = "Taller";
		        String user = "Ale";
		        String password = "1234";
		        String url = String.format("jdbc:sqlserver://172.16.100.36\\SQLALEJANDRO:1433;" + "databaseName=Taller;user=Admin;password=1234");
		        Connection connection = null;
		        Connection con = null;  
			      Statement stmt = null;  
			      ResultSet rs = null;  
		        try {
		                connection = DriverManager.getConnection(url);
		                String schema = connection.getSchema();
		                
		                System.out.println("Successful connection - Schema: " + schema);

		                System.out.println("Insert data example:");
		                System.out.println("=========================================");

		                // Prepared statement to insert data
		                String insertSql = "INSERT INTO Taller.dbo.Clientes (NIF, Nombre, Apellido1,Apellido2,Direccion,numerodeContacto,Email)" 
		                    + " VALUES (?,?,'2','3','asd',987654321,'a@g.com')";
		                
		                
		             
		                java.util.Date date = new java.util.Date();
		                java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());

		                try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
		                        prep.setString(1, NIF );
		                        prep.setString(2, Nombre);
		                        
		                        int count = prep.executeUpdate();
		                        System.out.println("Inserted: " + count + " row(s)");
		                        prep.executeQuery();
		                }
		        }
		        catch (Exception e) {
		                e.printStackTrace();
		        }
		        
		        
		        try {
	                connection = DriverManager.getConnection(url);
	                String schema = connection.getSchema();
	                
	                System.out.println("Successful connection - Schema: " + schema);

	                System.out.println("Insert data example:");
	                System.out.println("=========================================");

	                // Prepared statement to insert data
	             	                
	                String ModificarDni = "UPDATE Vehiculos SET Cliente = ? "
				                  + " WHERE Matricula = ?";
	               
	                java.util.Date date = new java.util.Date();
	                java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());

	                try (PreparedStatement prep = connection.prepareStatement(ModificarDni)) {
	                	   
	                	    prep.setString(1, NIF );
	                        prep.setString(2, matricula);
	                        int count = prep.executeUpdate();
	                        System.out.println("Inserted: " + count + " row(s)");
	                        prep.executeQuery();
	                }
	        }
	        catch (Exception e) {
	                e.printStackTrace();
	        }
		    }

		}


