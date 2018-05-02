package cogerDatos;

import java.util.Vector;

/**
 * Clase que representara un Instancia
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Instancia {
	private Vector<String> name;
	private Vector<String> types;
	
	/**
	 * Método constructor
	 * @param name
	 * @param types
	 */
	public Instancia(Vector name, Vector types){
		this.name = name;
		this.types = types;
	}
	/**
	 * Método para saber la cantidad de atributos de una instancia.
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
     * Método para visualizar los nombres de los atributos de la instancia.
     */
    public void print(){
    	System.out.println(toString());
    }
    /**
     * Método para obtener la variable name  
     * @return name
     */
    public Vector<String> getName() {
        return name;
    }
    /**
     * Método para obtener el valot de tipo la poscion i
     * @param i
     * @return
     */
    public String getTypes(int i) {
        return this.types.get(i);
    }
    /**
     * Método para obtener la variable types  
     * @return types
     */
    public Vector<String> getTypes() {
        return types;
    }
    /**
     * Método para establecer el valor de name
     * @param name estable el valor de name 
     */
    public void setName(Vector<String> name) {
        this.name = name;
    }
    /**
     * Método para establecer el valor de types
     * @param types estable el valor de types 
     */
    public void setTypes(Vector<String> types) {
        this.types = types;
    }

}
