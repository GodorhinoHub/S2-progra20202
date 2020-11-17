package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public Administrador(String Login, String Contrasena, String Email) {
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Email = Email;
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

    public void setEmail(String Email) {    
        this.Email = Email;
    }

    // Functions
    public boolean altaUsuario(Administrador administrador) { // Se podrá dar de alta usuarios.
        int insert;
        ResultSet exists = con.consultarSi("*", "administrador", "login", "" + administrador.getLogin());
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
    
    public boolean altaUsuario(Alumno alumno, String nivel_id) { // Se podrá dar de alta usuarios.
        int insert;
        ResultSet exists = con.consultarSi("*", "alumno", "login", "\'" + alumno.getLogin()+ "\'");
        try {
            if (exists.next()) {
                System.out.println("Alumno ya se encuentra dado de alta");
                return false;
            }else{
                insert = con.Insertar("alumno (nivel_id,login,clave,nombre,apellidos)","(" + nivel_id + alumno.toStringAlta() + ")");
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
    
    public boolean altaAsignatura(Asignatura asignatura, String nivel_id, String profesor_id){ // Se podrá dar de alta asignaturas.
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
    
    public boolean matricularAlumno(String alumno_id, String asignatura_id){ // Se podrá matricular a los alumnos en las distintas asignaturas.
        int insert;
        try {
            ResultSet alumnoExists = con.consultarSi("*", "alumno", "id", alumno_id);
            if (!alumnoExists.next() ) {
                System.out.println("Alumno no existe");
                return false;
            }
            alumnoExists.close();
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si alumno existe");
            System.out.println(ex);
        }
        
        try {
            ResultSet asignaturaExists = con.consultarSi("*", "asignatura", "id", asignatura_id);
            if (!asignaturaExists.next() ) {
                System.out.println("Asignatura no existe");
                return false;
            }
            asignaturaExists.close();;
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si la asignatura existe");
            System.out.println(ex);
        }
        
        try {
            ResultSet exists = con.consultarSi("*", "asignatura_has_alumno",
                    "asignatura_id", asignatura_id + " AND alumno_id = " + alumno_id);
            if(!exists.next()){
                insert = con.Insertar("asignatura_has_alumno",
                        "(" + asignatura_id + "," + alumno_id + "," + Integer.toString(0) + ")");
                if (insert != 0 ) {
                    System.out.println(insert);
                    System.out.println("Matricula completa");
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
    
    public boolean bajaUsuario(int id, String tabla){ // Se podrá dar de baja un usuario.
        int delet;
        ResultSet exists = con.consultarSi("*", tabla, "id", Integer.toString(id));
        try {
            if(exists.next()){
                delet = con.Eliminar(tabla, "id", Integer.toString(id));
                if(delet != 0){
                    System.out.println("Borrado exitoso");
                    return true;
                }else{
                    System.out.println("No se pudo borrar");
                    return false;
                }
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el usuario");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean bajaAsignatura(int id){ // Se podrá dar de baja una asignatura.
        int delet;
        ResultSet exists = con.consultarSi("*", "asignatura", "id", Integer.toString(id));
        try {
            if(exists.next()){
                delet = con.Eliminar("asignatura", "id", Integer.toString(id));
                if(delet != 0){
                    System.out.println("Borrado exitoso");
                    return true;
                }else{
                    System.out.println("No se pudo borrar");
                    return false;
                }
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe la asignatura");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean modificarUsuario(Administrador administrador){ // Se podrá modificar datos de un usuario.
        int update;
        ResultSet exists = con.consultarSi("id", "administrador", "id", Integer.toString(administrador.getId()));
        try {
            if(exists.next()){
                update = con.Actualizar("administrador",
                            "login = \'" + administrador.getLogin()+ "\'" +
                            ",clave = \'" + administrador.getContrasena()+ "\'" +
                            ",email = \'" + administrador.getEmail()+ "\'",
                        "id", Integer.toString(administrador.getId()));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el usuario");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean modificarUsuario(Alumno alumno, String nivel_id){ // Se podrá modificar datos de un usuario.
        int update;
        ResultSet exists = con.consultarSi("id", "alumno", "id", Integer.toString(alumno.getId()));
        try {
            if(exists.next()){
                update = con.Actualizar("alumno",
                            "nivel_id = \'" + nivel_id + "\'" +
                            ",login = \'" + alumno.getLogin()+ "\'" +
                            ",clave = \'" + alumno.getContrasena()+ "\'" +
                            ",nombre = \'" + alumno.getNombre()+ "\'" +
                            ",apellidos = \'" + alumno.getApellidos()+ "\'",
                        "id", Integer.toString(alumno.getId()));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el usuario");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean modificarUsuario(Profesor profesor){ // Se podrá modificar datos de un usuario.
        int update;
        ResultSet exists = con.consultarSi("id", "profesor", "id", Integer.toString(profesor.getId()));
        try {
            if(exists.next()){
                update = con.Actualizar("profesor",
                            "login = \'" + profesor.getLogin()+ "\'" +
                            ",clave = \'" + profesor.getContrasena()+ "\'" +
                            ",nombre = \'" + profesor.getNombre()+ "\'" +
                            ",apellidos = \'" + profesor.getApellidos()+ "\'" +
                            ",email = \'" + profesor.getEmail()+ "\'" +
                            ",especialista = \'" + Integer.toString(profesor.getEspecialista())+ "\'",
                        "id", Integer.toString(profesor.getId()));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Usuario no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe el usuario");
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean modificarAsignatura(Asignatura asignatura, String nivel_id, String profesor_id){ // Se podrá modificar datos de una asignatura.
        int update;
        ResultSet exists = con.consultarSi("*", "asignatura", "id", Integer.toString(asignatura.getId()));
        try {
            if(exists.next()){
                update = con.Actualizar("asignatura",
                            "nivel_id = \'" + nivel_id+ "\'" +
                            ",profesor_id = \'" + profesor_id+ "\'" +
                            ",nombre = \'" + asignatura.getNombre()+ "\'",
                        "id", Integer.toString(asignatura.getId()));
                if (update != 0 ) {
                    System.out.println("Actualización completa");
                    return true;
                }else{
                    System.out.println("Error al actualizar");
                    return false;
                }
            }else{
                System.out.println("Asignatura no existe");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al comprobar si existe la asignatura");
            System.out.println(ex);
            return false;
        }
    }
    
    public Administrador buscarAdmin(String login){
        int id;
        String Contrasena;
        String Email;
        ResultSet usuario = con.consultarSi("id,clave,email", "administrador", "login", "\'" + login + "\'");
        try {
            if (usuario.next()) {
                id = usuario.getInt("id");
                Contrasena = usuario.getString("clave");
                Email = usuario.getString("email");
                return new Administrador(id, login,Contrasena,Email, con);
            }else{
                System.out.println("No existe administrador");
                return new Administrador(0, " "," "," ", con);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar administrador");
            System.out.println(ex);
            return new Administrador(0, " "," "," ", con);
        }
    }
    
    public Alumno buscarAlumn(String login){
        int id;
        String Contrasena;
        String Nombre;
        String Apellidos;
        ResultSet usuario = con.consultarSi("id,nivel_id,clave,nombre,apellidos", "alumno", "login", "\'" + login + "\'");
        try {
            if (usuario.next()) {
                id = usuario.getInt("id");
                Contrasena = usuario.getString("clave");
                Nombre = usuario.getString("nombre");
                Apellidos = usuario.getString("apellidos");
                Alumno pivot = new Alumno(id, login, Contrasena, Nombre, Apellidos, con);
                pivot.setNivel(usuario.getString("nivel_id"));
                return pivot;
            }else{
                System.out.println("No existe el alumno");
                return new Alumno(0, " ", " ", " ", " ", con);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumno");
            System.out.println(ex);
            return new Alumno(0, " ", " ", " ", " ", con);
        }
    }
    
    public Profesor buscarProfe(String login){
        int id;
        String Contrasena;
        String Nombre;
        String Apellidos;
        String Email;
        int Especialista;
        ResultSet usuario = con.consultarSi("id,login,clave,nombre,apellidos,email,especialista", "profesor", "login", "\'" + login + "\'");
        try {
            if (usuario.next()) {
                id = usuario.getInt("id");
                Contrasena = usuario.getString("clave");
                Nombre = usuario.getString("nombre");
                Apellidos = usuario.getString("apellidos");
                Email = usuario.getString("email");
                Especialista = usuario.getInt("especialista");
                return new Profesor(id, login, Contrasena,Nombre, Apellidos, Email, Especialista, con);
            }else{
                System.out.println("No existe el profesor");
                return new Profesor(0, " ", " ", " ", " ", " ", 0, con);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar profesor");
            System.out.println(ex);
            return new Profesor(0, " ", " ", " ", " ", " ", 0, con);
        }
    }
    
    public ArrayList<String> buscarAsignatura(String id){
        ArrayList<String> arr = new ArrayList<String>();
        ResultSet usuario = con.consultarSi("id,nivel_id,profesor_id,nombre", "asignatura", "id", "\'" + id + "\'");
        try {
            if (usuario.next()) {
                arr.add(usuario.getString("id"));
                arr.add(usuario.getString("nivel_id"));
                arr.add(usuario.getString("profesor_id"));
                arr.add(usuario.getString("nombre"));
                return arr;
            }else{
                System.out.println("No existe el asignatura");
                arr.add("");
                arr.add("");
                arr.add("");
                arr.add("");
                return arr;
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar asignatura");
            System.out.println(ex);
                arr.add("");
                arr.add("");
                arr.add("");
                arr.add("");
            return arr;
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
