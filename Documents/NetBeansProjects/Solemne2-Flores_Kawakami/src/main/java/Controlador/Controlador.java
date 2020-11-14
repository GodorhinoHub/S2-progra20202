package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Controlador implements ActionListener{
    private final OperacionesBD modelo;
    private final JFrame vista;

    public Controlador(OperacionesBD modelo, JFrame vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void Iniciar(){
        this.vista.setTitle("Aplicación de cuadro, profe pongame 7");
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
    
    public void Cerrar() throws SQLException{
        this.vista.dispose();
    }
    
    public void Prueba() throws SQLException{
        System.out.println("Prueba iniciado");
        Alumno al = new Alumno("cmirandao", "1234", "Carmen", "Miranda Olivares");
        //Profesor pr = new Profesor(402, "echo", "echo", "echo", "echo","echo",5,modelo);
        Administrador admin = new Administrador(501,"echo", "echo", "echo", modelo);
        boolean a = admin.matricularAlumno(al, 101);
        //String a = pr.listarAlumnos(pr.getId()).toString();
        //String a = pr.listarProfesores().toString();
        System.out.println(a);
        System.out.println("Prueba terminado");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
