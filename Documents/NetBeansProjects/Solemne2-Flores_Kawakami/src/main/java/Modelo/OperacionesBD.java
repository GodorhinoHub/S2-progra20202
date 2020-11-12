package Modelo;

import java.sql.*;

public class OperacionesBD extends Conexion {
    private Statement stmt;

    public OperacionesBD(String schema, String user, String password) throws SQLException {
        setConexion(schema, user, password);
        stmt = getConexion().createStatement();
    }
    
    public ResultSet Consultar(String datos, String tabla){
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM " + tabla);
        } catch (SQLException ex){
            System.out.println("Error en la query");
            System.err.println(ex);
            return null;
        }
    }
    
    public ResultSet consultarSi(String datos, String tabla, String criterio, String condicion){
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM " + tabla +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException ex){
            System.out.println("Error en la query");
            System.err.println(ex);
            return null;
        }      
    }
    
    public int Insertar(String tabla, String valores){
        
        try {
            return stmt.executeUpdate("INSERT INTO " + tabla + " VALUES " + valores);
        } catch (SQLException ex) {
            System.out.println("Error en INSERT");
            System.err.println(ex);
            return 0;
        }
    }
    
    public int Actualizar(String tabla, String cambiar, String criterio, String condicion){
        try {
            return stmt.executeUpdate("UPDATE " + tabla +
                    " SET " + cambiar +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException ex) {
            System.out.println("Error en UPDATE");
            System.err.println(ex);
            return 0;
        }
    }
    
    public int Eliminar(String tabla, String criterio, String condicion){
        try {
            return stmt.executeUpdate("DELETE FROM " + tabla +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException ex) {
            System.out.println("Error en DELETE");
            System.err.println(ex);
            return 0;
        }
    }
}
