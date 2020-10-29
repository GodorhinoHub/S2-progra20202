package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String schema; // "test"
    private String user; // "standart"
    private String password; // "1234standart"
    private String url;
    private Connection con = null;

    public Conexion(String schema, String user, String password) {
        this.schema = schema;
        this.user = user;
        this.password = password;
    }
    
    public Connection getConection() throws ClassNotFoundException, SQLException{
        this.url = "jdbc:mysql://localhost:3306/" + schema;
        try {
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException ex) {
            System.out.println("Error en la BD");
        }

        return con;
    }
}
