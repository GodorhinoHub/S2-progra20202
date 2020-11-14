package Modelo;

import java.sql.*;
import javax.swing.*;

public class Alumno {
    private int id;
    private String Login;
    private String Contrasena;
    private String Nombre;
    private String Apellidos;
    private OperacionesBD con;

    // Constructor
    public Alumno(int id, String Login, String Contrasena, String Nombre, String Apellidos, OperacionesBD con) {
        this.id = id;
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.con = con;
    }
    
    public Alumno(String Login, String Contrasena, String Nombre, String Apellidos) {
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.con = con;
    } 

    // Getters
    public int getId() {
        return id;
    }

    public String getLogin() {
        return Login;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
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

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    
    // Functions
    public DefaultListModel listarAlumnosClase(int id){ // Se listan los alumnos que comparten clase con el alumno conectado (nombre y apellidos). 
        DefaultListModel def = new DefaultListModel();
        ResultSet listar = null;
        ResultSet nivelId = con.consultarSi("nivel_id", "alumno","id", Integer.toString(id));
        try {
            nivelId.next();
            listar = con.consultarSi("nombre, apellidos", "alumno","nivel_id", nivelId.getString("nivel_id"));
        } catch (SQLException ex) {
            System.out.println("No se han encontrado alumnos en la clase");
            System.out.println(ex);
        }
        try {
            while (listar.next()) {
                def.addElement("" + listar.getString("nombre") + " " + listar.getString("apellidos"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumnos");
            System.out.println(ex);
            return null;
        }
    }
    
    public DefaultListModel listarProfesores(int id){ // Se listarán los profesores que imparten clase al alumno conectado (nombre, apellidos y nombre de la asignatura que le imparten).
        DefaultListModel def = new DefaultListModel();
        String asignaturaNombre = "";
        ResultSet nivelId = con.consultarSi("nivel_id", "alumno","id", Integer.toString(id));
        ResultSet profesorId = null;
        ResultSet listar = null;
        try {
            nivelId.next();
            profesorId = con.consultarSi("profesor_id, nombre", "asignatura","nivel_id", nivelId.getString("nivel_id"));
            profesorId.next();
            asignaturaNombre = profesorId.getString("nombre");
            listar = con.consultarSi("nombre, apellidos", "profesor", "id", profesorId.getString("profesor_id"));
        } catch (SQLException ex) {
            System.out.println("No se han encontrado asignaturas");
            System.out.println(ex);
        }
        try {
            while (listar.next()) {
                def.addElement("" + listar.getString("nombre") + " " + listar.getString("apellidos") + ", " + asignaturaNombre);
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar asignaturas");
            System.out.println(ex);
            return null;
        }
    }
    
    public DefaultListModel listarNotas(int id){ // Se muestra un listado de las asignaturas en las que el alumno conectado se encuentra matriculado y cuando haga clik sobre una de ellas, se muestran las calificaciones correspondientes a esa asignatura
        DefaultListModel def = new DefaultListModel();
        ResultSet asignaturaId = con.consultarSi("asignatura_id", "asignatura_has_alumno","alumno_id", Integer.toString(id));
        ResultSet listar = null;
        try {
            asignaturaId.next();
            listar = con.consultarSi("nombre", "asignatura", "id", asignaturaId.getString("asignatura_id"));
        } catch (SQLException ex) {
            System.out.println("No se han encontrado asignaturas");
            System.out.println(ex);
        }
        try {
            while (listar.next()) {
                def.addElement("" + listar.getString("nombre"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar asignaturas");
            System.out.println(ex);
            return null;
        }
    }

    public String toStringAlta() {
        return ",\'" + Login + "\', \'" + Contrasena + "\', \'" + Nombre + "\', \'"+ Apellidos + "\'";
    }
    
    @Override
    public String toString() {
        return "(" + id + ", \'" + Login + "\', \'" + Contrasena + "\', \'" + Nombre + "\', \'"+ Apellidos + "\')";
    }
}
