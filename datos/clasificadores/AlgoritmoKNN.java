package clasificadores;

import java.util.Vector;
import cogerDatos.DataSet;
import distancia.IDistancia;

// Nota si esl prosesado el usuraio no dices no hay procesado.
// Har 3 opciones.
public class AlgoritmoKNN implements IClasificador {
    IDistancia distancia;

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
        int i =0;
        data.normalizar(newValue);
        
        for( Vector value : data.getNormalizado() ) {
           aux[i] = distancia.calcularDistancia(value, newValue);
           i++;
        }     
        
        return null;
    }
    
}
