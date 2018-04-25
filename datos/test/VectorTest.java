package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import cogerDatos.Vector;
/**
 * Clase que donde se hacen los tery para comprobar la clase Vector.
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
class VectorTest {
    
    @Test
    void testVectorInt() {
        Vector aux = new Vector(5);
        assertEquals(0, aux.getTam());
    }
    
    @Test
    void testVectorString() {
        Vector aux = new Vector("a,b,c");
        assertEquals(3, aux.getTam());
    }
    
    @Test
    void testGetDatos() {
        Vector aux = new Vector(5);
        aux.add("a");
        aux.add("b");
        assertEquals("a", aux.get(0));
    }
    
    @Test
    void testSetDatos() {
        ArrayList<String> nuevo = new ArrayList<String>();
        nuevo.add("a");
        nuevo.add("b");
        nuevo.add("c");
        Vector aux = new Vector(1);
        assertEquals(0, aux.getTam());
        aux.setDatos(nuevo);
        assertEquals(3, aux.getTam());
    }
    
    @Test
    void testToString() {
        Vector aux = new Vector("a,b,c");
        assertEquals("a,b,c", aux.toString());
    }
    
    @Test
    void testCompareIgual() {
        Vector aux = new Vector("a,b,c");
        Vector aux2 = new Vector("a,b,c");
        assertTrue(aux.compareIgual(aux2));
    }
    @Test
    void testMax() {
        Vector aux = new Vector("1,12121,2,3,5,1,2,3,300");
        System.out.println(aux.max());
    }
}
