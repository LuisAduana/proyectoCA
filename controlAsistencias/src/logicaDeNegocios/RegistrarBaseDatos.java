package logicaDeNegocios;

import conexionBaseDatos.ConexionRegistros;
import javax.swing.JOptionPane;

/**
* Clase encargada de mostrar mensajes si se efectuaron actualizaciones o registros con éxito o falla.
* @author Luis Bonilla
* @version 1.0
*/
public class RegistrarBaseDatos {
  ConexionRegistros registro = new ConexionRegistros();
  Validadores validador = new Validadores();
  
  /**
  * Método encargado de mostrar si se realizó con éxito la modificación de un Alumno.
  * @param alumno Recibe el Objeto Alumno con los datos a modificar
  * @param nrc Recibe el NRC que indica de que Experiencia Educativa es el Alumno
  * @param matricula Recibe la matricula del Alumno que será modificado
  */
  public void modificarAlumno(Alumno alumno, int nrc, String matricula) {
    boolean exitoso = registro.modificarAlumno(alumno, nrc, matricula);
    if(exitoso) {
      JOptionPane.showMessageDialog(null, "Alumno modificado con éxito");
    } else {
      JOptionPane.showMessageDialog(null, "Fallo en modificar alumno");
    }
  }
  
  /**
  * Método encargado de mostrar si se realizó con éxito el registro de un Alumno
  * @param alumno Recibe el Objeto Alumno con los datos que se registrarán
  * @param nrc Recibe el NRC que indica en qué Experiencia Educativa se registrará
  */
  public void registrarAlumno(Alumno alumno, int nrc) {
    boolean exitoso = registro.registrarAlumno(alumno, nrc);
    if(exitoso) {
      JOptionPane.showMessageDialog(null, "Registrado con éxito");
    } else {
      JOptionPane.showMessageDialog(null, "Fallo en el registro");
    }
  }
  
  /**
  * Método encargado de mostrar si se modificó con éxito una Experiencia Educativa.
  * @param experiencia Recibe el Objeto ExperienciaEducativa con los datos a modificar
  * @param nrcEntero Recibe el NRC que indica cual Experiencia Educativa se modificará
  */
  public void modificarExperiencia(ExperienciaEducativa experiencia, int nrcEntero) {
    boolean exitoso = registro.modificarExperiencia(experiencia, nrcEntero);
    if(exitoso){
      JOptionPane.showMessageDialog(null, "MODIFICACION EXITOSA");
    } else {
      JOptionPane.showMessageDialog(null, "FALLO EN MODIFICAR");
    }
  }
  
  /**
  * Método encargado de mostrar si se registró con éxito una Experiencia Educativa.
  * @param experiencia Recibe el Objeto ExperienciaEducativa con los datos a registrar
  */
  public void registrarExperiencia(ExperienciaEducativa experiencia) {
    boolean exitoso = registro.registrarExperiencia(experiencia);
    if(exitoso){
      JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
    } else {
      JOptionPane.showMessageDialog(null, "FALLO EN REGISTRO");
    }
  }
  
  /**
  * Método encargado de mostrar si se registró una Asistencia de un Alumno.
  * @param nombre Recibe el nombre del Alumno que se registrará la asistencia
  * @param apellidoPat Recibe el apellido Paterno del Alumno que se registrará la asistencia
  * @param apellidoMat Recibe el apellido Materno del Alumno que se registrará la asistencia
  * @param nrc Recibe el NRC que indica de qué Experiencia es el Alumno que se registrará la asistencia
  * @param asistencia  Recibe el número de Asistencia que se le registrará
  */
  public void registrarAsistencia(String nombre, String apellidoPat, String apellidoMat, 
      int nrc, int asistencia) {
    if(registro.registrarAsistencia(nombre, apellidoPat, apellidoMat, nrc, asistencia)) {
      JOptionPane.showMessageDialog(null, "Asistencia Registrada");
    } else {
      JOptionPane.showMessageDialog(null, "Error al registrar asistencia");
    }
  }
}
