package logicaDeNegocios;

import conexionBaseDatos.ConexionConsultas;
import java.util.ArrayList;
import javax.swing.JButton;

/**
* Clase encargada de enviar datos y recibir datos y transformarlos de las consultas a la
* Base de Datos.
* @author Luis Bonilla
* @version 1.0
*/
public class ConsultasBaseDatos {
  Validadores validador = new Validadores();
  ConexionConsultas consulta = new ConexionConsultas();
  
  /**
  * Método encargado de construir una Matriz de tipo Objeto del resultado obtenido de realizar una
  * consulta de buscar Alumnos a la Base de Datos
  * @param nrc Recibe un NRC que indica que de qué Experiencia será construida 
  * @return Regresa una matriz como resultado de la búsqueda de los alumnos en la Base de Datos
  */
  public Object[][] obtenerMatrizAlumno(int nrc) {
    ArrayList<Alumno> listaAlumnos = consulta.buscarAlumnos(nrc);
    Object matrizListas[][] = new Object[listaAlumnos.size()][4];
    for(int i = 0; i < listaAlumnos.size(); i++) {
      matrizListas[i][0] = listaAlumnos.get(i).getNombeAlumno() + "";
      matrizListas[i][1] = listaAlumnos.get(i).getApeMatAlumno()+ "";
      matrizListas[i][2] = listaAlumnos.get(i).getApePatAlumno()+ "";
      matrizListas[i][3] = new JButton("Asistencia");
    }
    return matrizListas;
  }
  
  /**
  * Método encargado de construir una Matriz de tipo Objeto del resultado obtenido de realizar una
  * consulta de buscar Alumnos que tengan derecho al examen Ordinario.
  * @param nrc Recibe un NRC que indica de qué Experiencia serán los alumnos buscados
  * @param porcentajeOrdinario Recibe el número mínimo de asistencias del Alumno
  * @param noClases Recibe el número máximo de asistencias del Alumno
  * @return Regresa la Matriz que se contruyó en el método
  */
  public Object[][] obtenerMatrizAlumnoOrdinario(int nrc, int porcentajeOrdinario, int noClases) {
    ArrayList<Alumno> listaAlumnos = consulta.buscarAlumnosOrdinario(nrc, porcentajeOrdinario, 
        noClases);
    Object matrizListas[][] = new Object[listaAlumnos.size()][3];
    for(int i = 0; i < listaAlumnos.size(); i++) {
      matrizListas[i][0] = listaAlumnos.get(i).getNombeAlumno() + "";
      matrizListas[i][1] = listaAlumnos.get(i).getApeMatAlumno()+ "";
      matrizListas[i][2] = listaAlumnos.get(i).getApePatAlumno()+ "";
    }
    return matrizListas;
  }
  
  /**
  * Método encargado de construir una Matriz de tipo Objeto del resultado obtenido de realizar una
  * consulta de buscar Alumnos que tengan derecho al examen Extraordinario.
  * @param nrc Recibe un NRC que indica de qué Experiencia serán los alumnos buscados
  * @param porcentajeExtraordinario Recibe el número mínimo de asistencias del Alumno
  * @param porcentajeOrdinario Recibe el número máximo de asistencias del Alumno
  * @return Regresa la matríz que se construyó en el método
  */
  public Object[][] obtenerMatrizAlumnoExtraordinario(int nrc, int porcentajeExtraordinario, 
      int porcentajeOrdinario) {
    ArrayList<Alumno> listaAlumnos = consulta.buscarAlumnosExtraordinario(nrc, 
        porcentajeExtraordinario, porcentajeOrdinario);
    Object matrizListas[][] = new Object[listaAlumnos.size()][3];
    for(int i = 0; i < listaAlumnos.size(); i++) {
      matrizListas[i][0] = listaAlumnos.get(i).getNombeAlumno() + "";
      matrizListas[i][1] = listaAlumnos.get(i).getApeMatAlumno()+ "";
      matrizListas[i][2] = listaAlumnos.get(i).getApePatAlumno()+ "";
    }
    return matrizListas;
  }
  
  /**
  * Método encargado de construir una Matriz de tipo Objeto del resultado obtenido de realizar una
  * consulta de buscar Alumnos que tengan derecho al examen de Título.
  * @param nrc Recibe un NRC que indica de qué Experiencia serán los alumnos buscados
  * @param porcentajeTitulos Recibe el número mínimo de asistencias del Alumno
  * @param porcentajeExtraordinario Recibe el número máximo de asistencias del Alumno
  * @return Regresa la matríz que se construyó en el método
  */
  public Object[][] obtenerMatrizAlumnoTitulos(int nrc, int porcentajeTitulos, 
      int porcentajeExtraordinario) {
    ArrayList<Alumno> listaAlumnos = consulta.buscarAlumnosTitulos(nrc, 
        porcentajeTitulos, porcentajeExtraordinario);
    Object matrizListas[][] = new Object[listaAlumnos.size()][3];
    for(int i = 0; i < listaAlumnos.size(); i++) {
      matrizListas[i][0] = listaAlumnos.get(i).getNombeAlumno() + "";
      matrizListas[i][1] = listaAlumnos.get(i).getApeMatAlumno()+ "";
      matrizListas[i][2] = listaAlumnos.get(i).getApePatAlumno()+ "";
    }
    return matrizListas;
  }
  
  /**
  * Método encargado de construir una Matríz de String como resultado de la búsqueda de todas las 
  * Experiencias Educativas.
  * @return Regresa la matríz que se construyó en el método.
  */
  public String[][] obtenerMatrizExperiencia() {
    ConexionConsultas consultarExperiencias = new ConexionConsultas();
    ArrayList<ExperienciaEducativa> listaExperiencias = 
        consultarExperiencias.buscarExperiencias();
    String matrizListas[][] = new String[listaExperiencias.size()][3];
    for(int i = 0; i < listaExperiencias.size(); i++){
      matrizListas[i][0] = listaExperiencias.get(i).getNombreExperiencia() + "";
      matrizListas[i][1] = listaExperiencias.get(i).getNrc() + "";
      matrizListas[i][2] = listaExperiencias.get(i).getNoClases() + "";
    }
    return matrizListas;
  }
  
  /**
  * Método encargado de realizar una conexión para obtener el objeto Experiencia Educativa.
  * @param nrc Recibe el NRC de la Experiencia Educativa que será buscada
  * @return Regresa el Objecto ExperienciaEducativa como resultado de hacer la consulta a la BD
  */
  public ExperienciaEducativa consultarExperiencia(String nrc) {
    ConexionConsultas consultarExperiencia = new ConexionConsultas();
    
    return consultarExperiencia.buscarEsperiencia(nrc);
  }
  
  /**
  * Método encargado de realizar una conexión para obtener el Objeto Alumno.
  * @param matricula Recibe la matrícula del Alumno que será buscado
  * @param nrc Recibe el NRC de la Experiencia Educativa de donde será el Alumno
  * @return Regresa el Objeto Alumno como resultado de hacer la consulta a la BD
  */
  public Alumno consultarAlumno(String matricula, int nrc) {
    ConexionConsultas consultarAlumno = new ConexionConsultas();
    
    return consultarAlumno.buscarAlumno(matricula, nrc);
  }
  
  /**
  * Método encargado de realizar una conexión para saber si existe un Alumno registrado en una
  * Experiencia Educativa 
  * @param existenAlumnos Recibe el NRC de la Experiencia en donde será registrado el Alumno
  * @return Regresa true en caso de que exista un alumno registrado en la Experiencia, false de lo contrario
  */
  public boolean consultarExitenAlumnos(String existenAlumnos) {
    ConexionConsultas consultarAlumno = new ConexionConsultas();
    int existeAlumno = Integer.parseInt(existenAlumnos);
    
    return consultarAlumno.existenAlumnos(existeAlumno);
  }
  
  /**
  * Método encargado de regresar el resultado de transformar el NRC String a un Integer.
  * @param nrc Recibe un NRC que será transformado
  * @return Regresa el NRC transformado
  */
  public Integer enviarNrc(String nrc) {
    Integer nrcValidado = validador.validarNrc(nrc);
    return nrcValidado;
  }
  
  /**
  * Método encargado de regresar el resultado de Asistencias de un alumno buscado.
  * @param nombre Recibe el nombre del Alumno a buscar
  * @param apellidoPat Recibe el apellido Paterno del alumno a Buscar
  * @param apellidoMat Recibe el apellido Materno del alumno a Buscar
  * @param nrc Recibe el NRC que indica de qué Experiencia será el alumno a Buscar
  * @return Regresa el número de asistencias del alumno encontrado
  */
  public int consultarAsistencia(String nombre, String apellidoPat, String apellidoMat, int nrc) {
    return consulta.buscarAsistencia(nombre, apellidoPat, apellidoMat, nrc);
  }
}