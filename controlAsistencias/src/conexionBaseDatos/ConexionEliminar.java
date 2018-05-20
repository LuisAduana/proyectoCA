package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
*
* @author BiiR4
*/
public class ConexionEliminar {
  
  public boolean eliminarTodosAlumnos(int nrc) {
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    String sentencia =  "DELETE FROM alumno WHERE nrc = ?";
    
    try {  
      PreparedStatement preStatement = connection.prepareStatement(sentencia);
      preStatement.setInt(1, nrc);
      exitoso = true;
      
      preStatement.executeUpdate();
      preStatement.close();
      conexion.desconectar();
      
    } catch (SQLException excepcion) {
      System.out.println(excepcion.getMessage());
      exitoso = false;
    }
    return exitoso;
  }
  
  public boolean eliminarExperienciaEducativa(String idNrc) {
    
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    int nrc = Integer.parseInt(idNrc);
    boolean exito;
    String sentencia =  "DELETE FROM experienciaeducativa WHERE nrc = ?";
    
    try {  
      PreparedStatement preStatement = connection.prepareStatement(sentencia);
      preStatement.setInt(1, nrc);
      
      preStatement.executeUpdate();
      exito = true;
      preStatement.close();
      conexion.desconectar();
      
    } catch (SQLException excepcion) {
      System.out.println(excepcion.getMessage());
      exito = false;
    }
    return exito;
  }
  
  public boolean eliminarAlumno(String matricula, int nrc) {
    
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    boolean exito;
    String sentencia =  "DELETE FROM alumno WHERE matricula = ? AND nrc = ?";
    
    try {  
      PreparedStatement preStatement = connection.prepareStatement(sentencia);
      preStatement.setString(1, matricula);
      preStatement.setInt(2, nrc);
      
      preStatement.executeUpdate();
      exito = true;
      preStatement.close();
      conexion.desconectar();
      
    } catch (SQLException excepcion) {
      System.out.println(excepcion.getMessage());
      exito = false;
    }
    return exito;
  }
}
