/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegradorentrega2;

/**
 *
 * @author Admin
 */
public class Pronostico {
    private final Partido partido;
    private final ResultadoEnum resultado;
    private int aciertos;

    public Pronostico(Partido partido, ResultadoEnum resultado, int aciertos) {
        this.partido = partido;
        this.resultado = resultado;
        this.aciertos = aciertos;
    }

    public Partido getPartido() {
        return partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int calcularPuntajePronostico() {
        ResultadoEnum resultadoPartido = this.partido.decidirResultado();
        if (resultadoPartido == this.resultado) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int calcularAciertoPronostico(){
        ResultadoEnum resultadoPartido = this.partido.decidirResultado();
        if (resultadoPartido == this.resultado){
            this.aciertos = 1;            
        }   
        return 0;
    }
}
