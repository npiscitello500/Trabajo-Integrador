/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajointegradorentrega2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TrabajoIntegradorEntrega2 {

    public static void main(String[] args) throws IOException {
        String ubicacionArchivoPronosticos = "archivos\\pronosticos1.csv";
        String ubicacionArchivoPartidos = "archivos\\resultados1.csv";
        List<Pronostico> pronosticos = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();
        List<Ronda> rondas = new ArrayList<>();
        List<Participante> participantes = new ArrayList<>();
        
        Path pathPartidos = Paths.get (ubicacionArchivoPartidos);
        
        for (String partidoLinea : Files.readAllLines (pathPartidos )) {
            String[] columnas = partidoLinea.split(";");
           
            int numeroRonda = Integer.valueOf(columnas[0]);
            
            //Ronda ronda = new Ronda(numeroRonda);
            
            if(columnas.length != 5) {
                System.out.println("Error, el archivo no tiene la cantidad de columnas apropiada");
                return;
            }
            Integer golesEquipo1 = 0;
            Integer golesEquipo2 = 0;
            
            try {
                golesEquipo1 = Integer.valueOf(columnas[2]);
                golesEquipo2 = Integer.valueOf(columnas[3]);
                
            } catch (NumberFormatException exception) {
                System.out.println("Error, los goles no son números");
                return;
            }
            Equipo equipo1 = new Equipo (columnas[1]);
            Equipo equipo2 = new Equipo (columnas[4]);
            Partido partido = new Partido (equipo1, equipo2, golesEquipo1, golesEquipo2, numeroRonda);
            partidos.add(partido);
        }
        
        Path pathPronosticos = Paths.get (ubicacionArchivoPronosticos);
        
        for (String pronosticoLinea : Files.readAllLines (pathPronosticos)) {
          String[] columnas = pronosticoLinea.split(";"); 
          Partido partidoEncontrado = BuscarPartidoPorNombreEquipos(partidos, columnas[1], columnas[5]);
          ResultadoEnum resultadoPronostico = DeterminarResultadoElegido(columnas);
          Pronostico pronostico = new Pronostico(partidoEncontrado, resultadoPronostico, 0);
          pronosticos.add(pronostico);
        }
        int puntajeFinalPersona = 0;
        
        for (Pronostico pronostico : pronosticos) {
            puntajeFinalPersona = puntajeFinalPersona + pronostico.calcularPuntajePronostico();
        }
        System.out.println("Puntaje: " + puntajeFinalPersona);
    }
    public static Partido BuscarPartidoPorNombreEquipos(List<Partido> partidos, String nombreEquipo1, String nombreEquipo2) {
        Partido partidoEncontrado = partidos.stream()
                .filter (partido -> partido.getEquipo1().getNombre().equals(nombreEquipo1) 
                        && partido.getEquipo2().getNombre().equals(nombreEquipo2))
                .findAny()
                .orElse(null);
        return partidoEncontrado;
    }
    public static Ronda BuscarRondaPorNombre(List<Ronda> rondas, int numeroRonda) {
        Ronda rondaEncontrada = rondas.stream()
                .filter (ronda -> ronda.getNumeroRonda() == numeroRonda)
                .findAny()
                .orElse(null);
        return rondaEncontrada;
    }
    private static ResultadoEnum DeterminarResultadoElegido(String[] columnas) {
        String ganaEquipo1 = columnas[2];
        String empate = columnas[3];
        String ganaEquipo2 = columnas[4];
        
        if (ganaEquipo1.equals("X")) return ResultadoEnum.GANA_EQUIPO_1;
        if (empate.equals("X")) return ResultadoEnum.EMPATE;
        if (ganaEquipo2.equals("X")) return ResultadoEnum.GANA_EQUIPO_2;
        
        return ResultadoEnum.EMPATE;
    }   
    }
