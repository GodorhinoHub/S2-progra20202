package Modelo;

public class Equipo {
    private int idEquipo;
    private String tipo;
    private String marca;
    private int ano;
    private char estado;

    // Constructor
    public Equipo(int idEquipo, String tipo, String marca, int ano, char estado) {
        this.idEquipo = idEquipo;
        this.tipo = tipo;
        this.marca = marca;
        this.ano = ano;
        this.estado = estado;
    }

    // Getters
    public int getIdEquipo() {
        return idEquipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public char getEstado() {
        return estado;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "(" + idEquipo + ", \'" + tipo + "\', \'" + marca + "\', " + ano + ", \'" + estado + "\')";
    }
}
