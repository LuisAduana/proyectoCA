package logicaDeNegocios;

/**
* Clase creada para controlar las excepciones del sistema.
* @author Luis Bonilla
* @version 1.0
*/
public class ExcepcionPersonal extends Exception {
  
  public static final long serialVersionUID = 700L;
  
  /**
  * Método encargado de regresar el mensaje de la ExcepcionPersonal
  * @param mensaje Recibe el mensaje que se mostrará
  */
  public ExcepcionPersonal(String mensaje) {
    super(mensaje);
  }
  
}
