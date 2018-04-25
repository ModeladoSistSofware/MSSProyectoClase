package main;

import clasificador.Clasificador;
import clasificadores.AlgoritmoKNN;

import cogerDatos.DataSet;
import distancia.Euclidia;

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
		// TODO Auto-generated method stub
          DataSet clasificar2 = new DataSet("glass.csv");
          clasificar2.print();
       
          /// Conjunto de datos///////////////////////////
          DataSet datos = new DataSet("iris.csv");
          datos.print();
          datos.printNormalizar();
          //////////////////El Algoritmo//////////////////
          Euclidia distancia = new Euclidia();
          AlgoritmoKNN algoritmo = new AlgoritmoKNN(distancia);
          //////////////////El Algoritmo////////////////////////
          
          
          Clasificador clasificador = new Clasificador(datos, algoritmo);
          String newData = "kkkkk"; // vlaores de la instancia.
          String resultado = clasificador.clasifica(newData);
          System.out.println(resultado);
	}

}
