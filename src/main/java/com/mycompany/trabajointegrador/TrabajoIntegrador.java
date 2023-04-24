/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajointegrador;

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
public class TrabajoIntegrador {

    public static void main(String[] args) throws IOException {
        String ubicacionArchivoPronosticos = "archivos\\pronosticos.csv";
        String ubicacionArchivoPartidos = "archivos\\resultados.csv";
        List<Pronostico> pronosticos = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();
        
        Path pathPartidos = Paths.get (ubicacionArchivoPartidos);
        
        for (String partidoLinea : Files.readAllLines (pathPartidos )) {
            String[] columnas = partidoLinea.split(";");
            Equipo equipo1 = new Equipo (columnas[0]);
            Equipo equipo2 = new Equipo (columnas[3]);
            Partido partido = new Partido (equipo1, equipo2, Integer.valueOf(columnas[1]), Integer.valueOf(columnas[2]), Integer.valueOf(1));
            partidos.add(partido);
        }
        
        Path pathPronosticos = Paths.get (ubicacionArchivoPronosticos);
        
        for (String pronosticoLinea : Files.readAllLines (pathPronosticos)) {
          String[] columnas = pronosticoLinea.split(";"); 
          Partido partidoEncontrado = BuscarPartidoPorNombreEquipos(partidos, columnas[0], columnas[4]);
          ResultadoEnum resultadoPronostico = DeterminarResultadoElegido(columnas);
          Pronostico pronostico = new Pronostico(partidoEncontrado, resultadoPronostico);
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
    private static ResultadoEnum DeterminarResultadoElegido(String[] columnas) {
        String ganaEquipo1 = columnas[1];
        String empate = columnas[2];
        String ganaEquipo2 = columnas[3];
        
        if (ganaEquipo1.equals("X")) return ResultadoEnum.GANA_EQUIPO_1;
        if (empate.equals("X")) return ResultadoEnum.EMPATE;
        if (ganaEquipo2.equals("X")) return ResultadoEnum.GANA_EQUIPO_2;
        
        return ResultadoEnum.EMPATE;
    }
            
}
