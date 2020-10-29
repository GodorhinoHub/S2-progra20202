import java.sql.*;
import Controlador.Controlador;
import Modelo.Conexion;
import Vista.Vista;

public class main {
      
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Vista forma = new Vista();
        Conexion conect = new Conexion("test","standart","1234standart");
        
        
        Controlador control = new Controlador(conect, forma);
        control.Iniciar();
    }
}
