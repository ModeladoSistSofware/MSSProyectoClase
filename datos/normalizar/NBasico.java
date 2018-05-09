package normalizar;

import java.util.ArrayList;
import java.util.Vector;
import estadistica.Estadistica;
/**
 * 
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class NBasico implements INormalizar{
   
    @Override
    public Vector<Double> normalizar(Vector<Double> datos) {
        System.out.println(datos);
        Double max = Estadistica.max(datos);
        //System.out.println(max + " maximo");
        Double min = Estadistica.min(datos);
        //System.out.println(min + " minimo");
        Double den = max - min;   
       // System.out.println(den + " resta");
        Vector<Double> nuevo = new Vector();
        int tam = datos.size();
        for (int i = 0; i < tam; i++) {
            double num = datos.get(i) - min;
           // System.out.println(datos.get(i)+ " resta"+min);
           // double x = Math.round(num / den);
            double x = num / den;
            System.out.println(x);
            nuevo.add(x);
        }
        return nuevo;
    }

   
}
