package clasificadores;

import java.util.Vector;
import cogerDatos.DataSet;
import distancia.IDistancia;

// Nota si esl prosesado el usuraio no dices no hay procesado.
// Har 3 opciones.
public class AlgoritmoKNN implements IClasificador {
    IDistancia distancia;
     int NumK;//*Aki separo los do*/

     
    /**
     * M�todo constructor
     * @param distancia
     */
    public AlgoritmoKNN(IDistancia distancia) {
        super();
        this.distancia = distancia;
    }

    /**
     * Hacereeeeee
     */
    @Override
    public String predecir(DataSet data, Vector newValue) {
        double aux[] = new double[data.getTam()];
                  
        Vector<Double> norma = data.normalizar(newValue);
          
        for(int i = 0 ; i < data.getTam(); i++){
        		aux[i] = distancia.calcularDistancia(data.getIntanciaNormalizadoOnlyDouble(i), norma);
           		System.out.println("EStoy calculando " + aux[i]);
        }         
        // Ordenar
        
        // segun la frecuencia.
        return null;
    }
    
}
