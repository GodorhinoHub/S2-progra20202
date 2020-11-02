package Main;

import java.sql.*;
import Controlador.Controlador;
import Modelo.Conexion;
import Vista.InicioSesion;

public class main {
    public static Controlador control;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        InicioSesion forma = new InicioSesion();
        Conexion conect = new Conexion("instituto","standart","1234standart"); //"instituto","standart","1234standart"
        
        
        control = new Controlador(conect, forma);
        control.Iniciar();
    }
}
