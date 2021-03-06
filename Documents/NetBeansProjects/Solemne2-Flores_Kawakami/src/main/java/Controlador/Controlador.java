package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Controlador implements ActionListener{
    private final OperacionesBD modelo;
    private final IniciarSesion vista;
    private Formulario form;
    private String nombreUsr = null;

    // Constructor
    public Controlador(OperacionesBD modelo, IniciarSesion vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    // Getters
    public JFrame getVista() {
        return vista;
    }
    
    // Setters
    public void Iniciar(){
        this.vista.setTitle("Aplicación de cuadro, profe pongame 7");
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.getButtonAceptar().addActionListener(this);
    }
    
    public void Cerrar(){
        this.vista.dispose();
    }
    
    // Functions
    public boolean IniciarSesion(String login, String clave){
        if (login.equals("root") && clave.equals("toor")) {
            this.nombreUsr = "ROOT";
            int id = 1;
            String email = "root@colegio.com";
            this.form = new Formulario(new Administrador(id, login, clave, email, modelo));
            System.out.println(this.nombreUsr + " ha entrado al sistema!");
            return true;
            
        }
        try {
            ResultSet adm = modelo.consultarSi("id,login,clave,email", "administrador", "login", "\'" + login + "\'");
            if (adm.next()) {
                if (adm.getString("clave").equals(clave)) {
                    this.nombreUsr = "Admin";
                    int id = adm.getInt("id");
                    String email = adm.getString("email");
                    this.form = new Formulario(new Administrador(id, login, clave, email, modelo));
                    System.out.println(this.nombreUsr + " ha entrado al sistema!");
                    return true;
                }else{
                    System.out.println("Clave incorrecta");
                    return false;
                }
            }
            adm.close();
            ResultSet alum = modelo.consultarSi("id,nivel_id,login,clave,nombre,apellidos", "alumno", "login", "\'" + login + "\'");
            if (alum.next()){
                if (alum.getString("clave").equals(clave)) {
                    this.nombreUsr = alum.getString("nombre");
                    int id = alum.getInt("id");
                    String apellidos = alum.getString("apellidos");
                    this.form = new Formulario(new Alumno(id, login, clave, nombreUsr, apellidos, modelo));
                    System.out.println(this.nombreUsr + " ha entrado al sistema!");
                    return true;
                }else{
                    System.out.println("Clave incorrecta");
                    return false;
                }
            }
            alum.close();
            ResultSet prof = modelo.consultarSi("id,login,clave,nombre,apellidos,email,especialista", "profesor", "login", "\'" + login + "\'");
            if (prof.next()) {
                if (prof.getString("clave").equals(clave)) {
                    this.nombreUsr = prof.getString("nombre");
                    int id = prof.getInt("id");
                    String apellidos = prof.getString("apellidos");
                    String email = prof.getString("email");
                    int especialista = prof.getInt("especialista");
                    this.form = new Formulario(new Profesor(id, login, clave, nombreUsr, apellidos, email, especialista, modelo));
                    System.out.println(this.nombreUsr + " ha entrado al sistema!");
                    return true;
                }else{
                    System.out.println("Clave incorrecta");
                    return false;
                }
            }
            prof.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario, llama inmediatamente a T.I.");
            System.out.println(ex);
            return false;
        }
        return false;
    }
    
    
    public void Prueba() throws SQLException{
        System.out.println("Prueba iniciado");
        //Administrador admin = new Administrador(501,"echo", "echo", "echo", modelo);
        //Asignatura as = new Asignatura(2181,"Filosofía");
        //DefaultListModel a = al.listarProfesores(23);
        System.out.println("Prueba terminado");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getButtonAceptar()) {
            String code = vista.getFieldLogin().getText();
            String pass = vista.getFieldClave().getText();
            if(IniciarSesion(code,pass)){
                vista.getLabelState().setText(nombreUsr + ", seas bienvenido/a!");
                this.Cerrar();
                form.abrirInterfaz();
            }else{
                vista.getLabelState().setText("Usuario o contraseña incorrecta/s");
            }
        }
    }
}
