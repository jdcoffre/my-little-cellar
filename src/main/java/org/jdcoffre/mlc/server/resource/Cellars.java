package org.jdcoffre.mlc.server.resource;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.NonEmptyStringParam;
import org.jdcoffre.mlc.server.api.Cellar;
import org.jdcoffre.mlc.server.data.DataPersister;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;

@Path("/cellars")
@Produces(MediaType.APPLICATION_JSON)
public class Cellars {

    private final DataPersister dataPersister;

    public Cellars(final DataPersister dataPersister) {
        this.dataPersister = dataPersister;
    }

    @GET
    @Timed
    public Cellar getCellar(@QueryParam("name") NonEmptyStringParam name) {
        return new Cellar();
    }

    @POST
    @Timed
    public Response postCellar(@Valid Cellar cellar) throws IOException {
        dataPersister.persist(cellar);
        return Response.created(UriBuilder.fromResource(Cellars.class).build(cellar.getName()))
                .build();
    }

}
