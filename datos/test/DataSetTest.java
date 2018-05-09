package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cogerDatos.DataSet;

class DataSetTest {
    
    @Test
    void test() {
        DataSet nuevo = new DataSet("pruebaDataSetTest.csv");
         Double aux = 1.2;
        
        //nuevo.print();
        nuevo.printNormalizar();
    }
//    @Test
//    void infoTest() {
//        DataSet nuevo = new DataSet("pruebaDataSetTest.csv");
//        Double aux = 1.2;
//        System.out.println(nuevo.toStringInfo());  
//    }
//    @Test
//    void infoAtributosTest() {
//        DataSet nuevo = new DataSet("pruebaDataSetTest.csv");
//        Double aux = 1.2;
//        System.out.println(nuevo.toStringInfoAtributos());  
//    }
}
