package org.jdcoffre.mlc.server.resource;


import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Rack;
import org.jdcoffre.mlc.server.data.DataPersister;
import org.junit.Test;

import javax.ws.rs.core.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class RacksTest {

    private final Racks racksResource = new Racks(mock(DataPersister.class));

    @Test
    public void createARack() throws IOException {
        Response response = racksResource.postRack(new NonEmptyStringParam("newRack"), new Rack());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void getACellar(){
        Rack rack = racksResource.getRack(new NonEmptyStringParam("newRack"));
        assertNotNull(rack);
    }

}
