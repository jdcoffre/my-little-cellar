package org.jdcoffre.mlc.server.resource;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Bottle;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/bottles")
@Produces(MediaType.APPLICATION_JSON)
public class Bottles {

    @GET
    @Timed
    public Bottle getBottle(@QueryParam("name") NonEmptyStringParam name) {
        return new Bottle();
    }

    @POST
    @Timed
    public Response postBottle(@QueryParam("name") NonEmptyStringParam name, @Valid Bottle bottle) {
        return Response.created(UriBuilder.fromResource(Bottles.class).build(name.get()))
                .build();
    }

}
