package clasificadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import cogerDatos.DataSet;
import distancia.IDistancia;
import resultado.DatoResultado;
import resultado.IRegla;
import resultado.IVoto;
import resultado.Resultado;

// Nota si esl prosesado el usuraio no dices no hay procesado.
// Har 3 opciones.
public class CAlgoritmoKNN implements IClasificador {
    IDistancia distancia;
    int numK;//*Aki separo los do*/
    Resultado solucion;
     
    /**
     * Mï¿½todo constructor
     * @param distancia
     */
    public CAlgoritmoKNN(IDistancia distancia, int numK) {
        super();
        this.distancia = distancia;
        this.numK = numK;
        this.solucion = new Resultado();//esta es por defecto.
    }
   /**
    * Método que devolvera los parámetro del algoritmo configurado.
    * @return
    */
    @Override
   public String parametroAlgoritmo() {
       String result = "";
       result+="Valor de k: " + this.numK + "\n";
       result+="Metrica: " + this.distancia.getClass() + "\n";
       result+="Pesado de caso: " + this.solucion.getVoto().getClass() + "\n";
       result+="Regla de calsificación: " + this.solucion.getRegla().getClass() + "\n";
       return result;
   }
    /**
     * Mï¿½todo constructor
     * @param distancia
     */
    public void cambioRegla(IRegla regla) {
        this.solucion.setRegla(regla);
    }
    /**
     * Mï¿½todo constructor
     * @param distancia
     */
    public void cambioVoto(IVoto voto) {
        this.solucion.setVoto(voto, this.numK);
    }
    /**
     * Hacereeeeee
     */
    @Override
    public String predecir(DataSet data, Vector newValue) {
        double aux[] = new double[data.getTam()];
        Vector<Double> norma = data.normalizar(newValue);
       // System.out.println( data.getTam() + "Este es tamaño");
        for(int i = 0 ; i < data.getTam(); i++){
//            System.out.println("Estoy dentor de aki" +data.getIntanciaNormalizadoOnlyDouble(i).size());
//            System.out.println("Estoy dentor de aki" + norma.size());
             
              aux[i] = distancia.calcularDistancia(data.getIntanciaNormalizadoOnlyDouble(i), norma); 
              aux[i] = distancia.calcularDistancia(data.getIntanciaPesada(i), norma); // se hace el 4 aki.
              //System.out.println("EStoy calculando " + aux[i]+data.getDato(data.getTamAttr()-1,i));
              solucion.addResul(new DatoResultado(aux[i],  (String)data.getDato(data.getTamAttr()-1,i)));
          //  solucion.add(new Resultado(aux[i]*peso(i)por itnta,  (String)data.getDato(data.getTamAttr()-1,i)));
        }         
        
       // System.out.println(aux);
       // Collections.sort( solucion );
        solucion.print();
       
        //System.out.println(data.toStringInfoAtributos());
        return solucion.seleccionResultado();
        //return solucion.get(0).getNombre();
    }
    
}
