package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;

public class Encargado extends Usuario{
    
    public Encargado(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'E');
    }
    
    // Functions
    public void registrarEquipo(Equipo equipo){
        
    }
    
    public void buscarEquipo(int idEquipo){
        
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
