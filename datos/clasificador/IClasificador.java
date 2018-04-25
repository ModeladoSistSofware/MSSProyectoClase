package clasificador;

import cogerDatos.DataSet;
import cogerDatos.Vector;

/**
 * Interfazar predecira el valor de clase de un conjunto de datos.
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public interface IClasificador {
    /**
     * Método al que se le pasara el conjunto de datos y el nuevo valor, devolvera
     * el valor que se predicira según lo variable data.
     * @param data
     * @param newValue
     * @return
     */
    public String predecir(DataSet data, Vector newValue );
}
