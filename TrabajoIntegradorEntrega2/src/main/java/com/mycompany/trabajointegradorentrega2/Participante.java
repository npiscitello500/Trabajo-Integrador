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
public class Participante {
    private final String nombre;
    private int puntaje;
    private int cantidadAciertos;
    private final List<Pronostico> pronosticos;

    public Participante(String nombre, int puntaje, int cantidadAciertos, java.util.List<com.mycompany.trabajointegradorentrega2.Pronostico> pronosticos) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.cantidadAciertos = cantidadAciertos;
        this.pronosticos = pronosticos;
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getCantidadAciertos() {
        return cantidadAciertos;
    }
    
    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void agregarPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }
    public void calcularPuntaje(){
        for(Pronostico pronostico : this.pronosticos) {
            this.puntaje = this.puntaje + pronostico.calcularPuntajePronostico();
        }
    }
    public void calcularAciertos(){
        for (Pronostico pronostico : this.pronosticos){
            this.cantidadAciertos = this.cantidadAciertos + pronostico.calcularAciertoPronostico();
        }
        
    }
}
