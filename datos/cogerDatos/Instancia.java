package cogerDatos;
/**
 * Clase que representara un Instancia
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Instancia {
	private Vector name;
	private Vector types;
	
	/**
	 * M�todo constructor
	 * @param name
	 * @param types
	 */
	public Instancia(Vector name, Vector types){
		this.name = name;
		this.types = types;
	}
	/**
	 * M�todo para saber la cantidad de atributos de una instancia.
	 * @return
	 */
	public int getTam(){
		return name.getTam();
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
    public Vector getName() {
        return name;
    }
    /**
     * M�todo para obtener la variable types  
     * @return types
     */
    public Vector getTypes() {
        return types;
    }
    /**
     * M�todo para establecer el valor de name
     * @param name estable el valor de name 
     */
    public void setName(Vector name) {
        this.name = name;
    }
    /**
     * M�todo para establecer el valor de types
     * @param types estable el valor de types 
     */
    public void setTypes(Vector types) {
        this.types = types;
    }
}
