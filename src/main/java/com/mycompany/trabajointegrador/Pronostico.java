/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegrador;

/**
 *
 * @author Admin
 */
public class Pronostico {

    private final Partido partido;
    private final ResultadoEnum resultado;

    public Pronostico(Partido partido, ResultadoEnum resultado) {
        this.partido = partido;
        this.resultado = resultado;
    }

    public Partido getPartido() {
        return partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public int calcularPuntajePronostico() {
        ResultadoEnum resultadoPartido = this.partido.decidirResultado();
        if (resultadoPartido == this.resultado) {
            return 1;
        } else {
            return 0;
        }
    }
}
