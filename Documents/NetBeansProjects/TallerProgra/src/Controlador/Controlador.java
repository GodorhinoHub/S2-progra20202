package Controlador;

import java.awt.*;
import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;

public class Controlador implements ActionListener{
    private final Vista form;
    private final Connection conect;
    private Statement stmt;

    public Controlador(Conexion conex, Vista form) throws ClassNotFoundException, SQLException {
        this.form = form;
        this.conect = conex.getConection();
    }
    
    public void Iniciar() throws ClassNotFoundException, SQLException{
        this.form.setTitle("Aplicación de cuadro, profe pongame 7");
        this.form.setLocationRelativeTo(null);
        this.form.setVisible(true);
        stmt = this.conect.createStatement();
        
        Prueba();        
    }
    
    public ResultSet crearQuery(String query) throws SQLException{
	return stmt.executeQuery(query);
    }
    
    private void Prueba() throws SQLException{
        String algo = "";
        ResultSet rs = crearQuery("SELECT nombre FROM autores");
        
        while (rs.next()) {
		String name = rs.getString("nombre");
		//float price = rs.getFloat("precio");
		algo = algo + "\n " + name;
	}
        
        form.getjLabel2().setText(algo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
