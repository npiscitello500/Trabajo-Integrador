
import com.mycompany.trabajointegradorentrega2.Equipo;
import com.mycompany.trabajointegradorentrega2.Partido;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class PartidoTest {
        @Test 
    public void resultadoGanaEquipo1() {
        Equipo equipo1 = new Equipo("Argentina");
        Equipo equipo2 = new Equipo("Francia");
        Partido partido = new Partido(equipo1, 4, 2, equipo2, 1);
        
        assertEquals(partido.decidirResultado(), ResutadoEnum.GANA_EQUIPO_1)
    }
    @Test 
    public void resultadoEmpate() {
        Equipo equipo1 = new Equipo("Argentina");
        Equipo equipo2 = new Equipo("Francia");
        Partido partido = new Partido(equipo1, 2, 2, equipo2, 1);
        
        assertEquals(partido.decidirResultado(), ResutadoEnum.EMPATE)
    }
    @Test 
    public void resultadoGanaEquipo2() {
        Equipo equipo1 = new Equipo("Argentina");
        Equipo equipo2 = new Equipo("Francia");
        Partido partido = new Partido(equipo1, 2, 3, equipo2, 1);
        
        assertEquals(partido.decidirResultado(), ResutadoEnum.GANA_EQUIPO_2)
    }
}
