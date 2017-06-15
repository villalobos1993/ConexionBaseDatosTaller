package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class InsertCocheDAO {


	   public static void InsertCoche(String Matricula,String Marca,String Modelo,int Puertas,String Color,int CV,String dni) {

	        // Connect to database
	        String hostName = "PC102\\SQLALEJANDRO";
	        String dbName = "Taller";
	        String user = "Ale";
	        String password = "1234";
	        String url = String.format("jdbc:sqlserver://172.16.100.36\\SQLALEJANDRO:1433;" + "databaseName=Taller;user=Admin;password=1234");
	        Connection connection = null;

	        try {
	                connection = DriverManager.getConnection(url);
	                String schema = connection.getSchema();
	                System.out.println("Successful connection - Schema: " + schema);

	                System.out.println("Insert data example:");
	                System.out.println("=========================================");

	                // Prepared statement to insert data
	                String insertSql = "INSERT INTO Taller.dbo.Vehiculos (Matricula, Marca, Modelo,Puertas,Color,AC,CV,Cliente,Mecanico,EstadoReparacion)" 
	                    + " VALUES (?,?,?,?,?,'si',?,null,'ale','averiado')";

	                java.util.Date date = new java.util.Date();
	                java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());

	                try (PreparedStatement prep = connection.prepareStatement(insertSql)) {
	                        prep.setString(1,Matricula);
	                        prep.setString(2, Marca);
	                        prep.setString(3, Modelo);
	                        prep.setInt(4, Puertas);
	                        prep.setString(5, Color);
	                        prep.setInt(6, CV);
	                       
	                      
	                       
	                        
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


