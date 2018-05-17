package conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*
* @author BiiR4
*/

class ConexionBaseDatos {
  private static final String USERNAME = "root";
  private static final String PASSWORD = "1234";
  private static final String BASEDATOS = 
      "jdbc:mysql://localhost:3306/controlasistencia?autoReconnect=true&useSSL=false";
  Connection conn = null;
  
  ConexionBaseDatos() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(BASEDATOS, USERNAME, PASSWORD);
      if(conn != null){
        // En caso de ser exitosa la conexión, no hacer nada.
      }
    } catch (ClassNotFoundException excepcion){
      System.out.println("ocurre una ClassNotFoundException: " + excepcion.getMessage());
    } catch (SQLException excepcion) {
      System.out.println("ocurre una SQLException: " + excepcion.getMessage());
    }
  }
  
  Connection getConnection(){
    return conn;
  }
  
  void desconectar(){
    conn = null;
  }
}