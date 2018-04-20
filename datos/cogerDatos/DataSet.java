package cogerDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase que contendra el conjunto de datos que recivira por fichero.
 * 
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class DataSet {
    private String name;
    private Instancia sc;
    private ArrayList<Vector> datos;// valor
    
    /**
     * M�todo constructor por defecto.
     */
    DataSet() {
        datos = new ArrayList<Vector>();
    }
    /**
     * M�todo constructor
     * @param name
     * @param sc
     */
    DataSet(String name, Instancia sc) {
        this();
        this.name = name;
        this.sc = sc;
    }
    /**
     * M�todo constructor, lee todo los datos por el fichero que le pasomos su
     * nombre como par�metros.
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
     * M�todo para obtener la variable sc
     * @return sc
     */
    public Instancia getSc() {
        return sc;
    }
    /**
     * M�todo para obtener la variable datos
     * @return datos
     */
    public ArrayList<Vector> getDatos() {
        return datos;
    }
    /**
     * M�todo para establecer el valor de name
     * @param name estable el valor de name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * M�todo para establecer el valor de sc
     * @param sc estable el valor de sc
     */
    public void setSc(Instancia sc) {
        this.sc = sc;
    }
    /**
     * M�todo para establecer el valor de datos
     * @param datos estable el valor de datos
     */
    public void setdatos(ArrayList<Vector> datos) {
        this.datos = datos;
    }
    /**
     * M�todo para un nuevo congunto de datos como un Strin separado pro comas.
     * Ejemplo : a,b,c
     * @param newVector
     */
    public void add(String linea) {
        this.datos.add(new Vector(linea));
    }
    /**
     * M�todo para un nuevo congunto de datos.
     * @param newVector
     */
    public void add(Vector newVector) {
        this.datos.add(newVector);
    }
    /**
     * M�todo que devuelve una intancia en concreto.
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
     * M�tdoo para visulizar todo los datos.
     */
    public void print() {
        System.out.println(toString());
    }
}