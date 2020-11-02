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
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el usuario");
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        con.Insertar("Usuarios", usuario.toString());
        System.out.println("Usuario creado con éxito");
        return true;
    }
    
    public Usuario buscarUsuario(String rut){
        String apellido;
        String nombre;
        String correo;
        char cargo;
        try {
            ResultSet usuario = con.consultarSi("apellido, nombre, correo, cargo", "Usuarios", "rut", '\'' + rut + '\'');
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
        try {
            ResultSet listar = con.Consultar("apellido, nombre, correo, rut, cargo", "Usuarios");
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
    
    public void eliminarUsuario(String rut){
        
    }
    
    public void actualizarUsuario(Usuario usuario){
        
    }
}
