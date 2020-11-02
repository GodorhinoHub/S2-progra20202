package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;
import Modelo.Sala;
import Main.main;
import java.sql.*;
import java.util.logging.*;

public class Encargado extends Usuario{
    Controlador con = main.control;
    
    // Constructor
    public Encargado(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'E');
    }
    
    // Functions
    public boolean registrarEquipo(Equipo equipo){
        ResultSet exists = con.consultarSi("idEquipo", "Equipos", "idEquipo", Integer.toString(equipo.getIdEquipo()));
        try {
            if (exists.next()) {
                System.out.println("Equipo ya existe");
                return false;
            }else{
                con.Insertar("Equipos", equipo.toString());
                System.out.println("Equipo creado con éxito");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el equipo");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Equipo buscarEquipo(String idEquipo){
        String tipo;
        String marca;
        int ano;
        char estado;
        ResultSet equipo = con.consultarSi("idEquipo, tipo, marca, año, estado", "Equipos", "idEquipo", idEquipo);
        try {
            equipo.next();
            tipo = equipo.getString("tipo");
            marca = equipo.getString("marca");
            ano = equipo.getInt("año");
            estado = equipo.getString("estado").charAt(0);
            return new Equipo(Integer.parseInt(idEquipo),tipo,marca,ano,estado);
        } catch (SQLException ex) {
            System.out.println("Error al buscar equipo");
            Logger.getLogger(Encargado.class.getName()).log(Level.SEVERE, null, ex);
            return new Equipo(0,"null","null",0,'0');
        }
    }
    
    public String listarEquipos(){
        String lista = "";
        ResultSet listar = con.Consultar("idEquipo, tipo, marca, año, estado", "Equipos");
        try{
            while (listar.next()) {
		lista = lista + "\n " + new Equipo(listar.getInt("idEquipo"),
                        listar.getString("tipo"),
                        listar.getString("marca"),
                        listar.getInt("año"),
                        listar.getString("estado").charAt(0))
                        .toString();
            }
            return lista;
        } catch(SQLException ex){
            System.out.println("Error al buscar equipos");
            Logger.getLogger(Encargado.class.getName()).log(Level.SEVERE, null, ex);
            return "null";
        }
    }
    
    public boolean actualizarEquipo(Equipo equipo){
        int update;
        ResultSet exists = con.consultarSi("idEquipo", "Equipos", "idEquipo", Integer.toString(equipo.getIdEquipo()));
        try {
            if(exists.next()){
                update = con.Actualizar("Equipos",
                            "tipo = \'" + equipo.getTipo()+ '\'' +
                            ",marca = \'" + equipo.getMarca()+ '\'' +
                            ",año = \'" + equipo.getAno()+ '\'' +
                            ",estado = \'" + equipo.getEstado() + '\'',
                        "idEquipo", Integer.toString(equipo.getIdEquipo()));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Equipo no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el equipo");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminarEquipo(int idEquipo){
        int delet;
        ResultSet exists = con.consultarSi("idEquipo", "Equipos", "idEquipo", Integer.toString(idEquipo));
        try {
            exists.next();
            delet = con.Eliminar("Equipos", "idEquipo", Integer.toString(idEquipo));
            if(delet != 0){
                System.out.println("Borrado exitoso");
                return true;
            }else{
                System.out.println("No se pudo borrar");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el equipo");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean actualizarEstado(int idEquipo, char estado){
        int update;
        ResultSet exists = con.consultarSi("idEquipo", "Equipos", "idEquipo", Integer.toString(idEquipo));
        try {
            if(exists.next()){
                update = con.Actualizar("Equipos",
                            "estado = \'" + estado + '\'',
                        "idEquipo", Integer.toString(idEquipo));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Equipo no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el equipo");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
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
            Logger.getLogger(Encargado.class.getName()).log(Level.SEVERE, null, ex);
            return "null";
        }
    }
    
    public String listarSalas(){
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
            Logger.getLogger(Encargado.class.getName()).log(Level.SEVERE, null, ex);
            return "null";
        }
    }
    
    public boolean actualizarSala(int idSala, char estado){
        int update;
        ResultSet exists = con.consultarSi("idSala", "Salas", "idSala", Integer.toString(idSala));
        try {
            if(exists.next()){
                update = con.Actualizar("Salas",
                            "estado = \'" + estado + '\'',
                        "idSala", Integer.toString(idSala));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Sala no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe la sala");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
