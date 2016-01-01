package org.jdcoffre.mlc.server.resource;


import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Cellar;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CellarsTest {

    private final Cellars cellarsResource = new Cellars();

    @Test
    public void createACellar(){
        Response response = cellarsResource.postCellar(new NonEmptyStringParam("newCellar"), new Cellar());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void getACellar(){
        Cellar cellar = cellarsResource.getCellar(new NonEmptyStringParam("newCellar"));
        assertNotNull(cellar);
    }

}
