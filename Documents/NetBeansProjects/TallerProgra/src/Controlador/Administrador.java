package Controlador;

import Modelo.Usuario;
//import Modelo.Equipo;
//import Modelo.Sala;
import Main.main;
import java.sql.*;
import java.util.logging.*;

public class Administrador extends Usuario {
    Controlador con = main.control;
    
    public Administrador(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'A');
    }
    
    // Funtion
    public boolean registrarUsuario(Usuario usuario){
        ResultSet exists = con.consultarSi("apellido", "Usuarios", "rut", '\'' + usuario.getRut() + '\'');
        try {
            if (exists.next()) {
                System.out.println("Usuario ya existe");
                return false;
            }else{
                con.Insertar("Usuarios", usuario.toString());
                System.out.println("Usuario creado con éxito");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el usuario");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Usuario buscarUsuario(String rut){
        String apellido;
        String nombre;
        String correo;
        char cargo;
        ResultSet usuario = con.consultarSi("apellido, nombre, correo, cargo", "Usuarios", "rut", '\'' + rut + '\'');
        try {
            usuario.next();
            apellido = usuario.getString("apellido");
            nombre = usuario.getString("nombre");
            correo = usuario.getString("correo");
            cargo = usuario.getString("cargo").charAt(0);
            return new Usuario(apellido, nombre, correo, rut, "clave secreta", cargo);
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return new Usuario("null", "null", "null", "null", "null", '0');
        }
    }
    
    public String listarUsuarios(){
        String lista = "";
        ResultSet listar = con.Consultar("apellido, nombre, correo, rut, cargo", "Usuarios");
        try {
            while (listar.next()) {
                lista = lista + "\n " + new Usuario(listar.getString("apellido"),
                        listar.getString("nombre"),
                        listar.getString("correo"),
                        listar.getString("rut"),
                        "clave secreta",
                        listar.getString("cargo").charAt(0))
                        .toString();
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return "null";
        }
    }
    
    public boolean eliminarUsuario(String rut){
        int delet;
        ResultSet exists = con.consultarSi("rut", "Usuarios", "rut", '\'' + rut + '\'');
        try {
            exists.next();
            delet = con.Eliminar("Usuarios", "rut", '\'' + rut + '\'');
            if(delet != 0){
                System.out.println("Borrado exitoso");
                return true;
            }else{
                System.out.println("No se pudo borrar");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el usuario");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void actualizarUsuario(Usuario usuario){
        
    }
}
