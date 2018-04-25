package cogerDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase que contendra el conjunto de datos que recibira por fichero.
 * 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class DataSet {
    private String name;
    private Instancia sc;
    private ArrayList<Vector> datos;// valor
    
    private ArrayList<Vector> normalizado;
////////////////Normalizar   
    /**
     * Método que normaliza los valore que hay en los datos segun. 
     */
    private void normalizar() {    
        for(Vector aux: datos) {
            normalizado.add(normalizar(aux));
        }
    }
    public Vector normalizar(Vector dato) {
        Vector max = this.max();
        Vector min = this.min();
        Vector nuevo = new Vector();
        for(int i = 0 ; i < dato.getTam()-1 ; i++) {
            double num = dato.getDouble(i) - min.getDouble(i);
            double den =  (max.getDouble(i) - min.getDouble(i));
            double x =  Math.round(num / den ); 
             System.out.println(Math.round(x) + "calculo");
             nuevo.add( x );
        } 
        nuevo.add(dato.get(dato.getTam()-1));
        return nuevo;
    }
//////////////////normalizar
    /**
     * Método que retorana el numero de atributos de la instancia.
     * @return
     */
    public int getNumAttr() {
        return sc.getTam();
    }
    /**
     * Método que retorana el numero de instancias.
     * @return
     */
    public int getTam() {
        return datos.size();
    }
    /**
     * Método que devuelve todo los valores de la columna index en un tipo 
     * de objeto Vector.
     * @param index
     * @return
     */
    public Vector columna(int index){
        Vector aux = new Vector(getTam());
        for(Vector value: datos) {
            aux.add(value.get(index));
        }
        return aux;
    }    
    /**
     * Se calcula el valor mínimo de cada atributo numerico y se devulve
     * un vector con todos eso valores.
     * @return
     */
    public Vector min() {
        Vector min = new Vector(getTam());
        // -1 el ultimo vecot es de clase.
        for(int i = 0 ; i < sc.getTam()-1 ;i++) {
             min.add(columna(i).min());
        }
        return min;
    }
    
    /**
     * Se calcula el valor máximo de cada atributo numerico y se devulve
     * un vector con todos eso valores.
     * @return
     */
    public Vector max() {
        Vector max = new Vector(getTam());
        // -1 el ultimo vecot es de clase.
        for(int i = 0 ; i < sc.getTam() -1 ;i++) {
             max.add(columna(i).max());
        }
        return max;
    }
    /**
     * Método constructor por defecto.
     */
    DataSet() {
        datos = new ArrayList<Vector>();
        normalizado = new ArrayList<Vector>();
    }
    /**
     * Método constructor
     * @param name
     * @param sc
     */
    DataSet(String name, Instancia sc) {
        this();
        this.name = name;
        this.sc = sc;
    }
    /**
     * Método constructor, lee todo los datos por el fichero que le pasomos su
     * nombre como parámetros.
     * @param nameFile
     */
    public DataSet(String nameFile) {
        this();
        File file = null;
        FileReader read = null;
        BufferedReader bufferRead = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            file = new File(nameFile);
            read = new FileReader(file);
            bufferRead = new BufferedReader(read);
            
            // Lectura del fichero
            String linea;
            int cont = 0;
            name = nameFile.substring(0, nameFile.length() - 4);
            // System.out.println(name);
            
            while ((linea = bufferRead.readLine()) != null) {
                // System.out.println(linea);
                if (cont == 0) {
                    // String tipo = bufferRead.readLine();
                    Vector attr = new Vector(linea);
                    Vector types = new Vector(bufferRead.readLine());
                    
                    sc = new Instancia(attr, types.typesDatos());
                    this.add(types);
                    // System.out.println(types.typesDatos());
                    linea = bufferRead.readLine();
                    cont++;
                }
                this.add(linea);
            }
            normalizar();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != read) {
                    read.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    /**
     * Método para obtener la variable sc
     * @return sc
     */
    public Instancia getSc() {
        return sc;
    }
    /**
     * Método para obtener la variable datos
     * @return datos
     */
    public ArrayList<Vector> getDatos() {
        return datos;
    }
    /**
     * Método para establecer el valor de name
     * @param name estable el valor de name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Método para establecer el valor de sc
     * @param sc estable el valor de sc
     */
    public void setSc(Instancia sc) {
        this.sc = sc;
    }
    /**
     * Método para establecer el valor de datos
     * @param datos estable el valor de datos
     */
    public void setdatos(ArrayList<Vector> datos) {
        this.datos = datos;
    }
    /**
     * Método para un nuevo congunto de datos como un Strin separado pro comas.
     * Ejemplo : a,b,c
     * @param newVector
     */
    public void add(String linea) {
        this.datos.add(new Vector(linea));
    }
    /**
     * Método para un nuevo congunto de datos.
     * @param newVector
     */
    public void add(Vector newVector) {
        this.datos.add(newVector);
    }
    /**
     * Método que devuelve una intancia en concreto.
     * @param index
     * @return
     */
    public Vector get(int index) {
        return this.datos.get(index);
    }
    /*
     * (sin Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result = sc.toString() + "\n";
        for (Vector valor : datos) {
            result = result + valor.toString() + "\n";
        }
        return result.substring(0, result.length() - 1);
    }
    /**
     * Métdoo para visulizar todo los datos.
     */
    public void print() {
        System.out.println(toString());
    }
    /**
     * Método para visualizar normalizar
     */
    public void printNormalizar() {       
        for(Vector aux: normalizado) {
            System.out.println(aux);
        }
    }
}