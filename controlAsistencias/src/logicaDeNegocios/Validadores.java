package logicaDeNegocios;

import conexionBaseDatos.ConexionConsultas;
import conexionBaseDatos.ConexionRegistros;

/**
* Esta Clase se encarga de hacer todas las validaciones que se requieran para hacer un registro,
*     una modificación, consulta o eliminación a la Base de Datos.
* @author Luis Bonilla Ramírez
* @version 1.0
*/
public class Validadores {
  
  ConexionRegistros conexion = new ConexionRegistros();
  ConexionConsultas consultar = new ConexionConsultas();
  
  /**
  * Método que valida el Nombre de la Experiencia Educativa.
  * @param nombreExperiencia Recibe el nombre de la Experiencia que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     que contiene el método
  */
  public void validarNombreExperiencia(String nombreExperiencia) throws ExcepcionPersonal {
    if (nombreExperiencia.equals("")) {
      throw new ExcepcionPersonal("El nombre no puede estar vacio");
    }
    
    if (nombreExperiencia.length() > 299) {
      throw new ExcepcionPersonal("El nombre es demasiado largo");
    }
    
    if (nombreExperiencia.length() < 2) {
      throw new ExcepcionPersonal("El nombre es demasiado corto");
    }
    
    if (consultar.existeNombreExperiencia(nombreExperiencia)) {
      throw new ExcepcionPersonal("Ese nombre ya está registrado");
    }
  }

  /**
   * Método para validar el nombre a modificar de la Experiencia Educativa.
   * @param nombreExperiencia Recibe el nombre de la Experiencia Educativa que se validará
   * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
   *     que contiene el método
   */
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
  
  /**
  * Método para validar el ApellidoPaterno de un Alumno.
  * @param apellidoPatAlumno Recibe el apellido paterno del Alumno que se validará
  * @throws ExcepcionPersonal Lanza una excepcion personal en caso de que cumpla alguna condición
  *     que contiene el método
  */
  public void validarApellidoPaterno(String apellidoPatAlumno) throws ExcepcionPersonal {
    if (apellidoPatAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Apellido Paterno del alumno");
    }
    
    if (apellidoPatAlumno.length() > 49) {
      throw new ExcepcionPersonal("El Apellido Paterno del Alumno es demasiado grande");
    }
    
    if (apellidoPatAlumno.length() < 2) {
      throw new ExcepcionPersonal("No puede ingresar apellidos menor de 2 letras");
    }
  }
  
  /**
  * Método para validar el apellido materno de un Alumno.
  * @param apellidoMatAlumno Recibe un apellido materno del Alumno que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     que contiene el método
  */
  public void validarApellidoMaterno(String apellidoMatAlumno) throws ExcepcionPersonal {
    if (apellidoMatAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Apellido Materno del alumno");
    }
    
    if (apellidoMatAlumno.length() > 49) {
      throw new ExcepcionPersonal("El Apellido Materno del Alumno es demasiado grande");
    }
    
    if (apellidoMatAlumno.length() == 2) {
      throw new ExcepcionPersonal("No puede ingresar apellidos de solo 2 letras");
    }
  }
  
  /**
  * Método para validar el nombre de un Alumno.
  * @param nombreAlumno Recibe el nombre del Alumno que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     que contiene el método
  */
  public void validarNombreAlumno(String nombreAlumno) throws ExcepcionPersonal {
    if (nombreAlumno.equals("")) {
      throw new ExcepcionPersonal("Ingrese el Nombre del Alumno");
    }
    
    if (nombreAlumno.length() > 69) {
      throw new ExcepcionPersonal("El nombre del Alumno es demasiado grande");
    }
    
    if (nombreAlumno.length() == 1) {
      throw new ExcepcionPersonal("No puede ingresar un nombre de solo 1 letra");
    }
    
  }
  
  /**
  * Método para validar la consulta a la Base de Datos de existencia de una matricula.
  * @param matricula Recibe la matrícula que se consultará del Alumno
  * @param nrc Recibe el NRC que indica de qué Experiencia Educativa será el Alumno
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     dentro del método
  */
  public void validarExisteMatriculaNrc(String matricula, int nrc) throws ExcepcionPersonal {
    if (consultar.existeMatriculaAlumno(matricula, nrc)) {
      throw new ExcepcionPersonal("No puede registrar la misma matrícula en la misma E.E");
    }
  }
  
  /**
  * Método para validar la matricula de un Alumno.
  * @param matricula Recibe la matrícula que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     dentro del método
  */
  public void validarMatricula(String matricula) throws ExcepcionPersonal {
    if (matricula.equals("")) {
      throw new ExcepcionPersonal("Ingrese una matrícula");
    }
    
    if (matricula.length() < 9 || matricula.length() > 9) {
      throw new ExcepcionPersonal("Matrícula no válida");
    }
  }
  
  /**
  * Método para validar la consulta a la Base de Datos de existencia de un Alumno con el mismo
  *     nombre, apellido paterno y apellido materno registrado en la misma Experiencia.
  * @param nombre Recibe el nombre que se consultará en la Base de Datos
  * @param apellidoPat Recibe el apellido paterno que se consultará en la Base de Datos
  * @param apellidoMat Recibe el apellido materno que se consultará en la Base de Datos
  * @param nrc Recibe el NRC que indica de qué Experiencia Educativa será el Alumno
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     dentro del método
  */
  public void validarNombreCompleto(String nombre, String apellidoPat,
      String apellidoMat, int nrc) throws ExcepcionPersonal {
    if (consultar.existeNombreCompleto(nombre, apellidoPat, apellidoMat, nrc)) {
      throw new ExcepcionPersonal("No puede ingresar un alumno con el mismo nombre");
    }
  }
  
  /**
  * Método para validar el NRC de la Experiencia Educativa.
  * @param nrc Recibe el NRC que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna excepción
  *     dentro del método
  */
  public void validarIntNrc(int nrc) throws ExcepcionPersonal {
    if (nrc == 0) {
      throw new ExcepcionPersonal("El NRC no puede estar vacio");
    }
    
    if (nrc < 10000) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if (nrc > 99999.00000000000000001) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if (consultar.existeExperiencia(nrc)) {
      throw new ExcepcionPersonal("Ese NRC ya existe");
    }
  }
  
  /**
  * Método para validar el NRC a modificar de la Experiencia Educativa.
  * @param nrc Recibe el NRC que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna dondición
  *     dentro del método
  */
  public void validarModificarIntNrc(int nrc) throws ExcepcionPersonal {
    if (nrc == 0) {
      throw new ExcepcionPersonal("El NRC no puede estar vacio");
    }
    
    if (nrc < 10000) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if (nrc > 99999.01) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
  }
  
  /**
  * Método para validar el NRC a buscar de una Experiencia Educativa.
  * @param nrc Recibe el NRC a validar
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     dentro del método
  */
  public void validarNrcBuscar(int nrc) throws ExcepcionPersonal {
    if (nrc == 0) {
      throw new ExcepcionPersonal("El NRC no puede estar vacio");
    }
    
    if (nrc < 10000) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
    
    if (nrc > 99999.01) {
      throw new ExcepcionPersonal("Digite un NRC de 5 dígitos");
    }
  }
  
  /**
  * Método para validar el No. de Clases de una Experiencia Educativa.
  * @param noClases Recibe el número de Clases que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna condición
  *     dentro del método
  */
  public void validarNoDeClases(int noClases) throws ExcepcionPersonal {
    if (noClases == 0) {
      throw new ExcepcionPersonal("El No. de Clases no puede estar vacío");
    }
    
    if (noClases < 10) {
      throw new ExcepcionPersonal("El No. de clases no debe ser inferior a 10");
    }
    
    if (noClases > 400) {
      throw new ExcepcionPersonal("El No. de clases no debe ser mayor a 400");
    }
  }
  
  /**
  * Método para validar la asistencia a modificar de un Alumno.
  * @param asistencia Recibe la asistencia que se validará
  * @throws ExcepcionPersonal Lanza una excepción personal en caso de que cumpla alguna dondición
  *     dentro del método
  */
  public void validarAsistenciaAlumno(String asistencia) throws ExcepcionPersonal {
        
    if (asistencia.equals("")) {
      throw new ExcepcionPersonal("La asistencia no puede estar vacia "
          + "(ingrese 0 para dejarlo vacio)");
    }
    
    if (asistencia.length() > 3) {
      throw new ExcepcionPersonal("La asistencia no puede ser tan grande");
    }
    
    if (validarAsistencia(asistencia) == false) {
      throw new ExcepcionPersonal("Las asistencias deben ser un número");
    }
  }
    
  /**
  * Método para validar que el NRC string pueda transformarse en un Integer.
  * @param nrc Recibe el NRC a transformar
  * @return Regresa el resultado de la transformación del Integer
  */
  public Integer validarNrc(String nrc) {
    Integer nrcValidado;
    try {
      nrcValidado = Integer.parseInt(nrc);
    } catch (Exception exception) {
      nrcValidado = null;
    }
    return nrcValidado;
  }
  
  /**
  * Método para validar que el No de Clases String puede transformarse en un Integer.
  * @param noClases Recibe el No de Clases a transformar
  * @return Regresa el resultado de la transformación del Integer
  */
  public Integer validarNoClases(String noClases) {
    Integer noClasesValidado;
    try {
      noClasesValidado = Integer.parseInt(noClases);
    } catch (Exception exception) {
      noClasesValidado = null;
    }
    return noClasesValidado;
  }
  
  /**
  * Método para validar que la Asistencia String puede transformarse en un Integer.
  * @param asistencia Recibe la Asistencia a transformar
  * @return Regresa el resultado de la transformación del Integer.
  */
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
