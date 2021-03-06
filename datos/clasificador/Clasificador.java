package clasificador;

import java.util.ArrayList;
import java.util.Vector;
import clasificadores.IClasificador;
import cogerDatos.DataSet;
import matriz.MatrizConfucion;


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
    MatrizConfucion matriz;
    /**
     * M�todo constructor
     * @param clasifica
     * @param setTraining
     */
    public Clasificador( DataSet setTraining, IClasificador clasifica) {
        super();
        this.clasifica = clasifica;
        this.setTraining = setTraining;
        this.matriz = new MatrizConfucion(this.setTraining., null);
    }  
    /**
     * MEtodo para ver hacre pruebas.
     * @param porcentaje
     */
    public void hacerPruebas(int porcentaje) {
       this.setTraining.modoExperimentar(porcentaje);
       
       ArrayList<Vector> auxPrueba = this.setTraining.getPrueba();
       DataSet auxEntrenamiento = this.setTraining.getEntrenamiento();
       int verdad =0;
       
       for(int i = 0; i< auxPrueba.getTam();i++) {
            String aux = this.clasifica.predecir(auxEntrenamiento, auxPrueba.getIntanciaOnlyDouble(i));
            if(aux.equals(auxPrueba.getDato(auxPrueba.getTamAttr(), i))){
                verdad++;
            }
       }
    }
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
        Vector<Double> result = new Vector<Double>(aux.length);
        
        for (int i = 0; i < aux.length; i++) {
            result.add(Double.parseDouble(aux[i]));
        }
//        System.out.println("EStoy clasificando" + result.size());
//        System.out.println("EStoy clasificando" + setTraining.getTamAttr());
        return clasifica.predecir(setTraining, result); 
    }
}
