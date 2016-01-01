package org.jdcoffre.mlc.server.resource;

import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Bottle;
import org.jdcoffre.mlc.server.data.DataPersister;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class BottlesTest {

    private final Bottles bottlesResource = new Bottles(mock(DataPersister.class));

    @Test
    public void createABottle() throws IOException {
        Response response = bottlesResource.postBottle(new NonEmptyStringParam("newBottle"), new Bottle());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void getABottle(){
        Bottle bottle = bottlesResource.getBottle(new NonEmptyStringParam("newBottle"));
        assertNotNull(bottle);
    }
}
