package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Controlador implements ActionListener{
    private final InicioSesion form;
    private final Connection conect;
    private Statement stmt;
    
    // Constructor
    public Controlador(Conexion conex, InicioSesion form) throws ClassNotFoundException, SQLException {
        this.form = form;
        this.conect = conex.getConection();
    }
    
    // Functions
    public void Iniciar() throws ClassNotFoundException, SQLException{
        
        this.form.setTitle("Profe pongame 7");
        this.form.setLocationRelativeTo(null);
        this.form.setVisible(true);
        stmt = this.conect.createStatement();
        
        Prueba();        
    }
    
    public ResultSet Consultar(String datos, String tabla){
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM " + tabla);
        } catch (SQLException e){
            System.out.println("Error en la query");
            return null;
        }
    }
    
    public ResultSet consultarSi(String datos, String tabla, String criterio, String condicion){
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM " + tabla +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException e){
            System.out.println("Error en la query");
            return null;
        }      
    }
    
    public int Insertar(String tabla, String valores){
        try {
            return stmt.executeUpdate("INSERT INTO " + tabla + " VALUES (" + valores + ')');
        } catch (SQLException e) {
            System.out.println("Error en INSERT");
            return 0;
        }
    }
    
    public int Actualizar(String tabla, String cambiar, String criterio, String condicion){
        try {
            return stmt.executeUpdate("UPDATE " + tabla +
                    " SET " + cambiar +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException e) {
            System.out.println("Error en UPDATE");
            return 0;
        }
    }
    
    public int Eliminar(String tabla, String criterio, String condicion){
        try {
            return stmt.executeUpdate("DELETE FROM " + tabla +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException e) {
            System.out.println("Error en INSERT");
            return 0;
        }
    }
    
    private void Prueba() throws SQLException{
        Encargado enc = new Encargado("Alvarez", "Cristián", "calv@institucion.cl", "21643-4", "1234");
        Profesor prof = new Profesor("Alvarez", "Cristián", "calv@institucion.cl", "21643-4", "1234");
        Administrador admin = new Administrador("Alvarez", "Cristián", "calv@institucion.cl", "21643-4", "1234");
        
        //Equipo e = enc.buscarEquipo("103");
        //Usuario e = admin.buscarUsuario("15946-4");
        
        //int e = Insertar("Equipos","113, 'Computador', 'HP', 2009, 'o'");
        //int e = Actualizar("Equipos","estado = \'n\'","idEquipo","107");
        //int e = Eliminar("Salas","idSala","504");
        
        //System.out.println(e);
        
        /*
        form.getjLabel2().setText(algo);
        */
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
