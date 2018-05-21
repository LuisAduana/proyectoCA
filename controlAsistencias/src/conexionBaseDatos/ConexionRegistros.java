package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaDeNegocios.Alumno;
import logicaDeNegocios.ExperienciaEducativa;

/**
* Clase encargada de realizar todos los registros necesarios a la Base de Datos.
* @author Luis Bonilla
* @version 1.0
*/
public class ConexionRegistros {
  
  /**
  * Método que encargado de realizar el registro del Alumno en la BD.
  * @param alumno Recibe un Objeto Alumno que es el que se va a registrar en la Base de Datos.
  * @param nrc Recibe un NRC para saber en qué Experiencia será registrado el Alumno.
  * @return Regresa un boolean para verificar si se realizó con éxito el registro del alumno o no.
  */
  public boolean registrarAlumno(Alumno alumno, int nrc) {
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    PreparedStatement preStatement = null;
    connection = conexion.getConnection();
    String consulta = "INSERT INTO alumno (matricula, nombreAlumno, apeAlumnoPat, apeAlumnoMat, "
        + "repite, asistencia, nrc) VALUES (?, ?, ?, ?, ?, 0, ?)";
    try {
      preStatement = connection.prepareStatement(consulta);
      preStatement.setString(1, alumno.getMatricula());
      preStatement.setString(2, alumno.getNombeAlumno());
      preStatement.setString(3, alumno.getApePatAlumno());
      preStatement.setString(4, alumno.getApeMatAlumno());
      preStatement.setBoolean(5, alumno.getRepite());
      preStatement.setInt(6, nrc);
      preStatement.execute();
      exitoso = true;
      
    } catch (SQLException ex) {
      exitoso = false;
      Logger.getLogger(ConexionRegistros.class.getName()).log(Level.SEVERE, null, ex);
      ex.printStackTrace();
    }
    return exitoso;
  }
  
  /**
  * Método encargado de realizar una modificación a un Alumno.
  * @param alumno Recibe un Objeto Alumno que es el que se va a modificar en la Base de Datos.
  * @param nrc Recibe un NRC para saber de qué Experiencia es el Alumno registrado
  * @param matricula Recibe una matrícula para saber qué alumno se modificará
  * @return Regresa true si se modificó correctamente, false de otra manera
  */
  public boolean modificarAlumno(Alumno alumno, int nrc, String matricula) {
    
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    String consulta = "UPDATE alumno SET matricula = ?, nombreAlumno = ?, apeAlumnoPat = ?, "
            + "apeAlumnoMat = ?, repite = ?, asistencia = ? WHERE nrc = ? AND matricula = ?";
    
    try {
      PreparedStatement preStatement = connection.prepareStatement(consulta);
      preStatement.setString(1, alumno.getMatricula());
      preStatement.setString(2, alumno.getNombeAlumno());
      preStatement.setString(3, alumno.getApePatAlumno());
      preStatement.setString(4, alumno.getApeMatAlumno());
      preStatement.setBoolean(5, alumno.getRepite());
      preStatement.setInt(6, alumno.getAsistencia());
      preStatement.setInt(7, nrc);
      preStatement.setString(8, matricula);
      preStatement.executeUpdate();
      
      exitoso = true;
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      exitoso = false;
    }
    
    return exitoso;
  }
  
  /**
  * Método encargado de registrar una nuevoa Experiencia en la Base de Datos.
  * @param experiencia Recibe un objeto de tipo ExperienciaEducativa que se registrará en la BD
  * @return Regresa true si se realizó el registro correctamente, false de otro modo
  */
  public boolean registrarExperiencia(ExperienciaEducativa experiencia) {
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    PreparedStatement preStatement = null;
    connection = conexion.getConnection();
    String consulta = "INSERT INTO experienciaeducativa (nrc, nombreExperiencia, noClases) "
              + "VALUES (?, ?, ?)";
    try {
      preStatement = connection.prepareStatement(consulta);
      preStatement.setInt(1, experiencia.getNrc());
      preStatement.setString(2, experiencia.getNombreExperiencia());
      preStatement.setInt(3, experiencia.getNoClases());
      preStatement.execute();
      exitoso = true;
      
    } catch (SQLException ex) {
      exitoso = false;
      Logger.getLogger(ConexionRegistros.class.getName()).log(Level.SEVERE, null, ex);
      ex.printStackTrace();
    }
    return exitoso;
  }
  
  /**
  * Método encargado de realizar la modificación de una Experiencia Educativa
  * @param experiencia Recibe un objeto de tipo ExperienciaEducativa que será lo que se modfique.
  * @param nrcEntero Recibe un NRC que indica qué Experiencia se modificará
  * @return Regresa true si se modificó con éxito, false de otro modo
  */
  public boolean modificarExperiencia(ExperienciaEducativa experiencia, int nrcEntero) {
    
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    String consulta = "UPDATE experienciaeducativa SET nrc = ?, nombreExperiencia = ?, "
        + "noClases = ? WHERE nrc = ?";
    
    try {
      PreparedStatement preStatement = connection.prepareStatement(consulta);
      preStatement.setInt(1, experiencia.getNrc());
      preStatement.setString(2, experiencia.getNombreExperiencia());
      preStatement.setInt(3, experiencia.getNoClases());
      preStatement.setInt(4, nrcEntero);
      preStatement.executeUpdate();
      
      exitoso = true;
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      exitoso = false;
    }
    
    return exitoso;
  }
  
  /**
  * Método encargado de registrar una asistencia en la Base de Datos.
  * @param nombre Recibe el nombre del alumno a quien se le registrará la asistencia
  * @param apellidoPat Recibe el apellido paterno del alumno a quien se le registrará la asistencia
  * @param apellidoMat Recibe el apellido materno del alumno a quien se le registrará la asistencia
  * @param nrc Recibe el NRC del alumno a quien se le registrará la asistencia
  * @param asistencia Recibe la nueva asistencia que tendrá el alumno.
  * @return Regresa true si se registró con éxito la asistencia, false de otro modo.
  */
  public boolean registrarAsistencia(String nombre, String apellidoPat, String apellidoMat, 
      int nrc, int asistencia) {
    
    boolean exitoso;
    Connection connection = null;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    connection = conexion.getConnection();
    String consulta = "UPDATE alumno SET asistencia = ? WHERE nombreAlumno = ? "
        + "AND apeAlumnoPat = ? AND apeAlumnoMat = ? AND nrc = ?";
    
    try {
      PreparedStatement preStatement = connection.prepareStatement(consulta);
      preStatement.setInt(1, asistencia);
      preStatement.setString(2, nombre);
      preStatement.setString(3, apellidoMat);
      preStatement.setString(4, apellidoPat);
      preStatement.setInt(5, nrc);
      preStatement.executeUpdate();
      
      exitoso = true;
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      exitoso = false;
    }
    
    return exitoso;
  }
}
