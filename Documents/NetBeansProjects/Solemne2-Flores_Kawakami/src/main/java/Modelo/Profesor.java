package Modelo;

public class Profesor {
    int id;
    String Login;
    String Contrasena;
    String Nombre;
    String Apellidos;
    String Email;
    int Especialista;

    // Constructor
    public Profesor(int id, String Login, String Contrasena, String Nombre, String Apellidos, String Email, int Especialista) {
        this.id = id;
        this.Login = Login;
        this.Contrasena = Contrasena;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Especialista = Especialista;
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
    public void listarProfesores(){
        
    }
    
    public void ponerNotas(){
        
    }
    
    public void listarAlumnos(){
        
    }
}
