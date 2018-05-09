package normalizar;

import java.util.ArrayList;
import java.util.Vector;
/**
 * Interfaza para agregar formas de normalizar.
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public interface INormalizar {
    public default ArrayList<Vector> normalizar(ArrayList<Vector> datos) {
        ArrayList<Vector> normalizado = new ArrayList<Vector>();
        for (int i = 0; i < datos.size()-1 ; i++) {
                normalizado.add(normalizar(datos.get(i)));
        }
        normalizado.add(datos.get(datos.size()-1));
        return normalizado;
    }
    public Vector<Double> normalizar( Vector<Double> datos);
}
