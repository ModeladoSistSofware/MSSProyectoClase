package normalizar;

import java.util.ArrayList;
import java.util.Vector;
import estadistica.Estadistica;

public class NEstandar implements INormalizar{
    @Override
    public Vector<Double> normalizar(Vector<Double> datos) {

        Double media = Estadistica.media(datos);
        //System.out.println(media + " media");
        Double desviacionTipica = Estadistica.desviacionTipica(datos);
        Vector<Double> nuevo = new Vector();
        int tam = datos.size();
        for (int i = 0; i < tam; i++) {
            double num = datos.get(i) - media;
            double x = num / desviacionTipica;
            //System.out.println(x);
            nuevo.add(x);
        }
        return nuevo;
    }
    
}
