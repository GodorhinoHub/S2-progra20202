package Modelo;

public class Alumno {
    int id;
    String Login;
    String Contrasena;
    String Nombre;
    String Apellidos;

    // Constructor
    public Alumno(int id, String Login, String Contrasena, String Nombre, String Apellidos) {
        this.id = id;
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
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
    public void listarAlumnosClase(){
        
    }
    
    public void listarProfesores(){
        
    }
    
    public void listarNotas(){
        
    }
}
