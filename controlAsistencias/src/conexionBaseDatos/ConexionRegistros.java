package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaDeNegocios.Alumno;
import logicaDeNegocios.ExperienciaEducativa;

/**
 *
 * @author BiiR4
 */
public class ConexionRegistros {
  
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
