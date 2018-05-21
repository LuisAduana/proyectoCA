package logicaDeNegocios;

/**
* Clase que realiza la estructura del Objeto Alumno
* @author Luis Aduana
* @version 1.0
*/
public class Alumno {
  private String nombreCompleto;
  private String nombreAlumno;
  private String apePatAlumno;
  private String apeMatAlumno;
  private String matricula;
  private boolean repite;
  private int asistencia;
  
  public String getNombeAlumno() {
    return nombreAlumno;
  }
  
  public void setNombreAlumno(String nombreAlumno) {
    this.nombreAlumno = nombreAlumno;
  }
  
  public String getApePatAlumno() {
    return apePatAlumno;
  }
  
  public void setApePatAlumno(String apePatAlumno) {
    this.apePatAlumno = apePatAlumno;
  }
  
  public String getApeMatAlumno() {
    return apeMatAlumno;
  }
  
  public void setApeMatAlumno(String apeMatAlumno) {
    this.apeMatAlumno = apeMatAlumno;
  }
  
  public String getMatricula() {
    return matricula;
  }
  
  public void setMatricula(String matricula){
    this.matricula = matricula;
  }
  
  public boolean getRepite() {
    return repite;
  }
  
  public void setRepite(boolean repite) {
    this.repite = repite;
  }
  
  public int getAsistencia() {
    return asistencia;
  }
  
  public void setAsistencia(int asistencia) {
    this.asistencia = asistencia;
  }
  
  public String getNombreCompleto() {
    nombreCompleto = nombreAlumno + apePatAlumno + apeMatAlumno + "";
    return nombreCompleto;
  }
  
}
