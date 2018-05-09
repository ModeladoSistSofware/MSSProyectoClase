package resultado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Clase qeu guardara todolo posibles solucion y dara una solucion segun una regal de clasificacion.
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Resultado {
    private ArrayList<DatoResultado> solucion;
    private IRegla regla;
    private IVoto voto;
    /**
     * Método constructor
     */
    public Resultado() {
        this.solucion= new ArrayList<DatoResultado>();
        this.regla = new RMayoriaSimple();
        this.voto = new VIgualdad();
    }
    /**
     * Método constructor
     * @param regla
     */
    public Resultado(IRegla regla) {
        super();
        this.regla = regla;
    }    
    /**
     * Métedo para agregar el nuevo resultado.
     * @param datoResultado
     */
    public void addResul(DatoResultado datoResultado) {
            solucion.add(datoResultado);
            Collections.sort( solucion );
    }
    /**
     * Método que selecciona la solcuion segun la regla que se seleccione.
     * @return
     */
    public String seleccionResultado() {
        return this.regla.seleccionClase(solucion);
    }
    /**
     * Método que visulizara todo el contenido de la solcion.
     */
    public void print() {
        for( Iterator it = solucion.iterator(); it.hasNext();) { 
            DatoResultado x = (DatoResultado)it.next();
            System.out.println(x.nombre + " : " + x.distancia);
        }  
    }
    /**
     * Método para obtener la variable solucion  
     * @return solucion
     */
    public ArrayList<DatoResultado> getSolucion() {
        return solucion;
    }
    /**
     * Método para obtener la variable regla  
     * @return regla
     */
    public IRegla getRegla() {
        return regla;
    }
    /**
     * Método para establecer el valor de solucion
     * @param solucion estable el valor de solucion 
     */
    public void setSolucion(ArrayList<DatoResultado> solucion) {
        this.solucion = solucion;
    }
    /**
     * Método para establecer el valor de regla
     * @param regla estable el valor de regla 
     */
    public void setRegla(IRegla regla) {
        this.regla = regla;
    }
    /**
     * Método para obtener la variable voto  
     * @return voto
     */
    public IVoto getVoto() {
        return voto;
    }
    /**
     * Método para establecer el valor de voto
     * @param voto estable el valor de voto 
     */
    public void setVoto(IVoto voto, int k) {
        this.voto = voto;
        this.voto.votar(this.solucion,k);
    }
    
}
