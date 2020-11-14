package Modelo;

import java.sql.*;
import javax.swing.*;

public class Administrador {
    int id;
    String Login;
    String Contrasena;
    String Email;
    OperacionesBD con;

    // Constructor
    public Administrador(int id, String Login, String Contrasena, String Email, OperacionesBD con) {
        this.id = id;
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Email = Email;
        this.con = con;
    }
    
    // Getters  
    public int getId(){
        return id;
        
    }

    public String getLogin() {
        return Login;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public String getEmail() {    
        return Email;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public void setEmail(String Email) {    
        this.Email = Email;
    }

    // Functions
    public void altaUsuario() { // Se podrá dar de alta usuarios.
        
    }
    
    public void altaAsignatura(){ // Se podrá dar de alta asignaturas.
        
    }
    
    public boolean matricularAlumno(Alumno alumno, int nivel_id){ // Se podrá matricular a los alumnos en las distintas asignaturas.
        int insert;
        ResultSet exists = con.consultarSi("*", "alumno", "apellidos", "\'" + alumno.Apellidos + "\' AND nombre = \'" + alumno.Nombre + "\'");
        try {
            if (exists.next()) {
                System.out.println("Alumno ya se encuentra matriculado");
                return false;
            }else{
                insert = con.Insertar("alumno (nivel_id,login,clave,nombre,apellidos)","(" + Integer.toString(nivel_id) + alumno.toStringMatricula());
                if (insert != 0) {
                    System.out.println("Alumno matriculado con éxito");
                    return true;
                } else{
                    System.out.println("Error al matricular el alumno");
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el alumno");
            System.out.println(ex);
            return false;
        }
    }
    
    public void bajaUsuario(){ // Se podrá dar de baja un usuario.
        
    }
    
    public void bajaAsignatura(){ // Se podrá dar de baja una asignatura.
        
    }
    
    public void modificarUsuario(){ // Se podrá modificar datos de un usuario.
        
    }
    
    public boolean ModificarAsignatura(Asignatura asignatura){ // Se podrá modificar datos de una asignatura.
        int insert;
        ResultSet exists = con.consultarSi("*", "asignatura", "id", "\'" + Integer.toString(asignatura.getId()));
        try {
            if (exists.next()) {
                System.out.println("Alumno ya se encuentra matriculado");
                return false;
            }else{
                /*insert = con.Insertar("alumno (nivel_id,login,clave,nombre,apellidos)");
                if (insert != 0) {
                    System.out.println("Alumno matriculado con éxito");
                    return true;
                } else{
                    System.out.println("Error al matricular el alumno");
                    return false;
                }*/
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el alumno");
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + id + ", \'" + Login + "\', \'" + Contrasena + "\', \'" + Email + "\')";
    }
}
