package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Formulario implements ActionListener {
    private AdminForm adminForm;
    private AlumnForm alumnForm;
    private ProfeForm profeForm;
    private AdminVista adminVista;
    private final String tipoUsr;
    private Administrador admin;
    private Alumno alumn;
    private Profesor profe;
    
    private String [] codigoAsign;
    
    // Constructor
    public Formulario(Administrador admin) {
        this.tipoUsr = "admin";
        this.admin = admin;
    }
    public Formulario(Alumno alumn) {
        this.tipoUsr = "alumn";
        this.alumn = alumn;
    }
    
    public Formulario(Profesor profe) {
        this.tipoUsr = "profe";
        this.profe = profe;
    }
    
    // Functions
    public void abrirInterfaz(){
        switch (tipoUsr){
            case "admin":
                this.abrirAdminForm("admin");
                break;
            case "alumn":
                this.abrirAlumnForm(alumn.getNombre());
                break;
            case "profe":
                this.abrirProfeForm(profe.getNombre());
                break;
            default:
                System.out.println("Usuario sin rol, LLAMA A TI URGENTE");
                break;
        }
    }
    
    private void abrirAdminForm(String nombreUsr){
        adminForm = new AdminForm();
        adminForm.setTitle("Formulario de administrador");
        adminForm.setLocationRelativeTo(null);
        adminForm.setVisible(true);
        adminForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
        adminForm.getButtonAltaUsuario().addActionListener(this);
        adminForm.getButtonAltaAsignatura().addActionListener(this);
        adminForm.getButtonMatricularAlumno().addActionListener(this);
    }
    
    private void abrirAlumnForm(String nombreUsr){
        alumnForm = new AlumnForm();
        alumnForm.setTitle("Formulario de alumno");
        alumnForm.setLocationRelativeTo(null);
        alumnForm.setVisible(true);
        alumnForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
        alumnForm.getListAlumnos().setModel(alumn.listarAlumnosClase(alumn.getId()));
        alumnForm.getListProfesores().setModel(alumn.listarProfesores(alumn.getId()));
        alumnForm.getListNotas().setModel(alumn.listarNotas(alumn.getId()));
        alumnForm.getListNotas().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent arg0){
                String asignatura = alumnForm.getListNotas().getSelectedValue();
                String [] codigo = asignatura.split("-");
                System.out.println(codigo[1]);
                alumnForm.getListDetalles().setModel(alumn.listarDetalles(codigo[1],alumn.getId()));
            }
        });
    }
    
    private void abrirProfeForm(String nombreUsr){
        profeForm = new ProfeForm();
        profeForm.setTitle("Formulario de profesor");
        profeForm.setLocationRelativeTo(null);
        profeForm.setVisible(true);
        profeForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
        profeForm.getListaProfesores().setModel(profe.listarProfesores());
        profeForm.getListaAsignaturas2().setModel(profe.listarAlumnos(profe.getId()));
        profeForm.getListaAsignaturas2().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent arg0){
                String asignatura = profeForm.getListaAsignaturas2().getSelectedValue();
                codigoAsign = asignatura.split("-");
                System.out.println(codigoAsign[1]);
                profeForm.getListaAlumnos2().setModel(profe.buscarAlumnos(codigoAsign[1]));
            }
        });
        profeForm.getButtonRegistrarNota().addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (tipoUsr){
            case "admin":
                if (ae.getSource() == adminForm.getButtonAltaUsuario()) {
                    adminVista = new AdminVista(admin);
                    adminVista.abrirUsuario();
                    this.adminForm.dispose();
                }
                if (ae.getSource() == adminForm.getButtonAltaAsignatura()) {
                    adminVista = new AdminVista(admin);
                    adminVista.abrirAsignatura();
                    this.adminForm.dispose();
                }
                if (ae.getSource() == adminForm.getButtonMatricularAlumno()) {
                    adminVista = new AdminVista(admin);
                    adminVista.abrirMatricular();
                    this.adminForm.dispose();
                }
                break;
            case "profe":
                if (ae.getSource() == profeForm.getButtonRegistrarNota()) {
                    String alumno = profeForm.getListaAlumnos2().getSelectedValue();
                    String [] codigoAlumn = alumno.split("-");
                    System.out.println(codigoAlumn[1]);
                    int trim = Integer.parseInt(profeForm.getFieldTrimestre().getText());
                    double not = Double.parseDouble(profeForm.getFieldNota().getText());
                    Nota nota = new Nota(trim,not);
                    String status = profe.ponerNota(codigoAlumn[1], codigoAsign[1], nota);
                    System.out.println(status);
                    profeForm.getLabelNotaStatus().setText(status);
                }
                break;
            default:
        }
    }
}
