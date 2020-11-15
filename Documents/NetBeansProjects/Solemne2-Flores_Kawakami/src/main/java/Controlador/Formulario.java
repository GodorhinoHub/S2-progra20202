package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Formulario implements ActionListener {
    private AdminForm adminForm;
    private AlumnForm alumnForm;
    private ProfeForm profeForm;
    private Administrador admin;
    private Alumno alumn;
    private Profesor profe;
    private String tipoUsr;
    
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
                this.abrirProfeForm(alumn.getNombre());
                break;
            case "profe":
                this.abrirAlumnForm(profe.getNombre());
                break;
            default:
                System.out.println("Usuario sin rol, LLAMA A TI URGENTE");
                break;
        }
    }
    
    private void abrirAdminForm(String nombreUsr){
        adminForm = new AdminForm();
        adminForm.setTitle("Profe pongame 7");
        adminForm.setLocationRelativeTo(null);
        adminForm.setVisible(true);
        //adminForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
    }
    
    private void abrirAlumnForm(String nombreUsr){
        alumnForm = new AlumnForm();
        alumnForm.setTitle("Profe pongame 7");
        alumnForm.setLocationRelativeTo(null);
        alumnForm.setVisible(true);
        //encargForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
    }
    
    private void abrirProfeForm(String nombreUsr){
        this.profeForm = new ProfeForm();
        this.profeForm.setTitle("Profe pongame 7");
        this.profeForm.setLocationRelativeTo(null);
        this.profeForm.setVisible(true);
        //this.profeForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (tipoUsr){
            case "admin":
                /*
                if (ae.getSource() == adminForm.getButtonRegistrarUsuario()) {
                    
                }
                if (ae.getSource() == adminForm.getButtonBuscarUsuario()) {
                    String rut = adminForm.getTextfieldRut().getText();
                    Usuario user = adm.buscarUsuario(rut);
                    adminForm.getTextfieldApellido().setText(user.getApellido());
                    adminForm.getTextfieldNombre().setText(user.getNombre());
                    adminForm.getTextfieldCorreo().setText(user.getCorreo());
                    adminForm.getTextfieldCargo().setText(Character.toString(user.getCargo()));
                    adminForm.getTextfieldPass().setText(user.getClave());
                }
                if (ae.getSource() == adminForm.getButtonEliminarUsuario()) {
                    
                }
                if (ae.getSource() == adminForm.getButtonActualizarUsuario()) {
                    
                }
                if (ae.getSource() == adminForm.getButtonListarUsuarios()) {
                    
                }
                */
                break;
            case "alumn":
                /*
                if (ae.getSource() == profeForm.getButtonActualizarSala()) {
                    int idSala = Integer.parseInt(profeForm.getTextfieldIdSala().getText());
                    char estado = profeForm.getTextfieldEstadoSala().getText().charAt(0);
                    profe.actualizarSala(idSala, estado);
                }
                if (ae.getSource() == profeForm.getButtonConsultarEquipo()) {
                    String idEquipo = profeForm.getTextfieldIdEquipo().getText();
                    String estadoEquipo = profe.consultarEquipo(idEquipo);
                    profeForm.getLabelOperativoEquipo().setText(estadoEquipo);
                }
                if (ae.getSource() == profeForm.getButtonConsultarEquipos()) {
                    
                }
                if (ae.getSource() == profeForm.getButtonConsultarSalas()) {
                    
                }
                */
                break;
            case "profe":
                /*
                
                */
                break;
            default:
        }
    }
}
