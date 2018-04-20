package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import cogerDatos.Vector;

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
    
}
