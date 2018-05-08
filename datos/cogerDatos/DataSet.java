package cogerDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

/**
 * Clase que contendra el conjunto de datos que recibira por fichero.
 * 
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018
 */
public class DataSet {
    private String name;
    private SChema sc;
    private ArrayList<Vector> datos;      // valor
    private ArrayList<Vector> normalizado;
    /**
     * M�todo constructor por defecto.
     */
    DataSet() {
        datos = new ArrayList<Vector>();
        normalizado = new ArrayList<Vector>();
    }
    /**
     * M�todo constructor
     * @param name
     * @param sc
     */
    DataSet(String name, SChema sc) {
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
                    Vector attr = cogerAtributos(linea);
                    linea = bufferRead.readLine();
                    Vector types = cogerTypesDatos(linea);
                
                    inicilizarTiposVectores(types);                  
                    sc = new SChema(attr, types);
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
     * M�todo encargado de introducir el tipo de vector que ira 
     * dentro de datos. Se le pasara un vecor ocn los tipos de datos que son.
     * @param types
     */
    private void inicilizarTiposVectores(Vector types) {
        Vector[] aux = null;
        this.datos = new ArrayList<Vector>(types.size()); 
        for(int i = 0; i < types.size() ;i++) {
            if(types.get(i).equals("Double")) {
                this.datos.add(new Vector<Double>());
            }else {
                this.datos.add(new Vector<String>());
            }
         }         
    }
    /**
     * M�todo que devuelve un vector con el tipo de dato que se ha almacenado distinguiendo si es de
     * tipo double o es un string.
     */
    public Vector<String> cogerTypesDatos(String linea) {
        String aux[] = linea.split(",");
        Vector<String> result = new Vector<String>(aux.length);        
        for(String value: aux) {
            if(isNumeric(value)) {
                result.add("Double");
            }else {
                result.add("String");
            }
        }
        return result;
    }
    
    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    /**
     * M�todo que pasa los datos que estan el string atributos.
     * @param linea
     * @return Vector de string.
     */
    private Vector<String> cogerAtributos(String linea) {
        String aux[] = linea.split(",");
        Vector<String> result = new Vector<String>(aux.length);
        for (int i = 0; i < aux.length; i++) {
            result.add(aux[i]);
        }
        return result;
    }
    /**
     * M�todo que normaliza los valore que hay en los datos segun.
     */
    private void normalizar() {
        for (int i = 0; i < this.getTamAttr()-1 ; i++) {
            normalizado.add(normalizar(i));
        }
        normalizado.add(this.datos.get(getTamAttr()-1));
    }
//    /**
//     * Metodo que normalizara el nuevo instancia de velores double.
//     * @param attr
//     * @return
//     */
//    public Vector<Double> normalizar(Vector<Double> newInstancia) {
//        Vector<Double> nuevo = new Vector<Double>();
//        for(int i = 0 ; i < newInstancia.size(); i++) {
//            Double max = this.max(i);
//            Double min = this.min(i);
//            Double den = max - min;   
//            double num = newInstancia.get(i) - min;
//            double x = Math.round(num / den);
//            nuevo.add(x);
//        }
//        return nuevo;
//    }
    public Vector<Double> normalizar(Vector<Double> newInstancia) {
      Vector<Double> nuevo = new Vector<Double>(newInstancia.size());
      for(int i = 0 ; i < newInstancia.size(); i++) {
          Double max = this.max(i);
          Double min = this.min(i);
          Double den = max - min;   
          //System.out.println(newInstancia.get(i) + "Mi vecotr") ;
          
          double num = newInstancia.get(i) - min;
          double x = Math.round(num / den);
          nuevo.add(x);
      }
      return nuevo;
  }
    
    
    /**
     * Se le pasa el attributo a recorrer.
     * @param attr
     * @return
     */
    public Vector normalizar(int attr) {
        Double max = this.max(attr);
        Double min = this.min(attr);
        Double den = max - min;   
        Vector nuevo = new Vector();
        Vector<Double> aux = this.datos.get(attr);
        int tam = aux.size();
        for (int i = 0; i < tam; i++) {
            double num = aux.get(i) - min;
            double x = Math.round(num / den);
            //System.out.println(Math.round(x) + "calculo");
            nuevo.add(x);
        }
        return nuevo;
    }
    /**
     * Se calcula el valor m�nimo del atributo numerico qeu se seleccionea. 
     * @return el minimo.
     */
    public Double min(int attr) {
        Double min = Double.MAX_VALUE;
        Vector aux = this.datos.get(attr);
        int tam = aux.size();
        for (int i = 0; i < tam; i++) {
            min= Double.min(min, this.getDatoDouble(attr,i));
        }
        return min;
    }
    /**
     * Se calcula el valor m�ximo del atributo numerico qeu se seleccionea. 
     * @return el minimo.
     */
    public Double max(int attr) {
        Double max = Double.MIN_VALUE;
        Vector<Double> aux = this.datos.get(attr);
        int tam = aux.size();
        for (int i = 0; i < tam; i++) {
            max= Double.max(max, this.getDatoDouble(attr,i));
        }
        return max;
    }
    /**
     * M�todo que devuelve n�mero de atributos
     * @return
     */
    public int getTamAttr() {
        return this.datos.size();
    }
    /**
     * M�todo para coger un dato double.
     * @return
     */
    public Double getDatoDouble(int attr, int intancia) {
        return (Double) this.datos.get(attr).get(intancia);
    }
    /**
     * M�todo datado
     * @return
     */
    public Object getDato(int attr, int intancia) {
        return this.datos.get(attr).get(intancia);
    }
    /**
     * M�todo datado
     * @return
     */
    public Object getDatoNormalizado(int attr, int intancia) {
        return this.normalizado.get(attr).get(intancia);
    }
    /**
     * M�todo que devuelve nuemoro de intancias
     * @return
     */
    public int getTam() {
        return get(0).size();
    }
    /**
     * M�todo para obtener la variable sc
     * @return sc
     */
    public SChema getSc() {
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
     * M�todo para obtener normalizados
     * @return datos
     */
    public ArrayList<Vector> getNormalizado() {
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
    public void setSc(SChema sc) {
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
     * M�todo para un nuevo congunto de datos como un Strin separado por comas.
     * Ejemplo : a,b,c
     * @param newVector
     */
    public void add(String linea) {
        String aux[] = linea.split(",");
        for(int i = 0 ; i < aux.length ; i++) {
            if(sc.getTypes(i).equals("Double")) {
                get(i).add(Double.parseDouble(aux[i]));
            }else {
                get(i).add(aux[i]);
            }
        }
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
    /**
     * Método que devolvera una instancia
     * @param
     * @return
     */
    public ArrayList<Vector> getIntancia(int index){
    	ArrayList<Vector> aux = new ArrayList<Vector>(this.getTamAttr());
    	for(int i=0; i< this.getTamAttr();i++){
    		if( sc.getTypes(i).equals("Double") ){
    			Vector<Double> auxVector = new Vector<Double>(); 
    			auxVector.add((Double)this.getDato(i, index));
    			aux.add(auxVector);
    		}else{
    			Vector<String> auxVector = new Vector<String>(); 
    			auxVector.add((String)this.getDato(i, index));
    			aux.add(auxVector);
    		}
    	}
    	return aux;
    }
    /**
     * Método que devolvera una instancia que solo tenga solo lo atributos
     * @param
     * @return
     */
    public Vector<Double> getIntanciaOnlyDouble(int index){
    	Vector<Double> aux = new Vector<Double>(this.getTamAttr());
    	for(int i=0; i< this.getTamAttr();i++){
    		if( sc.getTypes(i).equals("Double") ){
    			aux.add((Double)this.getDato(i, index));
    		}
    	}
    	return aux;
    }
    
    /**
     * Método que devolvera una instancia del ArrayLis normalizado
     * @param
     * @return
     */
    public ArrayList<Vector> getIntanciaNormalizada(int index){
    	ArrayList<Vector> aux = new ArrayList<Vector>(this.getTamAttr());
    	for(int i=0; i< this.getTamAttr();i++){
    		if( sc.getTypes(i).equals("Double") ){
    			Vector<Double> auxVector = new Vector<Double>(); 
    			auxVector.add((Double)this.getDatoNormalizado(i, index));
    			aux.add(auxVector);
    		}else{
    			Vector<String> auxVector = new Vector<String>(); 
    			auxVector.add((String)this.getDatoNormalizado(i, index));
    			aux.add(auxVector);
    		}
    	}
    	return aux;
    }
    /**
     * Método que devolvera una instancia que solo tenga solo lo atributos del ArrayListNormalizado.
     * @param
     * @return
     */
    public Vector<Double> getIntanciaNormalizadoOnlyDouble(int index){
    	Vector<Double> aux = new Vector<Double>(this.getTamAttr());
    	for(int i=0; i< this.getTamAttr();i++){
    		if( sc.getTypes(i).equals("Double") ){
    			aux.add((Double)this.getDatoNormalizado(i, index));
    		}
    	}
    	return aux;
    }
    /*
     * (sin Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result = toStringCabecera();
        
        for(int i=0; i <this.getTam();i++) {
            for(int j=0 ;j<this.getTamAttr();j++) {
                result +=  this.getDato(j, i) + ",";
            }
            result += "\n";
        }
        
        return result.substring(0, result.length() - 1);
    }
    /**
     * M�todo en el que se veran mucho datos relativo a el conjunto de datos.
     * @return
     */
    public String toStringCabecera() {
        String result = "N�mero de Atributos : " + this.getTamAttr() + "\n" ;    
        result+=sc.toString() + "\n";
        result+="N�mero de casos: " + this.getTam() + "\n";
        return result;       
    }
    /**
     * M�todo en el que se veran mucho datos relativo a el conjunto de datos.
     * @return
     */
    public String toStringAtributos() {
        String result = "N�mero de Atributos : " + this.getTamAttr() + "\n" ;    
        result+=sc.toString() + "\n";
        result+="N�mero de casos: " + this.getTam() + "\n";
        return result;    
     
    }
    /**
     * M�tdoo para visulizar todo los datos.
     */
    public void print() {
        System.out.println(toString());
    }
    /**
     * M�todo para visualizar normalizar
     */
    public void printNormalizar() {
        System.out.println(toStringNormalizar());
    }
    /**
     * M�todo para visualizar normalizar
     */
    public String toStringNormalizar() {
         String result = sc.toString() + "\n";
     
        
        for(int i=0; i <this.getTam();i++) {
            for(int j=0 ;j<this.getTamAttr();j++) {
                result +=  this.getDatoNormalizado(j, i) + ",";
            }
            result += "\n";
        }
        
        return result.substring(0, result.length() - 1);
    }
}