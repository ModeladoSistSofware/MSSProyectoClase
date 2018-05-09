package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;
import org.junit.jupiter.api.Test;
import estadistica.Estadistica;

class EstadisticaTest {
    
    @Test
    void mediaCalcularTest() {
       Vector<Double> aux = new Vector<Double>() ;
       aux.add(10.0);
       aux.add(15.0);
       aux.add(52.0);
       aux.add(45.0);
       aux.add(75.0);
       aux.add(148.0);
       aux.add(125.0);
       assertEquals(67.15,Estadistica.media(aux),0.1);
       aux.clear();
       aux.add(45.0);
       aux.add(12.0);
       aux.add(95.0);
       aux.add(32.0);
       assertEquals(46,Estadistica.media(aux),0.1);
    }
    
    @Test
    void varianzaCalcularTest() {
       Vector<Double> aux = new Vector<Double>() ;
       aux.add(15.0);
       aux.add(10.0);
       aux.add(15.0);
       aux.add(26.0);
       aux.add(23.0);
       assertEquals(34.16,Estadistica.varianza(aux),0.1);
       aux.clear();
       aux.add(54.0);
       aux.add(78.0);
       aux.add(52.0);
       aux.add(35.0);
       aux.add(152.0); 
       assertEquals(1700.96,Estadistica.varianza(aux),0.1);
    }
    
    @Test
    void desviaciónTipicaCalcularTest() {
        Vector<Double> aux = new Vector<Double>() ;
        aux.add(45.0);
        aux.add(15.0);
        aux.add(84.0);
        aux.add(56.0);
        assertEquals(24.70,Estadistica.desviacionTipica(aux),0.1);
        aux.clear();
        aux.add(45.0);
        aux.add(68.0);
        aux.add(95.0);
        aux.add(52.0);
        assertEquals(19.22,Estadistica.desviacionTipica(aux),0.1);
    }
    
}
