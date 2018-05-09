package cogerDatos;

import java.util.Vector;
import estadistica.Estadistica;

/**
 * Clase que representara un Instancia
 * @author Jairo Gonzï¿½lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Prï¿½ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class SChema {
	private Vector<String> name;
	private Vector<String> types;
	private Vector<Double> peso;
	/**
	 * Mï¿½todo constructor
	 * @param name
	 * @param types
	 */
	public SChema(Vector name, Vector types){
		this.name = name;
		this.types = types;
		// peso por defecto meno el valor de la calse
		int tam = (this.name.size()-1);
		this.peso = new Vector<Double>(tam);
	    double peso = 1.0/tam;
	    for(int i= 0; i <tam;i++ ) {
	        this.peso.add(peso);
	    }
	    //System.out.println(peso+"esoy en peso");
	}
	   /**
     * Mï¿½todo constructor
     * @param name
     * @param types
     */
    public SChema(Vector name, Vector types,Vector peso){
      this(name, types);
      this.setPeso(peso);
    }
	   /**
     * Método para obtener la variable peso  
     * @return peso
     */
    public double getPeso(int index) {
        return peso.get(index);
    }
	/**
     * Método para obtener la variable peso  
     * @return peso
     */
    public Vector<Double> getPeso() {
        return peso;
    }
    /**
     * Método para establecer el valor de peso la suma de todo los valor del vecto tine que ser uno
     * @param peso estable el valor de peso 
     */
    public void setPeso(Vector<Double> peso) {
        if(peso.size() != this.peso.size()) {
           double val = Estadistica.sum(peso);
           double aux = 1.0-val;
           int falta = (this.peso.size()-peso.size());
           aux = aux/falta;
           double valPeso = 1.0/peso.size();
           for(int i= 0; i < falta;i++ ) {
               peso.add(valPeso);
           }
        }
        this.peso = peso;
    }
    /**
	 * Mï¿½todo para saber la cantidad de atributos de una instancia.
	 * @return
	 */
	public int getTam(){
		return name.size();
	}
	/*
	 * (sin Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
	public String toString() {
        return name.toString();
    }
    /**
     * Mï¿½todo para visualizar los nombres de los atributos de la instancia.
     */
    public void print(){
    	System.out.println(toString());
    }
    /**
     * Mï¿½todo para obtener la variable name  
     * @return name
     */
    public Vector<String> getName() {
        return name;
    }
    /**
     * Método para obtener el nombre del atributo que se l pasa  
     * @return name
     */
    public String getName(int attr) {
        return name.get(attr);
    }
    /**
     * Mï¿½todo para obtener el valot de tipo la poscion i
     * @param i
     * @return
     */
    public String getTypes(int i) {
        return this.types.get(i);
    }
    /**
     * Mï¿½todo para obtener la variable types  
     * @return types
     */
    public Vector<String> getTypes() {
        return types;
    }
    /**
     * Mï¿½todo para establecer el valor de name
     * @param name estable el valor de name 
     */
    public void setName(Vector<String> name) {
        this.name = name;
    }
    /**
     * Mï¿½todo para establecer el valor de types
     * @param types estable el valor de types 
     */
    public void setTypes(Vector<String> types) {
        this.types = types;
    }

}
