package resultado;

import java.util.ArrayList;

public class RMayoriaUmbral implements IRegla {
    double umbral;
    /**
     * Método constructor
     * @param umbral
     */
    public RMayoriaUmbral() {
        super();
        this.umbral = 0.50;// mayoria amsolutla
    }
    /**
     * Método constructor
     * @param umbral
     */
    public RMayoriaUmbral(double umbral) {
        super();
        this.umbral = umbral;
    }
    @Override
    public String seleccionClase(ArrayList<DatoResultado> solucion) {
        Double max = Double.MIN_VALUE;
        int tam = solucion.size();
        String result = "";
        for (int i = 0; i < tam; i++) {
            if((max < solucion.get(i).getVoto())&&(this.umbral < solucion.get(i).getVoto())) {
                result = solucion.get(i).getNombre();
                max=  solucion.get(i).getVoto();
            }
        }
        return result;
    }
    
    /**
     * Método para obtener la variable umbral  
     * @return umbral
     */
    public double getUmbral() {
        return umbral;
    }

    /**
     * Método para establecer el valor de umbral
     * @param umbral estable el valor de umbral 
     */
    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }
   
    
}
