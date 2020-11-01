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
    
    public ResultSet Consultar(String datos) throws SQLException{
	return stmt.executeQuery("SELECT " + datos + " FROM Equipos");
    }
    
    public ResultSet consultarSi(String datos, String criterio, String condicion) throws SQLException{
	return stmt.executeQuery("SELECT " + datos + " FROM Equipos WHERE " + criterio + " = " + condicion);        
    }
    
    
    private void Prueba() throws SQLException{
        String algo = "";
        ResultSet listar = Consultar("idEquipo, tipo, marca, año");
        //ResultSet estado = Consultar("estado");
        //ResultSet buscar = consultarSi("tipo","idEquipo","103");
        
        while (listar.next()) {
		//float price = rs.getFloat("precio");
		algo = algo + "\n " + listar.getString("idEquipo");
	}
        
        ResultSet buscar = consultarSi("tipo","idEquipo","103");
        buscar.next();
        algo = algo + " " + buscar.getString("tipo");
        form.getjLabel2().setText(algo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
