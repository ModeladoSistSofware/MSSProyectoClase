package matriz;
/**
 * 
 * 
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class DatosMatriz {
    String valorReal;
    String valorPredicho;
    /**
     * M�todo constructor
     * @param valorReal
     * @param valorPredicho
     */
    public DatosMatriz(String valorReal, String valorPredicho) {
        super();
        this.valorReal = valorReal;
        this.valorPredicho = valorPredicho;
    }
    /**
     * Verifica si tine eso dos datos.
     * @param valorReal
     * @param valorPredicho
     * @return
     */
    public boolean isDato(String valorReal, String valorPredicho) {
        if((this.valorPredicho.equals(valorPredicho))&&
          (this.valorReal.equals(valorReal))){
           return true;   
          }
        return false;
    }
    /**
     * Verifica si tine eso dos datos.
     * @param valorReal
     * @param valorPredicho
     * @return
     */
    public boolean isCorrecta() {
        return (this.valorPredicho.equals(this.valorReal))? true:false;
     }
    /**
     * M�todo para obtener la variable valorReal  
     * @return valorReal
     */
    public String getValorReal() {
        return valorReal;
    }
    /**
     * M�todo para obtener la variable valorPredicho  
     * @return valorPredicho
     */
    public String getValorPredicho() {
        return valorPredicho;
    }
    /**
     * M�todo para establecer el valor de valorReal
     * @param valorReal estable el valor de valorReal 
     */
    public void setValorReal(String valorReal) {
        this.valorReal = valorReal;
    }
    /**
     * M�todo para establecer el valor de valorPredicho
     * @param valorPredicho estable el valor de valorPredicho 
     */
    public void setValorPredicho(String valorPredicho) {
        this.valorPredicho = valorPredicho;
    }
    
}
