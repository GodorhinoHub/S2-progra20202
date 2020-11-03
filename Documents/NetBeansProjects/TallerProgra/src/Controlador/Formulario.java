package Controlador;

import Main.main;
import Controlador.*;
import Modelo.*;
import Vista.*;
import java.awt.event.*;
import javax.swing.*;

public class Formulario implements ActionListener {
    private AdminForm adminForm;
    private ProfeForm profeForm;
    private EncargForm encargForm;
    private Administrador adm;
    private Profesor profe;
    private Encargado enc;
    private Usuario usr;
    Controlador con = main.control;
    
    public Formulario(Administrador adm){
        this.adm = adm;
        this.usr = adm;
    }
    public Formulario(Profesor profe){
        this.profe = profe;
        this.usr = profe;
    }
    public Formulario(Encargado enc){
        this.enc = enc;
        this.usr = enc;
    }
    
    public void abrirInterfaz(){
        String nombreUsr = usr.getNombre() + " " + usr.getApellido();
        switch (usr.getCargo()){
            case 'A':
                abrirAdminForm(nombreUsr);
                break;
            case 'P':
                abrirProfeForm(nombreUsr);
                break;
            case 'E':
                abrirEncargForm(nombreUsr);
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
        adminForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
        this.adminForm.getButtonActualizarUsuario().addActionListener(this);
        this.adminForm.getButtonBuscarUsuario().addActionListener(this);
        this.adminForm.getButtonEliminarUsuario().addActionListener(this);
        this.adminForm.getButtonListarUsuarios().addActionListener(this);
        this.adminForm.getButtonRegistrarUsuario().addActionListener(this);
    }
    
    private void abrirProfeForm(String nombreUsr){
        this.profeForm = new ProfeForm();
        this.profeForm.setTitle("Profe pongame 7");
        this.profeForm.setLocationRelativeTo(null);
        this.profeForm.setVisible(true);
        this.profeForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
        this.profeForm.getButtonActualizarSala().addActionListener(this);
        this.profeForm.getButtonConsultarEquipo().addActionListener(this);
        this.profeForm.getButtonConsultarEquipos().addActionListener(this);
        this.profeForm.getButtonConsultarSalas().addActionListener(this);
    }
    
    
    private void abrirEncargForm(String nombreUsr){
        encargForm = new EncargForm();
        encargForm.setTitle("Profe pongame 7");
        encargForm.setLocationRelativeTo(null);
        encargForm.setVisible(true);
        //encargForm.getLabelNombreUsuario().setText("Se ha conectado como " + nombreUsr);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (usr.getCargo()){
            case 'A':
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
                break;
            case 'P':
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
                break;
            case 'E':
                
            default:
        }
    }
}
