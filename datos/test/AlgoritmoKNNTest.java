package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clasificador.Clasificador;
import clasificadores.CAlgoritmoKNN;
import cogerDatos.DataSet;
import distancia.DEuclidia;

class AlgoritmoKNNTest {
    
    @Test
    void test() {
        DataSet datos = new DataSet("pruebaDataSetTest.csv");
        datos.print();
        //////////////////El Algoritmo//////////////////
        DEuclidia distancia = new DEuclidia();
        CAlgoritmoKNN algoritmo = new CAlgoritmoKNN(distancia,3);
        //////////////////El Algoritmo////////////////////////
        Clasificador clasificador = new Clasificador(datos, algoritmo);
        String newData = "3,2,1"; // vlaores de la instancia.
        String resultado = clasificador.clasifica(newData);
        System.out.println(resultado);
    }
    
}
