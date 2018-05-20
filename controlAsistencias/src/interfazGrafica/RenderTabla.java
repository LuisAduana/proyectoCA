package interfazGrafica;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author BiiR4
 */
public class RenderTabla extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable jtable, Object value, 
      boolean bln, boolean bln1, int i, int i1) {
    
      if(value instanceof JButton) {
        JButton boton = (JButton)value;
        return boton;
      }
    return super.getTableCellRendererComponent(jtable, value  , bln, 
        bln1, i, i1);
  }
  
}
