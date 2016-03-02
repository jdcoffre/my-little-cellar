package org.jdcoffre.mlc.server.services;

import com.codahale.metrics.annotation.Timed;
import org.jdcoffre.mlc.server.data.Bottle;
import org.jdcoffre.mlc.server.data.Cellar;
import org.jdcoffre.mlc.server.db.Database;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.List;

@Path("/cellars")
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

        db.setCellar(cellar);
        return Response.created(UriBuilder.fromResource(Cellars.class).build()).build();

    }

    @POST
    @Timed
    @Path("/{name}/{high}/{width}")
    public Response setBottle(@NotNull @PathParam("name") String name, @NotNull @PathParam("high") Integer high, @NotNull @PathParam("width") Integer width, @NotNull @Valid Bottle bottle) throws IOException{
        final Cellar cellar = db.getCellar(name);
        if(cellar == null ||
                !db.exist(bottle)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if(cellar.getHigh() < high ||
                cellar.getWidth() < width){
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }

        cellar.getShelve(high).setBottle(width, bottle);
        db.setCellar(cellar);
        return Response.created(UriBuilder.fromResource(Cellars.class).build()).build();

    }

}
