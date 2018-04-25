package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cogerDatos.Vector;
import distancia.Euclidia;

class EuclidiaTest {
    
    @Test
    void test() {
       Vector x = new Vector("15,13");
       Vector y = new Vector("3,5");
       Euclidia distancia = new Euclidia();
       
      assertEquals(14.42,distancia.calcularDistancia(x, y), 0.1);
    }
    @Test
    void otroPuntotest() {
       Vector x = new Vector("3,2");
       Vector y = new Vector("5,6");
       Euclidia distancia = new Euclidia();    
       assertEquals(4.47,distancia.calcularDistancia(x, y), 0.1);
    }
    @Test
    void otroPunto1test() {
       Vector x = new Vector("15,3");
       Vector y = new Vector("13,5");
       Euclidia distancia = new Euclidia();    
       assertEquals(2.82,distancia.calcularDistancia(x, y), 0.1);
    }
    @Test
    void otroPuntoDecimaltest() {
       Vector x = new Vector("15.5,3.45");
       Vector y = new Vector("13.14,5.13");
       Euclidia distancia = new Euclidia();    
       assertEquals(2.89,distancia.calcularDistancia(x, y), 0.1);
    }
}
