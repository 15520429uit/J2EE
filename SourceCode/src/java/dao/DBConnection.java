package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBConnection
{
    String connURL = "jdbc:derby://localhost:1527/J2EE";
    
    public static Connection getCon()
    {
        Connection conn = null;
        try
        {
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //conn = DriverManager.getConnection("jdbc:derby://localhost:1527/J2EE");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=java_web_mvc;user=sa;password=sa");
            
        }
        catch (Exception ex) { System.out.println(ex); }
        return conn;
    }
    
    public static void main(String[] args)
    {
  try {
    String dbURL = "jdbc:sqlserver://localhost;databaseName=java_web_mvc;user=sa;password=sa";
    Connection conn = DriverManager.getConnection(dbURL);
    if (conn != null) {
      System.out.println("Connected");
      DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
      System.out.println("Driver name: " + dm.getDriverName());
      System.out.println("Driver version: " + dm.getDriverVersion());
      System.out.println("Product name: " + dm.getDatabaseProductName());
      System.out.println("Product version: " + dm.getDatabaseProductVersion());
    }
   } catch (Exception ex) {
     System.err.println("Cannot connect database, " + ex);
     ex.printStackTrace();
   }
    }
}


