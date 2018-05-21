package conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Esta clase es la encargada de realizar únicamente la conexiones a la Base de Datos
* consta de 3 métodos: uno se encarga de realizar la conexión, otro de obtener la conexión
* y la última para cerrar la conexión.
* @author BiiR4
* @version 1.0
*/
class ConexionBaseDatos {
  private static final String USERNAME = "root";
  private static final String PASSWORD = "1234";
  private static final String BASEDATOS = 
      "jdbc:mysql://localhost:3306/controlasistencia?autoReconnect=true&useSSL=false";
  Connection conn = null;
  
  /**
  * Método para realizar la conexión a la Base de Datos.
  */
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
  
  /**
  * Método que regresa la conexión.
  * @return conn regresa la conexión a bierta
  */
  Connection getConnection(){
    return conn;
  }
  
  /** 
  * Método para desconectar la conexión a la Base de Datos.
  */
  void desconectar(){
    conn = null;
  }
}