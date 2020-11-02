package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;
import Main.main;
import java.sql.*;

public class Administrador extends Usuario {
    Controlador con = main.control;
    
    public Administrador(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'A');
    }
    
    // Funtion
    public void registrarUsuario(Usuario usuario){
        
    }
    
    public Usuario buscarUsuario(String rut){
        String apellido;
        String nombre;
        String correo;
        char cargo;
        try {
            ResultSet equipo = con.consultarSi("apellido, nombre, correo, cargo", "idEquipo", rut);
            equipo.next();
            apellido = equipo.getString("apellido");
            nombre = equipo.getString("nombre");
            correo = equipo.getString("correo");
            cargo = equipo.getString("cargo").charAt(0);
            return new Usuario(apellido, nombre, correo, rut, "clave secreta", cargo);
        } catch(SQLException e){
            System.out.println("Error al buscar equipo");
            return new Usuario("null", "null", "null", "null", "null", '0');
        }
    }
    
    public String listarUsuarios(){
        try{
            String lista = "";
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
        } catch(SQLException e){
            System.out.println("Error al buscar usuario");
            return "null";
        }
    }
    
    public void eliminarUsuario(String rut){
        
    }
    
    public void actualizarUsuario(Usuario usuario){
        
    }
}
