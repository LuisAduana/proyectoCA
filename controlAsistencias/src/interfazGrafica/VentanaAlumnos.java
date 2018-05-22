package interfazGrafica;

import static interfazGrafica.VentanaExperiencias.nrc;
import static interfazGrafica.VentanaExperiencias.noClases;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import logicaDeNegocios.ConsultasBaseDatos;
import logicaDeNegocios.RegistrarBaseDatos;

/**
*
* @author Luis Bonilla
*/
class VentanaAlumnos extends JPanel implements ActionListener, MouseListener {
  
  private JButton botonConsultarAlumno;
  private JButton botonRegistrarAlumno;
  private JButton regresar;
  private JComboBox comboTablas;
  private JLabel labelImagenLogoUv;
  private JLabel labelTitulo;
  private JScrollPane paneTabla;
  private JScrollPane paneTablaOrdinarios;
  private JTable tablaAlumnos;
  private JTable tablaAlumnosExtraordinario;
  private JTable tablaAlumnosOrdinario;
  private JTable tablaAlumnosTitulos;
  private int porcentajeOrdinario = 0;
  private int porcentajeExtraordinario = 0;
  private int porcentajeTitulo = 0;
  
  VentanaAlumnos() {
    setBounds(0, 0, 540, 650);
    setLayout(null);
    setBackground(Color.white);
    cargarLabelLogo();
    cargarLabelTitulo();
    cargarBotones();
    cargarComboBox();
    setVisible(true);
  }
  
  private void cargarComboBox() {
    comboTablas = new JComboBox();
    comboTablas.addItem("LISTAR");
    comboTablas.addItem("TODOS");
    comboTablas.addItem("ORDI");
    comboTablas.addItem("EXTRA");
    comboTablas.addItem("TITULO");
    comboTablas.setBounds(430, 150, 70, 20);
    comboTablas.setLayout(null);
    comboTablas.addActionListener(this);
    this.add(comboTablas);

  }
  
  private void construirTablaAsistencia() {
    ConsultasBaseDatos consulta = new ConsultasBaseDatos();
    String titulos[] = {"Nombre", "Ape. Paterno", "Ape. Materno", "Asistencia"};
    tablaAlumnos = new JTable();
    final Class[] tiposColumnas = new Class[] {
      java.lang.String.class,
      java.lang.String.class,
      java.lang.String.class,
      JButton.class
    };
    Object informacion[][] = consulta.obtenerMatrizAlumno(nrc);
    
     tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(informacion, titulos) {
      Class[] tipos = tiposColumnas;
      
      @Override
      public Class getColumnClass(int columnIndex) {
        return tipos[columnIndex];
      }
      
      @Override
      public boolean isCellEditable(int row, int column) {
        return !(this.getColumnClass(column).equals(JButton.class));
      }
    });
     
    tablaAlumnos.setDefaultRenderer(JButton.class, new TableCellRenderer() {
      @Override
      public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean bln, 
          boolean bln1, int i, int i1) {
        return (Component) objeto;
      }
    });
    
    tablaAlumnos.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int fila = tablaAlumnos.rowAtPoint(e.getPoint());
        int columna = tablaAlumnos.columnAtPoint(e.getPoint());
        String nombreAlumno = "";
        String apellidoPatAlumno = "";
        String apellidoMatAlumno = "";
        
        if (tablaAlumnos.getModel().getColumnClass(columna).equals(JButton.class)) {
          for (int i = 0; i < tablaAlumnos.getModel().getColumnCount(); i++) {
            if (!tablaAlumnos.getModel().getColumnClass(i).equals(JButton.class)) {
              nombreAlumno = tablaAlumnos.getModel().getValueAt(fila, 0).toString();
              apellidoPatAlumno = tablaAlumnos.getModel().getValueAt(fila, 1).toString();
              apellidoMatAlumno = tablaAlumnos.getModel().getValueAt(fila, 2).toString();
            }
          }
          ConsultasBaseDatos consultar = new ConsultasBaseDatos();
          int asistencia = consultar.consultarAsistencia(nombreAlumno, apellidoPatAlumno, 
              apellidoMatAlumno, nrc);
          asistencia = asistencia + 1;
          RegistrarBaseDatos registrar = new RegistrarBaseDatos();
          if (asistencia < noClases) {
            registrar.registrarAsistencia(nombreAlumno, apellidoPatAlumno, apellidoMatAlumno,
                nrc, asistencia);
          } else {
            JOptionPane.showMessageDialog(null, "Este Alumno alcanzó el máximo de asistencias");
          }
        }
      }
    });
    //paneTabla.setViewportView(tablaAlumnos);
    //paneTabla.repaint();
  }
  
  private void construirTablaOrdinarios() {
    ConsultasBaseDatos consulta = new ConsultasBaseDatos();
    String titulos[] = {"Nombre", "Ape. Paterno", "Ape. Materno"};
    Object informacion[][] = consulta.obtenerMatrizAlumnoOrdinario(nrc, porcentajeOrdinario, 
        noClases);
    tablaAlumnosOrdinario = new JTable(informacion, titulos) {
      @Override
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
      }
    };
    tablaAlumnosOrdinario.setFocusable(false);
    JTableHeader cabecera = tablaAlumnosOrdinario.getTableHeader();
    cabecera.setPreferredSize(new Dimension(10, 20));
    //paneTabla.setViewportView(tablaAlumnosOrdinario);
    //paneTabla.repaint();
  }
  
  private void construirTablaExtraordinarios() {
    ConsultasBaseDatos consulta = new ConsultasBaseDatos();
    String titulos[] = {"Nombre", "Ape. Paterno", "Ape. Materno"};
    Object informacion[][] = consulta.obtenerMatrizAlumnoExtraordinario(nrc, 
        porcentajeExtraordinario, porcentajeOrdinario);
    tablaAlumnosExtraordinario = new JTable(informacion, titulos) {
      @Override
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
      }
    };
    tablaAlumnosExtraordinario.setFocusable(false);
    JTableHeader cabecera = tablaAlumnosExtraordinario.getTableHeader();
    cabecera.setPreferredSize(new Dimension(10, 20));
    paneTabla.setViewportView(tablaAlumnosExtraordinario);
  }
  
  private void construirTablaTitulos() {
    ConsultasBaseDatos consulta = new ConsultasBaseDatos();
    String titulos[] = {"Nombre", "Ape. Paterno", "Ape. Materno"};
    Object informacion[][] = consulta.obtenerMatrizAlumnoTitulos(nrc, 
        porcentajeTitulo, porcentajeExtraordinario);
    tablaAlumnosTitulos = new JTable(informacion, titulos) {
      @Override
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
      }
    };
    tablaAlumnosTitulos.setFocusable(false);
    JTableHeader cabecera = tablaAlumnosTitulos.getTableHeader();
    cabecera.setPreferredSize(new Dimension(10, 20));
    paneTabla.setViewportView(tablaAlumnosTitulos);
  }
  
  private void cargarTablaAlumnos() {
    paneTabla = new JScrollPane();
    paneTabla.setBounds(15, 220, 500, 386);
    this.add(paneTabla);
  }
  
  private void cargarTablaAlumnosOrdinario() {
    paneTablaOrdinarios = new JScrollPane();
    paneTablaOrdinarios.setBounds(15, 220, 500, 386);
    this.add(paneTablaOrdinarios);
  }
  
  private void cargarBotones() {
    
    regresar = new JButton("REG");
    regresar.setBounds(430, 15, 70, 70);
    regresar.setLayout(null);
    regresar.addActionListener(this);
    regresar.setToolTipText("Regresar");
    this.add(regresar);
    
    botonRegistrarAlumno = new JButton("ALU");
    botonRegistrarAlumno.setBounds(240, 15, 70, 70);
    botonRegistrarAlumno.setLayout(null);
    botonRegistrarAlumno.addActionListener(this);
    botonRegistrarAlumno.setToolTipText("Registrar nuevo Alumno");
    this.add(botonRegistrarAlumno);
    
    botonConsultarAlumno = new JButton("MOD");
    botonConsultarAlumno.setBounds(335, 15, 70, 70);
    botonConsultarAlumno.setLayout(null);
    botonConsultarAlumno.addActionListener(this);
    botonConsultarAlumno.setToolTipText("Modificar E.E");
    this.add(botonConsultarAlumno);
  }
  
  private void cargarLabelTitulo() {
    labelTitulo = new JLabel();
    labelTitulo.setBounds(54, 180, 400, 30);
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setText("ALUMNOS");
    labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
    labelTitulo.setLayout(null);
    this.add(labelTitulo);
  }
  
  private void cargarLogoUv() {
    ImageIcon imagen = 
        new ImageIcon(getClass().getResource("/imagenes/universidadVeracruzana.png"));
    ImageIcon icono = 
        new ImageIcon(imagen.getImage().getScaledInstance(labelImagenLogoUv.getWidth(), 
        labelImagenLogoUv.getHeight(), Image.SCALE_DEFAULT));
    labelImagenLogoUv.setIcon(icono);
  }
  
  private void cargarLabelLogo() {
    labelImagenLogoUv = new JLabel();
    labelImagenLogoUv.setBounds(15, 15, 173, 140);
    cargarLogoUv();
    labelImagenLogoUv.setLayout(null);
    this.add(labelImagenLogoUv);
  }
  
  public void recibirNrc(int nrcEntrante) {
    nrc = nrcEntrante;
  }
  
  public void recibirClases(int noClasesEntrante) {
    noClases = noClasesEntrante;
  }
  
  private void porcentajesAsistencias() {
    porcentajeOrdinario = Math.round((80*noClases)/100);
    porcentajeExtraordinario = Math.round((60*noClases)/100);
    porcentajeTitulo = Math.round((50*noClases)/100);
  }

  @Override
  public void actionPerformed(ActionEvent evento) {
    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

    if(evento.getSource() == regresar) {
      setVisible(false);
      JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
      frame.dispose();      
      ventanaPrincipal.setVisible(true);
    }
    
    if(evento.getSource() == botonRegistrarAlumno) {
      VentanaRegistrarAlumno ventanaRegistro;
      ventanaRegistro = new VentanaRegistrarAlumno(ventanaPrincipal, true);
    }
    
    if(evento.getSource() == botonConsultarAlumno) {
      VentanaConsultaAlumno ventanaConsultaAlumno;
      ventanaConsultaAlumno = new VentanaConsultaAlumno(ventanaPrincipal, true);
    }
    
    if(evento.getSource() == comboTablas) {
      
      porcentajesAsistencias();
      cargarTablaAlumnos();
      construirTablaAsistencia();
      construirTablaOrdinarios();
      
      if(comboTablas.getSelectedItem() == "TODOS") {
        tablaAlumnosOrdinario.removeAll();
        paneTabla.setViewportView(tablaAlumnos);
      }
      
      if(comboTablas.getSelectedItem() == "ORDI") {
        tablaAlumnos.removeAll();
        paneTabla.setViewportView(tablaAlumnosOrdinario);
      }
      
      if(comboTablas.getSelectedItem() == "EXTRA") {
        construirTablaExtraordinarios();
      }
      
      if(comboTablas.getSelectedItem() == "TITULO") {
        construirTablaTitulos();
      }
    }
    
  }
  
  @Override
  public void mouseClicked(MouseEvent me) {
    
  }

  @Override
  public void mousePressed(MouseEvent me) {
    
  }

  @Override
  public void mouseReleased(MouseEvent me) {

  }

  @Override
  public void mouseEntered(MouseEvent me) {

  }

  @Override
  public void mouseExited(MouseEvent me) {

  }
  
}
