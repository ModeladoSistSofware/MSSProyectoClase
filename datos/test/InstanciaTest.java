package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;
import org.junit.jupiter.api.Test;
import cogerDatos.SChema;

/**
 * Clase que donde se hacen los ters para comprobar la clase Instanncia.
 * 
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
class InstanciaTest {
    
    @Test
    void test() {
        Vector name = new Vector();   
        name.add("attr3");
        name.add("attr3");
        name.add("attr3");
        Vector types = new Vector();  
        types.add("int");
        types.add("int");
        types.add("int");
        SChema nuevo = new SChema(name,types);
        nuevo.print();
    }
    
}
