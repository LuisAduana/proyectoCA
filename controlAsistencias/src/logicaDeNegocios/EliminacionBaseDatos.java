package logicaDeNegocios;

import conexionBaseDatos.ConexionEliminar;

/**
*
* @author BiiR4
*/
public class EliminacionBaseDatos {
  
  ConexionEliminar eliminar = new ConexionEliminar();
  
  public boolean eliminarAlumno(String matricula, int nrc) {
    return eliminar.eliminarAlumno(matricula, nrc);
  }
  
  public boolean eliminarTodosAlumnos(int nrc) {
    
    return eliminar.eliminarTodosAlumnos(nrc);
  }
  
  public boolean eliminarExperiencia(String idNrc){
    
    return eliminar.eliminarExperienciaEducativa(idNrc);
  }
}
