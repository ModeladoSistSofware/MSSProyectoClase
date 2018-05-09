package distancia;

import java.util.Vector;
import estadistica.Estadistica;

public class DChebychef implements IDistancia {
    
    @Override
    public double calcularDistancia(Vector<Double> a, Vector<Double> b) {
        Vector<Double> aux = new Vector<Double>();
        if ( a.size() == b.size()) {
            for(int i = 0 ; i< a.size() ; i++) {
                aux.add( valorAbsolutoDiferencia(a.get(i) , b.get(i)));
            }
        }
        return Estadistica.max(aux);
    }
    
    private double valorAbsolutoDiferencia(double numA, double numB) {
        return Math.abs(numB-numA);
    }
}
