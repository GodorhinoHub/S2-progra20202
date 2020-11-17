package Modelo;

import java.sql.*;
import javax.swing.*;

public class Profesor {
    private int id;
    private String Login;
    private String Contrasena;
    private String Nombre;
    private String Apellidos;
    private String Email;
    private int Especialista;
    private OperacionesBD con;

    // Constructor
    public Profesor(int id, String Login, String Contrasena, String Nombre, String Apellidos, String Email, int Especialista, OperacionesBD con) {
        this.id = id;
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Especialista = Especialista;
        this.con = con;
    }
    
    public Profesor(String Login, String Contrasena, String Nombre, String Apellidos, String Email, int Especialista) {
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Especialista = Especialista;
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

    public String getEmail() {
        return Email;
    }

    public int getEspecialista() {
        return Especialista;
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

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setEspecialista(int Especialista) {
        this.Especialista = Especialista;
    }
    
    // Functions
    public DefaultListModel listarAlumnos(int id){ // Se muestra el listado de las asignaturas que imparte el profesor conectado 
        DefaultListModel def = new DefaultListModel();
        ResultSet listar = con.consultarSi("nombre, id", "asignatura","profesor_id", Integer.toString(id));
        try {
            while (listar.next()) {
                def.addElement(listar.getString("nombre") + "-" + listar.getString("id"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar asignaturas");
            System.out.println(ex);
            return null;
        }
    }
    
    public DefaultListModel buscarAlumnos(String asignatura){ // cuando selecciona una de ellas se muestran los alumnos que se encuentra matriculados en esa asignatura (nombre y apellidos).
        DefaultListModel def = new DefaultListModel();
        ResultSet listar = con.Consultar("alumno.nombre, alumno.apellidos, alumno.id", "alumno" +
                " INNER JOIN asignatura_has_alumno " +
                " ON asignatura_has_alumno.asignatura_id = " + asignatura + " AND asignatura_has_alumno.alumno_id=alumno.id");
        try {
            while (listar.next()) {
                def.addElement(listar.getString("alumno.nombre") + " " + listar.getString("alumno.apellidos") +"-" + listar.getString("alumno.id"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar asignaturas");
            System.out.println(ex);
            def.addElement("Error al buscar asignaturas");
            return def;
        }
    }
    
    public DefaultListModel listarProfesores(){ // Se listan los profesores que imparten clases en el centro (nombre y apellidos).
        DefaultListModel def = new DefaultListModel();
        ResultSet listar = con.Consultar("nombre, apellidos", "profesor");
        try {
            while (listar.next()) {
                def.addElement("" + listar.getString("nombre") + " " + listar.getString("apellidos"));
            }
            return def;
        } catch (SQLException ex) {
            System.out.println("Error al buscar asignaturas");
            System.out.println(ex);
            return null;
        }
    }
    
    public String ponerNota(String alumno_id, String asignatura_id, Nota nota){ // para que cuando seleccione una de ellas pueda elegir un alumno de los que se encuentran matriculados en esa asignatura y ponerle una nota.
        int insert;
        insert = con.Insertar("nota(asignatura_has_alumno_alumno_id,asignatura_has_alumno_asignatura_id,trimestre,nota)",
            "(" + alumno_id + "," + asignatura_id + "," + nota.toString() + ")");
        if (insert != 0) {
            System.out.println("Nota Puesta");
            return "Nota Puesta";
        } else{
            System.out.println("Error al poner nota");
            return "Nota no puesta";
        }
    }
    
    public String toStringAlta() {
        return " \'" + Login + "\', \'" + Contrasena + "\', \'" + Nombre + "\', \'" + Apellidos + "\', \'" + Email + "\', " + Especialista;
    }

    @Override
    public String toString() {
        return "(" + id + ", \'" + Login + "\', \'" + Contrasena + "\', \'" + Nombre + "\', \'" + Apellidos + "\', \'" + Email + "\', " + Especialista + ")";
    }
}
