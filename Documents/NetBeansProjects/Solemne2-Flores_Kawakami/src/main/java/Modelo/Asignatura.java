package Modelo;

public class Asignatura {
    int id;
    String Nombre;

    // Constructor
    public Asignatura(int id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
