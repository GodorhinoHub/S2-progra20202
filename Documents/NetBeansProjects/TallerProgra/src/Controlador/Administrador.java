package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;

public class Administrador extends Usuario {
    Controlador con;
    
    public Administrador(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'A');
    }
    
    // Funtion
    public void registrarUsuario(Usuario usuario){
        
    }
    
    public void buscarUsuario(int rut){
        
    }
    
    public void listarUsuarios(){
        
    }
    
    public void eliminarUsuario(String rut){
        
    }
    
    public void actualizarUsuario(Usuario usuario){
        
    }
}
