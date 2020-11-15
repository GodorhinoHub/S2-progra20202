package Modelo;

import java.sql.*;

public class Conexion {
    private String schema; // "test"
    private String user; // "standart"
    private String password; // "1234standart"
    private String url;
    private Connection con = null;
    protected Statement stmt = null;


    public void setConexion(String schema, String user, String password) {
        this.schema = schema;
        this.user = user;
        this.password = password;
    }
    
    public Connection getConexion(){
        this.url = "jdbc:mysql://" + schema;
        try {
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException ex) {
            System.out.println("Error en la conexión a la BBDD");
            System.out.println(ex);
        }
        return con;
    }
    
    public void Cerrar(){
        try {
            stmt.close();
            getConexion().close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BD");
            System.out.println(ex);
        }
    }
}
