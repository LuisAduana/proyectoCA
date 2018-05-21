package logicaDeNegocios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BiiR4
 */
public class EliminacionBaseDatosTest {
  
  EliminacionBaseDatos eliminar;
  
  @Before
  public void setUp() {
    eliminar = new EliminacionBaseDatos();
  }
  
  /**
  * Test of eliminarAlumno method, of class EliminacionBaseDatos.
  */
  @Test
  public void testEliminarAlumnoUno() {
    String matricula = "S1601895";
    int nrc = 12346;
    boolean resultado = eliminar.eliminarAlumno(matricula, nrc);
    assertEquals(resultado, true);
  }
  
  /**
  * Test of eliminarAlumno method, of class EliminacionBaseDatos.
  */
  @Test
  public void testEliminarAlumnoDos() {
    String matricula = "S1407957";
    int nrc = 12345;
    boolean resultado = eliminar.eliminarAlumno(matricula, nrc);
    assertEquals(resultado, true);
  }

  /**
  * Test of eliminarTodosAlumnos method, of class EliminacionBaseDatos.
  */
  @Test
  public void testEliminarTodosAlumnosUno() {
    int nrc = 12346;
    boolean resultado = eliminar.eliminarTodosAlumnos(nrc);
    assertEquals(resultado, true);
  }
  
  /**
  * Test of eliminarTodosAlumnos method, of class EliminacionBaseDatos.
  */
  @Test
  public void testEliminarTodosAlumnosDos() {
    int nrc = 12345;
    boolean resultado = eliminar.eliminarTodosAlumnos(nrc);
    assertEquals(resultado, true);
  }

  /**
  * Test of eliminarExperiencia method, of class EliminacionBaseDatos.
  */
  @Test
  public void testEliminarExperienciaUno() {
    String nrc = "16273";
    Boolean resultado = eliminar.eliminarExperiencia(nrc);
    assertEquals(resultado, true);
  }
  
  /**
  * Test of eliminarExperiencia method, of class EliminacionBaseDatos.
  */
  @Test
  public void testEliminarExperienciaDos() {
    String nrc = "12345";
    Boolean resultado = eliminar.eliminarExperiencia(nrc);
    assertEquals(resultado, true);
  }
  
}
