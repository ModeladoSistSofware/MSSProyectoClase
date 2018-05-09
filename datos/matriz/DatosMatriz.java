package matriz;
/**
 * 
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class DatosMatriz {
    String valorReal;
    String valorPredicho;
    /**
     * Método constructor
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
     * Método para obtener la variable valorReal  
     * @return valorReal
     */
    public String getValorReal() {
        return valorReal;
    }
    /**
     * Método para obtener la variable valorPredicho  
     * @return valorPredicho
     */
    public String getValorPredicho() {
        return valorPredicho;
    }
    /**
     * Método para establecer el valor de valorReal
     * @param valorReal estable el valor de valorReal 
     */
    public void setValorReal(String valorReal) {
        this.valorReal = valorReal;
    }
    /**
     * Método para establecer el valor de valorPredicho
     * @param valorPredicho estable el valor de valorPredicho 
     */
    public void setValorPredicho(String valorPredicho) {
        this.valorPredicho = valorPredicho;
    }
    
}
