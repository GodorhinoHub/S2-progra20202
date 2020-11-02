package Controlador;

import Modelo.Usuario;
//import Modelo.Equipo;
import Modelo.Sala;
import Main.main;
import java.sql.*;
import java.util.logging.*;

public class Profesor extends Usuario{
    Controlador con = main.control;
    
    // Constructor
    public Profesor(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'P');
    }
    
    // Functions
    public String consultarEstados(){
        String lista = "";
        ResultSet listar = con.Consultar("idEquipo, estado", "Equipos"); 
        try{       
            while (listar.next()) {
		lista = lista + "\n ID " + 
                        listar.getString("idEquipo") + " = " + listar.getString("estado").charAt(0);
            }
            return lista;
        } catch(SQLException ex){
            System.out.println("Error al buscar equipo");
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
            return "null";
        }
    }
    
    public String consultarEquipo(String idEquipo){
        ResultSet equipo = con.consultarSi("estado", "Equipos", "idEquipo", idEquipo);
        try {
            equipo.next();
            return "Estado del equipo "+ idEquipo + " = " + equipo.getString("estado").charAt(0);
        } catch(SQLException ex){
            System.out.println("Error al buscar equipo");
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
    }
    
    public String consultarSalas(){
        String lista = "";
        ResultSet listar = con.Consultar("idSala, estado", "Salas");
        try{
            while (listar.next()) {
		lista = lista + "\n " + new Sala(listar.getInt("idSala"),
                        listar.getString("estado").charAt(0))
                        .toString();
            }
            return lista;
        } catch(SQLException ex){
            System.out.println("Error al buscar salas");
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
            return "null";
        }
    }
}
