package clasificadores;

import java.util.Vector;
import cogerDatos.DataSet;

/**
 * Interfazar predecira el valor de clase de un conjunto de datos.
 * @author Jairo Gonzï¿½lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Prï¿½ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public interface IClasificador {

    /**
     * Mï¿½todo al que se le pasara el conjunto de datos y el nuevo valor, devolvera
     * el valor que se predicira segï¿½n lo variable data.
     * @param data
     * @param newValue
     * @return
     */
    public String predecir(DataSet data, Vector newValue );
    /**
     * Método que devolvera los parámetro del algoritmo configurado.
     * @return
     */
    public String parametroAlgoritmo();
}
