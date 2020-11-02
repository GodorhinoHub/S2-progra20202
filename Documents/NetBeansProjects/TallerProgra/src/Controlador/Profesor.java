package Controlador;

import Modelo.Usuario;
import Modelo.Equipo;
import java.sql.SQLException;

public class Profesor extends Usuario{
    Controlador con;
    
    public Profesor(String apellido, String nombre, String correo, String rut, String clave) {
        super(apellido, nombre, correo, rut, clave, 'P');
    }
    
    // Functions
    public void consultarEstados(){
        
    }
    
    public void consultarEquipo(int idEquipo){
        
    }
}
