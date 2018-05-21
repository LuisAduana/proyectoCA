package logicaDeNegocios;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
*
* @author Luis Bonilla
*/
public class ValidadoresTest {
  
  Validadores instance;
  
  @Before
  public void setUp() {
    instance = new Validadores();
  }
  
  /**
  * Test of validarNombreExperiencia method, of class Validadores.
  */
  @Test
  public void testValidarNombreExperienciaUno() {
    String nombre = "";
    String resultado = "El nombre no puede estar vacio";
    try {
      instance.validarNombreExperiencia(nombre);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNombreExperiencia method, of class Validadores.
  */
  @Test
  public void testValidarNombreExperienciaDos() {
    String nombre = "O";
    String resultado = "El nombre es demasiado corto";
    try {
      instance.validarNombreExperiencia(nombre);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNombreExperiencia method, of class Validadores.
  */
  @Test
  public void testValidarNombreExperienciaTres() {
    String nombre = "dladjlksdkjdjlksaldkjalkjdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkj"
        + "djlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksa"
        + "ldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdla"
        + "ldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdla"
        + "ldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdla"
        + "ldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdla"
        + "ldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdla"
        + "ldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdladjlksdkjdjlksaldkdla";
    String resultado = "El nombre es demasiado largo";
    try {
      instance.validarNombreExperiencia(nombre);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarApellidoPaterno method, of class Validadores.
  */
  @Test
  public void testValidarApellidoPaternoUno() throws ExcepcionPersonal {
    String apellidoPatAlumno = "";
    String resultado = "Ingrese el Apellido Paterno del alumno";
    
    try {
      instance.validarApellidoPaterno(apellidoPatAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarApellidoPaterno method, of class Validadores.
  */
  @Test
  public void testValidarApellidoPaternoDos() throws ExcepcionPersonal {
    String apellidoPatAlumno = "L";
    String resultado = "No puede ingresar apellidos menor de 2 letras";
    
    try {
      instance.validarApellidoPaterno(apellidoPatAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarApellidoPaterno method, of class Validadores.
  */
  @Test
  public void testValidarApellidoPaternoTres() throws ExcepcionPersonal {
    String apellidoPatAlumno = "alsdjaskldjskaldjlasdjsasajlkjdslajdldsalalsdjaskldjskaldjlasdjs"
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd"
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd"
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd";
    String resultado = "El Apellido Paterno del Alumno es demasiado grande";
    
    try {
      instance.validarApellidoPaterno(apellidoPatAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarApellidoMaterno method, of class Validadores.
  */
  @Test
  public void testValidarApellidoMaternoUno() throws ExcepcionPersonal {
    String apellidoMatAlumno = "";
    String respuesta = "Ingrese el Apellido Materno del alumno";
    
    try {
    instance.validarApellidoMaterno(apellidoMatAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(respuesta, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarApellidoMaterno method, of class Validadores.
  */
  @Test
  public void testValidarApellidoMaternoDos() throws ExcepcionPersonal {
    String apellidoMatAlumno = "alsdjaskldjskaldjlasdjsasajlkjdslajdldsalalsdjaskldjskaldjlasdjs"
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd"
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd" 
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd";
    String respuesta = "El Apellido Materno del Alumno es demasiado grande";
    
    try {
    instance.validarApellidoMaterno(apellidoMatAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(respuesta, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarApellidoMaterno method, of class Validadores.
  */
  @Test 
  public void testValidarApellidoMaternoTres() throws ExcepcionPersonal {
    String apellidoMatAlumno = "O";
    String respuesta = "No puede ingresar apellidos de solo 2 letras";
    
    try {
    instance.validarApellidoMaterno(apellidoMatAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(respuesta, excepcion.getMessage());
    }
  }

  /**
  * Test of validarNombreAlumno method, of class Validadores.
  */
  @Test
  public void testValidarNombreAlumnoUno() throws ExcepcionPersonal {
    String nombreAlumno = "";
    String resultado = "Ingrese el Nombre del Alumno";
    try {
      instance.validarNombreAlumno(nombreAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNombreAlumno method, of class Validadores.
  */
  @Test
  public void testValidarNombreAlumnoDos() throws ExcepcionPersonal {
    String nombreAlumno = "alsdjaskldjskaldjlasdjsasajlkjdslajdldsalalsdjaskldjskaldjlasdjsdadwf"
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd"
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd" 
        + "asajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajdldsalasajlkjdslajd";
    String resultado = "El nombre del Alumno es demasiado grande";
    try {
      instance.validarNombreAlumno(nombreAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNombreAlumno method, of class Validadores.
  */
  @Test
  public void testValidarNombreAlumnoTres() throws ExcepcionPersonal {
    String nombreAlumno = "O";
    String resultado = "No puede ingresar un nombre de solo 1 letra";
    try {
      instance.validarNombreAlumno(nombreAlumno);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarExisteMatriculaNrc method, of class Validadores.
  */
  @Test
  public void testValidarExisteMatriculaNrcUno() throws ExcepcionPersonal {
    String matricula = "S14017957";
    int nrc = 12345;
    String resultado = "No puede registrar la misma matrícula en la misma E.E";
    
    try {
      instance.validarExisteMatriculaNrc(matricula, nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarExisteMatriculaNrc method, of class Validadores.
  */
  @Test
  public void testValidarExisteMatriculaNrcDos() throws ExcepcionPersonal {
    String matricula = "S14017958";
    int nrc = 12345;
    String resultado = "No puede registrar la misma matrícula en la misma E.E";
    
    try {
      instance.validarExisteMatriculaNrc(matricula, nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarExisteMatriculaNrc method, of class Validadores.
  */
  @Test
  public void testValidarExisteMatriculaNrcTres() throws ExcepcionPersonal {
    String matricula = "S14017960";
    int nrc = 12345;
    String resultado = "No puede registrar la misma matrícula en la misma E.E";
    
    try {
      instance.validarExisteMatriculaNrc(matricula, nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarMatricula method, of class Validadores.
  */
  @Test
  public void testValidarMatriculaUno() throws ExcepcionPersonal {
    String matricula = "";
    String resultado = "Ingrese una matrícula";
    try {
    instance.validarMatricula(matricula);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarMatricula method, of class Validadores.
  */
  @Test
  public void testValidarMatriculaDos() throws ExcepcionPersonal {
    String matricula = "S1401";
    String resultado = "Matrícula no válida";
    try {
    instance.validarMatricula(matricula);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarMatricula method, of class Validadores.
  */
  @Test
  public void testValidarMatriculaTres() throws ExcepcionPersonal {
    String matricula = "S140179576";
    String resultado = "Matrícula no válida";
    try {
    instance.validarMatricula(matricula);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNombreCompleto method, of class Validadores.
  */
  @Test
  public void testValidarNombreCompleto() throws ExcepcionPersonal {
    String nombre = "Luis Gerardo";
    String apellidoPat = "Bonilla";
    String apellidoMat = "Ramírez";
    int nrc = 12345;
    String resultado = "No puede ingresar un alumno con el mismo nombre";
    try {
      instance.validarNombreCompleto(nombre, apellidoPat, apellidoMat, nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarIntNrc method, of class Validadores.
  */
  @Test
  public void testValidarIntNrcUno() throws ExcepcionPersonal {
    int nrc = 0;
    String resultado = "El NRC no puede estar vacio";
    try {
      instance.validarIntNrc(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarIntNrc method, of class Validadores.
  */
  @Test
  public void testValidarIntNrcDos() throws ExcepcionPersonal {
    int nrc = 1234;
    String resultado = "Digite un NRC de 5 dígitos";
    try {
      instance.validarIntNrc(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());       
    }
  }
  
  /**
  * Test of validarIntNrc method, of class Validadores.
  */
  @Test
  public void testValidarIntNrcTres() throws ExcepcionPersonal {
    int nrc = 123456;
    String resultado = "Digite un NRC de 5 dígitos";
    try {
      instance.validarIntNrc(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());     
    }
  }
  
  /**
  * Test of validarIntNrc method, of class Validadores.
  */
  @Test
  public void testValidarIntNrcCuatro() throws ExcepcionPersonal {
    int nrc = 12345;
    String resultado = "Ese NRC ya existe";
    try {
      instance.validarIntNrc(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());     
    }
  }

  /**
  * Test of validarModificarIntNrc method, of class Validadores.
  */
  @Test
  public void testValidarModificarIntNrcUno() throws ExcepcionPersonal {
    int nrc = 0;
    String resultado = "El NRC no puede estar vacio";
    try {
      instance.validarModificarIntNrc(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarModificarIntNrc method, of class Validadores.
  */
  @Test
  public void testValidarModificarIntNrcDos() throws ExcepcionPersonal {
    int nrc = 1234;
    String resultado = "Digite un NRC de 5 dígitos";
    try {
      instance.validarModificarIntNrc(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarModificarIntNrc method, of class Validadores.
  */
  @Test
  public void testValidarModificarIntNrcTres() throws ExcepcionPersonal {
    int nrc = 123456;
    String resultado = "Digite un NRC de 5 dígitos";
    try {
      instance.validarModificarIntNrc(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarNrcBuscar method, of class Validadores.
  */
  @Test
  public void testValidarNrcBuscarUno() throws ExcepcionPersonal {
    int nrc = 0;
    String resultado = "El NRC no puede estar vacio";
    try {
    instance.validarNrcBuscar(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNrcBuscar method, of class Validadores.
  */
  @Test
  public void testValidarNrcBuscarDos() throws ExcepcionPersonal {
    int nrc = 9999;
    String resultado = "Digite un NRC de 5 dígitos";
    try {
    instance.validarNrcBuscar(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNrcBuscar method, of class Validadores.
  */
  @Test
  public void testValidarNrcBuscarTres() throws ExcepcionPersonal {
    int nrc = 100000;
    String resultado = "Digite un NRC de 5 dígitos";
    try {
    instance.validarNrcBuscar(nrc);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarNoDeClases method, of class Validadores.
  */
  @Test
  public void testValidarNoDeClasesUno() throws ExcepcionPersonal {
    int noClases = 0;
    String resultado = "El No. de Clases no puede estar vacío";
    try { 
      instance.validarNoDeClases(noClases);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNoDeClases method, of class Validadores.
  */
  @Test
  public void testValidarNoDeClasesDos() throws ExcepcionPersonal {
    int noClases = 9;
    String resultado = "El No. de clases no debe ser inferior a 10";
    try { 
      instance.validarNoDeClases(noClases);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarNoDeClases method, of class Validadores.
  */
  @Test
  public void testValidarNoDeClasesTres() throws ExcepcionPersonal {
    int noClases = 400;
    String resultado = "El No. de clases no debe ser mayor a 400";
    try { 
      instance.validarNoDeClases(noClases);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarAsistenciaAlumno method, of class Validadores.
  */
  @Test
  public void testValidarAsistenciaAlumnoUno() throws ExcepcionPersonal {
    String asistencia = "";
    String resultado = "La asistencia no puede estar vacia (ingrese 0 para dejarlo vacio)";
    try {
      instance.validarAsistenciaAlumno(asistencia);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarAsistenciaAlumno method, of class Validadores.
  */
  @Test
  public void testValidarAsistenciaAlumnoDos() throws ExcepcionPersonal {
    String asistencia = "1000";
    String resultado = "La asistencia no puede ser tan grande";
    try {
      instance.validarAsistenciaAlumno(asistencia);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }
  
  /**
  * Test of validarAsistenciaAlumno method, of class Validadores.
  */
  @Test
  public void testValidarAsistenciaAlumnoTres() throws ExcepcionPersonal {
    String asistencia = "pru";
    String resultado = "Las asistencias deben ser un número";
    try {
      instance.validarAsistenciaAlumno(asistencia);
    } catch (ExcepcionPersonal excepcion) {
      assertEquals(resultado, excepcion.getMessage());
    }
  }

  /**
  * Test of validarNrc method, of class Validadores.
  */
  @Test
  public void testValidarNrcUno() {
    String nrc = "";
    Integer resultado = null;
    Integer nrcValidado = instance.validarNrc(nrc);
    assertEquals(resultado, nrcValidado);
  }
  
  /**
  * Test of validarNrc method, of class Validadores.
  */
  @Test
  public void testValidarNrcDos() {
    String nrc = "prueba";
    Integer resultado = null;
    Integer nrcValidado = instance.validarNrc(nrc);
    assertEquals(resultado, nrcValidado);
  }

  /**
  * Test of validarNoClases method, of class Validadores.
  */
  @Test
  public void testValidarNoClasesUno() {
    String noClases = "";
    Integer resultadoEsperado = null;
    Integer resultado = instance.validarNoClases(noClases);
    assertEquals(resultadoEsperado, resultado);
  }
  
  /**
  * Test of validarNoClases method, of class Validadores.
  */
  @Test
  public void testValidarNoClasesDos() {
    String noClases = "prueba";
    Integer resultadoEsperado = null;
    Integer resultado = instance.validarNoClases(noClases);
    assertEquals(resultadoEsperado, resultado);
  }

  /**
  * Test of validarAsistencia method, of class Validadores.
  */
  @Test
  public void testValidarAsistenciaUno() {
    String asistencia = "prueba";
    Boolean prueba = instance.validarAsistencia(asistencia);
    Boolean resultado = false;
    assertEquals(resultado, prueba);
  }
  
  /**
  * Test of validarAsistencia method, of class Validadores.
  */
  @Test
  public void testValidarAsistenciaDos() {
    String asistencia = "21";
    Boolean prueba = instance.validarAsistencia(asistencia);
    Boolean resultado = true;
    assertEquals(resultado, prueba);
  }
  
}
