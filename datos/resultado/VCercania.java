package resultado;

import java.util.ArrayList;
/**
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class VCercania implements IVoto {

    @Override
    public void votar(ArrayList<DatoResultado> solucion, int k) {
        
        for(int i=0; i<k;i++) {
            double voto = 1.0/solucion.get(i).getDistancia(); 
            solucion.get(i).setVoto(voto);
        }
    }
    
}
