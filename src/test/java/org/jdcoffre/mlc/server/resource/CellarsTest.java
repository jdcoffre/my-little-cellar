package org.jdcoffre.mlc.server.resource;


import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Cellar;
import org.jdcoffre.mlc.server.data.DataPersister;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class CellarsTest {

    private final Cellars cellarsResource = new Cellars(mock(DataPersister.class));

    @Test
    public void createACellar() throws IOException {
        Response response = cellarsResource.postCellar(new Cellar());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void getACellar(){
        Cellar cellar = cellarsResource.getCellar(new NonEmptyStringParam("newCellar"));
        assertNotNull(cellar);
    }

}
