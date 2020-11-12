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
    
    public void Prueba() throws SQLException{
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
