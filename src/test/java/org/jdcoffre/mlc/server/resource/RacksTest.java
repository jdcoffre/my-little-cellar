package org.jdcoffre.mlc.server.resource;


import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Rack;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RacksTest {

    private final Racks racksResource = new Racks();

    @Test
    public void createARack(){
        Response response = racksResource.postRack(new NonEmptyStringParam("newRack"), new Rack());
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void getACellar(){
        Rack rack = racksResource.getRack(new NonEmptyStringParam("newRack"));
        assertNotNull(rack);
    }

}
