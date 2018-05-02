package cogerDatos;

import java.util.Vector;

/**
 * Clase que representara un Instancia
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class SChema {
	private Vector<String> name;
	private Vector<String> types;
	
	/**
	 * M�todo constructor
	 * @param name
	 * @param types
	 */
	public SChema(Vector name, Vector types){
		this.name = name;
		this.types = types;
	}
	/**
	 * M�todo para saber la cantidad de atributos de una instancia.
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
     * M�todo para visualizar los nombres de los atributos de la instancia.
     */
    public void print(){
    	System.out.println(toString());
    }
    /**
     * M�todo para obtener la variable name  
     * @return name
     */
    public Vector<String> getName() {
        return name;
    }
    /**
     * M�todo para obtener el valot de tipo la poscion i
     * @param i
     * @return
     */
    public String getTypes(int i) {
        return this.types.get(i);
    }
    /**
     * M�todo para obtener la variable types  
     * @return types
     */
    public Vector<String> getTypes() {
        return types;
    }
    /**
     * M�todo para establecer el valor de name
     * @param name estable el valor de name 
     */
    public void setName(Vector<String> name) {
        this.name = name;
    }
    /**
     * M�todo para establecer el valor de types
     * @param types estable el valor de types 
     */
    public void setTypes(Vector<String> types) {
        this.types = types;
    }

}
