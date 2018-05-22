package interfazGrafica;

import java.awt.Color;
import javax.swing.JFrame;

/**
*
* @author Luis Bonilla
*/
class VentanaPrincipal extends JFrame {
  
  VentanaExperiencias panelExperiencia = new VentanaExperiencias();
  VentanaAlumnos panelAlumnos = new VentanaAlumnos();
  
  VentanaPrincipal() {
    setSize(540, 650);
    
    getContentPane().setBackground(Color.WHITE);
    setLocationRelativeTo(null);
    setResizable(false);
    setTitle("PASE DE LISTA");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(panelExperiencia);
    add(panelAlumnos);
  }
}
