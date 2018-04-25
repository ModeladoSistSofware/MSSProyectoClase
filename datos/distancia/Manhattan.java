package distancia;

import cogerDatos.Vector;

public class Manhattan implements IDistancia {

	@Override
	public double calcularDistancia(Vector a, Vector b) {
	    double result = 0;
        if ( a.getTam() == b.getTam()) {
            for(int i = 0 ; i< a.getTam() ; i++) {
                result += valorAbsolutoDiferencia(a.getDouble(i) , b.getDouble(i));
            }
        }
        return result;
    }
	
    private double valorAbsolutoDiferencia(double numA, double numB) {
        return Math.abs(numB-numA);
    }
    
}
