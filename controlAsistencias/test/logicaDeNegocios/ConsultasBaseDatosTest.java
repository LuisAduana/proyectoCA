package logicaDeNegocios;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
*
* @author Luis Bonilla
*/
public class ConsultasBaseDatosTest {
  
  ConsultasBaseDatos consultar;
  
  @Before
  public void setUp() {
    consultar = new ConsultasBaseDatos();
  }
  
  /**
  * Test of consultarExitenAlumnos method, of class ConsultasBaseDatos.
  */
  @Test
  public void testConsultarExitenAlumnosUno() {
    String nrc = "12345";
    boolean resultado = true;
    boolean consulta = consultar.consultarExitenAlumnos(nrc);
    assertEquals(consulta, resultado);
  }
  
  /**
  * Test of consultarExitenAlumnos method, of class ConsultasBaseDatos.
  */
  @Test
  public void testConsultarExitenAlumnosDos() {
    String nrc = "54321";
    boolean resultado = false;
    boolean consulta = consultar.consultarExitenAlumnos(nrc);
    assertEquals(consulta, resultado);
  }

  /**
  * Test of enviarNrc method, of class ConsultasBaseDatos.
  */
  @Test
  public void testEnviarNrcUno() {
    String nrc = "12345";
    Integer resultado = 12345;
    Integer consulta = consultar.enviarNrc(nrc);
    assertEquals(consulta, resultado);
  }
  
  /**
  * Test of enviarNrc method, of class ConsultasBaseDatos.
  */
  @Test
  public void testEnviarNrcDos() {
    String nrc = "prueba";
    Integer resultado = null;
    Integer consulta = consultar.enviarNrc(nrc);
    assertEquals(consulta, resultado);
  }

  /**
  * Test of consultarAsistencia method, of class ConsultasBaseDatos.
  */
  @Test
  public void testConsultarAsistenciaUno() {
    String nombre = "Luis Gerardo";
    String apellidoPat = "Bonilla";
    String apellidoMat = "Ramírez";
    int nrc = 12345;
    int expResult = 50;
    int resultado = consultar.consultarAsistencia(nombre, apellidoPat, apellidoMat, nrc);
    assertEquals(expResult, resultado);
  }
  
  /**
  * Test of consultarAsistencia method, of class ConsultasBaseDatos.
  */
  @Test
  public void testConsultarAsistenciaDos() {
    String nombre = "Luz Angélica";
    String apellidoPat = "Bonilla";
    String apellidoMat = "Ramírez";
    int nrc = 12345;
    int expResult = 70;
    int resultado = consultar.consultarAsistencia(nombre, apellidoPat, apellidoMat, nrc);
    assertEquals(expResult, resultado);
  }
  
}
