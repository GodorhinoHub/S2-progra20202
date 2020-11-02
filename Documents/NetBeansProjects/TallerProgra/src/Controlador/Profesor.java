package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;

public class Profesor extends Usuario{
    
    public Profesor(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'P');
    }
    
    // Functions
    public void consultarEstados(){
        
    }
    
    public void consultarEquipo(int idEquipo){
        
    }
}
