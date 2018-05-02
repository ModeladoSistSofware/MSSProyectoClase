package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clasificador.Clasificador;
import clasificadores.AlgoritmoKNN;
import cogerDatos.DataSet;
import distancia.Euclidia;

class AlgoritmoKNNTest {
    
    @Test
    void test() {
        DataSet datos = new DataSet("pruebaDataSetTest.csv");
        datos.print();
        //////////////////El Algoritmo//////////////////
        Euclidia distancia = new Euclidia();
        AlgoritmoKNN algoritmo = new AlgoritmoKNN(distancia);
        //////////////////El Algoritmo////////////////////////
        Clasificador clasificador = new Clasificador(datos, algoritmo);
        String newData = ""; // vlaores de la instancia.
        String resultado = clasificador.clasifica(newData);
        System.out.println(resultado);
    }
    
}
