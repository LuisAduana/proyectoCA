package logicaDeNegocios;

import conexionBaseDatos.ConexionEliminar;

/**
* Clase encargada de conectar el módulo interfazGrafica con el módulo conexionBaseDatos.
* @author Luis Bonilla
*/
public class EliminacionBaseDatos {
  
  ConexionEliminar eliminar = new ConexionEliminar();
  
  /**
  * Método encargado de regresar el resultado de eliminar un Alumno.
  * @param matricula Recibe la matricula del alumno que será eliminado
  * @param nrc Recibe el NRC de la Experiencia de donde será buscado el Alumno
  * @return Regresa true si se eliminó con éxito el alumno, false de otro modo
  */
  public boolean eliminarAlumno(String matricula, int nrc) {
    return eliminar.eliminarAlumno(matricula, nrc);
  }
  
  /**
  * Método encargado de regresar el resultado de eliminar todos los Alumnos.
  * @param nrc Recibe el NRC de la Experiencia de donde se eliminarán los alumnos
  * @return Regresa true si se eliminaron con éxito los alumnos, false de otro modo
  */
  public boolean eliminarTodosAlumnos(int nrc) {
    return eliminar.eliminarTodosAlumnos(nrc);
  }
  
  /**
   * Método encargado de regresar el resultado de eliminar una Experiencia Educativa.
   * @param idNrc Recibe el NRC de la experiencia que se eliminará
   * @return Regresa true si se eliminó con éxito, false de otro modo
   */
  public boolean eliminarExperiencia(String idNrc){
    return eliminar.eliminarExperienciaEducativa(idNrc);
  }
}
