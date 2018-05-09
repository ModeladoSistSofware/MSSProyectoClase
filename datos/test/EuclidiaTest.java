package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;
import org.junit.jupiter.api.Test;
import distancia.DEuclidia;

class EuclidiaTest {
    
    @Test
    void test() {
       Vector x = new Vector();
       x.add(15.0);
       x.add(13.0);
       Vector y = new Vector();
       y.add(3.0);
       y.add(5.0);
       DEuclidia distancia = new DEuclidia();
       
      assertEquals(14.42,distancia.calcularDistancia(x, y), 0.1);
    }
    @Test
    void otroPuntotest() {
       Vector x = new Vector();
       x.add(3.0);
       x.add(2.0);
       Vector y = new Vector();
       y.add(5.0);
       y.add(6.0);
       DEuclidia distancia = new DEuclidia();    
       assertEquals(4.47,distancia.calcularDistancia(x, y), 0.1);
    }
    @Test
    void otroPunto1test() {
       Vector x = new Vector();
       x.add(15.0);
       x.add(3.0);
       Vector y = new Vector();
       y.add(13.0);
       y.add(5.0);
       DEuclidia distancia = new DEuclidia();    
       assertEquals(2.82,distancia.calcularDistancia(x, y), 0.1);
    }
    @Test
    void otroPuntoDecimaltest() {
       Vector x = new Vector();
       x.add(15.5);
       x.add(3.45);
       Vector y = new Vector();
       y.add(13.14);
       y.add(5.13);
       DEuclidia distancia = new DEuclidia();    
       assertEquals(2.89,distancia.calcularDistancia(x, y), 0.1);
    }
}
