package Controlador;

import Modelo.*;
import java.awt.event.*;
import Vista.*;
import Vista.AdminVistas.*;
import javax.swing.*;

public class AdminVista implements ActionListener{
    private AltaUsuario aUsuario;
    private AltaAsignatura aAsignatura;
    private MatricularAlumno mAlumno;
    private Formulario form;
    private Administrador admin;
    private String tarea;

    // Constructor
    public AdminVista(Administrador admin) {
        this.admin = admin;
    }
    
    // Open Functions
    public void abrirUsuario(){
        tarea = "aUsuario";
        aUsuario = new AltaUsuario();
        aUsuario.setTitle("Formulario de administrador/AltaUsuario");
        aUsuario.setLocationRelativeTo(null);
        aUsuario.setVisible(true);
        aUsuario.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        aUsuario.getLabelEstado().setText("Preparado");
        
        
        aUsuario.getRadioAdmin().addActionListener(this);
        aUsuario.getRadioAlumn().addActionListener(this);
        aUsuario.getRadioProfe().addActionListener(this);
        
        aUsuario.getButtonAlta().addActionListener(this);
        aUsuario.getButtonBuscar().addActionListener(this);
        aUsuario.getButtonBaja().addActionListener(this);
        aUsuario.getButtonModificar().addActionListener(this);
        aUsuario.getButtonReturn().addActionListener(this);
    }
    
    public void abrirAsignatura(){
        tarea = "aAsignatura";
        aAsignatura = new AltaAsignatura();
        aAsignatura.setTitle("Formulario de administrador/AltaAsignatura");
        aAsignatura.setLocationRelativeTo(null);
        aAsignatura.setVisible(true);
        aAsignatura.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        aAsignatura.getLabelEstado().setText("Preparado");
        
        aAsignatura.getButtonAlta().addActionListener(this);
        aAsignatura.getButtonBuscar().addActionListener(this);
        aAsignatura.getButtonBaja().addActionListener(this);
        aAsignatura.getButtonModificar().addActionListener(this);
        aAsignatura.getButtonReturn().addActionListener(this);
    }
    
    public void abrirMatricular(){
        tarea = "mAlumno";
        mAlumno = new MatricularAlumno();
        mAlumno.setTitle("Formulario de administrador/MatricularAlumno");
        mAlumno.setLocationRelativeTo(null);
        mAlumno.setVisible(true);
        mAlumno.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        mAlumno.getLabelEstado().setText("Preparado");
        
        mAlumno.getButtonMatricular().addActionListener(this);
        mAlumno.getButtonReturn().addActionListener(this);
    }
    
    // Listener Functions
    public void actionUsuario(ActionEvent ae){
        if (ae.getSource() == aUsuario.getButtonAlta()) {
            aUsuario();
        }
        if (ae.getSource() == aUsuario.getButtonBuscar()) {
            buUsuario();
        }
        if (ae.getSource() == aUsuario.getButtonBaja()) {
            bUsuario();
        }
        if (ae.getSource() == aUsuario.getButtonModificar()) {
            mUsuario();
        }
        
        if (ae.getSource() == aUsuario.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.aUsuario.dispose();
        }
    }
    
    public void actionAsignatura(ActionEvent ae){
        
        
        
        if (ae.getSource() == aAsignatura.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.aAsignatura.dispose();
        }
    }
    
    public void actionMalumno(ActionEvent ae){
        
        
        if (ae.getSource() == mAlumno.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.mAlumno.dispose();
        }
    }
    
    // Operation Functions
    public void aUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String email = aUsuario.getFieldEmail().getText();
            if (admin.altaUsuario(new Administrador(login,clave,email))) {
                System.out.println("Admin agregado");
            }
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String nivel = aUsuario.getFieldNivel().getText();
            if (admin.altaUsuario(new Alumno(login,clave,nombre,apellidos),nivel)) {
                System.out.println("Alumno agregado");
            }
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String email = aUsuario.getFieldEmail().getText();
            int especialista = Integer.parseInt(aUsuario.getFieldEspecialista().getText());
            if (admin.altaUsuario(new Profesor(login, clave, nombre, apellidos, email, especialista))) {
                System.out.println("Profesor agregado");
            }
        }
        
        
    }
    public void buUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Administrador buscado = admin.buscarAdmin(login);
            
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            aUsuario.getFieldNombre().setText("");
            aUsuario.getFieldApellidos().setText("");
            aUsuario.getFieldNivel().setText("");
            aUsuario.getFieldEspecialista().setText("");
            
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Alumno buscado = admin.buscarAlumn(login);
            
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldNivel().setText(buscado.getNivel());
            aUsuario.getFieldEmail().setText("");
            aUsuario.getFieldEspecialista().setText("");
            
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Profesor buscado = admin.buscarProfe(login);
            
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            aUsuario.getFieldEspecialista().setText(Integer.toString(buscado.getEspecialista()));
            aUsuario.getFieldNivel().setText("");
            
        }
        
        
        
    }
    public void bUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Administrador buscado = admin.buscarAdmin(login);
            
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                admin.bajaUsuario(buscado.getId(), "administrador");
            }
            
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Alumno buscado = admin.buscarAlumn(login);
            
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldNivel().setText(buscado.getNivel());
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                admin.bajaUsuario(buscado.getId(), "alumno");
            }
            
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Profesor buscado = admin.buscarProfe(login);
            
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            aUsuario.getFieldEspecialista().setText(Integer.toString(buscado.getEspecialista()));
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                admin.bajaUsuario(buscado.getId(), "profesor");
            }
            
        }
        
        
        
    }
    public void mUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            int id = Integer.parseInt(aUsuario.getFieldId().getText());
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String email = aUsuario.getFieldEmail().getText();
            if (admin.modificarUsuario(new Administrador(id,login,clave,email,admin.getCon()))) {
                System.out.println("Admin agregado");
            }
            
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            int id = Integer.parseInt(aUsuario.getFieldId().getText());
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String nivel = aUsuario.getFieldNivel().getText();
            if (admin.modificarUsuario(new Alumno(id,login,clave,nombre,apellidos,admin.getCon()),nivel)) {
                System.out.println("Alumno agregado");
            }
            
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            int id = Integer.parseInt(aUsuario.getFieldId().getText());
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String email = aUsuario.getFieldEmail().getText();
            int especialista = Integer.parseInt(aUsuario.getFieldEspecialista().getText());
            if (admin.modificarUsuario(new Profesor(id,login, clave, nombre, apellidos, email, especialista,admin.getCon()))) {
                System.out.println("Profesor agregado");
            }
            
        }
        
        
        
    }
    
    public void aAsignatura(){
        
    }
    public void bAsignatura(){
        
    }
    public void mAsignatura(){
        
    }
    
    public void mAlumno(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (tarea){
                case "aUsuario":
                    this.actionUsuario(ae);
                    break;
                case "aAsignatura":
                    this.actionAsignatura(ae);
                    break;
                case "mAlumno":
                    this.actionMalumno(ae);
                    break;
                default:
                    System.out.println("Graves problemas");
                    break;
        }
    }
}