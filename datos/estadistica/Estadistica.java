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
        double media = media(datos);
        for(Double val : datos) {
            suma = Math.pow((val - media), 2);
            varianza += suma;
        }
        return (varianza/(datos.size()));
    }
    /**
     * Método que suma todo los elmentdo del vector
     * @param datos
     * @return
     */
    public static double sum(Vector<Double> datos) {
        double suma =0;
        for(Double val : datos) {
            suma+=val;
        }
        return suma;
    }
    
    public static double desviacionTipica(Vector<Double> datos) {
        double desviacion = Math.sqrt(varianza(datos));
        Math.rint(desviacion);
        return desviacion;
    }
    
    /** Se calcula el valor mï¿½nimo del atributo numerico qeu se seleccionea. 
    * @return el minimo.
    */
    public static double min(Vector<Double> datos)  {
       Double min = Double.MAX_VALUE;
     
       int tam = datos.size();
       for (int i = 0; i < tam; i++) {
           min= Double.min(min, datos.get(i));
       }
       return min;
   }
   /**
    * Se calcula el valor mï¿½ximo del atributo numerico qeu se seleccionea. 
    * @return el minimo.
    */
    public static double max(Vector<Double> datos)  {
       Double max = Double.MIN_VALUE;
       int tam = datos.size();
      
       for (int i = 0; i < tam; i++) {
           max= Double.max(max, datos.get(i));
       }
       return max;
   }
}
