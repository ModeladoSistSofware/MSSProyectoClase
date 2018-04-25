package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cogerDatos.DataSet;

class DataSetTest {
    
    @Test
    void test() {
        DataSet nuevo = new DataSet("pruebaDataSetTest.csv");
        nuevo.print();
        nuevo.printNormalizar();
    }
    
}
