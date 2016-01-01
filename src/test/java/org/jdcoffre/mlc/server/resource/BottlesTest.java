package org.jdcoffre.mlc.server.resource;

import org.jdcoffre.mlc.server.api.Bottle;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BottlesTest {

    @Test
    public void getBottlesReturnsBottles(){
        Bottles bottlesResource = new Bottles();
        assertNotNull(bottlesResource.getBottle(null));
    }
}
