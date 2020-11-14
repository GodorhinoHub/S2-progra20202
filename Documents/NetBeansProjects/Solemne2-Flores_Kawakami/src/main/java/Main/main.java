package Main;

import Controlador.*;
import Modelo.*;
import Vista.*;
import java.sql.*;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        OperacionesBD bd = new OperacionesBD("colegio","standart","1234standart");
        IniciarSesion initSes = new IniciarSesion();
        
        Controlador ctrl = new Controlador(bd, initSes);
        
        ctrl.Iniciar();
        ctrl.Prueba();

        
        /*
	ResultSet rs = bd.Consultar("login", "Administrador");
	while (rs.next()) {
		String name = rs.getString("login");
		System.out.println(name);
	}
        rs.close();
        
        ctrl.Prueba();
        
        bd.Cerrar();
        */
    }
}