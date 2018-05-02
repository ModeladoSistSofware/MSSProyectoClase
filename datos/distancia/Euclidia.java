package distancia;

import java.util.Vector;

/**
 * Clase que calcula la distancia Ecuclidia entre dos Vecotres implementa la interfas 
 * IDistancia.
 * 
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Euclidia implements IDistancia {
    
    @Override
    public double calcularDistancia(Vector<Double> a, Vector<Double> b) {
        double result = 0.0;
        System.out.println(a.size() +" diferencia aaaaaaaaaaaa"+b.size() );
        if ( a.size() == b.size()) {
            for(int i = 0 ; i< a.size() ; i++) {
            	System.out.println(" diferencia aaaaaaaaaaaa");
                result += diferenciaDeCuadrado(a.get(i) , b.get(i));
            }
        }
      
        return Math.sqrt(result);
    }
    private double diferenciaDeCuadrado(double numA, double numB) {
    	  System.out.println(Math.pow(numB-numA, 2)+  " diferencia aaaaaaaaaaaa");
        return Math.pow(numB-numA, 2);
    }
}
