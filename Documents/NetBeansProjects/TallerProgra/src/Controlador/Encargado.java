package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;
import java.sql.*;
import Main.main;

public class Encargado extends Usuario{
    Controlador con = main.control;
    
    public Encargado(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'E');
    }
    
    // Functions
    public void registrarEquipo(Equipo equipo){
        
    }
    
    public Equipo buscarEquipo(String idEquipo){
        String tipo;
        String marca;
        int ano;
        char estado;
        try {
            ResultSet equipo = con.consultarSi("idEquipo, tipo, marca, año, estado", "idEquipo", idEquipo);
            equipo.next();
            tipo = equipo.getString("tipo");
            marca = equipo.getString("tipo");
            ano = equipo.getInt("año");
            estado = equipo.getString("estado").charAt(0);
            return new Equipo(Integer.parseInt(idEquipo),tipo,marca,ano,estado);
        } catch(SQLException e){
            System.out.println("Error al buscar equipo");
            return null;
        }
    }
    
    public void listarEquipos(){
        
    }
    
    public void actualizarEquipo(Equipo Equipo){
        
    }
    
    public void eliminarEquipo(int idEquipo){
        
    }
    
    public void actualizarEstado(int idEquipo){
        
    }
    
    public void consultarEstados(){
        
    }
}
