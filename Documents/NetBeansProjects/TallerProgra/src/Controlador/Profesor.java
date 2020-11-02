package Controlador;

import Modelo.Usuario;
//import Modelo.Equipo;
import Modelo.Sala;
import Main.main;
import java.sql.*;

public class Profesor extends Usuario{
    Controlador con = main.control;
    
    // Constructor
    public Profesor(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'P');
    }
    
    // Functions
    public String consultarEstados(){
        try{
            String lista = "";
            ResultSet listar = con.Consultar("idEquipo, estado", "Equipos");        
            while (listar.next()) {
		lista = lista + "\n ID " + 
                        listar.getString("idEquipo") + " = " + listar.getString("estado").charAt(0);
            }
            return lista;
        } catch(SQLException e){
            System.out.println("Error al buscar equipo");
            return "null";
        }
    }
    
    public String consultarEquipo(String idEquipo){
        try {
            ResultSet equipo = con.consultarSi("estado", "Equipos", "idEquipo", idEquipo);
            equipo.next();
            return "Estado del equipo "+ idEquipo + " = " + equipo.getString("estado").charAt(0);
        } catch(SQLException e){
            System.out.println("Error al buscar equipo");
            return "error";
        }
    }
    
    public void consultarSalas(){
        
    }
}
