package resultado;

import java.util.ArrayList;

public class VVecindad implements IVoto {
    
    /**
     * Siempre este arrya estar ordenado de meno a myor.
     */
    @Override
    public void votar(ArrayList<DatoResultado> solucion, int k) {
        double val = 1/k;
        for(int i=0; i<k;i++) {
            solucion.get(i).setVoto(val);
        }
        
    }
    
}
