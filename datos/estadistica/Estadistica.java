package estadistica;

import java.util.Vector;

/**
 * Clase que tendra funciones estaticar pa calcural valores de un vector.
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Estadistica {
    /**
     * Método que devolvera la media de un conjunto de vectores.
     * @param datos
     * @return
     */
    public static double media(Vector<Double> datos) {
        double suma =0;
        for(Double val : datos) {
            suma+=val;
        }
        return (suma/ datos.size());
    }
    /**
     * Método que devolvera varainza de un conjunto de datos 
     * @param datos
     * @return
     */
    public static double varianza(Vector<Double> datos) {
        double suma =0;
        double varianza=0;
        for(Double val : datos) {
            suma = Math.pow(val - media(datos), 2);
            varianza = varianza + suma;
        }
        return varianza/(datos.size()-1);
    }
    public static double desviacionTipica(Vector<Double> datos) {
//        double desviacion = Math.sqrt(varianza(datos));
//        Math.rint(desviacion);
//        return desviacion
    }
}
