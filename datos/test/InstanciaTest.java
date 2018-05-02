package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;
import org.junit.jupiter.api.Test;
import cogerDatos.Instancia;

/**
 * Clase que donde se hacen los ters para comprobar la clase Instanncia.
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
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
        Instancia nuevo = new Instancia(name,types);
        nuevo.print();
    }
    
}
