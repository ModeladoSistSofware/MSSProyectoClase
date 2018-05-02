package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cogerDatos.DataSet;

class DataSetTest {
    
    @Test
    void test() {
        DataSet nuevo = new DataSet("pruebaDataSetTest.csv");
         Double aux = 1.2;
         assertEquals(aux, nuevo.min(0),0.100);
         nuevo.print();
        nuevo.printNormalizar();
    }
    
}
