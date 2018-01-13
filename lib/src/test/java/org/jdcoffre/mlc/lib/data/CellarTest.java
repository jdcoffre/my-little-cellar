package org.jdcoffre.mlc.lib.data;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class CellarTest {

    @Test
    public void addNewBottle(){
        Bottle bottle = new Bottle();

        Cellar cellar = new Cellar("home");
        cellar.addBottle(bottle);

        assertThat(cellar.getBottles(), contains(bottle));
    }

}