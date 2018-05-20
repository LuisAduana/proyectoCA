package conexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicaDeNegocios.Alumno;
import logicaDeNegocios.ExperienciaEducativa;

/**
*
* @author BiiR4
*/
public class ConexionConsultas {
  
  public ArrayList<Alumno> buscarAlumnos(int nrc) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    Alumno alumno;
    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = estatuto.executeQuery("SELECT nombreAlumno, apeAlumnoPat, "
          + "apeAlumnoMat, asistencia FROM alumno WHERE nrc = " + nrc +"");
      while(resultado.next()) {
        alumno = new Alumno();
        alumno.setNombreAlumno(resultado.getString("nombreAlumno"));
        alumno.setApePatAlumno(resultado.getString("apeAlumnoPat"));
        alumno.setApeMatAlumno(resultado.getString("apeAlumnoMat"));
        alumno.setAsistencia(resultado.getInt("asistencia"));
        listaAlumnos.add(alumno);
      }
      resultado.close();
      estatuto.close();
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      System.out.println(excepcion.getMessage());
      JOptionPane.showMessageDialog(null, "Error al consultar alumnos", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return listaAlumnos;
  }
  
  public ArrayList<Alumno> buscarAlumnosOrdinario(int nrc, int porcentajeOrdinario, int noClases) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    Alumno alumno;
    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = estatuto.executeQuery("SELECT * FROM alumno WHERE asistencia > "
          + porcentajeOrdinario + " AND asistencia < " + noClases + " AND nrc = " + nrc + "");
      while(resultado.next()) {
        alumno = new Alumno();
        alumno.setNombreAlumno(resultado.getString("nombreAlumno"));
        alumno.setApePatAlumno(resultado.getString("apeAlumnoPat"));
        alumno.setApeMatAlumno(resultado.getString("apeAlumnoMat"));
        listaAlumnos.add(alumno);
      }
      resultado.close();
      estatuto.close();
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      System.out.println(excepcion.getMessage());
      JOptionPane.showMessageDialog(null, "Error al consultar alumnos de Ordinario", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return listaAlumnos;
  }
  
  public ArrayList<Alumno> buscarAlumnosExtraordinario(int nrc, int porcentajeExtraordinario, 
      int porcentajeOrdinario) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    Alumno alumno;
    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = estatuto.executeQuery("SELECT * FROM alumno WHERE asistencia > "
          + porcentajeExtraordinario + " AND asistencia < " + porcentajeOrdinario + " AND nrc = " 
          + nrc + "");
      while(resultado.next()) {
        alumno = new Alumno();
        alumno.setNombreAlumno(resultado.getString("nombreAlumno"));
        alumno.setApePatAlumno(resultado.getString("apeAlumnoPat"));
        alumno.setApeMatAlumno(resultado.getString("apeAlumnoMat"));
        listaAlumnos.add(alumno);
      }
      resultado.close();
      estatuto.close();
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      System.out.println(excepcion.getMessage());
      JOptionPane.showMessageDialog(null, "Error al consultar alumnos de Extraordinario", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return listaAlumnos;
  }
  
  public ArrayList<Alumno> buscarAlumnosTitulos(int nrc, int porcentajeTitulos, 
      int porcentajeExtraordinario) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    Alumno alumno;
    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = estatuto.executeQuery("SELECT * FROM alumno WHERE asistencia > "
          + porcentajeTitulos + " AND asistencia < " + porcentajeExtraordinario + " AND "
          + "nrc = " + nrc + " AND repite = 0");
      while(resultado.next()) {
        alumno = new Alumno();
        alumno.setNombreAlumno(resultado.getString("nombreAlumno"));
        alumno.setApePatAlumno(resultado.getString("apeAlumnoPat"));
        alumno.setApeMatAlumno(resultado.getString("apeAlumnoMat"));
        listaAlumnos.add(alumno);
      }
      resultado.close();
      estatuto.close();
      conexion.desconectar();
    } catch (SQLException excepcion) {
      System.out.println(excepcion);
      System.out.println(excepcion.getMessage());
      JOptionPane.showMessageDialog(null, "Error al consultar alumnos de Ordinario", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return listaAlumnos;
  }
  
  public ArrayList<ExperienciaEducativa> buscarExperiencias(){
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<ExperienciaEducativa> listaExperiencias = new ArrayList<ExperienciaEducativa>();
    ExperienciaEducativa experiencia;

    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = 
          estatuto.executeQuery("SELECT nrc, nombreExperiencia, noClases FROM experienciaeducativa");
      while(resultado.next()) {
        experiencia = new ExperienciaEducativa();
        experiencia.setNombreExperiencia(resultado.getString("nombreExperiencia"));
        experiencia.setNrc(Integer.parseInt(resultado.getString("nrc")));
        experiencia.setNoClases(Integer.parseInt(resultado.getString("noClases")));
        listaExperiencias.add(experiencia);
      }
      resultado.close();
      estatuto.close();
      conexion.desconectar();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return listaExperiencias;
  }

  public ExperienciaEducativa buscarEsperiencia(String nrc) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ExperienciaEducativa experiencia = null;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM experienciaeducativa WHERE nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setString(1, nrc);
      resultado = statement.executeQuery();
      
      while(resultado.next() == true) {
        experiencia = new ExperienciaEducativa();
        experiencia.setNrc(resultado.getInt("nrc"));
        experiencia.setNombreExperiencia(resultado.getString("nombreExperiencia"));
        experiencia.setNoClases(resultado.getInt("noClases"));
      }
      
      resultado.close();
      conexion.desconectar();
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
            
    return experiencia;
  }
  
  public Alumno buscarAlumno(String matricula, int nrc) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    Alumno alumno = null;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM alumno WHERE matricula = ? AND nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setString(1, matricula);
      statement.setInt(2, nrc);
      resultado = statement.executeQuery();
      
      while(resultado.next() == true) {
        alumno = new Alumno();
        alumno.setMatricula(resultado.getString("matricula"));
        alumno.setNombreAlumno(resultado.getString("nombreAlumno"));
        alumno.setApePatAlumno(resultado.getString("apeAlumnoPat"));
        alumno.setApeMatAlumno(resultado.getString("apeAlumnoMat"));
        alumno.setRepite(resultado.getBoolean("repite"));
        alumno.setAsistencia(resultado.getInt("asistencia"));
      }
            
      resultado.close();
      conexion.desconectar();
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
            
    return alumno;
  }
  
  public boolean existenAlumnos(int nrc) {
    boolean existeNrc = false;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM alumno WHERE nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setInt(1, nrc);
      resultado = statement.executeQuery();
      
      if(resultado.next()){
        if(resultado.getRow() > 0){
          existeNrc = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion){
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeNrc;
  }
  
  public boolean existeNombreCompleto(String nombre, String apellidoPat, String apellidoMat, 
      int nrc) {
    boolean existeMatricula = false;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM alumno WHERE nombreAlumno = ? AND apeAlumnoPat = ? AND "
            + "apeAlumnoMat = ? AND nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setString(1, nombre);
      statement.setString(2, apellidoPat);
      statement.setString(3, apellidoMat);
      statement.setInt(4, nrc);
      resultado = statement.executeQuery();
      
      if(resultado.next()){
        if(resultado.getRow() > 0){
          existeMatricula = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion){
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeMatricula;
  }
  
  public boolean existeMatriculaAlumno(String matricula, int nrc) {
    boolean existeMatricula = false;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM alumno WHERE matricula = ? AND nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setString(1, matricula);
      statement.setInt(2, nrc);
      resultado = statement.executeQuery();
      
      if(resultado.next()){
        if(resultado.getRow() > 0){
          existeMatricula = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion){
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeMatricula;
  }
  
  public boolean existeNombreExperiencia(String nombreExperiencia) {
    boolean existeExperiencia = false;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM experienciaeducativa WHERE nombreExperiencia = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setString(1, nombreExperiencia);
      resultado = statement.executeQuery();
      
      if(resultado.next()){
        if(resultado.getRow() > 0){
          existeExperiencia = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion){
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeExperiencia;
  }
  
  public boolean existeExperiencia(int nrc) {
    boolean existeExperiencia = false;
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    
    connection = conexion.getConnection();
    String consulta = "SELECT * FROM experienciaeducativa WHERE nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setInt(1, nrc);
      resultado = statement.executeQuery();
      
      if(resultado.next()){
        if(resultado.getRow() > 0){
          existeExperiencia = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion){
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeExperiencia;
  }
  
  public int buscarAsistencia(String nombre, String apellidoPat, String apellidoMat, int nrc) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultado = null;
    int asistencia = 0;
    
    connection = conexion.getConnection();
    String consulta = "SELECT asistencia FROM alumno WHERE nombreAlumno = ? AND apeAlumnoPat = ? "
            + "AND apeAlumnoMat = ? AND nrc = ?";
    
    try {
      statement = connection.prepareStatement(consulta);
      statement.setString(1, nombre);
      statement.setString(2, apellidoMat);
      statement.setString(3, apellidoPat);
      statement.setInt(4, nrc);
      resultado = statement.executeQuery();
      
      while(resultado.next()) {
        asistencia = resultado.getInt("asistencia");
      }
            
      resultado.close();
      conexion.desconectar();
      
    } catch (SQLException excepcion) {
      System.out.println("Error al obtener el numero de assitencia" + excepcion.getMessage());
    }
    return asistencia;
  }
}
  
