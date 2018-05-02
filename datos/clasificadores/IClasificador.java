package clasificadores;

import java.util.Vector;
import cogerDatos.DataSet;

/**
 * Interfazar predecira el valor de clase de un conjunto de datos.
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public interface IClasificador {
    /**
     * M�todo al que se le pasara el conjunto de datos y el nuevo valor, devolvera
     * el valor que se predicira seg�n lo variable data.
     * @param data
     * @param newValue
     * @return
     */
    public String predecir(DataSet data, Vector newValue );
}
