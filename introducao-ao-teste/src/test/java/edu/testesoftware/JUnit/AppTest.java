package edu.testesoftware.JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest{
    @Test
    void testeSomar(){
        App appSoma = new App(2, 3);
        Assertions.assertEquals(5.0, appSoma.somar(), 0.0001);
    }

    @Test
    void testeConferirDifereca(){
        App appSoma = new App(2, 3);
        Assertions.assertTrue(appSoma.conferirDiferenca());
    }

    @Test
    void compararArrays(){
        int[] conjunto_um = {1, 2, 3, 4, 5};
        int[] conjunto_dois = {1, 2, 3, 4, 5};

        Assertions.assertArrayEquals(conjunto_um, conjunto_dois);

        /*atenção!
        * o método assertArrayEquals só verifica corretamente arrays de mesmo tamanho
        * além disso a ordem de comparação é sempre o primeiro parâmetro com o segundo
        * */
    }
}
