package org.jdcoffre.mlc.server.services;

import com.codahale.metrics.annotation.Timed;
import org.jdcoffre.mlc.server.data.Cellar;
import org.jdcoffre.mlc.server.db.Database;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.List;

@Path("/bottles")
@Produces(MediaType.APPLICATION_JSON)
public class Cellars {

    private final Database db;


    public Cellars(Database db) {
        this.db = db;
    }

    @GET
    @Timed
    public List<Cellar> getCellars(){
        return db.getCellars();
    }

    @POST
    @Timed
    public Response postCellar(@Valid @NotNull Cellar cellar) throws IOException{
        if(db.exist(cellar)){
            return Response.status(Response.Status.CONFLICT).build();
        }

        db.addCellar(cellar);
        return Response.created(UriBuilder.fromResource(Cellars.class).build()).build();

    }

}