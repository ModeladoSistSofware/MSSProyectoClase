package cogerDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Vector;
import estadistica.Estadistica;
import normalizar.INormalizar;
import normalizar.NBasico;

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
    private INormalizar estandarizar;
    private ArrayList<Vector> normalizado;
    
    private ArrayList<Vector> entrenamiento;      // valor
    private ArrayList<Vector> prueba;      // valor
    /**
     * M�todo constructor por defecto.
     */
    DataSet() {
        datos = new ArrayList<Vector>();
        estandarizar = new NBasico();// estes es pro defecto
        normalizado = new ArrayList<Vector>();
    }

    /**
     * M�todo constructor
     * @param name
     * @param sc
     */
    DataSet(String name, SChema sc, INormalizar estandarizar) {
        this();
        this.name = name;
        this.sc = sc;
        this.estandarizar = estandarizar;
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

           this.normalizado = this.estandarizar.normalizar(datos);
           
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
     * M�todo que devuelve n�mero de atributos
     * @return
     */
    public int getTamAttr() {
        return this.datos.size();
    }
    /**
     * M�todo para obtener la variable estandarizar  
     * @return estandarizar
     */
    public INormalizar getEstandarizar() {
        return estandarizar;
    }
    /**
     * M�todo para establecer el valor de estandarizar
     * @param estandarizar estable el valor de estandarizar 
     */
    public void setEstandarizar(INormalizar estandarizar) {
        this.estandarizar = estandarizar;
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
     * Método que devolvera una instancia que solo tenga solo lo atributos
     * @param
     * @return
     */
    public Vector<Double>  getIntanciaPesada(int index){
        Vector<Double> aux = new Vector<Double>(this.getTamAttr());
        for(int i=0; i< this.getTamAttr();i++){
            if( sc.getTypes(i).equals("Double") ){
                aux.add((Double)this.getDato(i, index)* this.sc.getPeso(i));
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
        String result = toStringInfo();
        
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
    public String toStringInfo() {
        String result = "N�mero de Atributos : " + this.getTamAttr() + "\n" ;    
        result+=sc.toString() + "\n";
        result+="N�mero de casos: " + this.getTam() + "\n";
        return result;       
    }
    /**
     * M�todo en el que se veran mucho datos relativo a el conjunto de datos.
     * @return
     */
    public String toStringInfoAtributos() {
        String result =toStringAtributosCuantitativos();
        result +=toStringAtributosCualitativos();
        return result;   
    }
    /**
     * M�todo que visulizara los datos referido a los atributos cuntitativos.
     * @return
     */
    public String toStringAtributosCuantitativos() {
        String result = "";
        for(int attr=0; attr<this.getTamAttr();attr++ ) {
            if(this.sc.getTypes(attr) == "Double" ) {
                result += "-----\n";
                result += "Nombre del Atributo: " + this.sc.getName(attr) + "\n" ;    
                result += "Minimo valor: " + String.format("%.2f", Estadistica.min(this.datos.get(attr))) + "\n" ;    
                result += "Maximo valor: " + String.format("%.2f", Estadistica.max(this.datos.get(attr))) + "\n" ;
                result += "Media valor: " + String.format("%.2f", Estadistica.media(this.datos.get(attr))) + "\n" ;
                result += "Desviaci�n T�pica: " + String.format("%.2f",this.desviacionTipica(attr)) + "\n" ;
            }
        }
        return result;
    }
    /**
     * M�todo que visulizara los datos referido a los atributos cuntitativos.
     * @return
     */
    public String toStringAtributosCualitativos() {
        String result = "";
        for(int attr=0; attr<this.getTamAttr();attr++ ) {
            if(this.sc.getTypes(attr).equals("String") ) {
                result = "-----\n";
                result += "Nombre del Atributo: " + this.sc.getName(attr) + "\n" ;    
                int nValores = this.nClasesDistitnas(attr);
                result += "Cantidad de clase distintas: " +  nValores + "\n" ; 
                TreeSet<String> aux = this.valorPosibles(attr);
                for(String val: aux) {
                    result += "Valor: "+ val + " Frecuencia Relativa: " +
                    String.format("%.2f",this.frecuenciaRelativa(val,attr)*100)+ "%\n" ; 
                }
            }
        }
        return result;
    }
    /**
     * Metodo que calcula  la frecuencia relativa.Es el cociente entre la frecuencia 
     * absoluta de un determinado valor y el n�mero total de datos.
     * @param val
     * @return
     */
    public double frecuenciaRelativa(String val, int index) {
        return (frecunenciaAbsoluta(val,index)/this.getTam());
    }
    /**
     * Metodo que calcula la frecuencia absoluta, numero de veces que aparece un determinado valor.
     * @param val
     * @param index
     * @return
     */
    public double frecunenciaAbsoluta(String val, int index) {
        Vector<String> aux = this.datos.get(index);
        double cont=0;
        for(String dato : aux) {
            if(dato.equals(val)) {
                cont++;
            }
        }
      
        return cont;
    }
    /**
     * M�todo que devolvera la cantidad de valro posibles
     * @param attr
     * @return
     */
    public int nClasesDistitnas(int attr) {
        return valorPosibles(attr).size();
    }
    /**
     * M�todo qeu devuelve una treeSet con los valores posibles que tenemos.
     * @param attr
     * @return
     */
     TreeSet<String> valorPosibles(int attr) {
         TreeSet result = new TreeSet();
         Vector<String> aux = this.datos.get(attr);
         for(String val: aux) {
             result.add(val);
         }
         return result;
     }
    /**
     * M�todo que obtine la desviaci�n t�pica del attributo attr.
     * @param attr
     * @return
     */
    private double desviacionTipica(int attr) {
        return Estadistica.desviacionTipica(this.datos.get(attr));
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
    /**
     * M�todo que llna los vetor de entrenamiento y de prueba
     * @param aux
     */
    private void llenarVectoresExperimentar(int aux) {

        for(int i=0; i< this.getTamAttr();i++) {
            Vector auxVector = new Vector();
            for(int j=0; j< aux;j++) {
                auxVector.add(this.normalizado.get(i).get(j));
            }
            this.entrenamiento.add( auxVector );
        }
        
        for(int i=1; i< this.getTamAttr();i++) {
            Vector auxVector = new Vector();
            for(int j=aux; j< getTam();j++) {
                auxVector.add(this.normalizado.get(i).get(j));
            }
            this.entrenamiento.add( auxVector );
        }
    }
    /**
     * M�todo para  ver el mood expetimentacion, se le pasa el posrecnetajeque es el conjunto de
     * pruebas.
     * @param porcentaje
     */
    public void modoExperimentar(int porcentaje) {
       int aux = (int)(this.datos.size() * (porcentaje/100));
       llenarVectoresExperimentar(aux);       
    }
    /**
     * M�toda para normalizar la nueva intancia.
     * @param newValue
     * @return
     */
    public Vector<Double> normalizar(Vector newValue) {
        return this.estandarizar.normalizar(newValue);
    }

    /**
     * M�todo para obtener la variable entrenamiento  
     * @return entrenamiento
     */
    public ArrayList<Vector> getEntrenamiento() {
        return entrenamiento;
    }

    /**
     * M�todo para obtener la variable prueba  
     * @return prueba
     */
    public ArrayList<Vector> getPrueba() {
        return prueba;
    }

    /**
     * M�todo para establecer el valor de entrenamiento
     * @param entrenamiento estable el valor de entrenamiento 
     */
    public void setEntrenamiento(ArrayList<Vector> entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    /**
     * M�todo para establecer el valor de prueba
     * @param prueba estable el valor de prueba 
     */
    public void setPrueba(ArrayList<Vector> prueba) {
        this.prueba = prueba;
    }
}