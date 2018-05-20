package logicaDeNegocios;

import conexionBaseDatos.ConexionConsultas;
import java.util.ArrayList;
import javax.swing.JButton;

/**
*
* @author BiiR4
*/
public class ConsultasBaseDatos {
  Validadores validador = new Validadores();
  ConexionConsultas consulta = new ConexionConsultas();
  
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
  
  public ExperienciaEducativa consultarExperiencia(String nrc) {
    ConexionConsultas consultarExperiencia = new ConexionConsultas();
    
    return consultarExperiencia.buscarEsperiencia(nrc);
  }
  
  public Alumno consultarAlumno(String matricula, int nrc) {
    ConexionConsultas consultarAlumno = new ConexionConsultas();
    
    return consultarAlumno.buscarAlumno(matricula, nrc);
  }
  
  public boolean consultarExitenAlumnos(String existenAlumnos) {
    ConexionConsultas consultarAlumno = new ConexionConsultas();
    int existeAlumno = Integer.parseInt(existenAlumnos);
    
    return consultarAlumno.existenAlumnos(existeAlumno);
  }
  
  public Integer enviarNrc(String nrc) {
    Integer nrcValidado = validador.validarNrc(nrc);
    return nrcValidado;
  }
  
  public int consultarAsistencia(String nombre, String apellidoPat, String apellidoMat, int nrc) {
    return consulta.buscarAsistencia(nombre, apellidoPat, apellidoMat, nrc);
  }
}