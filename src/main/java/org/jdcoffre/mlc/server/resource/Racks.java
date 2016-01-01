package org.jdcoffre.mlc.server.resource;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Rack;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/racks")
@Produces(MediaType.APPLICATION_JSON)
public class Racks {

    @GET
    @Timed
    public Rack getRack(@QueryParam("name") NonEmptyStringParam name) {
        return new Rack();
    }

    @POST
    @Timed
    public Response postRack(@QueryParam("name") NonEmptyStringParam name, @Valid Rack rack) {
        return Response.created(UriBuilder.fromResource(Racks.class).build(name.get()))
                .build();
    }

}
