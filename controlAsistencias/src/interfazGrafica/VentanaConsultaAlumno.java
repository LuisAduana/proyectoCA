package interfazGrafica;

import static interfazGrafica.VentanaExperiencias.nrc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logicaDeNegocios.Alumno;
import logicaDeNegocios.ConsultasBaseDatos;
import logicaDeNegocios.EliminacionBaseDatos;
import logicaDeNegocios.ExcepcionPersonal;
import logicaDeNegocios.RegistrarBaseDatos;
import logicaDeNegocios.Validadores;

/**
*
* @author Luis Bonilla
*/
class VentanaConsultaAlumno extends JDialog implements ActionListener {
  
  private JButton buscar;
  private JButton cancelar;
  private JButton eliminar;
  private JButton modificar;
  private JButton nuevo;
  private JCheckBox repite;
  private JLabel labelBuscarMatricula;
  private JLabel labelAsistencia;
  private JLabel labelApellidoMat;
  private JLabel labelApellidoPat;
  private JLabel labelMatricula;
  private JLabel labelNombreAlumno;
  private JLabel labelTitulo;
  private JPanel panelConsulta;
  private JTextField apellidoMatTexto;
  private JTextField apellidoPatTexto;
  private JTextField asistenciasTexto;
  private JTextField buscarMatricula;
  private JTextField nombreTexto;
  private JTextField matriculaOculta;
  private JTextField matriculaTexto;

  VentanaConsultaAlumno(VentanaPrincipal ventanaPrincipal, boolean modal) {
    super(ventanaPrincipal, modal);
    setSize(500, 500);
    setTitle("Consultar");
    setLocationRelativeTo(null);
    setResizable(false);
    cargarPanel();
    setVisible(true);
  }
  
  private void cargarPanel() {
    panelConsulta = new JPanel();
    panelConsulta.setBounds(0, 0, 500, 500);
    panelConsulta.setLayout(null);
    this.add(panelConsulta);
    cargarLabels();
    cargarCheckBox();
    cargarTextFields();
    cargarBotones();
  }
  
  private void cargarTextFields() {
    buscarMatricula = new JTextField();
    buscarMatricula.setBounds(135, 98, 200, 28);
    buscarMatricula.setLayout(null);
    panelConsulta.add(buscarMatricula);
    
    nombreTexto = new JTextField();
    nombreTexto.setBounds(140, 168, 300, 28);
    nombreTexto.setLayout(null);
    nombreTexto.setEditable(false);
    panelConsulta.add(nombreTexto);
    
    apellidoPatTexto = new JTextField();
    apellidoPatTexto.setBounds(140, 208, 300, 28);
    apellidoPatTexto.setLayout(null);
    apellidoPatTexto.setEditable(false);
    panelConsulta.add(apellidoPatTexto);
    
    apellidoMatTexto = new JTextField();
    apellidoMatTexto.setBounds(140, 248, 300, 28);
    apellidoMatTexto.setLayout(null);
    apellidoMatTexto.setEditable(false);
    panelConsulta.add(apellidoMatTexto);
    
    matriculaTexto = new JTextField();
    matriculaTexto.setBounds(140, 288, 300, 28);
    matriculaTexto.setLayout(null);
    matriculaTexto.setEditable(false);
    panelConsulta.add(matriculaTexto);
    
    asistenciasTexto = new JTextField();
    asistenciasTexto.setBounds(140, 328, 300, 28);
    asistenciasTexto.setLayout(null);
    asistenciasTexto.setEditable(false);
    panelConsulta.add(asistenciasTexto);
    
    matriculaOculta = new JTextField();
    matriculaOculta.setBounds(0, 0, 70, 28);
    matriculaOculta.setLayout(null);
    matriculaOculta.setVisible(false);
    panelConsulta.add(matriculaOculta);
    
  }
  
  private void cargarBotones() {
    
    nuevo = new JButton();
    nuevo.setBounds(355, 98, 100,28);
    nuevo.setText("NUEVO");
    nuevo.addActionListener(this);
    nuevo.setLayout(null);
    nuevo.setVisible(false);
    panelConsulta.add(nuevo);
    
    buscar = new JButton();
    buscar.setBounds(355, 98, 100,28);
    buscar.setText("BUSCAR");
    buscar.addActionListener(this);
    buscar.setLayout(null);
    buscar.setVisible(true);
    panelConsulta.add(buscar);
    
    eliminar = new JButton();
    eliminar.setBounds(80, 410, 100, 28);
    eliminar.setText("ELIMINAR");
    eliminar.addActionListener(this);
    eliminar.setLayout(null);
    panelConsulta.add(eliminar);
    
    modificar = new JButton();
    modificar.setBounds(205, 410, 100, 28);
    modificar.setText("MODIFICAR");
    modificar.addActionListener(this);
    modificar.setLayout(null);
    panelConsulta.add(modificar);
    
    cancelar = new JButton();
    cancelar.setBounds(330, 410, 100, 28);
    cancelar.setText("CANCELAR");
    cancelar.addActionListener(this);
    cancelar.setLayout(null);
    panelConsulta.add(cancelar);
    
  }
  
  private void cargarCheckBox() {
    repite = new JCheckBox();
    repite.setBounds(220, 370,150, 20);
    repite.setHorizontalAlignment(SwingConstants.RIGHT);
    repite.setText("Alumno de Repite");
    repite.setEnabled(false);
    repite.setLayout(null);
    panelConsulta.add(repite);
  }
  
  private void cargarLabels() {
    
    labelBuscarMatricula = new JLabel();
    labelBuscarMatricula.setBounds(0, 100, 130, 20);
    labelBuscarMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
    labelBuscarMatricula.setText("MATRICULA a buscar: ");
    labelBuscarMatricula.setLayout(null);
    panelConsulta.add(labelBuscarMatricula);
    
    labelNombreAlumno = new JLabel();
    labelNombreAlumno.setBounds(25, 170, 100, 20);
    labelNombreAlumno.setHorizontalAlignment(SwingConstants.RIGHT);
    labelNombreAlumno.setText("Nombre(s): ");
    labelNombreAlumno.setLayout(null);
    panelConsulta.add(labelNombreAlumno);
    
    labelApellidoPat = new JLabel();
    labelApellidoPat.setBounds(25, 210, 100, 20);
    labelApellidoPat.setHorizontalAlignment(SwingConstants.RIGHT);
    labelApellidoPat.setText("Apellido Pat. : ");
    labelApellidoPat.setLayout(null);
    panelConsulta.add(labelApellidoPat);
    
    labelApellidoMat = new JLabel();
    labelApellidoMat.setBounds(25, 250, 100, 20);
    labelApellidoMat.setHorizontalAlignment(SwingConstants.RIGHT);
    labelApellidoMat.setText("Apellido Mat. : ");
    labelApellidoMat.setLayout(null);
    panelConsulta.add(labelApellidoMat);
    
    labelMatricula = new JLabel();
    labelMatricula.setBounds(25, 290, 100, 20);
    labelMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
    labelMatricula.setText("Matrícula : ");
    labelMatricula.setLayout(null);
    panelConsulta.add(labelMatricula);
    
    labelAsistencia = new JLabel();
    labelAsistencia.setBounds(25, 330, 100, 20);
    labelAsistencia.setHorizontalAlignment(SwingConstants.RIGHT);
    labelAsistencia.setText("Asistencias : ");
    labelAsistencia.setLayout(null);
    panelConsulta.add(labelAsistencia);
    
    labelTitulo = new JLabel();
    labelTitulo.setBounds(50, 25, 400, 30);
    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitulo.setText("CONSULTAR ALUMNO");
    labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
    labelTitulo.setLayout(null);
    panelConsulta.add(labelTitulo);
  }
  
  @Override
  public void actionPerformed(ActionEvent evento) {
    
    if (evento.getSource() == buscar) {
      buscarAlumno();
    }
    
    if (evento.getSource() == nuevo) {
      nuevaBusqueda();
    }
    
    if (evento.getSource() == cancelar) {
      dispose();
    }
    
    if (evento.getSource() == modificar) {
      modificarAlumno();
    }
    
    if (evento.getSource() == eliminar) {
      eliminarAlumno();
    }
    
  }
  
  private void eliminarAlumno() {
    String idMatricula = matriculaOculta.getText().trim();
    if (idMatricula.equals("")) {
      JOptionPane.showMessageDialog(null, "Debe buscar un ALUMNO para eliminarlo");
    } else {
      int respuesta = 0;
      respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar el"
            + " Alumno?", "ALERTA", respuesta);
      if (respuesta == JOptionPane.YES_OPTION) {
        EliminacionBaseDatos eliminar = new EliminacionBaseDatos();
        if (eliminar.eliminarAlumno(idMatricula, nrc)) {
          JOptionPane.showMessageDialog(null, "Alumno eliminado con éxito");
        } else {
          JOptionPane.showMessageDialog(null, "Error al eliminar Alumno");
        }
      } else {
        // Si no se confirma el dialogo simplemente eliminarlo
      }
    }
  }
  
  private void modificarAlumno() {
    String idMatricula = matriculaOculta.getText().trim();
    if (idMatricula.equals("")) {
      JOptionPane.showMessageDialog(null, "Debe buscar un ALUMNO para modificarlo");
    } else {
      String matricula = matriculaTexto.getText().trim();
      String nombreAlumno = nombreTexto.getText().trim();
      String apellidoPat = apellidoPatTexto.getText().trim();
      String apellidoMat = apellidoMatTexto.getText().trim();
      boolean esRepite = repite.isSelected();
      String asistencia = asistenciasTexto.getText().trim();
      Validadores validar = new Validadores();
      
      try {
        validar.validarMatricula(matricula);
        validar.validarNombreAlumno(nombreAlumno);
        validar.validarApellidoPaterno(apellidoPat);
        validar.validarApellidoMaterno(apellidoMat);
        validar.validarAsistenciaAlumno(asistencia);
        int asistenciaEntero = Integer.parseInt(asistencia);
        
        Alumno alumno = new Alumno();
        alumno.setMatricula(matricula);
        alumno.setNombreAlumno(nombreAlumno);
        alumno.setApePatAlumno(apellidoPat);
        alumno.setApeMatAlumno(apellidoMat);
        alumno.setAsistencia(asistenciaEntero);
        alumno.setRepite(esRepite);
        
        RegistrarBaseDatos modificar = new RegistrarBaseDatos();
        modificar.modificarAlumno(alumno, nrc, idMatricula);
        
      } catch (ExcepcionPersonal excepcion) {
        JOptionPane.showMessageDialog(null, "" + excepcion.getMessage() + "");
      }
      
    }
  }
  
  private void nuevaBusqueda() {
    nuevo.setVisible(false);
    buscar.setVisible(true);
    buscarMatricula.setEditable(true);
    nombreTexto.setEditable(false);
    apellidoPatTexto.setEditable(false);
    apellidoMatTexto.setEditable(false);
    matriculaTexto.setEditable(false);
    asistenciasTexto.setEditable(false);
    repite.setEnabled(false);
    
    buscarMatricula.setText("");
    nombreTexto.setText("");
    apellidoPatTexto.setText("");
    apellidoMatTexto.setText("");
    matriculaTexto.setText("");
    asistenciasTexto.setText("");
    repite.setSelected(false);
    
  }
  
  private void buscarAlumno() {
    String matricula = buscarMatricula.getText();
    try {
      Validadores validar = new Validadores();
      validar.validarMatricula(matricula);
      ConsultasBaseDatos consulta = new ConsultasBaseDatos();
      Alumno alumno = consulta.consultarAlumno(matricula, nrc);
      
      if(alumno != null) {
        nombreTexto.setText(alumno.getNombeAlumno() + "");
        apellidoPatTexto.setText(alumno.getApePatAlumno() + "");
        apellidoMatTexto.setText(alumno.getApeMatAlumno() + "");
        matriculaTexto.setText(alumno.getMatricula() + "");
        matriculaOculta.setText(alumno.getMatricula() + "");
        asistenciasTexto.setText(alumno.getAsistencia() + "");
        repite.setSelected(alumno.getRepite());
        
        buscarMatricula.setEditable(false);
        nombreTexto.setEditable(true);
        apellidoPatTexto.setEditable(true);
        apellidoMatTexto.setEditable(true);
        matriculaTexto.setEditable(true);
        asistenciasTexto.setEditable(true);
        repite.setEnabled(true);
        buscar.setVisible(false);
        nuevo.setVisible(true);
      } else {
        JOptionPane.showMessageDialog(null, "MATRICULA NO ENCONTRADA", 
            "ERROR", JOptionPane.WARNING_MESSAGE);
      }
    } catch (ExcepcionPersonal excepcion) {
      JOptionPane.showMessageDialog(null, "" + excepcion.getMessage() + "");
    }
  }
  
}
