package distancia;

import java.util.Vector;

public class Manhattan implements IDistancia {

	@Override
	public double calcularDistancia(Vector<Double> a, Vector<Double> b) {
	    double result = 0;
        if ( a.size() == b.size()) {
            for(int i = 0 ; i< a.size() ; i++) {
                result += valorAbsolutoDiferencia(a.get(i) , b.get(i));
            }
        }
        return result;
    }
	
    private double valorAbsolutoDiferencia(double numA, double numB) {
        return Math.abs(numB-numA);
    }
    
}
