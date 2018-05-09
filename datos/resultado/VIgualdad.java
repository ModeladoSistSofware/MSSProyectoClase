package resultado;

import java.util.ArrayList;

public class VIgualdad implements IVoto {

    @Override
    public void votar(ArrayList<DatoResultado> solucion, int k) {
        for(int i=0; i<k;i++) {
            solucion.get(i).setVoto(1.0);
        }
    }
    
}
