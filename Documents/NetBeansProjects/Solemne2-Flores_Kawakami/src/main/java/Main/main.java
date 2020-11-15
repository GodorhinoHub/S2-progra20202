package Main;

import Controlador.*;
import Modelo.*;
import Vista.*;
import java.sql.*;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        OperacionesBD bd = new OperacionesBD("localhost:3306/colegio","standart","1234standart");
        IniciarSesion initSes = new IniciarSesion();
        
        Controlador ctrl = new Controlador(bd, initSes);
        
        ctrl.Iniciar();
        ctrl.Prueba();
    }
}