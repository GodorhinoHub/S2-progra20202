package Modelo;

public class Administrador {
    int id;
    String Login;
    String Contrasena;
    String Email;

    // Constructor
    public Administrador(int id, String Login, String Contrasena, String Email) {
        this.id = id;
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
    public void altaUsuario() {
        
    }
    
    public void altaAsignatura(){
        
    }
    
    public void matricularAlumno(){
        
    }
    
    public void bajaUsuario(){
        
    }
    
    public void bajaAsignatura(){
        
    }
    
    public void modificarUsuario(){
        
    }
    
    public void ModificarAsignatura(){
        
    }
}
