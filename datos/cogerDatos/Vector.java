package cogerDatos;

import java.util.ArrayList;

/**
 * Clase que manejara un arryalist<String> como si fuera un vector.
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Vector {
    ArrayList<String> datos;
    
    /**
     * Método constructor que se le pasa un tamaño.
     * @param datos
     */
    public Vector(int tam) {
        super();
        datos = new ArrayList<String>(tam);
    }
    /**
     * Método constructor que recive como argumetno un strign de valore separado
     * por comas.
     * @param linea
     */
    public Vector(String linea) {
        String aux[] = linea.split(",");
        // System.out.println(aux.length);
        datos = new ArrayList<String>(aux.length);
        for (int i = 0; i < aux.length; i++) {
            add(aux[i]);
        }
    }
    /**
     * Método para saber si los elemnto de las posiciones index son el mismo.
     * @param aux
     * @return
     */
    public boolean compareIgual(Vector aux) {
        int cont = 0;
        if (getTam() == aux.getTam()) {
            for (int i = 0; i < getTam(); i++) {
                if (compareIgual(aux, i)) {
                    cont++;
                }
            }
        }
        return (cont == getTam()) ? true : false; 
    }
    /**
     * Método para saber si los elemnto de las posiciones index son el mismo.
     * @param aux
     * @return
     */
    public boolean compareIgual(Vector aux, int index) {
        return (aux.get(index).equals(datos.get(index))) ? true : false;
    }
    /**
     * Método para obtener la variable datos
     * @return datos
     */
    public ArrayList<String> getDatos() {
        return datos;
    }
    /**
     * Método para establecer el valor de datos
     * @param datos estable el valor de datos
     */
    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }
    /**
     * Métod que devuleve el tamaño de mi vector.
     * @return
     */
    public int getTam() {
        return this.datos.size();
    }
    /**
     * Método que ingresara un dato dentro del arrayList.
     * @param newDato el nuevo dato introducido.
     */
    public void add(String newDato) {
        datos.add(newDato);
    }
    /**
     * Método que devuleve el valor de la posicion index.
     * @param index
     * @return
     */
    public String get(int index) {
        return datos.get(index);
    }
    /*
     * (sin Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.join(",", datos);
        
    }
    /**
     * Método que imprime por pantalla los elemntos del vector.
     */
    public void print() {
        System.out.println(toString());
    }
}
