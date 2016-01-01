package org.jdcoffre.mlc.server.resource;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Cellar;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/cellars")
@Produces(MediaType.APPLICATION_JSON)
public class Cellars {

    @GET
    @Timed
    public Cellar getCellar(@QueryParam("name") NonEmptyStringParam name) {
        return new Cellar();
    }

    @POST
    @Timed
    public Response postCellar(@QueryParam("name") NonEmptyStringParam name, @Valid Cellar cellar) {
        return Response.created(UriBuilder.fromResource(Cellars.class).build(name.get()))
                .build();
    }

}
