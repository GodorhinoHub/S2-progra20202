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
        //Alumno al = new Alumno("rayalab", "1234", "Roberto", "Ayala Berrios");
        //Profesor pr = new Profesor("128795", "1234", "Daniela", "Rocha","droc@colegio.com",5,modelo);
        //Administrador adn = new Administrador("09456-5", "1234", "ufav@colegio.com", modelo);
        //Asignatura as = new Asignatura(2181,"Filosofía");
        Administrador admin = new Administrador(501,"echo", "echo", "echo", modelo);
        
        //boolean a = admin;
        //System.out.println(a);
        System.out.println("Prueba terminado");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
