package distancia;

import cogerDatos.Vector;
/**
 * Clase que calcula la distancia Ecuclidia entre dos Vecotres implementa la interfas 
 * IDistancia.
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Euclidia implements IDistancia {
    
    @Override
    public double calcularDistancia(Vector a, Vector b) {
        double result = 0;
        if ( a.getTam() == b.getTam()) {
            for(int i = 0 ; i< a.getTam() ; i++) {
                result += diferenciaDeCuadrado(a.getDouble(i) , b.getDouble(i));
            }
        }
        return result;
    }
    private double diferenciaDeCuadrado(double numA, double numB) {
        return Math.pow(numA-numB, 2);
    }
    
}
