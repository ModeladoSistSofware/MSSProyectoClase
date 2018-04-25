package clasificador;

import cogerDatos.DataSet;
import cogerDatos.Vector;

/**
 * Clase que contendra un conjunto de datos de entrenamiento DataSet y el clasificador que ayudara a 
 * conseguir la solución a una nueva instancia.
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Clasificador {
    IClasificador clasifica;
    DataSet setTraining;
    /**
     * Método constructor
     * @param clasifica
     * @param setTraining
     */
    public Clasificador( DataSet setTraining, IClasificador clasifica) {
        super();
        this.clasifica = clasifica;
        this.setTraining = setTraining;
    }  
    /**
     * Método que devolvera el resultados según la nueva instancia introducida.
     * @param newData
     * @return
     */
    public String clasifica(String newData) {
        Vector newValue = new Vector(newData);
        return clasifica.predecir(setTraining, newValue); 
    }
}
