package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;
import Modelo.Sala;
import Main.main;
import java.sql.*;

public class Encargado extends Usuario{
    Controlador con = main.control;
    
    // Constructor
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
            ResultSet equipo = con.consultarSi("idEquipo, tipo, marca, año, estado", "Equipos", "idEquipo", idEquipo);
            equipo.next();
            tipo = equipo.getString("tipo");
            marca = equipo.getString("marca");
            ano = equipo.getInt("año");
            estado = equipo.getString("estado").charAt(0);
            return new Equipo(Integer.parseInt(idEquipo),tipo,marca,ano,estado);
        } catch(SQLException e){
            System.out.println("Error al buscar equipo");
            return new Equipo(0,"null","null",0,'0');
        }
    }
    
    public String listarEquipos(){
        try{
            String lista = "";
            ResultSet listar = con.Consultar("idEquipo, tipo, marca, año, estado", "Equipos");
            while (listar.next()) {
		lista = lista + "\n " + new Equipo(listar.getInt("idEquipo"),
                        listar.getString("tipo"),
                        listar.getString("marca"),
                        listar.getInt("año"),
                        listar.getString("estado").charAt(0))
                        .toString();
            }
            return lista;
        } catch(SQLException e){
            System.out.println("Error al buscar equipo");
            return "null";
        }
    }
    
    public void actualizarEquipo(Equipo Equipo){
        
    }
    
    public void eliminarEquipo(int idEquipo){
        
    }
    
    public void actualizarEstado(int idEquipo){
        
    }
    
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
    
    public void consultarSalas(){
        
    }
    
    public void actualizarSala(){
        
    }
}
