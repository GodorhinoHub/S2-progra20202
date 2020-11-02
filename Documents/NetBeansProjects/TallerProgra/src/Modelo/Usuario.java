package Modelo;

public class Usuario {
    private String apellido;
    private String nombre;
    private String correo;
    private String rut;
    private String clave;
    private char cargo;

    // Constructor
    public Usuario(String apellido, String nombre, String correo, String rut, String clave, char cargo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.rut = rut;
        this.clave = clave;
        this.cargo = cargo;
    }
    
    // Getters
    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRut() {
        return rut;
    }

    public String getClave() {
        return clave;
    }

    public char getCargo() {
        return cargo;
    }
    
    // Setters
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCargo(char cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "apellido=" + apellido + ", nombre=" + nombre + ", correo=" + correo + ", rut=" + rut + ", clave=" + clave + ", cargo=" + cargo + '}';
    }
    
    
}
