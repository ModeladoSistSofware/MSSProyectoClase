package matriz;

import java.util.ArrayList;

public class MatrizConfucion {

    ArrayList<String> val; // valores posibles.
    ArrayList<DatosMatriz>  matriz;
    /**
     * Método constructor
     * @param val
     * @param matriz
     */
    public MatrizConfucion(ArrayList<String> val,
            ArrayList<DatosMatriz> matriz) {
        super();
        this.val = val;
        this.matriz = matriz;
    }
    /**
     * Método para contar los valor 
     */
    public void verMatriz() {
        System.out.println("Cantidad de aciertos: " + String.format("%.2f", (getAciertos()/this.matriz.size())*100));
        System.out.println("Cantidad de errores: " +  String.format("%.2f", (getErrores()/this.matriz.size())*100));
        for(int i = 0; i< val.size();i++) {
            for(int j = 0; j< val.size();j++) {
                System.out.println(val.get(i) + "-" + val.get(j) + ": " + conteoVeces(val.get(i),val.get(j) ));
            }
        }
        
    }
    /**
     * Método que cogera la cantidad de fallo.
     * @return
     */
    public int getErrores() {
        return this.matriz.size() - getAciertos();
    }
    /**
     * Método para saber la cantidad de aciertos que existen.
     * @return
     */
    public int getAciertos() {
        int cont = 0;
        for(int j=0; j<matriz.size();j++) {
            if(matriz.get(j).isCorrecta()) {
                cont++;
            }
        }
        return cont;
    }
    /**
     * Contador de veces para la siguente concidendcia.
     * @param valorReal
     * @param valorPredicho
     * @return
     */
    public int conteoVeces(String valorReal, String valorPredicho) {
        int cont=0;
        for(int i = 0; i< val.size();i++) {
            for(int j=0; j<matriz.size();j++) {
               if(matriz.get(j).isDato(valorReal, valorPredicho)) {
                   cont++;
               }
            }
        }
        return cont;
    }
    /**
     * Método para obtener la variable val  
     * @return val
     */
    public ArrayList<String> getVal() {
        return val;
    }
    /**
     * Método para obtener la variable matriz  
     * @return matriz
     */
    public ArrayList<DatosMatriz> getMatriz() {
        return matriz;
    }
    /**
     * Método para establecer el valor de val
     * @param val estable el valor de val 
     */
    public void setVal(ArrayList<String> val) {
        this.val = val;
    }
    /**
     * Método para establecer el valor de matriz
     * @param matriz estable el valor de matriz 
     */
    public void setMatriz(ArrayList<DatosMatriz> matriz) {
        this.matriz = matriz;
    }
    
    
    
    
}
