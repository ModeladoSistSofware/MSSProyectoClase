package clasificadores;

import cogerDatos.DataSet;
import cogerDatos.Vector;
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
        double aux;
        
        
        for( Vector value : data.getDatos()) {
           aux= distancia.calcularDistancia(value, newValue);
        }
        
        
        
        return null;
    }
    
}
