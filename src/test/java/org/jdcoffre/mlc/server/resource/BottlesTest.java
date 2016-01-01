package org.jdcoffre.mlc.server.resource;

import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Bottle;
import org.jdcoffre.mlc.server.api.Cellar;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BottlesTest {

    private final Bottles bottlesResource = new Bottles();

    @Test
    public void createABottle(){
        Response response = bottlesResource.postBottle(new NonEmptyStringParam("newBottle"), new Bottle());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void getABottle(){
        Bottle bottle = bottlesResource.getBottle(new NonEmptyStringParam("newBottle"));
        assertNotNull(bottle);
    }
}
