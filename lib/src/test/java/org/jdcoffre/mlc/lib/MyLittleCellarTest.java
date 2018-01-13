package org.jdcoffre.mlc.lib;

import org.jdcoffre.mlc.lib.data.Cellar;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class MyLittleCellarTest {

    @Test
    public void addANewCellar() throws MLCExecption {
        Cellar cellar = new Cellar("MyCellar");

        MyLittleCellar mlc = new MyLittleCellar();
        mlc.addCellar(cellar);

        assertThat(mlc.getCellars(), contains(cellar));
    }

    @Test(expected = MLCExecption.class)
    public void addingTheSameCellarMultipleTimesIsNotAllowed() throws MLCExecption {
        Cellar cellar = new Cellar("MyCellar");

        MyLittleCellar mlc = new MyLittleCellar();
        mlc.addCellar(cellar);
        mlc.addCellar(cellar);
    }
}