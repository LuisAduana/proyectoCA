package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
* Clase encargada de realizar todas las consultas que se hagan a la Base de Datos.
* @author BiiR4
* @version 1.0
*/
public class ConexionEliminar {
  
  /**
  * Método que eliminá varios alumnos de la BD.
  * @param nrc Recibe el NRC que indica cuales alumnos serán eliminados
  * @return Regresa true si se eliminarón correctamente, false de otro modo
  */
  public boolean eliminarTodosAlumnos(int nrc) {
    boolean exitoso = false;
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
  
  /**
  * Método que elimina una Experiencia Educativa.
  * @param idNrc Recibe el NRC que indica qué Experiencia se eliminará
  * @return Regresa true si se eliminó con éxito, false de otro modo
  */
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
  
  /**
  * Método encargado de eliminar una alumno de la Base de Datos.
  * @param matricula Recibe una matricula que indica qué Alumno de cual matricula será eliminado
  * @param nrc Recibe un NRC que indica qué Alumno de cual NRC será elimado
  * @return Regresa true si el alumno se eliminó con éxito, false de otro modo
  */
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
