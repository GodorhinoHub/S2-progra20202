package Main;

import java.sql.*;
import Controlador.Controlador;
import Controlador.Formulario;
import Modelo.Conexion;
import Vista.InicioSesion;

public class main {
    public static Controlador control;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        InicioSesion form = new InicioSesion();
        Conexion conect = new Conexion("instituto","standart","1234standart"); //"instituto","standart","1234standart"
        
        control = new Controlador(conect);
        control.Iniciar(form);
    }
}
