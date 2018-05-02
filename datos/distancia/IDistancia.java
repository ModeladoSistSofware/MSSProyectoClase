/**
 * 
 */
package distancia;

import java.util.Vector;

/**
 * Interfaz para calcular la distancias hay entre dos Vectores.
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public interface IDistancia {
    public double calcularDistancia(Vector<Double> a, Vector<Double> b);
}
