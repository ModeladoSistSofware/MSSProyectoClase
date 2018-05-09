package resultado;
/**
 * Clase que almacenara cada resultado del algorim
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class DatoResultado implements Comparable  {

    double distancia;
    String nombre;
    double voto;
    /**
     * M�todo constructor
     * @param distancia
     * @param nombre
     */
    public DatoResultado(double distancia, String nombre) {
        super();
        this.distancia = distancia;
        this.nombre = nombre;
        this.voto = 0;
    }
    /**
     * M�todo para obtener la variable voto  
     * @return voto
     */
    public double getVoto() {
        return voto;
    }
    /**
     * M�todo para establecer el valor de voto
     * @param voto estable el valor de voto 
     */
    public void setVoto(double voto) {
        this.voto = voto;
    }
    /**
     * M�todo para obtener la variable distancia  
     * @return distancia
     */
    public double getDistancia() {
        return distancia;
    }
    /**
     * M�todo para obtener la variable nombre  
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * M�todo para establecer el valor de distancia
     * @param distancia estable el valor de distancia 
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    /**
     * M�todo para establecer el valor de nombre
     * @param nombre estable el valor de nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public int compareTo(Object o) {
        int resultado = 0 ;
        DatoResultado auxR = (DatoResultado)o;
        double aux =(this.distancia - auxR.distancia);
        // ordenar por distancia y somo el mismonombre.
        if((aux < 0)&&(this.nombre.equals(auxR.nombre))){   resultado = -1;      }
        else if((aux> 0)&&(this.nombre.equals(auxR.nombre))) {    resultado = 1;      }
        else if(aux < 0){   resultado = -1;      }
        else if(aux > 0){   resultado = 1;    }

        return resultado;
        
    }    
    
}
