package logicaDeNegocios;

import conexionBaseDatos.ConexionConsultas;
import conexionBaseDatos.ConexionRegistros;

/**
*
* @author BiiR4
*/
public class Validadores {
  
  ConexionRegistros conexion = new ConexionRegistros();
  ConexionConsultas consultar = new ConexionConsultas();
  
  public void validarNombreExperiencia(String nombreExperiencia) throws ExcepcionPersonal {
    if(nombreExperiencia.equals("")) {
      throw new ExcepcionPersonal("El nombre no puede estar vacio");
    }
    
    if(nombreExperiencia.length() > 299) {
      throw new ExcepcionPersonal("El nombre es demasiado largo");
    }
    
    if(nombreExperiencia.length() < 2) {
      throw new ExcepcionPersonal("El nombre es demasiado corto");
    }
    
    if(consultar.existeNombreExperiencia(nombreExperiencia)) {
      throw new ExcepcionPersonal("Ese nombre ya está registrado");
    }
  }
  
  public void validarModificarNombreExperiencia(String nombreExperiencia) throws ExcepcionPersonal{
    if(nombreExperiencia.equals("")) {
      throw new ExcepcionPersonal("El nombre no puede estar vacio");
    }
    
    if(nombreExperiencia.length() > 299) {
      throw new ExcepcionPersonal("El nombre es demasiado largo");
    }
    
    if(nombreExperiencia.length() < 2) {
      throw new ExcepcionPersonal("El nombre es demasiado corto");
    }
  }
  
  public void validarApellidoPaterno(String apellidoPatAlumno) throws ExcepcionPersonal {
    if(apellidoPatAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Apellido Paterno del alumno");
    }
    
    if(apellidoPatAlumno.length() > 49){
      throw new ExcepcionPersonal("El Apellido Paterno del Alumno es demasiado grande");
    }
    
    if(apellidoPatAlumno.length() == 2) {
      throw new ExcepcionPersonal("No puede ingresar apellidos de solo 2 letras");
    }
  }
  
  public void validarApellidoMaterno(String apellidoMatAlumno) throws ExcepcionPersonal {
    if(apellidoMatAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Apellido Materno del alumno");
    }
    
    if(apellidoMatAlumno.length() > 49){
      throw new ExcepcionPersonal("El Apellido Materno del Alumno es demasiado grande");
    }
    
    if(apellidoMatAlumno.length() == 2) {
      throw new ExcepcionPersonal("No puede ingresar apellidos de solo 2 letras");
    }
  }
  
  public void validarNombreAlumno(String nombreAlumno) throws ExcepcionPersonal {
    if(nombreAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Nombre del Alumno");
    }
    
    if(nombreAlumno.length() > 69){
      throw new ExcepcionPersonal("El nombre del Alumno es demasiado grande");
    }
    
    if(nombreAlumno.length() == 1) {
      throw new ExcepcionPersonal("No puede ingresar un nombre de solo 1 letra");
    }
    
  }
  
  public void validarExisteMatriculaNrc(String matricula, int nrc) throws ExcepcionPersonal {
    if(consultar.existeMatriculaAlumno(matricula, nrc)) {
      throw new ExcepcionPersonal("No puede registrar la misma matrícula en la misma E.E");
    }
  }
  
  public void validarMatricula(String matricula) throws ExcepcionPersonal {
    
    if(matricula.equals("")){
      throw new ExcepcionPersonal("Ingrese una matrícula");
    }
    
    if(matricula.length() < 9 || matricula.length() > 9){
      throw new ExcepcionPersonal("Matrícula no válida");
    }
   
  }
  
  public void validarNombreCompleto(String nombre, String apellidoPat,
      String apellidoMat, int nrc) throws ExcepcionPersonal {
    if(consultar.existeNombreCompleto(nombre, apellidoPat, apellidoMat, nrc)) {
      throw new ExcepcionPersonal("No puede ingresar un alumno con el mismo nombre");
    }
  }
  
  public void validarIntNrc(int nrc) throws ExcepcionPersonal {
    if(nrc == 0) {
      throw new ExcepcionPersonal("El NRC no puede estar vacio");
    }
    
    if(nrc < 10000) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if(nrc > 99999.01) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if(consultar.existeExperiencia(nrc)) {
      throw new ExcepcionPersonal("Ese NRC ya existe");
    }
  }
  
  public void validarModificarIntNrc(int nrc) throws ExcepcionPersonal {
    if(nrc == 0) {
      throw new ExcepcionPersonal("El NRC no puede estar vacio");
    }
    
    if(nrc < 10000) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if(nrc > 99999.01) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
  }
  
  public void validarNrcBuscar(int nrc) throws ExcepcionPersonal{
    if(nrc == 0) {
      throw new ExcepcionPersonal("El NRC no puede estar vacio");
    }
    
    if(nrc < 10000) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if(nrc > 99999.01) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
  }
  
  public void validarNoDeClases(int noClases) throws ExcepcionPersonal {
    if(noClases == 0) {
      throw new ExcepcionPersonal("El No. de Clases no puede estar vacio");
    }
    
    if(noClases < 10) {
      throw new ExcepcionPersonal("El No. de clases no debe ser inferior a 10");
    }
    
    if(noClases > 400) {
      throw new ExcepcionPersonal("El No. de clases no debe ser mayor a 400");
    }
  }
  
  public void validarAsistenciaAlumno(String asistencia) throws ExcepcionPersonal {
        
    if(asistencia.equals("")) {
      throw new ExcepcionPersonal("La asistencia no puede estar vacia "
          + "(ingrese 0 para dejarlo vacio)");
    }
    
    if(asistencia.length() > 3) {
      throw new ExcepcionPersonal("La asistencia no puede ser tan grande");
    }
    
    if(!validarAsistencia(asistencia)) {
      throw new ExcepcionPersonal("La asistencias deben ser un número");
    }
    
  }
    
  public Integer validarNrc(String nrc) {
    Integer nrcValidado;
    try {
      nrcValidado = Integer.parseInt(nrc);
    } catch (Exception exception) {
      nrcValidado = null;
    }
    return nrcValidado;
  }
  
  public Integer validarNoClases(String noClases) {
    Integer noClasesValidado;
    try {
      noClasesValidado = Integer.parseInt(noClases);
    } catch (Exception exception) {
      noClasesValidado = null;
    }
    return noClasesValidado;
  }
  
  public boolean validarAsistencia(String asistencia) {
    
    boolean esNumero;
    Integer noAsistencia;
    
    try {
      noAsistencia = Integer.parseInt(asistencia);
      esNumero = true;
    } catch (Exception exception) {
      esNumero = false;
    }
    
    return esNumero;
  }
  
}
