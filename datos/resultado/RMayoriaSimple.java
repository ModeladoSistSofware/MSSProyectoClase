package resultado;

import java.util.ArrayList;

public class RMayoriaSimple implements IRegla {
    
    @Override
    public String seleccionClase( ArrayList<DatoResultado> solucion) {
        Double max = Double.MIN_VALUE;
        int tam = solucion.size();
        String result = "";
        for (int i = 0; i < tam; i++) {
            if(max < solucion.get(i).getVoto()) {
                result = solucion.get(i).getNombre();
                max=  solucion.get(i).getVoto();
            }
        }
        return result;
    }
    
}
