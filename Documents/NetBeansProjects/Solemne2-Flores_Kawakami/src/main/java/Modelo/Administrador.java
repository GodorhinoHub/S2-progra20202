package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Administrador {
    private int id;
    private String Login;
    private String Contrasena;
    private String Email;
    private OperacionesBD con;

    // Constructor
    public Administrador(int id, String Login, String Contrasena, String Email, OperacionesBD con) {
        this.id = id;
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Email = Email;
        this.con = con;
    }
    
    public Administrador(String Login, String Contrasena, String Email, OperacionesBD con) {
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
    public boolean altaUsuario(Administrador administrador) { // Se podrá dar de alta usuarios.
        int insert;
        ResultSet exists = con.consultarSi("*", "administrador", "login", "\'" + administrador.getLogin());
        try {
            if (exists.next()) {
                System.out.println("Administrador ya se encuentra dado de alta");
                return false;
            }else{
                insert = con.Insertar("administrador (login,clave,email)","(" + administrador.toStringAlta() + ")");
                if (insert != 0) {
                    System.out.println("Administrador dado de alta con éxito");
                    return true;
                } else{
                    System.out.println("Error al dar de alta al administrador");
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el administrador");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean altaUsuario(Alumno alumno, int nivel_id) { // Se podrá dar de alta usuarios.
        int insert;
        ResultSet exists = con.consultarSi("*", "alumno", "login", "\'" + alumno.getLogin()+ "\'");
        try {
            if (exists.next()) {
                System.out.println("Alumno ya se encuentra dado de alta");
                return false;
            }else{
                insert = con.Insertar("alumno (nivel_id,login,clave,nombre,apellidos)","(" + Integer.toString(nivel_id) + alumno.toStringAlta() + ")");
                if (insert != 0) {
                    System.out.println("Alumno dado de alta con éxito");
                    return true;
                } else{
                    System.out.println("Error al dar de alta al alumno");
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el alumno");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean altaUsuario(Profesor profesor) { // Se podrá dar de alta usuarios.
        int insert;
        ResultSet exists = con.consultarSi("*", "profesor", "login", "\'" + profesor.getLogin() + "\'");
        try {
            if (exists.next()) {
                System.out.println("Profesor ya se encuentra dado de alta");
                return false;
            }else{
                insert = con.Insertar("profesor (login,clave,nombre,apellidos,email,especialista)","(" + profesor.toStringAlta() + ")");
                if (insert != 0) {
                    System.out.println("Profesor dado de alta con éxito");
                    return true;
                } else{
                    System.out.println("Error al dar de alta al profesor");
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el profesor");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean altaAsignatura(Asignatura asignatura, int nivel_id, int profesor_id){ // Se podrá dar de alta asignaturas.
        int insert;
        ResultSet exists = con.consultarSi("*", "asignatura", "id", "\'" + asignatura.getId()+ "\'");
        try {
            if (exists.next()) {
                System.out.println("Asignatura ya se encuentra dada de alta");
                return false;
            }else{
                insert = con.Insertar("asignatura","(" + asignatura.toStringAlta(nivel_id,profesor_id) + ")");
                if (insert != 0) {
                    System.out.println("Asignatura dada de alta con éxito");
                    return true;
                } else{
                    System.out.println("Error al dar de alta a la asignatura");
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe la asignatura");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean matricularAlumno(int alumno_id, int asignatura_id, int id_nota) throws SQLException{ // Se podrá matricular a los alumnos en las distintas asignaturas.
        int insert;
        
        try {
            ResultSet alumnoExists = con.consultarSi("*", "alumno", "id", Integer.toString(alumno_id));
            if (!alumnoExists.next() ) {
                System.out.println("Alumno no existe");
                return false;
            }
            alumnoExists.close();;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        try {
            ResultSet asignaturaExists = con.consultarSi("*", "asignatura", "id", Integer.toString(asignatura_id));
            if (!asignaturaExists.next() ) {
                System.out.println("Asignatura no existe");
                return false;
            }
            asignaturaExists.close();;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        try {
            ResultSet exists = con.consultarSi("*", "asignatura_has_alumno",
                    "asignatura_id", Integer.toString(asignatura_id) + " AND alumno_id = " + Integer.toString(alumno_id));
            if(exists.next()){
                insert = con.Insertar("asignatura_has_alumno",
                        "(" + Integer.toString(asignatura_id) + "," + Integer.toString(alumno_id) + "," + Integer.toString(id_nota) + ")");
                if (insert != 0 ) {
                    System.out.println("Matriula completa");
                    return true;
                }else{
                    System.out.println("Error al matricular");
                    return false;
                }
            }else{
                System.out.println("Alumno ya matriculado");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si alumno ya fue matriculado");
            System.out.println(ex);
            return false;
        }
    }
    
    public void bajaUsuario(int id, String usuario){ // Se podrá dar de baja un usuario.
        
    }
    
    public void bajaAsignatura(int id){ // Se podrá dar de baja una asignatura.
        
    }
    
    public void modificarUsuario(Administrador administrador){ // Se podrá modificar datos de un usuario.
        
    }
    
    public void modificarUsuario(Alumno alumno){ // Se podrá modificar datos de un usuario.
        
    }
    
    public void modificarUsuario(Profesor profesor){ // Se podrá modificar datos de un usuario.
        
    }
    
    public boolean ModificarAsignatura(Asignatura asignatura, int nivel_id, int profesor_id){ // Se podrá modificar datos de una asignatura.
        int update;
        ResultSet exists = con.consultarSi("nombre", "asignatura", "id", Integer.toString(asignatura.getId()));
        try {
            if(exists.next()){
                update = con.Actualizar("asignatura",
                            "nombre = \'" + asignatura.getNombre()+ '\'' +
                            ",nivel_id = \'" + Integer.toString(nivel_id) + '\'' +
                            ",profesor_id = \'" + Integer.toString(profesor_id) + '\'',
                        "id", Integer.toString(asignatura.getId()));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Id de asignatura no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe la asignatura");
            System.out.println(ex);
            return false;
        }
    }

    public String toStringAlta() {
        return "\'" + Login + "\', \'" + Contrasena + "\', \'" + Email + "\'";
    }
    
    @Override
    public String toString() {
        return "(" + id + ", \'" + Login + "\', \'" + Contrasena + "\', \'" + Email + "\')";
    }
}
