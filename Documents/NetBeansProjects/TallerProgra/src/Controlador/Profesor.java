/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;

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
