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
* Clase encargada de realizar exclusivamente consultas a la Base de Datos.
* @author Luis Bonilla
* @version 1.0
*/
public class ConexionConsultas {
  
  /**
  * Método encargado de buscar todos los alumnos con una NRC dada.
  * @param nrc Recibe un NRC que indica los alumnos a buscar
  * @return Regresa una Lista de objetos Alumno si se realizó con éxito
  */
  public ArrayList<Alumno> buscarAlumnos(int nrc) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    Alumno alumno;
    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = estatuto.executeQuery("SELECT nombreAlumno, apeAlumnoPat, "
          + "apeAlumnoMat, asistencia FROM alumno WHERE nrc = " + nrc + "");
      while (resultado.next()) {
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
  
  
  /**
  * Método encargado de realizar búsquedas de alumnos que tienen derecho a presentar el 
  * examen Ordinario.
  * @param nrc Recibe un NRC que indica de qué Experiencia se buscarán los alumnos
  * @param porcentajeOrdinario Recibe número de asistencias mínimas que debe tener el alumno
  * @param noClases Recibe número de asistencias máximas que debe tener el alumno
  * @return Regresa una lista de objetos Alumno si la búsqueda se realiza con éxito
  */
  public ArrayList<Alumno> buscarAlumnosOrdinario(int nrc, int porcentajeOrdinario, int noClases) {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    Alumno alumno;
    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = estatuto.executeQuery("SELECT * FROM alumno WHERE asistencia > "
          + porcentajeOrdinario + " AND asistencia < " + noClases + " AND nrc = " + nrc + "");
      while (resultado.next()) {
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
  
  /**
  * Método encargado de realizar búsquedas de alumnos que tienen derecho a presentar el 
  * examen extraordinario.
  * @param nrc Recibe un NRC que indica de qué Experiencia se buscarán los alumnos
  * @param porcentajeExtraordinario Recibe número de asistencias mínimas que debe tener el alumno
  * @param porcentajeOrdinario Recibe número de asistencias máximas que debe tener el alumno
  * @return Regresa una lista de objetos Alumno si la búsqueda se realiza con éxito
  */
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
      while (resultado.next()) {
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
  
  /**
  * Método encargado de realizar búsquedas de alumnos que tienen derecho a presentar el 
  * examen de título.
  * @param nrc Recibe un NRC que indica de qué Experiencia se buscarán los alumnos
  * @param porcentajeTitulos Recibe número de asistencias mínimas que debe tener el alumno
  * @param porcentajeExtraordinario Recibe número de asistencias máximas que debe tener el alumno
  * @return Regresa una lista de objetos Alumno si la búsqueda se realiza con éxito
  */
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
      while (resultado.next()) {
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
  
  /**
  * Método encargado de realizar una búsqueda de Experiencias Educativas.
  * @return Regresa una lista de objetos Alumno si la búsqueda se realizó con éxito
  */
  public ArrayList<ExperienciaEducativa> buscarExperiencias() {
    ConexionBaseDatos conexion = new ConexionBaseDatos();
    ArrayList<ExperienciaEducativa> listaExperiencias = new ArrayList<ExperienciaEducativa>();
    ExperienciaEducativa experiencia;

    try {
      Statement estatuto = conexion.getConnection().createStatement();
      ResultSet resultado = 
          estatuto.executeQuery("SELECT nrc, nombreExperiencia, noClases FROM "
            + "experienciaeducativa");
      while (resultado.next()) {
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

  /**
  * Método encargado de buscar una Experiencia educativa.
  * @param nrc Recibe un NRC para saber que Experiencia Educativa
  * @return Regresa un Objeto ExperienciaEducativa si la búsqueda se realizó con éxito
  */
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
      
      while (resultado.next() == true) {
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
  
  /**
  * Método encargado de buscar un solo Alumno en la Base de Datos.
  * @param matricula Recibe una matrícula que indica el alumno a buscar
  * @param nrc Recibe un NRC que indica de qué Experiencia es el Alumno a buscar
  * @return Regresa un objeto Alumno si la búsqueda se hace con éxito
  */
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
      
      while (resultado.next() == true) {
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
  
  /**
  * Método encargado de buscar la existencia de algunos alumnos en la Base de Datos.
  * @param nrc Recibe un NRC que indica de que Experiencia son los Alumnos a Buscar
  * @return Regresa true en caso de que exista algun alumno con los parámetros dados, 
  *     false de lo contrario
  */
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
      
      if (resultado.next()) {
        if (resultado.getRow() > 0) {
          existeNrc = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeNrc;
  }
  
  /**
  * Método encargado de saber si existe un Alumno cuyo Nombre, apellido paterno y apellido materno
  * ya está registrado en la Base de Datos.
  * @param nombre Recibe un nombre que será buscado en la Base de Datos
  * @param apellidoPat Recibe un apellido paterno que será buscado en la Base de Datos
  * @param apellidoMat Recibe un apellido materno que será buscado en la Base de Datos
  * @param nrc Recibe un NRC que indica de qué Experiencia Educativa será buscado en Nombre Completo
  * @return Regresa true en caso de que exista un alumno con los parámetros, false de lo contrario
  */
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
      
      if (resultado.next()) {
        if (resultado.getRow() > 0) {
          existeMatricula = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeMatricula;
  }
  
  /**
  * Método encargado de buscar una matrícula que ya exista en la Base de Datos.
  * @param matricula Recibe una Matricula que será la que se va a buscar
  * @param nrc Recibe un NRC que indica de qué Experiencia Educativa será la Matricula
  * @return Regresa true en caso de que ya exista una matricula registrada, false de otra manera
  */
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
      
      if (resultado.next()) {
        if (resultado.getRow() > 0) {
          existeMatricula = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeMatricula;
  }
  
  /**
  * Método encargado de buscar la existencia de un nombre de Experiencia Educativa.
  * @param nombreExperiencia Recibe el Nombre de la Experiencia a buscar
  * @return Regresa true en caso de que exista el nombre ya registrado, false de otro modo
  */
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
      
      if (resultado.next()) {
        if (resultado.getRow() > 0) {
          existeExperiencia = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeExperiencia;
  }
  
  /**
  * Método encargado de buscar si existe una Experiencia Educativa con un NRC ingresado.
  * @param nrc Recibe el NRC que indica la Experiencia que se buscará
  * @return Regresa true en caso de que se encuentre una Experiencia con el NRC, false de otro modo
  */
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
      
      if (resultado.next()) {
        if (resultado.getRow() > 0) {
          existeExperiencia = true;
        }
      }
      
      resultado.close();
      conexion.desconectar();
      statement.close();
      
    } catch (SQLException excepcion) {
      System.out.println("Error en Consulta de Experiencia Educativa" + excepcion.getMessage());
    }
    
    return existeExperiencia;
  }

  /**
   * Método encargado de buscar la asistencia que tiene un Alumno en la Base de Datos.
   * @param nombre Recibe el nombre del Alumno a buscar
   * @param apellidoPat Recibe el apellido Paterno del Alumno a buscar
   * @param apellidoMat Recibe el apellido Materno del Alumno a buscar
   * @param nrc Recibe un NRC que indica de qué Experiencia será el alumno a buscar
   * @return Regresa el número de Asistencias del alumno encontrado con los parámetros dados
   */
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
      
      while (resultado.next()) {
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
  
