package logicaDeNegocios;

import org.junit.Before;
import org.junit.Test;
// import static org.junit.Assert.*;

/**
*
* @author Luis Bonilla
*/
public class RegistrarBaseDatosTest {
  
  RegistrarBaseDatos registrar;
  
  @Before
  public void setUp() {
    registrar = new RegistrarBaseDatos();
  }
  
  /**
  * Test of enviarNrc method, of class RegistrarBaseDatos.
  */
  @Test
  public void testEnviarNrcUno() {
    String nrc = "24135";
    // Integer nrcTransformado = registrar.enviarNrc(nrc);
    Integer resultado = 24135;
    // assertEquals(nrcTransformado, resultado);
  }
  
  /**
  * Test of enviarNrc method, of class RegistrarBaseDatos.
  */
  @Test
  public void testEnviarNrcDos() {
    String nrc = "prueba";
    // Integer nrcTransformado = registrar.enviarNrc(nrc);
    Integer resultado = null;
    // assertEquals(nrcTransformado, resultado);
  }

  /**
  * Test of enviarNoClases method, of class RegistrarBaseDatos.
  */
  @Test
  public void testEnviarNoClasesUno() {
    String noClases = "24";
    // Integer noClasesTransformado = registrar.enviarNoClases(noClases);
    Integer resultado = 24;
    // assertEquals(resultado, noClasesTransformado);  
  }
  
  /**
  * Test of enviarNoClases method, of class RegistrarBaseDatos.
  */
  @Test
  public void testEnviarNoClasesDos() {
    String noClases = "prueba";
    // Integer noClasesTransformado = registrar.enviarNoClases(noClases);
    Integer resultado = null;
    // assertEquals(resultado, noClasesTransformado);  
  }
  
}
