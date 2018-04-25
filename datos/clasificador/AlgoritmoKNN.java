package clasificador;

import cogerDatos.DataSet;
import cogerDatos.Vector;
import distancia.IDistancia;

public class AlgoritmoKNN implements IClasificador {
    IDistancia distancia;
    
    /**
     * Método constructor
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
