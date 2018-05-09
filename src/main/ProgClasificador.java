package main;

import java.util.ArrayList;
import clasificador.Clasificador;
import clasificadores.CAlgoritmoKNN;

import cogerDatos.DataSet;
import distancia.DEuclidia;
import resultado.DatoResultado;

/**
 * Desarrollo en Java, usando el paradigma de orientación a objetos,
 * un sistema software preliminar para la clasificación de instancias usando el
 * método k-nn.
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas
 *         Sofware.
 * @version 1.0
 * @since 2018-03-14
 */
public class ProgClasificador {

  
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//          DataSet clasificar2 = new DataSet("glass.csv");
//          clasificar2.print();
       
          /// Conjunto de datos///////////////////////////
          DataSet datos = new DataSet("iris.csv");
          datos.print();
          datos.printNormalizar();
          //////////////////El Algoritmo//////////////////
          DEuclidia distancia = new DEuclidia();
          CAlgoritmoKNN algoritmo = new CAlgoritmoKNN(distancia, 4);
          //////////////////El Algoritmo////////////////////////

          //System.out.println(datos.getTamAttr() + "dafsa");
          Clasificador clasificador = new Clasificador(datos, algoritmo);
          //String newData = "5.1,3.5,1.4,0.2"; //iris vlaores de la instancia.
          String newData = "4.9,2.4,3.3,1"; // versicolor.
          String resultado = clasificador.clasifica(newData);
          System.out.println(resultado+"datos");
          System.out.println(algoritmo.parametroAlgoritmo());
          
	}

}
