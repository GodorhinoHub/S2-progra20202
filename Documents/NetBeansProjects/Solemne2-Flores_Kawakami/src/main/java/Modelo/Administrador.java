package Modelo;

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
    
    public void matricularAlumno(){ // Se podrá matricular a los alumnos en las distintas asignaturas.
        
    }
    
    public void bajaUsuario(){ // Se podrá dar de baja un usuario.
        
    }
    
    public void bajaAsignatura(){ // Se podrá dar de baja una asignatura.
        
    }
    
    public void modificarUsuario(){ // Se podrá modificar datos de un usuario.
        
    }
    
    public void ModificarAsignatura(){ // Se podrá modificar datos de una asignatura.
        
    }

    @Override
    public String toString() {
        return "(" + id + ", \'" + Login + "\', \'" + Contrasena + "\', \'" + Email + "\')";
    }
}
