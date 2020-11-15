package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;

public class Formulario implements ActionListener {
    private AdminForm adminForm;
    private AlumnForm alumnForm;
    private ProfeForm profeForm;
    private Administrador admin;
    private final String tipoUsr;
    private Alumno alumn;
    private Profesor profe;
    
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
        alumnForm.getButtonConsultarNotas().addActionListener(this);
    }
    
    private void abrirProfeForm(String nombreUsr){
        profeForm = new ProfeForm();
        profeForm.setTitle("formulario de profesor");
        profeForm.setLocationRelativeTo(null);
        profeForm.setVisible(true);
        profeForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
        profeForm.getListaAsignaturas().setModel(profe.listarAlumnos(profe.getId()));
        profeForm.getListaProfesores().setModel(profe.listarProfesores());
        profeForm.getListaAsignaturas2().setModel(profe.registrarNotas(profe.getId()));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (tipoUsr){
            case "admin":
                /*
                if (ae.getSource() == adminForm.getButtonRegistrarUsuario()) {
                    
                }
                */
                break;
            case "alumn":
                if (ae.getSource() == alumnForm.getButtonConsultarNotas()) {
                    String asignatura = alumnForm.getListNotas().getSelectedValue();
                    alumnForm.getListDetalles().setModel(alumn.listarDetalles(asignatura));
                }
                break;
            case "profe":
                
                break;
            default:
        }
    }
}
