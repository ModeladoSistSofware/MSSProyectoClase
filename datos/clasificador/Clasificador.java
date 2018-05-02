package clasificador;

import java.util.Vector;
import clasificadores.IClasificador;
import cogerDatos.DataSet;


/**
 * Clase que contendra un conjunto de datos de entrenamiento DataSet y el clasificador que ayudara a 
 * conseguir la soluci�n a una nueva instancia.
 * 
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Clasificador {
    IClasificador clasifica;
    DataSet setTraining;
    /**
     * M�todo constructor
     * @param clasifica
     * @param setTraining
     */
    public Clasificador( DataSet setTraining, IClasificador clasifica) {
        super();
        this.clasifica = clasifica;
        this.setTraining = setTraining;
    }  
    //////////////////////////////////////////
//    -separao el conjutno de entrenamientor en dos seugn x cosas.
//    
//    
//    -despues pasr por el casificado y contar cada ve zk hacienta.
//    -
    
    ///////////////////////////////////////////
    
    /**
     * M�todo que devolvera el resultados seg�n la nueva instancia introducida.
     * @param newData
     * @return
     */
    public String clasifica( Vector newData){
        return clasifica.predecir(setTraining, newData); 
    }
    /**
     * M�todo que devolvera el resultados seg�n la nueva instancia introducida.
     * @param newData
     * @return
     */
    public String clasifica(String newData) {
        String aux[] = newData.split(",");
        Vector<String> result = new Vector<String>(aux.length);
        for (int i = 0; i < aux.length; i++) {
            result.add(aux[i]);
        }
        
        return clasifica.predecir(setTraining, result); 
    }
}
