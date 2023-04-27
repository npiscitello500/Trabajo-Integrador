/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegradorentrega2;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Ronda {
    private final int numeroRonda;
    private final List<Partido> partidos;

    public Ronda(int numeroRonda, List<Partido> partidos) {
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }   
}
