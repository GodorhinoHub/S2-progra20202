package Modelo;

public class Nota {
    int trimestre;
    double nota;

    // Constructor
    public Nota(int trimestre, double nota) {
        if (nota / 10 >= 1) {
            nota = nota/10;
        }
        this.trimestre = trimestre;
        this.nota = nota;
    }

    // Getters and Setters
    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int Trimestre) {
        this.trimestre = Trimestre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double Nota) {
        this.nota = Nota;
    }

    @Override
    public String toString() {
        return "" + trimestre + "," + nota;
    }
    
    
}
