package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Controlador implements ActionListener{
    private final InicioSesion form;
    private final Connection conect;
    private Administrador adm;
    private Profesor profe;
    private Encargado enc;
    private String sesion;
    private Statement stmt;
    
    // Constructor
    public Controlador(Conexion conex, InicioSesion form) throws ClassNotFoundException, SQLException {
        this.form = form;
        this.conect = conex.getConection();
    }
    
    // Functions
    public void Iniciar() throws ClassNotFoundException, SQLException{
        this.form.setTitle("Profe pongame 7");
        this.form.setLocationRelativeTo(null);
        this.form.setVisible(true);
        stmt = this.conect.createStatement();
        
        Prueba();        
    }
    
    public boolean IniciarSesion(String rut, String clave){
        String apellido;
        String nombre;
        String correo;
        ResultSet usuario = consultarSi("apellido, nombre, correo, clave, cargo", "Usuarios", "rut", '\'' + rut + '\'');
        try {
            if (usuario.next()) {
                if (usuario.getString("clave").equals(clave)) {
                    apellido = usuario.getString("apellido");
                    nombre = usuario.getString("nombre");
                    correo = usuario.getString("correo");
                    switch (usuario.getString("cargo")){
                            case "A":
                                setSesionActual(new Administrador(apellido, nombre, correo, rut, clave));
                                return true;
                            case "P":
                                setSesionActual(new Profesor(apellido, nombre, correo, rut, clave));
                                return true;
                            case "E":
                                setSesionActual(new Encargado(apellido, nombre, correo, rut, clave));
                                return true;
                            default:
                                System.out.println("Usuario no dispone de cargos, llame a TI y vea el espectáculo");
                                return false;
                    }
                }else{
                    System.out.println("Clave incorrecta");
                    return false;
                }
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario");
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void setSesionActual(Administrador adm){
        this.sesion = "adm";
        this.adm = adm;
    }
    public void setSesionActual(Profesor profe){
        this.sesion = "profe";
        this.profe = profe;
    }
    public void setSesionActual(Encargado enc){
        this.sesion = "enc";
        this.enc = enc;
    }
    
    public ResultSet Consultar(String datos, String tabla){
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM " + tabla);
        } catch (SQLException ex){
            System.out.println("Error en la query");
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet consultarSi(String datos, String tabla, String criterio, String condicion){
        try{
            return stmt.executeQuery("SELECT " + datos + " FROM " + tabla +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException ex){
            System.out.println("Error en la query");
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }      
    }
    
    public int Insertar(String tabla, String valores){
        
        try {
            return stmt.executeUpdate("INSERT INTO " + tabla + " VALUES " + valores);
        } catch (SQLException ex) {
            System.out.println("Error en INSERT");
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int Eliminar(String tabla, String criterio, String condicion){
        try {
            return stmt.executeUpdate("DELETE FROM " + tabla +
                    " WHERE " + criterio + " = " + condicion);
        } catch (SQLException ex) {
            System.out.println("Error en DELETE");
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    private void Prueba() throws SQLException{
        IniciarSesion("21850-0", "1234");
        
        //String e = SesionActual().consultarEstados();
        
        String e = enc.consultarEstados();
        
        System.out.println(e);
        System.out.println(enc.toString());
        
        /*
        form.getjLabel2().setText(algo);
        */
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
