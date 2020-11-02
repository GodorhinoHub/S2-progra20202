package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;

public class Controlador implements ActionListener{
    private final InicioSesion form;
    private final Connection conect;
    private Statement stmt;
    
    private static Controlador instance = null;
    
    public Controlador(Conexion conex, InicioSesion form) throws ClassNotFoundException, SQLException {
        this.form = form;
        this.conect = conex.getConection();
    }
    
    public void Iniciar() throws ClassNotFoundException, SQLException{
        
        this.form.setTitle("Profe pongame 7");
        this.form.setLocationRelativeTo(null);
        this.form.setVisible(true);
        stmt = this.conect.createStatement();
        
        
        Prueba();        
    }
    
    public ResultSet Consultar(String datos, String tabla) throws SQLException{
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM " + tabla);
        } catch (SQLException e){
            System.out.println("Error en la query");
            return null;
        }
    }
    
    public ResultSet consultarSi(String datos, String criterio, String condicion) throws SQLException{
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM Equipos WHERE " + criterio + " = " + condicion);
        } catch (SQLException e){
            System.out.println("Error en la query");
            return null;
        }      
    }
    
    
    private void Prueba() throws SQLException{
        Encargado enc = new Encargado("Alvarez", "Cristián", "calv@institucion.cl", "21643-4", "1234");
        Profesor prof = new Profesor("Alvarez", "Cristián", "calv@institucion.cl", "21643-4", "1234");
        Administrador admin = new Administrador("Alvarez", "Cristián", "calv@institucion.cl", "21643-4", "1234");
        
        //Equipo e = en.buscarEquipo("103");
        String e = enc.listarEquipos();
        System.out.println(e);
        
        /*
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
        */
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
