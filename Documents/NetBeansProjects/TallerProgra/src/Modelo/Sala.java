package Modelo;

public class Sala {
    private int idSala;
    private char estado;

    // Constructor
    public Sala(int idSala, char estado) {
        this.idSala = idSala;
        this.estado = estado;
    }

    // Getters
    public int getIdSala() {
        return idSala;
    }

    public char getEstado() {
        return estado;
    }
    
    // Setters
    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sala{" + "idSala=" + idSala + ", estado=" + estado + '}';
    }
    
    
}
