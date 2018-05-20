package logicaDeNegocios;

import conexionBaseDatos.ConexionRegistros;
import javax.swing.JOptionPane;

/**
*
* @author BiiR4
*/
public class RegistrarBaseDatos {
  ConexionRegistros registro = new ConexionRegistros();
  Validadores validador = new Validadores();
  
  public void modificarAlumno(Alumno alumno, int nrc, String matricula) {
    boolean exitoso = registro.modificarAlumno(alumno, nrc, matricula);
    if(exitoso) {
      JOptionPane.showMessageDialog(null, "Alumno modificado con éxito");
    } else {
      JOptionPane.showMessageDialog(null, "Fallo en modificar alumno");
    }
    
  }
  
  public void registrarAlumno(Alumno alumno, int nrc) {
    boolean exitoso = registro.registrarAlumno(alumno, nrc);
    if(exitoso) {
      JOptionPane.showMessageDialog(null, "Registrado con éxito");
    } else {
      JOptionPane.showMessageDialog(null, "Fallo en el registro");
    }
  }
  
  public void modificarExperiencia(ExperienciaEducativa experiencia, int nrcEntero) {
    boolean exitoso = registro.modificarExperiencia(experiencia, nrcEntero);
    if(exitoso){
      JOptionPane.showMessageDialog(null, "MODIFICACION EXITOSA");
    } else {
      JOptionPane.showMessageDialog(null, "FALLO EN MODIFICAR");
    }
  }
  
  public void registrarExperiencia(ExperienciaEducativa experiencia) {
    boolean exitoso = registro.registrarExperiencia(experiencia);
    if(exitoso){
      JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
    } else {
      JOptionPane.showMessageDialog(null, "FALLO EN REGISTRO");
    }
  }
  
  public void registrarAsistencia(String nombre, String apellidoPat, String apellidoMat, 
      int nrc, int asistencia) {
    if(registro.registrarAsistencia(nombre, apellidoPat, apellidoMat, nrc, asistencia)) {
      JOptionPane.showMessageDialog(null, "Asistencia Registrada");
    } else {
      JOptionPane.showMessageDialog(null, "Error al registrar asistencia");
    }
  }
  
  public Integer enviarNrc(String nrc) {
    Integer nrcValidado = validador.validarNrc(nrc);
    return nrcValidado;
  }
  
  public Integer enviarNoClases(String noClases) {
    Integer noClasesValidado = validador.validarNoClases(noClases);
    return noClasesValidado;
  }
}
