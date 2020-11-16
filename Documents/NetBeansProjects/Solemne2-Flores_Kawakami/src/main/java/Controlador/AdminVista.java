package Controlador;

import Modelo.*;
import java.awt.event.*;
import Vista.*;
import Vista.AdminVistas.*;

public class AdminVista implements ActionListener{
    private AltaUsuario aUsuario;
    private AltaAsignatura aAsignatura;
    private BajaUsuario bUsuario;
    private BajaAsignatura bAsignatura;
    private ModificarUsuario mUsuario;
    private ModificarAsignatura mAsignatura;
    private MatricularAlumno mAlumno;
    private Formulario form;
    private Administrador admin;
    private String tarea;

    // Constructor
    public AdminVista(Administrador admin) {
        this.admin = admin;
    }
    
    // Open Functions
    public void abrirAltaUsuario(){
        tarea = "aUsuario";
        aUsuario = new AltaUsuario();
        aUsuario.setTitle("Formulario de administrador/AltaUsuario");
        aUsuario.setLocationRelativeTo(null);
        aUsuario.setVisible(true);
        aUsuario.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        
        aUsuario.getButtonReturn().addActionListener(this);
    }
    
    public void abrirAltaAsignatura(){
        tarea = "aAsignatura";
        aAsignatura = new AltaAsignatura();
        aAsignatura.setTitle("Formulario de administrador/AltaAsignatura");
        aAsignatura.setLocationRelativeTo(null);
        aAsignatura.setVisible(true);
        aAsignatura.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        
        aAsignatura.getButtonReturn().addActionListener(this);
    }
    
    public void abrirBajaUsuario(){
        tarea = "bUsuario";
        bUsuario = new BajaUsuario();
        bUsuario.setTitle("Formulario de administrador/BajaUsuario");
        bUsuario.setLocationRelativeTo(null);
        bUsuario.setVisible(true);
        bUsuario.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        
        bUsuario.getButtonReturn().addActionListener(this);
    }
    
    public void abrirBajaAsignatura(){
        tarea = "bAsignatura";
        bAsignatura = new BajaAsignatura();
        bAsignatura.setTitle("Formulario de administrador/BajaAsignatura");
        bAsignatura.setLocationRelativeTo(null);
        bAsignatura.setVisible(true);
        bAsignatura.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        
        bAsignatura.getButtonReturn().addActionListener(this);
    }
    
    public void abrirModificarUsuario(){
        tarea = "mUsuario";
        mUsuario = new ModificarUsuario();
        mUsuario.setTitle("Formulario de administrador/ModificarUsuario");
        mUsuario.setLocationRelativeTo(null);
        mUsuario.setVisible(true);
        mUsuario.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        
        mUsuario.getButtonReturn().addActionListener(this);
    }
    
    public void abrirModificarAsignatura(){
        tarea = "mAsignatura";
        mAsignatura = new ModificarAsignatura();
        mAsignatura.setTitle("Formulario de administrador/ModificarAsignatura");
        mAsignatura.setLocationRelativeTo(null);
        mAsignatura.setVisible(true);
        mAsignatura.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        
        mAsignatura.getButtonReturn().addActionListener(this);
    }
    
    public void abrirMatricularAlumno(){
        tarea = "mAlumno";
        mAlumno = new MatricularAlumno();
        mAlumno.setTitle("Formulario de administrador/MatricularAlumno");
        mAlumno.setLocationRelativeTo(null);
        mAlumno.setVisible(true);
        mAlumno.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        
        mAlumno.getButtonReturn().addActionListener(this);
    }
    
    // Functions
    public void actionAusuario(ActionEvent ae){
        
        
        if (ae.getSource() == aUsuario.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.aUsuario.dispose();
        }
    }
    
    public void actionAasignatura(ActionEvent ae){
        
        
        
        if (ae.getSource() == aAsignatura.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.aAsignatura.dispose();
        }
    }
    
    public void actionBusuario(ActionEvent ae){
        
        
        if (ae.getSource() == bUsuario.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.bUsuario.dispose();
        }
    }
    
    public void actionBasignatura(ActionEvent ae){
        
        
        if (ae.getSource() == bAsignatura.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.bAsignatura.dispose();
        }
    }
    
    public void actionMusuario(ActionEvent ae){
        
        
        if (ae.getSource() == mUsuario.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.mUsuario.dispose();
        }
    }
    
    public void actionMasignatura(ActionEvent ae){
        
        
        if (ae.getSource() == mAsignatura.getButtonReturn()) {
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.mAsignatura.dispose();
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
                    this.actionAusuario(ae);
                    break;
                case "aAsignatura":
                    this.actionAasignatura(ae);
                    break;
                case "bUsuario":
                    this.actionBusuario(ae);
                    break;
                case "bAsignatura":
                    this.actionBasignatura(ae);
                    break;
                case "mUsuario":
                    this.actionMusuario(ae);
                    break;
                case "mAsignatura":
                    this.actionMasignatura(ae);
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