package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cogerDatos.Instancia;
import cogerDatos.Vector;
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
        Vector name = new Vector("att1,att2,att3");   
        Vector types = new Vector("int,int,int");   
        Instancia nuevo = new Instancia(name,types);
        nuevo.print();
    }
    
}
