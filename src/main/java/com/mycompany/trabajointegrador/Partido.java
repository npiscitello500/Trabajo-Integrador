/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegrador;

/**
 *
 * @author Admin
 */
public class Partido {

    private final Equipo equipo1;
    private final Equipo equipo2;
    private final int golesEquipo1;
    private final int golesEquipo2;
    private final int numeroRonda;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, int numeroRonda) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.numeroRonda = numeroRonda;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public ResultadoEnum decidirResultado() {
        if (this.golesEquipo1 > this.golesEquipo2) {
            return ResultadoEnum.GANA_EQUIPO_1;
        }
        if (this.golesEquipo1 < this.golesEquipo2) {
            return ResultadoEnum.GANA_EQUIPO_2;
        }
        return ResultadoEnum.EMPATE;
    }
}
