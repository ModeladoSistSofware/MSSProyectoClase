package cogerDatos;

import java.util.ArrayList;


/**
 * Clase que manejara un arryalist<String> como si fuera un vector.
 * 
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class Vector{
    private ArrayList<String> datos;
    
    /**
     * M�todo constructor
     */
    public Vector() {
        datos = new ArrayList<String>();
    }
    /**
     * M�todo constructor que se le pasa un tama�o.
     * @param datos
     */
    public Vector(int tam) {
        super();
        datos = new ArrayList<String>(tam);
    }
    /**
     * M�todo constructor que recive como argumetno un strign de valore separado
     * por comas.
     * @param linea
     */
    public Vector(String linea) {
        String aux[] = linea.split(",");
        // System.out.println(aux.length);
        datos = new ArrayList<String>(aux.length);
       
        for (int i = 0; i < aux.length; i++) {
            if(isDouble(aux[i])) {
                add(aux[i].replaceAll("\\,","\\."));
            }
            else if(isInteger(aux[i])) {
                add(aux[i] + ".0");
            //  System.out.println("ddddddddd" + aux[i]+".00");
            }else {
                add(aux[i]);
            }
        }
    }

    /**
     * M�todo que devuelve un vector con el tipo de dato que se ha almacenado distinguiendo si es de
     * tipo double o es un string.
     */
    public Vector typesDatos() {
        Vector aux = new Vector(getTam());      
        for(String value: this.datos) {
            if(isNumeric(value)) {
                aux.add("Double");
            }else {
                aux.add("String");
            }
        }
        return aux;
    }
////////////////////////////////////////////////////////////////////
    /**
     * M�todo que verifica el si el string que se le pasa es un numero o no.
     * @param str
     * @return
     */
    private boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
    /**
     * M�todo que verifica el si el string que se le pasa es un double o no.
     * @param str
     * @return
     */
    private boolean isDouble(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)") && str.equals("")==false);
    }
    /**
     * M�todo que verifica el si el string que se le pasa es un double o no.
     * @param str
     * @return
     */
    private boolean isInteger(String str) {
        return (str.matches("[+-]?\\d+") && str.equals("")==false);
    }
///////////////////////////////////////////////////////////////////////
    /**
     * M�todo para saber si los elemnto de las posiciones index son el mismo.
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
     * M�todo para saber si los elemnto de las posiciones index son el mismo.
     * @param aux
     * @return
     */
    public boolean compareIgual(Vector aux, int index) {
        return (aux.get(index).equals(datos.get(index))) ? true : false;
    }
    
    public String min() {
        Double min= 100000.0;
        for(String value : this.datos) {
            int d = Double.compare(min, Double.parseDouble(value));
            if(d > 0) {
                min =  Double.parseDouble(value);
            }
        }
        return String.format("%.2f", min);
    }
    public String max() {
        Double max= -10000.0;
        for(String value : this.datos) {
            int d = Double.compare(max, Double.parseDouble(value));
          //  System.out.println(value);
            if(d < 0) {
                max =  Double.parseDouble(value);
            }
        }
       
        return String.format("%.2f", max);
    }
 //////////////////////////////////////////////////////////////////
    /**
     * M�todo para saber si los elemnto de las posiciones index son es menor.
     * @param aux
     * @return
     */
    public boolean compareMenor(Vector aux, int index) {
        double numA = Double.parseDouble(get(index));
        double numB = Double.parseDouble(aux.get(index));
        int d = Double.compare(numA, numB);
        return (d > 0) ? true : false;
    }
    /**
     * M�todo para saber si los elemnto de las posiciones index son es mayor.
     * @param aux
     * @return
     */
    public boolean compareMayor(Vector aux, int index) {
        double numA = Double.parseDouble(get(index));
        double numB = Double.parseDouble(aux.get(index));
        int d = Double.compare(numA, numB);
        return (d > 0) ? true : false;
    }
 //////////////////////////////////////////////////////////////////////////
    /**
     * M�todo para obtener la variable datos
     * @return datos
     */
    public ArrayList<String> getDatos() {
        return datos;
    }
    /**
     * M�todo para establecer el valor de datos
     * @param datos estable el valor de datos
     */
    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }
    /**
     * M�tod que devuleve el tama�o de mi vector.
     * @return
     */
    public int getTam() {
        return this.datos.size();
    }
    /**
     * M�todo que ingresara un dato dentro del arrayList.
     * @param newDato el nuevo dato introducido.
     */
    public void add(Double newDato) {
        System.out.println(newDato + "mieeeeeeeeeee");
        datos.add(newDato.toString());
    }
    /**
     * M�todo que ingresara un dato dentro del arrayList.
     * @param newDato el nuevo dato introducido.
     */
    public void add(String newDato) {
        datos.add(newDato);
    }
    /**
     * M�todo que devuleve el valor de la posicion index.
     * @param index
     * @return
     */
    public String get(int index) {
        return datos.get(index).replaceAll(",", ".");
    }
    /**
     * M�todo que devuleve el valor de la posicion index en tipo double.
     * @param index
     * @return
     */
    public Double getDouble(int index) {
       // System.out.println(get(index) + " ufff" + index);
        return Double.parseDouble(get(index));
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
     * M�todo que imprime por pantalla los elemntos del vector.
     */
    public void print() {
        System.out.println(toString());
    }
}
