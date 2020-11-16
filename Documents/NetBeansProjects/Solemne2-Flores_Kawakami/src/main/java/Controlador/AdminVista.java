package Controlador;

import Modelo.*;
import java.awt.event.*;
import Vista.*;
import Vista.AdminVistas.*;

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
    
    // Functions
    public void actionUsuario(ActionEvent ae){
        
        
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