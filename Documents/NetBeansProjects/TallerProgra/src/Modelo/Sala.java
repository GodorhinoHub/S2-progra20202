/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Asus
 */
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
    
    // Functions
}
