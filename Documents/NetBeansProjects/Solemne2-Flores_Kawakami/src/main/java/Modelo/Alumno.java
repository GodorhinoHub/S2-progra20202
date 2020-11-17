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
    private String Nivel;

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
    
    public String getNivel() {
        return Nivel;
    }

    public OperacionesBD getCon() {    
        return con;
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

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }
    
    // Functions
    public DefaultListModel listarAlumnosClase(int id){ // Se listan los alumnos que comparten clase con el alumno conectado (nombre y apellidos). 
        DefaultListModel def = new DefaultListModel();
        ResultSet listar  = con.Consultar("DISTINCT alumno.nombre,alumno.apellidos","alumno" +
                " INNER JOIN asignatura_has_alumno A, asignatura_has_alumno B" +
                " WHERE B.alumno_id= " + id +
                " AND A.asignatura_id=B.asignatura_id AND alumno.id=A.alumno_id");
        try {
            while (listar.next()) {
                def.addElement(listar.getString("alumno.nombre") + " " + listar.getString("alumno.apellidos"));
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
        ResultSet listar = con.Consultar("profesor.nombre, profesor.apellidos, asignatura.nombre", "profesor" +
                " INNER JOIN asignatura_has_alumno ON asignatura_has_alumno.alumno_id = " + id +
                " INNER JOIN asignatura ON asignatura_has_alumno.asignatura_id=asignatura.id AND asignatura.profesor_id=profesor.id");
        try {
            while (listar.next()) {
                def.addElement("" + listar.getString("profesor.nombre") + " " + listar.getString("profesor.apellidos") + ", " + listar.getString("asignatura.nombre"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumnos");
            System.out.println(ex);
            return null;
        }
    }
    
    public DefaultListModel listarNotas(int id){ // Se muestra un listado de las asignaturas en las que el alumno conectado se encuentra matriculado y cuando haga clik sobre una de ellas, se muestran las calificaciones correspondientes a esa asignatura
        DefaultListModel def = new DefaultListModel();
        ResultSet listar = con.Consultar("asignatura_has_alumno.asignatura_id, asignatura.nombre", "asignatura" +
                " INNER JOIN asignatura_has_alumno ON asignatura_has_alumno.alumno_id = " + Integer.toString(id) + 
                " AND asignatura.id=asignatura_has_alumno.asignatura_id");
        try {
            while (listar.next()) {
                def.addElement(listar.getString("asignatura.nombre") + "-" + listar.getString("asignatura_has_alumno.asignatura_id"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar asignaturas");
            System.out.println(ex);
            return null;
        }
    }
    
    public DefaultListModel listarDetalles(String asignatura,int id){
        DefaultListModel def = new DefaultListModel();
        ResultSet listar = con.consultarSi("nota", "nota", "asignatura_has_alumno_asignatura_id", asignatura +
                " AND asignatura_has_alumno_alumno_id = " + id);
        try {
            while (listar.next()) {
                def.addElement("" + listar.getString("nota"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar notas");
            System.out.println(ex);
            def.addElement("Error al buscar notas");
            return def;
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
