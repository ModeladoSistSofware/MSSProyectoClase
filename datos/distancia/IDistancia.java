/**
 * 
 */
package distancia;

import java.util.Vector;

/**
 * Interfaz para calcular la distancias hay entre dos Vectores.
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public interface IDistancia {
    public double calcularDistancia(Vector<Double> a, Vector<Double> b);
}
